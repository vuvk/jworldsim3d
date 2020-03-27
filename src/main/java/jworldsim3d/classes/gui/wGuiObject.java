package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.classes.ClassWrap;

/**
 *
 * @author Vuvk
 */
public abstract class wGuiObject extends ClassWrap {
    
    public void setId(int id) {
        WS3D.wGuiObjectSetId(pointer, id);
    }
    
    public int getId() {
        return WS3D.wGuiObjectGetId(pointer);
    }
    
    public void setName(String name) {
        WS3D.wGuiObjectSetName(pointer, name);
    }
    
    public boolean isHovered() {
        return WS3D.wGuiObjectIsHovered(pointer);
    }
    
    public String getName() {
        return WS3D.wGuiObjectGetName(pointer);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            //WS3D.wGuiObjectDestroy(pointer);
        }
    }
}
