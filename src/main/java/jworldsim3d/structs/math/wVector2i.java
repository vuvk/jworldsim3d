package jworldsim3d.structs.math;

import jworldsim3d.structs.interfaces.wVector2;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wVector2i extends wVector2 {
    public final static wVector2i ZERO = new wVector2i(0,0);
    public final static wVector2i ONE  = new wVector2i(1,1);

    @Getter @Setter public int x, y;
}
