package jworldsim3d.structs.gui;

import com.sun.jna.Pointer;
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
public class wGuiEvent extends Structure{
    private static final List<String> FIELDS = Arrays.asList("id", 
                                                             "name",
                                                             "event",
                                                             "position");
    
    @Getter @Setter public int id;
    @Getter @Setter public String name;
    @Getter @Setter public int event;
    @Getter @Setter public wVector2i position;
    
    public wGuiEvent(Pointer peer) {
        super(peer);
    }
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }
    
    public static class ByReference extends wGuiEvent implements Structure.ByReference {};
    public static class ByValue extends wGuiEvent implements Structure.ByValue {};
}