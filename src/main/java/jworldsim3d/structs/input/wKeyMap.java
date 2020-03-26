package jworldsim3d.structs.input;

import jworldsim3d.enums.input.wKeyAction;
import jworldsim3d.enums.input.wKeyCode;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import jworldsim3d.enums.*;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wKeyMap extends Structure {
    private static final List<String> FIELDS = Arrays.asList("keyAction", 
                                                             "keyCode");
    
    public static final wKeyMap[] wKEYMAP_DEFAULT = {
        new wKeyMap(wKeyAction.wKA_MOVE_FORWARD,  wKeyCode.wKC_KEY_W),
        new wKeyMap(wKeyAction.wKA_MOVE_FORWARD,  wKeyCode.wKC_UP   ),
        new wKeyMap(wKeyAction.wKA_MOVE_BACKWARD, wKeyCode.wKC_KEY_S),
        new wKeyMap(wKeyAction.wKA_MOVE_BACKWARD, wKeyCode.wKC_DOWN ),
        new wKeyMap(wKeyAction.wKA_STRAFE_LEFT,   wKeyCode.wKC_KEY_A),
        new wKeyMap(wKeyAction.wKA_STRAFE_LEFT,   wKeyCode.wKC_LEFT ),
        new wKeyMap(wKeyAction.wKA_STRAFE_RIGHT,  wKeyCode.wKC_KEY_D),
        new wKeyMap(wKeyAction.wKA_STRAFE_RIGHT,  wKeyCode.wKC_RIGHT)
    };
    
    @Getter @Setter public int keyAction;
    @Getter @Setter public int keyCode;
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }    
    
    public static class ByReference extends wKeyMap implements Structure.ByReference {};
    public static class ByValue extends wKeyMap implements Structure.ByValue {};
}
