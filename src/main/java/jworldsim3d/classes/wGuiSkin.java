package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wGuiSkin extends ClassWrap {
    
    

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            // ?
        }
    }    
}
