package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.wrapper.LibWS3D;
import lombok.*;

/**
 * Обертка класса над указателем из WS3D
 * @author Vuvk
 */
public abstract class ClassWrap {
    protected final LibWS3D ws3d = LibWS3D.INSTANCE;  
    
    @Getter protected Pointer pointer = null;
    
    abstract protected void destroyPointer();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        destroyPointer();
    }
}
