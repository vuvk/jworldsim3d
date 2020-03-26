package jworldsim3d.wrapper;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import jworldsim3d.Constants;
import jworldsim3d.structs.math.wVector2f;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.math.wVector2i;
import jworldsim3d.structs.math.wVector2u;

/**
 *
 * @author Vuvk
 */
public interface LibWS3D extends StdCallLibrary {  
    public final static LibWS3D INSTANCE = (LibWS3D)Native.load(Constants.LIB_NAME, LibWS3D.class);
    
    
    ////////////////////////////////////////////////
    /// wEngine
    boolean wEngineStart(int iDevice,
                         wVector2u size,
                         int iBPP,
                         boolean boFullscreen,
                         boolean boShadows,
                         boolean boCaptureEvents,
                         boolean vsync);
    void wEngineCloseByEsc();
    void wEngineYield();
    boolean wEngineRunning();
    ///Pause execution and let other processes to run for a specified amount of time.
    void wEngineSleep(int ms, boolean pauseTimer);
    boolean wEngineStop(boolean closeDevice);
    void wEngineSetFPS(int limit);
    int wEngineGetFPS();
    
    ////////////////////////////////////////////////
    ////wFont
    Pointer wFontLoad(String fontPath);
    void wFontDraw(Pointer font,
                   char[] text,
                   wVector2i fromPos,
                   wVector2i toPos,
                   wColor4s color);
    void wFontDestroy(Pointer font);
    
   
    ////////////////////////////////////////////////
    ///wTexture//
    Pointer wTextureLoad(String file);
    Pointer wTextureCreateRenderTarget(wVector2i size);
    Pointer wTextureCreate(String name, wVector2i size, int colorFormat);
    void wTextureDestroy(Pointer texture);
    Pointer wTextureLock(Pointer texture);
    void wTextureUnlock(Pointer texture);
    void wTextureSave(Pointer texture, String file);
//    wImage* wTextureConvertToImage(Pointer texture);
//    void wTextureGetInformation(Pointer texture, wVector2u* size, Integer pitch, wColorFormat* format);
    void wTextureMakeNormalMap(Pointer texture, float amplitude);
 /*   int wTexturesSetBlendMode(Pointer texturedest,
                              Pointer texturesrc,
                              wVector2i offset,
                              wBlendOperation operation );
*/
    void wTextureSetColorKey(Pointer texture, wColor4s key);
    void wTextureSetGray(Pointer texture);
    void wTextureSetAlpha(Pointer texture, int value);
    void wTextureSetInverse(Pointer texture);
    void wTextureSetBrightness(Pointer texture, int value);
    Pointer wTextureCopy(Pointer texture, String name);
    void wTextureSetContrast(Pointer texture, float value);
    Pointer wTextureFlip(Pointer texture, int mode);
    void wTextureSetBlur(Pointer texture, float radius);
    String wTextureGetFullName(Pointer texture);
    String wTextureGetInternalName(Pointer texture);
    void wTextureDraw(Pointer texture, wVector2i pos, boolean useAlphaChannel, wColor4s color);
    void wTextureDrawEx(Pointer texture, wVector2i pos, wVector2f scale, boolean useAlphaChannel);
    void wTextureDrawMouseCursor(Pointer texture);
    void wTextureDrawElement(Pointer texture,
                             wVector2i pos,
                             wVector2i fromPos,
                             wVector2i toPos,
                             boolean useAlphaChannel,
                             wColor4s color);
    void wTextureDrawElementStretch(Pointer texture,
                                    wVector2i destFromPos,
                                    wVector2i destToPos,
                                    wVector2i sourceFromPos,
                                    wVector2i sourceToPos,
                                    boolean useAlphaChannel);
    void wTextureDrawAdvanced(Pointer texture,
                              wVector2i pos,
                              wVector2i rotPoint,
                              float rotation,
                              wVector2f scale,
                              boolean useAlphaChannel,
                              wColor4s color,
                              int antiAliasingMode,
                              boolean bFilter,
                              boolean tFilter,
                              boolean aFilter);
    void wTextureDrawElementAdvanced(Pointer texture,
                                     wVector2i pos,
                                     wVector2i fromPos,
                                     wVector2i toPos,
                                     wVector2i rotPoint,
                                     float rotAngleDeg,
                                     wVector2f scale,
                                     boolean useAlphaChannel,
                                     wColor4s color,
                                     int antiAliasingMode,
                                     boolean bilinearFilter,
                                     boolean trilinearFilter,
                                     boolean anisotropFilter);

