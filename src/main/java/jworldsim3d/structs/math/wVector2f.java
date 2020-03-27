package jworldsim3d.structs.math;

import com.sun.jna.Structure;
import jworldsim3d.structs.interfaces.wVector2;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wVector2f extends wVector2 {
    public final static wVector2f ZERO = new wVector2f(0,0);
    public final static wVector2f ONE  = new wVector2f(1,1);

    @Getter @Setter public float x, y;
    
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public ByReference ByReference() {
        return new ByReference(this);
    }
    
    public ByValue ByValue() {
        return new ByValue(this);
    }
                
    public static class ByReference extends wVector2f implements Structure.ByReference {
        public ByReference() {
        }
        public ByReference(float x, float y) {
            super(x, y);
        }
        public ByReference(wVector2f vector) {
            super(vector.x, vector.y);
        }
    };
    
    public static class ByValue extends wVector2f implements Structure.ByValue {
        public ByValue() {
        }
        public ByValue(float x, float y) {
            super(x, y);
        }
        public ByValue(wVector2f vector) {
            super(vector.x, vector.y);
        }    
    };
}