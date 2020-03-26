package jworldsim3d.classes;

import jworldsim3d.structs.math.wVector2i;

/**
 *
 * @author Vuvk
 */
public class wTexture extends ClassWrap {
    public wTexture(String name, wVector2i size, int colorFormat) {
        pointer = ws3d.wTextureCreate(name, size, colorFormat);
    }
    
    public wTexture(String path) {
        load(path);
    }
    
    public void load(String path) {
        destroyPointer();
        
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
    protected void destroyPointer() {
        if (pointer != null) {
            ws3d.wTextureDestroy(pointer);
        }       
    }
}
