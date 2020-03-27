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
//    void wTextureGetInformation(Pointer texture, wVector2u.ByReference size, Integer pitch, wColorFormat* format);
    void wTextureMakeNormalMap(Pointer texture, float amplitude);
 /*   int wTexturesSetBlendMode(Pointer texturedest,
                              Pointer texturesrc,
                              wVector2i.ByValue offset,
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
    Pointer wMeshCreateHillPlane(String meshname,
                                wVector2f.ByValue tilesSize,
                                wVector2i.ByValue tilesCount,
                                Pointer material,
                                float hillHeight,
                                wVector2f.ByValue countHills,
                                wVector2f.ByValue texRepeatCount);
    Pointer wMeshCreateArrow(String name,
                             wColor4s.ByValue cylinderColor,
                             wColor4s.ByValue coneColor,
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
    ///wNode///
    ///primitives///
    Pointer wNodeCreateEmpty();
    Pointer wNodeCreateCube(float size, wColor4s.ByValue color);
    Pointer wNodeCreateSphere(float radius,
                             int polyCount,
                             wColor4s.ByValue color);
    Pointer wNodeCreateCylinder(int tesselation,
                               float radius,
                               float length,
                               wColor4s.ByValue color);
    Pointer wNodeCreateCone(int tesselation,
                           float radius,
                           float length,
                           wColor4s.ByValue clorTop,
                           wColor4s.ByValue clorBottom);
    Pointer wNodeCreatePlane(float size,
                            int tileCount,
                            wColor4s.ByValue color);
    Pointer wNodeCreateFromMesh(Pointer mesh);
    Pointer wNodeCreateFromStaticMesh(Pointer mesh);
    Pointer wNodeCreateFromMeshAsOctree(Pointer vptrMesh,
                                        int minimalPolysPerNode,
                                        boolean alsoAddIfMeshPointerZero);
    Pointer wNodeCreateFromBatchingMesh(Pointer batchMesh);
    Pointer wNodeCreateFromBatchingMeshAsOctree(Pointer batchMesh,
                                                int minimalPolysPerNode,
                                                boolean alsoAddIfMeshPointerZero);
    void wNodeRemoveCollision(Pointer node, Pointer selector);
    void wNodeAddCollision(Pointer node, Pointer selector);    
    void wNodeSetDecalsEnabled(Pointer node);
    void wNodeSetParent(Pointer node, Pointer parent);
    Pointer wNodeGetParent(Pointer node);
    void wNodeSetReadOnlyMaterials(Pointer node, boolean readonly);
    boolean wNodeIsReadOnlyMaterials(Pointer node);
    Pointer wNodeGetFirstChild(Pointer node, int[] iterator);
    int wNodeGetChildsCount(Pointer node, int[] iterator);
    Pointer wNodeGetNextChild(Pointer node, int[] iterator);
    boolean wNodeIsLastChild(Pointer node, int[] iterator);
    void wNodeSetId(Pointer node, int id);
    int wNodeGetId(Pointer node);
    void wNodeSetName(Pointer node, String  name);
    String  wNodeGetName(Pointer node);
    void wNodeSetUserData(Pointer node, Pointer newData);
    Pointer wNodeGetUserData(Pointer node);
    void wNodeSetDebugMode(Pointer node, int debugMode);
    void wNodeSetDebugDataVisible(Pointer node, boolean value);
    int wNodeGetMaterialsCount(Pointer node);
    Pointer wNodeGetMaterial(Pointer node, int matIndex);
    void wNodeSetPosition(Pointer node, wVector3f.ByValue position);
    wVector3f.ByValue wNodeGetPosition(Pointer node);
    wVector3f.ByValue wNodeGetAbsolutePosition(Pointer node);
    void wNodeSetRotation (Pointer node, wVector3f.ByValue rotation);
    void wNodeSetAbsoluteRotation(Pointer node, wVector3f.ByValue rotation);
    wVector3f.ByValue wNodeGetRotation(Pointer node);
    wVector3f.ByValue wNodeGetAbsoluteRotation(Pointer node);
    void wNodeTurn(Pointer Entity, wVector3f.ByValue turn);
    void wNodeMove(Pointer Entity, wVector3f.ByValue direction);
    void wNodeRotateToNode(Pointer Entity1, Pointer Entity2);
    float wNodesGetBetweenDistance(Pointer nodeA, Pointer nodeB);
    boolean wNodesAreIntersecting(Pointer nodeA, Pointer nodeB);
    boolean wNodeIsPointInside(Pointer node, wVector3f.ByValue pos);
    void wNodeDrawBoundingBox(Pointer node, wColor4s.ByValue color);
    void wNodeGetBoundingBox(Pointer Node, wVector3f.ByReference min, wVector3f.ByReference max);
    void wNodeGetTransformedBoundingBox(Pointer Node, wVector3f.ByReference min, wVector3f.ByReference max);
    void wNodeSetScale(Pointer node, wVector3f.ByValue scale);
    wVector3f.ByValue wNodeGetScale(Pointer node);
    Pointer wNodeDuplicate(Pointer entity);
    Pointer wNodeGetJointByName(Pointer node, String node_name);
    Pointer wNodeGetJointById( Pointer node,int Id);
    int wNodeGetJointsCount( Pointer node);
    void wNodeSetJointSkinningSpace(Pointer bone, int boneSkinningSpace);
    int wNodeGetJointSkinningSpace(Pointer bone);
    void wNodeSetRenderFromIdentity(Pointer node, boolean value);
    void wNodeAddShadowVolume(Pointer node,
                              Pointer mesh,
                              boolean zfailMethod,
                              float infinity,
                              boolean oldStyle);
    Pointer wNodeAddShadowVolumeFromMeshBuffer(Pointer nodeParent,
                                               Pointer meshbuffer,
                                               boolean zfailMethod,
                                               float infinity,
                                               boolean oldStyle);
    void wNodeUpdateShadow(Pointer shadow);
    void wNodeSetVisibility(Pointer node, boolean visible );
    boolean wNodeIsVisible(Pointer node);
    boolean wNodeIsInView(Pointer node);
    void wNodeDestroy(Pointer node);
    void wNodeSetMesh(Pointer node, Pointer mesh);
    Pointer wNodeGetMesh(Pointer node);
    void wNodeSetRotationPositionChange(Pointer node,
                                        wVector3f.ByValue angles,
                                        wVector3f.ByValue offset,
                                        wVector3f.ByReference forwardStore,
                                        wVector3f.ByReference upStore,
                                        int numOffsets,
                                        wVector3f.ByReference offsetStore );
    void wNodeSetCullingState(Pointer node, int cullingState);
    int wNodeGetType(Pointer node);
    void wNodeSetAnimationRange(Pointer node, wVector2i.ByValue range);
    void wNodePlayMD2Animation(Pointer node, int md2AnimationType);
    void wNodeSetAnimationSpeed(Pointer node, float fSpeed);
    void wNodeSetAnimationFrame(Pointer node, float fFrame);
    float wNodeGetAnimationFrame(Pointer node);
    void wNodeSetTransitionTime(Pointer node, float fTime);
    void wNodeAnimateJoints(Pointer node);
    void wNodeSetJointMode(Pointer node, int jointMode);
    void wNodeSetAnimationLoopMode(Pointer node, boolean value);
    void wNodeDestroyAllAnimators(Pointer node);
    int wNodeGetAnimatorsCount(Pointer node);
    Pointer wNodeGetFirstAnimator(Pointer node);
    Pointer wNodeGetLastAnimator(Pointer node);
    Pointer wNodeGetAnimatorByIndex(Pointer node, int index);
    void wNodeOnAnimate(Pointer node,int timeMs);
    void wNodeDraw(Pointer node);
    void wNodeUpdateAbsolutePosition (Pointer node);
    
    ////////////////////////////////////////////////    
    ///wMaterial///
    void wMaterialSetTexture(Pointer material, int texIdx, Pointer texture);
    Pointer wMaterialGetTexture(Pointer material, int texIdx);
    void wMaterialScaleTexture(Pointer material, int texIdx, wVector2f.ByValue scale);
    void wMaterialScaleTextureFromCenter(Pointer material, int texIdx, wVector2f.ByValue scale);
    void wMaterialTranslateTexture(Pointer material, int texIdx, wVector2f.ByValue translate);
    void wMaterialTranslateTextureTransposed(Pointer material, int texIdx, wVector2f.ByValue translate);
    void wMaterialRotateTexture(Pointer material, int texIdx, float angle);
    void wMaterialSetTextureWrapUMode(Pointer material, int texIdx, int textureClamp);
    int wMaterialGetTextureWrapUMode(Pointer material, int texIdx);
    void wMaterialSetTextureWrapVMode(Pointer material, int texIdx, int textureClamp);
    int wMaterialGetTextureWrapVMode(Pointer material, int texIdx);
    void wMaterialSetTextureLodBias(Pointer material, int texIdx, int lodBias);
    int wMaterialGetTextureLodBias(Pointer material, int texIdx);
    void wMaterialSetFlag(Pointer material, int materialFlag, boolean boValue);
    boolean wMaterialGetFlag(Pointer material, int materialFlag);
    void wMaterialSetType(Pointer material, int materialType);
    void wMaterialSetShininess(Pointer material, float shininess);
    float wMaterialGetShininess(Pointer material);
    void wMaterialSetVertexColoringMode(Pointer material, int colorMaterial);
    int wMaterialGetVertexColoringMode(Pointer material);
    void wMaterialSetSpecularColor(Pointer material, wColor4s.ByValue color);
    wColor4s.ByValue wMaterialGetSpecularColor(Pointer material);
    void wMaterialSetDiffuseColor(Pointer material, wColor4s.ByValue color);
    wColor4s.ByValue wMaterialGetDiffuseColor(Pointer material);
    void wMaterialSetAmbientColor(Pointer material, wColor4s.ByValue color);
    wColor4s.ByValue wMaterialGetAmbientColor(Pointer material);
    void wMaterialSetEmissiveColor(Pointer material, wColor4s.ByValue color); 
    wColor4s.ByValue wMaterialGetEmissiveColor(Pointer material);
    void wMaterialSetTypeParameter(Pointer material, float param1);
    float wMaterialGetTypeParameter(Pointer material);
    void wMaterialSetTypeParameter2(Pointer material, float param2);
    float wMaterialGetTypeParameter2(Pointer material);
    void wMaterialSetBlendingMode(Pointer material, int blendFactorSrc, int blendFactorDest);
    void wMaterialSetLineThickness(Pointer material, float lineThickness);
    float wMaterialGetLineThickness(Pointer material);
    void wMaterialSetColorMask(Pointer material, int colorPlane);
    int wMaterialGetColorMask(Pointer material);
    void wMaterialSetAntiAliasingMode(Pointer material, int antiAliasingMode);
    int wMaterialGetAntiAliasingMode(Pointer material);
    
    ////////////////////////////////////////////////    
    ///wCamera///
    Pointer wCameraCreate(wVector3f.ByValue pos, wVector3f.ByValue target);
    /*
    wNode* wMayaCameraCreate(Float32 rotateSpeed,
                             Float32 zoomSpeed,
                             Float32 moveSpeed);

    void wCameraSetTarget(wNode* camera,
                          wVector3f target);

    wVector3f wCameraGetTarget(wNode* camera);

    wVector3f wCameraGetUpDirection(wNode* camera);

    void wCameraSetUpDirection(wNode* camera,
                               wVector3f upDir);

    void wCameraGetOrientation(wNode* camera,
                               wVector3f* upDir,
                               wVector3f* forwardDir,
                               wVector3f* rightDir);

    #ifdef __cplusplus
    void wCameraSetClipDistance(wNode* camera,
                                Float32 farDistance,
                                Float32 nearDistance=1.f);
    #else
    void wCameraSetClipDistance(wNode* camera,
                                Float32 farDistance,
                                Float32 nearDistance);
    #endif // __cplusplus

    void wCameraSetActive(wNode* camera);

    void wCameraSetFov(wNode* camera,
                       Float32 fov );

    Float32 wCameraGetFov(wNode* camera);

    void wCameraSetOrthogonal(wNode* camera,
                              wVector3f vec);

    void wCameraRevolve(wNode* camera,
                        wVector3f angleDeg,
                        wVector3f offset);

    void wCameraSetUpAtRightAngle(wNode* camera );

    void wCameraSetAspectRatio(wNode* camera,
                               Float32 aspectRatio );

    void wCameraSetInputEnabled(wNode* camera,
                                bool value);

    bool wCameraIsInputEnabled(wNode* camera);

    #ifdef __cplusplus
    void wCameraSetCollisionWithScene(wNode* camera,
                                      wVector3f radius,
                                      wVector3f gravity={0,-10,0},
                                      wVector3f offset={0,0,0},
                                      Float32 slidingValue=0.0005f);
    #else
    void wCameraSetCollisionWithScene(wNode* camera,
                                      wVector3f radius,
                                      wVector3f gravity,
                                      wVector3f offset,
                                      Float32 slidingValue);
    #endif // __cplusplus
    */

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