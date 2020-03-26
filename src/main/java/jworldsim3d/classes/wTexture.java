package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.wVector2i;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wTexture {
    private final static LibWS3D ws3d = LibWS3D.INSTANCE;  
    
    Pointer pointer = null;
    
    public wTexture(String name, wVector2i size, int colorFormat) {
        pointer = ws3d.wTextureCreate(name, size, colorFormat);
    }
    
    public wTexture(String path) {
        load(path);
    }
    
    public void load(String path) {
        if (pointer != null) {
            ws3d.wTextureDestroy(pointer);
        }
        pointer = ws3d.wTextureLoad(path);
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }
    }
    
    public void lock() {
        pointer = ws3d.wTextureLock(pointer);
    }
    
    public void unlock() {
        ws3d.wTextureUnlock(pointer);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (pointer != null) {
            ws3d.wFontDestroy(pointer);
        }
    }    
}
