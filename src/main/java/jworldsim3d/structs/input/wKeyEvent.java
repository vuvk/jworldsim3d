package jworldsim3d.structs.input;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wKeyEvent extends Structure implements Structure.ByValue {
    private static final List<String> FIELDS = Arrays.asList("keyCode", 
                                                             "keyDirection",
                                                             "isShift",
                                                             "isControl");
    
    @Getter @Setter public int keyCode;
    @Getter @Setter public int keyDirection;
    @Getter @Setter public boolean isShift;
    @Getter @Setter public boolean isControl;
        
    public wKeyEvent(Pointer peer) {
        super(peer);
    }
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }
}