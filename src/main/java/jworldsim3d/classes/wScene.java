package jworldsim3d.classes;

import jworldsim3d.structs.wColor4s;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wScene {
    private final static LibWS3D ws3d = LibWS3D.INSTANCE;    
    
    public static boolean begin(wColor4s color) {
        return ws3d.wSceneBegin(color);        
    }
    
    public static boolean begin() {
        return begin(wColor4s.BLACK);        
    }
    
    public static void drawAll() {
        ws3d.wSceneDrawAll();        
    }
    
    public static boolean end() {
        return ws3d.wSceneEnd();
    } 
    
    private wScene(){}
}
