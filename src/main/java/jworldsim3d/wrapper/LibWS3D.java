package jworldsim3d.wrapper;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import jworldsim3d.Constants;
import jworldsim3d.structs.gui.wGuiEvent;
import jworldsim3d.structs.input.wJoystickEvent;
import jworldsim3d.structs.input.wJoystickInfo;
import jworldsim3d.structs.input.wKeyEvent;
import jworldsim3d.structs.input.wMouseEvent;
import jworldsim3d.structs.math.wVector2f;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.math.wVector2i;
import jworldsim3d.structs.math.wVector2u;
import jworldsim3d.structs.math.wVector3f;
import jworldsim3d.structs.wVert;

/**
 *
 * @author Vuvk
 */
public interface LibWS3D extends StdCallLibrary {  
    public final static LibWS3D INSTANCE = (LibWS3D)Native.load(Constants.LIB_NAME, LibWS3D.class);
    
    
    ////////////////////////////////////////////////
    /// wEngine
    boolean wEngineStart(int iDevice,
                         wVector2u.ByValue size,
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
    ///wInput///
    ///keyboard///
    ///Get character without waiting for Return to be pressed.
    boolean wInputWaitKey();
    boolean wInputIsKeyEventAvailable();
    wKeyEvent.ByReference wInputReadKeyEvent();
    boolean wInputIsKeyUp(int keyCode);
    boolean wInputIsKeyHit(int keyCode);
    boolean wInputIsKeyPressed(int keyCode);
    ///mouse///
    boolean wInputIsMouseEventAvailable();
    wMouseEvent.ByReference wInputReadMouseEvent();
    void wInputSetCursorVisible(boolean boShow );
    boolean wInputIsCursorVisible();
    void wInputSetMousePosition(wVector2i.ByReference position);
    void wInputGetMousePosition(wVector2i.ByReference position);
    void wInputSetMouseLogicalPosition(wVector2f.ByReference position);
    void wInputGetMouseLogicalPosition(wVector2f.ByReference position);
    float wInputGetMouseWheel();
    void wInputGetMouseDelta(wVector2i.ByReference deltaPos);
    boolean wInputIsMouseUp(int mouseButtons);
    boolean wInputIsMouseHit(int mouseButtons);
    boolean wInputIsMousePressed(int mouseButtons);
    int wInputGetMouseX();
    int wInputGetMouseY();
    int wInputGetMouseDeltaX();
    int wInputGetMouseDeltaY();
    ///joystick///
    boolean wInputActivateJoystick();
    int wInputGetJoysitcksCount();
    void wInputGetJoystickInfo(int joyIndex, wJoystickInfo.ByReference joyInfo);
    boolean wInputIsJoystickEventAvailable();
    wJoystickEvent.ByReference wInputReadJoystickEvent();
    
    ////////////////////////////////////////////////
    ////wFont
    Pointer wFontLoad(String fontPath);
    Pointer wFontGetDefault();
    void wFontDraw(Pointer font,
                   char[] text,
                   wVector2i.ByValue fromPos,
                   wVector2i.ByValue toPos,
                   wColor4s.ByValue color);
    void wFontDestroy(Pointer font);    
    wVector2u.ByValue wFontGetTextSize(Pointer font, char[] text);
    void wFontSetKerningSize(Pointer font, wVector2u.ByValue kerning);
    wVector2u.ByValue wFontGetKerningSize(Pointer font);
    int wFontGetCharacterFromPos(Pointer font, char[] text, int xPixel);
    void wFontSetInvisibleCharacters(Pointer font, char[] s);
    Pointer wFontLoadFromTTF(String fontPath, int size, boolean antialias, boolean transparency);
    void wFontDrawAsTTF(Pointer font,
                        char[] wcptrText,
                        wVector2i.ByValue fromPos,
                        wVector2i.ByValue toPos,
                        wColor4s.ByValue color,
                        boolean hcenter,
                        boolean vcenter);
    
   
    ////////////////////////////////////////////////
    ///wTexture//
    Pointer wTextureLoad(String file);
    Pointer wTextureCreateRenderTarget(wVector2i.ByValue size);
    Pointer wTextureCreate(String name, wVector2i.ByValue size, int colorFormat);
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
    void wTextureSetColorKey(Pointer texture, wColor4s.ByValue key);
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
    void wTextureDraw(Pointer texture, wVector2i.ByValue pos, boolean useAlphaChannel, wColor4s.ByValue color);
    void wTextureDrawEx(Pointer texture, wVector2i.ByValue pos, wVector2f.ByValue scale, boolean useAlphaChannel);
    void wTextureDrawMouseCursor(Pointer texture);
    void wTextureDrawElement(Pointer texture,
                             wVector2i.ByValue pos,
                             wVector2i.ByValue fromPos,
                             wVector2i.ByValue toPos,
                             boolean useAlphaChannel,
                             wColor4s.ByValue color);
    void wTextureDrawElementStretch(Pointer texture,
                                    wVector2i.ByValue destFromPos,
                                    wVector2i.ByValue destToPos,
                                    wVector2i.ByValue sourceFromPos,
                                    wVector2i.ByValue sourceToPos,
                                    boolean useAlphaChannel);
    void wTextureDrawAdvanced(Pointer texture,
                              wVector2i.ByValue pos,
                              wVector2i.ByValue rotPoint,
                              float rotation,
                              wVector2f.ByValue scale,
                              boolean useAlphaChannel,
                              wColor4s.ByValue color,
                              int antiAliasingMode,
                              boolean bFilter,
                              boolean tFilter,
                              boolean aFilter);
    void wTextureDrawElementAdvanced(Pointer texture,
                                     wVector2i.ByValue pos,
                                     wVector2i.ByValue fromPos,
                                     wVector2i.ByValue toPos,
                                     wVector2i.ByValue rotPoint,
                                     float rotAngleDeg,
                                     wVector2f.ByValue scale,
                                     boolean useAlphaChannel,
                                     wColor4s.ByValue color,
                                     int antiAliasingMode,
                                     boolean bilinearFilter,
                                     boolean trilinearFilter,
                                     boolean anisotropFilter);
    
    ////////////////////////////////////////////////
    ///wMesh///
    Pointer wMeshLoad(String cptrFile, boolean ToTangents);
    Pointer wMeshCreate(String cptrMeshName);
    void wMeshAddMeshBuffer(Pointer mesh, Pointer meshbuffer);
    Pointer wMeshCreateSphere(String name, float radius, int polyCount );
    Pointer wMeshCreateCube();
    int wMeshSave(Pointer mesh, int meshFileFormat, String filename);//return 0/1/2/3  3- успешно
    void wMeshDestroy(Pointer mesh);
    boolean  wMeshSetName(Pointer mesh, String name);
    String wMeshGetName(Pointer mesh); 
    int wMeshGetType(Pointer mesh);
    void wMeshFlipSurface(Pointer mesh);
    void wMeshMakePlanarTextureMapping(Pointer mesh, float resolution);
    void wMeshMakePlanarTextureMappingAdvanced(Pointer mesh,
                                               float resolutionH,
                                               float resolutionV,
                                               byte axis,
                                               wVector3f.ByValue offset);
    Pointer wMeshCreateStaticWithTangents(Pointer aMesh);
    void wMeshRecalculateNormals(Pointer mesh,
                                 boolean  smooth,
                                 boolean  angleWeighted);
    void wMeshRecalculateTangents(Pointer mesh,
                                  boolean  recalculateNormals,
                                  boolean  smooth,
                                  boolean  angleWeighted);
/*    Pointer wMeshCreateHillPlane(String meshname,
                                wVector2f tilesSize,
                                wVector2i tilesCount,
                                wMaterial* material,
                                float hillHeight,
                                wVector2f.ByValue countHills,
                                wVector2f.ByValue texRepeatCount);*/
    Pointer wMeshCreateArrow(String name,
                             wColor4s.ByValue  cylinderColor,
                             wColor4s.ByValue  coneColor,
                             int tesselationCylinder,
                             int tesselationCone,
                             float height,
                             float heightCylinder,
                             float widthCylinder,
                             float widthCone);
    Pointer wMeshCreateBatching();
    void wMeshAddToBatching(Pointer meshBatch,
                            Pointer mesh,
                            wVector3f.ByValue position,
                            wVector3f.ByValue rotation,
                            wVector3f.ByValue scale);
    void wMeshUpdateBatching(Pointer meshBatch);
    void wMeshFinalizeBatching(Pointer meshBatch);
    void wMeshClearBatching(Pointer meshBatch);
    void wMeshDestroyBatching(Pointer meshBatch);
    void wMeshEnableHardwareAcceleration(Pointer mesh, int iFrame);
    int wMeshGetFramesCount(Pointer mesh);
    int wMeshGetIndicesCount(Pointer mesh, int iFrame, int iMeshBuffer);
    short[] wMeshGetIndices(Pointer mesh, int iFrame, int iMeshBuffer);
    void wMeshSetIndices(Pointer mesh, int iFrame, short[] indicies, int iMeshBuffer);
    int wMeshGetVerticesCount(Pointer mesh, int iFrame, int iMeshBuffer);
    void wMeshGetVertices(Pointer mesh, int iFrame, wVert[] verts, int iMeshBuffer);
    int[] wMeshGetVerticesMemory(Pointer mesh, int iFrame, int iMeshBuffer);
    void wMeshSetVertices(Pointer mesh, int iFrame, wVert[] verts, int iMeshBuffer);
    void wMeshSetScale(Pointer mesh,
                       float scale,
                       int iFrame,
                       int iMeshBuffer,
                       Pointer sourceMesh);
    void wMeshSetRotation(Pointer mesh, wVector3f.ByValue rot);
    void wMeshSetVerticesColors(Pointer mesh,
                                int iFrame,
                                wColor4s.ByReference verticesColor,
                                int groupCount,
                                int[] startPos,
                                int[] endPos,
                                int iMeshBuffer);
    void wMeshSetVerticesAlpha(Pointer mesh,
                               int iFrame,
                               byte value);
    void wMeshSetVerticesCoords(Pointer mesh,
                                int iFrame,
                                wVector3f.ByReference vertexCoord,
                                int groupCount,
                                int[] startPos,
                                int[] endPos,
                                int iMeshBuffer);
    void wMeshSetVerticesSingleColor(Pointer mesh,
                                     int iFrame,
                                     wColor4s.ByValue verticesColor,
                                     int groupCount,
                                     int[] startPos,
                                     int[] endPos,
                                     int iMeshBuffer);
    void wMeshGetBoundingBox (Pointer mesh,
                              wVector3f.ByReference min,
                              wVector3f.ByReference max);
    Pointer wMeshDuplicate(Pointer src);
    void wMeshFit(Pointer src, wVector3f.ByValue pivot, wVector3f.ByReference delta);
    boolean  wMeshIsEmpty(Pointer mesh); 
    int wMeshGetBuffersCount(Pointer mesh, int iFrame);
    Pointer wMeshGetBuffer(Pointer mesh, int iFrame, int index);

    ////////////////////////////////////////////////
    ///wGui///
    void wGuiDrawAll();
    void wGuiDestroyAll();
    boolean wGuiIsEventAvailable();
    wGuiEvent.ByReference wGuiReadEvent();
    boolean wGuiLoad(String fileName, Pointer start);
    boolean wGuiSave(String fileName, Pointer start);
    Pointer wGuiGetSkin();
    void wGuiSetSkin(Pointer skin);
    char[] wGuiGetLastSelectedFile();
    ///Returns the element which holds the focus.
    Pointer wGuiGetObjectFocused();
    ///Returns the element which was last under the mouse cursor.
    Pointer wGuiGetObjectHovered();
    Pointer wGuiGetRootNode();
    Pointer wGuiGetObjectById(int id, boolean searchchildren);
    Pointer wGuiGetObjectByName(String name, boolean searchchildren);

    ///wGuiObject///
    void wGuiObjectDestroy(Pointer element);
    void wGuiObjectSetParent(Pointer element, Pointer parent);
    Pointer wGuiObjectGetParent(Pointer element);
    void wGuiObjectSetRelativePosition(Pointer element, wVector2i.ByValue position);
    void wGuiObjectSetRelativeSize(Pointer element, wVector2i.ByValue size);
    wVector2i.ByValue wGuiObjectGetRelativePosition(Pointer element);
    wVector2i.ByValue wGuiObjectGetRelativeSize(Pointer element);
    wVector2i.ByValue wGuiObjectGetAbsolutePosition(Pointer element);
    wVector2i.ByValue wGuiObjectGetAbsoluteClippedPosition(Pointer element);
    wVector2i.ByValue wGuiObjectGetAbsoluteClippedSize(Pointer element);
    ///Sets whether the element will ignore its parent's clipping rectangle.
    void wGuiObjectSetClippingMode(Pointer element, boolean value);
    boolean wGuiObjectIsClipped(Pointer element);
    void wGuiObjectSetMaxSize(Pointer element, wVector2i.ByValue size);
    void wGuiObjectSetMinSize(Pointer element, wVector2i.ByValue size);
    void wGuiObjectSetAlignment(Pointer element,
                                int leftGuiAlignment,
                                int rightGuiAlignment,
                                int topGuiAlignment,
                                int bottomGuiAlignment);
    void wGuiObjectUpdateAbsolutePosition(Pointer element);
    ///Возвращает гуи-объект -потомок element-а, который находится на пересечении
    ///с точкой экрана position
    ///Если нужен любой объект, то в качестве element-а нужно
    ///поставить root=wGuiGetRootNode()
    ///Примечание: Элемент root имеет размер ВСЕГО экрана
    Pointer wGuiObjectGetFromScreenPos(Pointer element, wVector2i.ByValue position);
    ///Персекается ли объект с точкой экрана position
    boolean wGuiObjectIsPointInside(Pointer element, wVector2i.ByValue position);
    void wGuiObjectDestroyChild(Pointer element, Pointer child);
    ///Можно вызывать вместо wGuiDrawAll() для конкретного элемента
    void wGuiObjectDraw(Pointer element);
    void wGuiObjectMoveTo(Pointer element, wVector2i.ByValue position);
    void wGuiObjectSetVisible(Pointer element, boolean value);
    boolean wGuiObjectIsVisible(Pointer element);
    /// Устанавливает, был ли этот элемент управления создан
    /// как часть родительского элемента.
    /// Например, если полоса прокрутки является частью списка.
    /// Подразделы не сохраняются на диск при вызове wGuiSave()
    void wGuiObjectSetSubObject(Pointer element, boolean value);
    /// Вовзращает, был ли этот элемент управления создан
    /// как часть родительского элемента.
    boolean wGuiObjectIsSubObject(Pointer element);
    void wGuiObjectSetTabStop(Pointer element, boolean value);
    ///Returns true if this element can be focused by navigating with the tab key.
    boolean wGuiObjectIsTabStop(Pointer element);
    ///Sets the priority of focus when using the tab key to navigate between a group of elements.
    void wGuiObjectSetTabOrder(Pointer element, int index);
    int wGuiObjectGetTabOrder(Pointer element);
    ///If set to true, the focus will visit this element when using the tab key to cycle through elements.
    void wGuiObjectSetTabGroup(Pointer element, boolean value);
    boolean wGuiObjectIsTabGroup(Pointer element);
    void wGuiObjectSetEnable(Pointer element, boolean value);
    boolean wGuiObjectIsEnabled(Pointer element); 
    void wGuiObjectSetText(Pointer element, char[] text);
    char[] wGuiObjectGetText(Pointer element);
    ///Sets the new caption of this element.
    void wGuiObjectSetToolTipText(Pointer element, char[] text);
    char[] wGuiObjectGetToolTipText(Pointer element);
    void wGuiObjectSetId(Pointer element, int id);
    int wGuiObjectGetId(Pointer element);
    void wGuiObjectSetName(Pointer element, String name);
    boolean wGuiObjectIsHovered(Pointer el);
    String wGuiObjectGetName(Pointer element);
    ///Ищет  среди "детей" объекта искомого по его Id
    ///Если требуется найти ЛЮБОЙ ГУИ-объект сцены,
    ///нужно в качестве элемента указать root=wGuiGetRootNode()
    Pointer wGuiObjectGetChildById(Pointer element, int id, boolean searchChildren);
    Pointer wGuiObjectGetChildByName(Pointer element, String name, boolean searchChildren);
    boolean wGuiObjectIsChildOf(Pointer element, Pointer child);
    boolean wGuiObjectBringToFront(Pointer element, Pointer subElement);
    int wGuiObjectGetType(Pointer element);
    String wGuiObjectGetTypeName(Pointer element);
    boolean wGuiObjectHasType(Pointer element, int guiElementType);
    boolean wGuiObjectSetFocus(Pointer element);
    boolean wGuiObjectRemoveFocus(Pointer element);
    boolean wGuiObjectIsFocused(Pointer element);
//    void wGuiObjectReadFromXml(Pointer node, wXmlReader* reader);
//    void wGuiObjectWriteToXml(Pointer node, wXmlWriter* writer);
    
    ///wGuiSkin///
    Pointer wGuiSkinCreate(int guiSkinSpace);
    wColor4s.ByValue wGuiSkinGetColor(Pointer skin, int guiDefaultColor);
    void wGuiSkinSetColor(Pointer skin, int guiDefaultColor, wColor4s.ByValue color);
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
                            wVector2i.ByValue minPos,
                            wVector2i.ByValue maxPos,
                            boolean boBorder,
                            boolean boWordWrap);
    wVector2i.ByValue wGuiLabelGetTextSize(Pointer txt);
    void wGuiLabelSetOverrideFont(Pointer obj, Pointer font);
    Pointer wGuiLabelGetOverrideFont(Pointer obj);
    Pointer wGuiLabelGetActiveFont(Pointer obj);
    void wGuiLabelEnableOverrideColor(Pointer obj, boolean value);
    boolean wGuiLabelIsOverrideColor(Pointer obj);
    void wGuiLabelSetOverrideColor(Pointer obj, wColor4s.ByValue color);
    wColor4s.ByValue wGuiLabelGetOverrideColor(Pointer obj);
    void wGuiLabelSetDrawBackground(Pointer obj, boolean value);
    boolean wGuiLabelIsDrawBackGround(Pointer obj);
    void wGuiLabelSetDrawBorder(Pointer obj, boolean value);
    boolean wGuiLabelIsDrawBorder(Pointer obj);
    void wGuiLabelSetTextAlignment(Pointer obj, int horGuiAlignment, int verGuiAlignment);
    void wGuiLabelSetWordWrap(Pointer obj, boolean value);
    boolean wGuiLabelIsWordWrap(Pointer obj);
    void wGuiLabelSetBackgroundColor(Pointer obj, wColor4s.ByValue color);
    wColor4s.ByValue wGuiLabelGetBackgroundColor(Pointer obj);
    
    ///wGuiScrollBar
    Pointer wGuiScrollBarCreate(boolean Horizontal, wVector2i.ByValue minPos, wVector2i.ByValue maxPos);
    void wGuiScrollBarSetMaxValue(Pointer scroll, int max);
    int wGuiScrollBarGetMaxValue(Pointer scroll);
    void wGuiScrollBarSetMinValue(Pointer scroll, int min);
    int wGuiScrollBarGetMinValue(Pointer scroll);
    void wGuiScrollBarSetValue(Pointer scroll, int value);
    int wGuiScrollBarGetValue(Pointer scroll);
    void wGuiScrollBarSetSmallStep(Pointer scroll, int step);
    int wGuiScrollBarGetSmallStep(Pointer scroll);
    void wGuiScrollBarSetLargeStep(Pointer scroll, int step);
    int wGuiScrollBarGetLargeStep(Pointer scroll);
    
    
    ////////////////////////////////////////////////
    /// wWindow
    void wWindowSetCaption(char[] wcptrText);        

    
    ////////////////////////////////////////////////
    /// wScene
    boolean wSceneBegin (wColor4s.ByValue color);
    void wSceneDrawAll();
    boolean wSceneEnd();
}