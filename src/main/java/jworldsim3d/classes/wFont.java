package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.wVector2i;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wFont {
    private final static LibWS3D ws3d = LibWS3D.INSTANCE;  
    
    Pointer pointer = null;
    
    public wFont(String path) {
        load(path);
    }
    
    public void load(String path) {
        if (pointer != null) {
            ws3d.wFontDestroy(pointer);
        }
        pointer = ws3d.wFontLoad(path);
    }
    
    public void draw(String text, wVector2i fromPos, wVector2i toPos, wColor4s color) {
        if (pointer != null) {
            ws3d.wFontDraw(pointer, (text + '\0').toCharArray(), fromPos, toPos, color);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        ws3d.wFontDestroy(pointer);
    }
}
