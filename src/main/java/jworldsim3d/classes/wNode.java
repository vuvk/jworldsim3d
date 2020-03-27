package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.structs.math.wVector3f;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wNode extends ClassWrap {

    public wNode(Pointer pointer) {
        setPointer(pointer);
    }

    /*
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
    */
    
    public static wNode createFromMesh(wMesh mesh) {
        return new wNode(LibWS3D.INSTANCE.wNodeCreateFromMesh(mesh.getPointer()));
    }
    
    public static wNode createFromStaticMesh(wMesh mesh) {
        return new wNode(LibWS3D.INSTANCE.wNodeCreateFromStaticMesh(mesh.getPointer()));
    }
    
    public static wNode createFromMeshAsOctree(wMesh mesh, int minimalPolysPerNode, boolean alsoAddIfMeshPointerZero) {
        return new wNode(LibWS3D.INSTANCE.wNodeCreateFromMeshAsOctree(mesh.getPointer(), minimalPolysPerNode, alsoAddIfMeshPointerZero));
    }
    
    public static wNode createFromBatchingMesh(wMesh mesh) {
        return new wNode(LibWS3D.INSTANCE.wNodeCreateFromBatchingMesh(mesh.getPointer()));
    }
    
    public static wNode createFromBatchingMeshAsOctree(wMesh mesh, int minimalPolysPerNode, boolean alsoAddIfMeshPointerZero) {
        return new wNode(LibWS3D.INSTANCE.wNodeCreateFromBatchingMeshAsOctree(mesh.getPointer(), minimalPolysPerNode, alsoAddIfMeshPointerZero));
    }
    
    /*void wNodeRemoveCollision(Pointer node, Pointer selector);
    void wNodeAddCollision(Pointer node, Pointer selector);    
    void wNodeSetDecalsEnabled(Pointer node);*/
    
    public void setParent(wNode parent) {
        WS3D.wNodeSetParent(pointer, parent.getPointer());
    }
    
    public wNode getParent() {
        return new wNode(WS3D.wNodeGetParent(pointer));
    }
    
    /*
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
    */
    
    public int getMaterialsCount() {
        return WS3D.wNodeGetMaterialsCount(pointer);
    }   
    
    public wMaterial getMaterial(int matIndex) {
        return new wMaterial(WS3D.wNodeGetMaterial(pointer, matIndex));
    }
    
    public void setPosition(wVector3f position) {
        WS3D.wNodeSetPosition(pointer, position.ByValue());
    }
    
    public wVector3f getPosition() {
        return WS3D.wNodeGetPosition(pointer);
    }
    
    /*wVector3f.ByValue wNodeGetAbsolutePosition(Pointer node);
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
    */
    public void setScale(wVector3f scale) {
        WS3D.wNodeSetScale(pointer, scale.ByValue());
    }
    
    public wVector3f getScale(wVector3f scale) {
        return WS3D.wNodeGetScale(pointer);
    }
    
    /*
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
                                        wVector3f.ByReference upStore,wNodeGetMaterial
                                        int numOffsets,
                                        wVector3f.ByReference offsetStore );
    void wNodeSetCullingState(Pointer node, int cullingState);
    int wNodeGetType(Pointer node);
    void wNodeSetAnimationRange(Pointer node, wVector2i.ByValue range);
    void wNodePlayMD2Animation(Pointer node, int md2AnimationType);
    */
    public void setAnimationSpeed(float fSpeed) {
        WS3D.wNodeSetAnimationSpeed(pointer, fSpeed);
    }
    
    public void setAnimationFrame(float fFrame) {
        WS3D.wNodeSetAnimationFrame(pointer, fFrame);
    }
    
    /*float wNodeGetAnimationFrame(Pointer node);
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
    */
    
    public void draw() {
        WS3D.wNodeDraw(pointer);
    }
    
    //void wNodeUpdateAbsolutePosition (Pointer node);
    
    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            WS3D.wNodeDestroy(pointer);
        }
    }
}
