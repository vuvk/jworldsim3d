package jworldsim3d.classes;

import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wWindow {
    private final static LibWS3D WS3D = LibWS3D.INSTANCE;
    
    public final static void setCaption(String text) {
        WS3D.wWindowSetCaption((text + '\0').toCharArray());
    }
    
    private wWindow(){}
}
