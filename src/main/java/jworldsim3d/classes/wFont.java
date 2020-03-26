package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.math.wVector2i;

/**
 *
 * @author Vuvk
 */
public class wFont extends ClassWrap {  
    
    public wFont(Pointer pointer) {
        setPointer(pointer);
    }
    
    public wFont(String path) {
        load(path);
    }
    
    public void load(String path) {
        destroyPointer();
            
        pointer = ws3d.wFontLoad(path);
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }
    }
    
    public void draw(String text, wVector2i fromPos, wVector2i toPos, wColor4s color) {
        if (pointer != null) {
            ws3d.wFontDraw(pointer, (text + '\0').toCharArray(), fromPos.ByValue(), toPos.ByValue(), color.ByValue());
        }
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            ws3d.wFontDestroy(pointer);
        }
    }
}
