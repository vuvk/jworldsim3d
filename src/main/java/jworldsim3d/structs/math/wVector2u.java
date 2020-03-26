package jworldsim3d.structs.math;

/**
 *
 * @author Vuvk
 */
public class wVector2u extends wVector2i {
    public final static wVector2u ZERO = new wVector2u(0,0);
    public final static wVector2u ONE  = new wVector2u(1,1);
    public final static wVector2u DEFAULT_SCREENSIZE  = new wVector2u(800,600);
    
    public wVector2u(int x, int y) {
        super(x, y);
    }
}
