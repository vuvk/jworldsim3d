package jworldsim3d.wrapper;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import jworldsim3d.Constants;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.wVector2i;
import jworldsim3d.structs.wVector2u;

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
//    void wTextureDrawEx(Pointer texture, wVector2i pos, wVector2f scale, boolean useAlphaChannel);
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
 /*   void wTextureDrawAdvanced(Pointer texture,
                                       wVector2i pos,
                                       wVector2i rotPoint,
                                       float rotation,
                                       wVector2f scale,
                                       boolean useAlphaChannel,
                                       wColor4s color,
                                       wAntiAliasingMode aliasMode,
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
                                   wAntiAliasingMode aliasMode,
                                   boolean bilinearFilter,
                                   boolean trilinearFilter,
                                   boolean anisotropFilter);*/

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
    /*
    ///wGuiSkin///
    Pointer wGuiSkinCreate(int guiSkinSpace);
    wColor4s wGuiSkinGetColor(Pointer skin, wGuiDefaultColor elementType);

    void wGuiSkinSetColor(wGuiObject* skin,
                          wGuiDefaultColor elementType,
                          wColor4s color);

    void wGuiSkinSetSize(wGuiObject* skin,
                         wGuiDefaultSize sizeType,
                         Int32 newSize);

    Int32 wGuiSkinGetSize(wGuiObject* skin,
                        wGuiDefaultSize sizeType);

    const wchar_t* wGuiSkinGetDefaultText(wGuiObject* skin,
                                          wGuiDefaultText txt);

    void wGuiSkinSetDefaultText(wGuiObject* skin,
                                wGuiDefaultText txt,
                                const wchar_t* newText);

    #ifdef __cplusplus
    void wGuiSkinSetFont(wGuiObject* skin,
                         wFont* font,
                         wGuiDefaultFont fntType=wGDF_DEFAULT);
    #else
    void wGuiSkinSetFont(wGuiObject* skin,
                         wFont* font,
                         wGuiDefaultFont fntType);
    #endif // __cplusplus

    #ifdef __cplusplus
    wFont* wGuiSkinGetFont(wGuiObject* skin,
                           wGuiDefaultFont fntType=wGDF_DEFAULT);
    #else
    wFont* wGuiSkinGetFont(wGuiObject* skin,
                           wGuiDefaultFont fntType);
    #endif // __cplusplus

    void wGuiSkinSetSpriteBank(wGuiObject* skin,
                                                            wGuiObject* bank);

    wGuiObject* wGuiSkinGetSpriteBank(wGuiObject* skin);

    void wGuiSkinSetIcon(wGuiObject* skin,
                         wGuiDefaultIcon icn,
                         UInt32 index);

    UInt32 wGuiSkinGetIcon(wGuiObject* skin,
                                 wGuiDefaultIcon icn);

    wGuiSkinSpace wGuiSkinGetType(wGuiObject* skin);
    */
    
    
    ////////////////////////////////////////////////
    /// wWindow
    void wWindowSetCaption(char[] wcptrText);        

    
    ////////////////////////////////////////////////
    /// wScene
    boolean wSceneBegin (wColor4s color);
    void wSceneDrawAll();
    boolean wSceneEnd();
}