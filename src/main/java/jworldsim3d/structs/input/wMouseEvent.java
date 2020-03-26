package jworldsim3d.structs;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
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
/*
    public wMouseEvent() {
        super();
    }

    public wMouseEvent(int mouseEventType, float delta, wVector2i position, boolean isShift, boolean isControl) {
        this.mouseEventType = mouseEventType;
        this.delta = delta;
        this.position = position;
        this.isShift = isShift;
        this.isControl = isControl;
    }
  */  
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }
}
