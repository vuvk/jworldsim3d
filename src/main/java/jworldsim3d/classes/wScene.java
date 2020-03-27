package jworldsim3d.classes;

import jworldsim3d.structs.wColor4s;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wScene {
    private final static LibWS3D WS3D = LibWS3D.INSTANCE;    
    
    public static boolean begin(wColor4s color) {
        return WS3D.wSceneBegin(color.ByValue());        
    }
    
    public static boolean begin() {
        return begin(wColor4s.BLACK);        
    }
    
    public static void drawAll() {
        WS3D.wSceneDrawAll();        
    }
    
    public static boolean end() {
        return WS3D.wSceneEnd();
    } 
    
    private wScene(){}
}
