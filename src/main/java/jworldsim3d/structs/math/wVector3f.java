package jworldsim3d.structs.math;

import com.sun.jna.Structure;
import jworldsim3d.structs.interfaces.wVector3;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wVector3f extends wVector3 {
    public final static wVector3f ZERO = new wVector3f(0,0,0);
    public final static wVector3f ONE  = new wVector3f(1,1,1);
    public final static wVector3f UP       = new wVector3f(0.0f,1.0f,0.0f);
    public final static wVector3f DOWN     = new wVector3f(0.0f,-1.0f,0.0f);
    public final static wVector3f FORWARD  = new wVector3f( 0.0f, 0.0f, -1.0f);
    public final static wVector3f BACKWARD = new wVector3f( 0.0f, 0.0f, 1.0f);
    public final static wVector3f RIGHT    = new wVector3f( 1.0f, 0.0f,  0.0f);
    public final static wVector3f LEFT     = new wVector3f(-1.0f, 0.0f,  0.0f);

    @Getter @Setter public float x, y, z;
    
    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public ByReference ByReference() {
        return new ByReference(this);
    }
    
    public ByValue ByValue() {
        return new ByValue(this);
    }
                
    public static class ByReference extends wVector3f implements Structure.ByReference {
        public ByReference() {
        }
        public ByReference(float x, float y, float z) {
            super(x, y, z);
        }
        public ByReference(wVector3f vector) {
            super(vector.x, vector.y, vector.z);
        }
    };
    
    public static class ByValue extends wVector3f implements Structure.ByValue {
        public ByValue() {
        }
        public ByValue(float x, float y, float z) {
            super(x, y, z);
        }
        public ByValue(wVector3f vector) {
            super(vector.x, vector.y, vector.z);
        }    
    };
}