package jworldsim3d.structs.input;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wJoystickInfo extends Structure {
    private static final List<String> FIELDS = Arrays.asList("axes", 
                                                             "buttons",
                                                             "joyId",
                                                             "joyName",
                                                             "joystickPovHat");
    
    //Note: with a Linux device, the POV hat (if any) will use two axes.
    //These will be included in this count.
    @Getter @Setter public int axes;//The number of axes that the joystick has, i.e. X, Y, Z, R, U, V.
    @Getter @Setter public int buttons;//The number of buttons that the joystick has.
    //This is an internal WS3D index; it does not map directly to any particular hardware joystick.
    @Getter @Setter public byte joyId;//The ID of the joystick.
    //char joyName0[256];//
    @Getter @Setter public String joyName;
    //A Windows device will identify the presence or absence or the POV hat.
    //A Linux device cannot, and will always return wJPH_UNKNOWN.
    //Mac OSX not supported!
    @Getter @Setter public int joystickPovHat;//An indication of whether the joystick has a POV hat.  
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }    
    
    public static class ByReference extends wJoystickInfo implements Structure.ByReference {};
    public static class ByValue extends wJoystickInfo implements Structure.ByValue {};
}
