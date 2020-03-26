package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.classes.ClassWrap;

/**
 *
 * @author user
 */
public abstract class wGuiObject extends ClassWrap {
    
    public void setId(int id) {
        ws3d.wGuiObjectSetId(pointer, id);
    }
    
    public int getId() {
        return ws3d.wGuiObjectGetId(pointer);
    }
    
    public void setName(String name) {
        ws3d.wGuiObjectSetName(pointer, name);
    }
    
    public boolean isHovered() {
        return ws3d.wGuiObjectIsHovered(pointer);
    }
    
    public String getName() {
        return ws3d.wGuiObjectGetName(pointer);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            //ws3d.wGuiObjectDestroy(pointer);
        }
    }
}
