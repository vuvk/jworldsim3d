package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.structs.math.wVector3f;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wCamera extends wNode {
    
    public wCamera(Pointer pointer) {
        super(pointer);
    }
    
    public wCamera(wVector3f pos, wVector3f target) {
        super(LibWS3D.INSTANCE.wCameraCreate(pos.ByValue(), target.ByValue()));
    }
}