    ////////////////////////////////////////////////
    ///wGui///
    void wGuiDrawAll();
    void wGuiDestroyAll();
    boolean wGuiIsEventAvailable();
    Pointer wGuiReadEvent();
    boolean wGuiLoad(String fileName, Pointer start);
    boolean wGuiSave(String fileName, Pointer start);
    Pointer wGuiGetSkin();
    void wGuiSetSkin(Pointer skin);
    
    ///wGuiSkin///
    Pointer wGuiSkinCreate(int guiSkinSpace);
    wColor4s wGuiSkinGetColor(Pointer skin, int guiDefaultColor);
    void wGuiSkinSetColor(Pointer skin, int guiDefaultColor, wColor4s color);
    void wGuiSkinSetSize(Pointer skin, int guiDefaultSize, int newSize);
    int wGuiSkinGetSize(Pointer skin, int guiDefaultSize);
    char[] wGuiSkinGetDefaultText(Pointer skin, int guiDefaultText);
    void wGuiSkinSetDefaultText(Pointer skin, int guiDefaultText, char[] newText);
    void wGuiSkinSetFont(Pointer skin, Pointer font, int guiDefaultFont);
    Pointer wGuiSkinGetFont(Pointer skin, int guiDefaultFont);
    void wGuiSkinSetSpriteBank(Pointer skin, Pointer bank);
    Pointer wGuiSkinGetSpriteBank(Pointer skin);
    void wGuiSkinSetIcon(Pointer skin, int guiDefaultIcon, int index);
    int wGuiSkinGetIcon(Pointer skin, int guiDefaultIcon);
    /*wGuiSkinSpace*/ int wGuiSkinGetType(Pointer skin);
    
    ///wGuiLabel
    Pointer wGuiLabelCreate(char[] wcptrText, 
                            wVector2i minPos,
                            wVector2i maxPos,
                            boolean boBorder,
                            boolean boWordWrap);
    wVector2i wGuiLabelGetTextSize(Pointer txt);
    void wGuiLabelSetOverrideFont(Pointer obj, Pointer font);
    Pointer wGuiLabelGetOverrideFont(Pointer obj);
    Pointer wGuiLabelGetActiveFont(Pointer obj);
    void wGuiLabelEnableOverrideColor(Pointer obj, boolean value);
    boolean wGuiLabelIsOverrideColor(Pointer obj);
    void wGuiLabelSetOverrideColor(Pointer obj, wColor4s color);
    wColor4s wGuiLabelGetOverrideColor(Pointer obj);
    void wGuiLabelSetDrawBackground(Pointer obj, boolean value);
    boolean wGuiLabelIsDrawBackGround(Pointer obj);
    void wGuiLabelSetDrawBorder(Pointer obj, boolean value);
    boolean wGuiLabelIsDrawBorder(Pointer obj);
    void wGuiLabelSetTextAlignment(Pointer obj, int horGuiAlignment, int verGuiAlignment);
    void wGuiLabelSetWordWrap(Pointer obj, boolean value);
    boolean wGuiLabelIsWordWrap(Pointer obj);
    void wGuiLabelSetBackgroundColor(Pointer obj, wColor4s color);
    wColor4s wGuiLabelGetBackgroundColor(Pointer obj);
    
    
    ////////////////////////////////////////////////
    /// wWindow
    void wWindowSetCaption(char[] wcptrText);        

    
    ////////////////////////////////////////////////
    /// wScene
    boolean wSceneBegin (wColor4s color);
    void wSceneDrawAll();
    boolean wSceneEnd();
}