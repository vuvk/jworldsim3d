package jworldsim3d.structs.input;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import jworldsim3d.structs.math.wVector2i;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wMouseEvent extends Structure implements Structure.ByValue {
    @Getter @Setter public int mouseEventType;
    @Getter @Setter public float delta;
    @Getter @Setter public wVector2i position;
    @Getter @Setter public boolean isShift;
    @Getter @Setter public boolean isControl;
    
    private final static List<String> FIELDS = Arrays.asList("mouseEventType", 
                                                             "delta", 
                                                             "position", 
                                                             "isShift", 
                                                             "isControl");
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }
}
