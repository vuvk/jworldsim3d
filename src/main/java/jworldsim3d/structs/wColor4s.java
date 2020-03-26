package jworldsim3d.structs;

import jworldsim3d.structs.interfaces.wColor4;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wColor4s extends wColor4 {
    
    public final static wColor4s ZERO = new wColor4s(0,0,0,0);
    public final static wColor4s WHITE = new wColor4s(255,255,255,255);
    public final static wColor4s DARKGREY = new wColor4s(255,64,64,64);
    public final static wColor4s GREY = new wColor4s(255,128,128,128);
    public final static wColor4s SILVER = new wColor4s(255,192,192,192);
    public final static wColor4s BLACK = new wColor4s(255,0,0,0);
    public final static wColor4s RED = new wColor4s(255,255,0,0);
    public final static wColor4s DARKRED = new wColor4s(255,140,0,0);
    public final static wColor4s MAROON = new wColor4s(255,128,0,0);
    public final static wColor4s GREEN = new wColor4s(255,0,255,0);
    public final static wColor4s LIME = new wColor4s(255,250,128,114);
    public final static wColor4s DARKGREEN = new wColor4s(255,0,100,0);
    public final static wColor4s OLIVE = new wColor4s(255,240,128,128);
    public final static wColor4s BLUE = new wColor4s(255,0,0,255);
    public final static wColor4s DARKBLUE = new wColor4s(255,0,0,139);
    public final static wColor4s NAVY = new wColor4s(255,0,0,128);
    public final static wColor4s SKYBLUE = new wColor4s(255,135,206,235);
    public final static wColor4s MAGENTA = new wColor4s(255,255,0,255);
    public final static wColor4s PINK = new wColor4s(255,255,192,203);
    public final static wColor4s DEEPPINK = new wColor4s(255,255,20,147);
    public final static wColor4s INDIGO = new wColor4s(255,75,0,130);
    public final static wColor4s YELLOW = new wColor4s(255,255,255,0);
    public final static wColor4s GOLD = new wColor4s(255,255,215,0);
    public final static wColor4s KHAKI = new wColor4s(255,245,230,140);
    public final static wColor4s ORANGE = new wColor4s(255,255,68,0);
    public final static wColor4s DARKORANGE = new wColor4s(255,255,140,0);
    public final static wColor4s ORANGERED = new wColor4s(255,255,69,0);
    
    @Getter @Setter 
    public short alpha, 
                 red, 
                 green, 
                 blue;
    
    public wColor4s(int alpha, int red, int green, int blue) {
        this((short)alpha, (short)red, (short)green, (short)blue);
    }
}