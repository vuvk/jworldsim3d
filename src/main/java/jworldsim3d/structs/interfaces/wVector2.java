package jworldsim3d.structs.interfaces;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Vuvk
 */
public abstract class wVector2 extends Structure implements Structure.ByValue {
    private static final List<String> FIELDS = Arrays.asList("x", "y");
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }
}
