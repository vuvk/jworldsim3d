package jworldsim3d.structs.interfaces;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Vuvk
 */
public abstract class wColor4 extends Structure implements Structure.ByValue {    
    private final static List<String> FIELDS = Arrays.asList("alpha", "red", "green", "blue");
        
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }    
}
