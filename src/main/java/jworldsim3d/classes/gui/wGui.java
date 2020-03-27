package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.structs.gui.wGuiEvent;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wGui {
    private final static LibWS3D WS3D = LibWS3D.INSTANCE;
    
    public static void drawAll() {
        WS3D.wGuiDrawAll();
    }
    
    public static void destroyAll() {
        WS3D.wGuiDestroyAll();
    }
    
    public static boolean isEventAvailable() {
        return WS3D.wGuiIsEventAvailable();
    }
    
    public static wGuiEvent readEvent() {
        return WS3D.wGuiReadEvent();
    }
    
    public static boolean load(String fileName, wGuiObject start) {
        return WS3D.wGuiLoad(fileName, start.getPointer());
    }
    
    public static boolean save(String fileName, wGuiObject start) {
        return WS3D.wGuiSave(fileName, start.getPointer());
    }
    
    public static wGuiSkin getSkin() {
        return new wGuiSkin(WS3D.wGuiGetSkin());
    }
    
    public static void setSkin(wGuiSkin skin) {
        WS3D.wGuiSetSkin(skin.getPointer());
    }
    
    public static String getLastSelectedFile() {
        return new String(WS3D.wGuiGetLastSelectedFile());
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
