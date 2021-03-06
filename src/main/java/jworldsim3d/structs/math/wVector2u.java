package jworldsim3d.structs.math;

import com.sun.jna.Structure;
import jworldsim3d.structs.interfaces.wVector2;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wVector2u extends wVector2 {
    public final static wVector2u ZERO = new wVector2u(0,0);
    public final static wVector2u ONE  = new wVector2u(1,1);
    public final static wVector2u DEFAULT_SCREENSIZE = new wVector2u(800,600);    

    @Getter @Setter public int x, y;
    
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public ByReference ByReference() {
        return new ByReference(this);
    }
    
    public ByValue ByValue() {
        return new ByValue(this);
    }
                
    public static class ByReference extends wVector2u implements Structure.ByReference {
        public ByReference() {
        }
        public ByReference(int x, int y) {
            super(x, y);
        }
        public ByReference(wVector2u vector) {
            super(vector.x, vector.y);
        }
    };
    
    public static class ByValue extends wVector2u implements Structure.ByValue {
        public ByValue() {
        }
        public ByValue(int x, int y) {
            super(x, y);
        }
        public ByValue(wVector2u vector) {
            super(vector.x, vector.y);
        }    
    };
}
