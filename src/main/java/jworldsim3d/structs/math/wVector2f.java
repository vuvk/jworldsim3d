package jworldsim3d.structs.math;

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
}