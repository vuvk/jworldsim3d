package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.structs.gui.wGuiEvent;
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
    
    public static void destroyAll() {
        ws3d.wGuiDestroyAll();
    }
    
    public static boolean isEventAvailable() {
        return ws3d.wGuiIsEventAvailable();
    }
    
    public static wGuiEvent readEvent() {
        return ws3d.wGuiReadEvent();
    }
    
    public static boolean load(String fileName, wGuiObject start) {
        return ws3d.wGuiLoad(fileName, start.getPointer());
    }
    
    public static boolean save(String fileName, wGuiObject start) {
        return ws3d.wGuiSave(fileName, start.getPointer());
    }
    
    public static wGuiSkin getSkin() {
        return new wGuiSkin(ws3d.wGuiGetSkin());
    }
    
    public static void setSkin(wGuiSkin skin) {
        ws3d.wGuiSetSkin(skin.getPointer());
    }
    
    public static String getLastSelectedFile() {
        return new String(ws3d.wGuiGetLastSelectedFile());
    }
    
    ///Returns the element which holds the focus.
    /*public static wGuiObject wGuiGetObjectFocused() {
        
    }
    
    ///Returns the element which was last under the mouse cursor.
    public static Pointer wGuiGetObjectHovered();
    public static Pointer wGuiGetRootNode();
    public static Pointer wGuiGetObjectById(int id, boolean searchchildren);
    public static Pointer wGuiGetObjectByName(String name, boolean searchchildren);
    */
    
    private wGui(){}
}
