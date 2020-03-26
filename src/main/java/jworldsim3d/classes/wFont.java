package jworldsim3d.classes;

import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.math.wVector2i;

/**
 *
 * @author Vuvk
 */
public class wFont extends ClassWrap {    
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
            ws3d.wFontDraw(pointer, (text + '\0').toCharArray(), fromPos, toPos, color);
        }
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            ws3d.wFontDestroy(pointer);
        }
    }
}
