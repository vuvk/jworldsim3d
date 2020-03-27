package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.wrapper.LibWS3D;
import lombok.*;

/**
 * Обертка класса над указателем из WS3D
 * @author Vuvk
 */
public abstract class ClassWrap {
    protected final LibWS3D WS3D = LibWS3D.INSTANCE;  
    
    @Getter protected Pointer pointer = null;
    
    abstract protected void destroyPointer();

    public void setPointer(Pointer pointer) {
        destroyPointer();
        this.pointer = pointer;
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        destroyPointer();
    }
}
