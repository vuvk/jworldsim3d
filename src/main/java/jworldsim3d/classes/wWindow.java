package jworldsim3d.classes;

import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wWindow {
    private final static LibWS3D ws3d = LibWS3D.INSTANCE;
    
    public final static void setCaption(String text) {
        ws3d.wWindowSetCaption((text + '\0').toCharArray());
    }
    
    private wWindow(){}
}
