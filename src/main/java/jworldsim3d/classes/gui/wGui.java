package jworldsim3d.classes.gui;

import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author user
 */
public final class wGui {
    private final static LibWS3D ws3d = LibWS3D.INSTANCE;
    
    public static void drawAll() {
        ws3d.wGuiDrawAll();
    }
    
    public static wGuiSkin getSkin() {
        return new wGuiSkin(ws3d.wGuiGetSkin());
    }
    
    private wGui(){}
}
