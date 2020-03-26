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
public class wJoystickEvent extends Structure implements Structure.ByValue {
    private static final List<String> FIELDS = Arrays.asList("joyId", 
                                                             "buttonStates",
                                                             "axis",
                                                             "POV");
    
    public final static int wNUMBER_OF_BUTTONS = 32;
    public final static int wAXIS_X = 0;
    public final static int wAXIS_Y = 1;
    public final static int wAXIS_Z = 2;
    public final static int wAXIS_R = 3;
    public final static int wAXIS_U = 4;
    public final static int wAXIS_V = 5;
    public final static int wNUMBER_OF_AXES = 6;
    
    @Getter @Setter public byte joyId;//The ID of the joystick which generated this event.
    @Getter @Setter boolean[] buttonStates = new boolean[wNUMBER_OF_BUTTONS];//A helper function to check if a button is pressed
    @Getter @Setter short[] axis = new short[wNUMBER_OF_AXES];
    @Getter @Setter short POV;
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }    
}
