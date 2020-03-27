package jworldsim3d.structs;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import jworldsim3d.structs.math.wVector2f;
import jworldsim3d.structs.math.wVector3f;
import lombok.*;

/**
 *
 * @author Vuvk
 */
@AllArgsConstructor @NoArgsConstructor
public class wVert extends Structure {
    private static final List<String> FIELDS = Arrays.asList("vertPos", 
                                                             "vertNormal",
                                                             "vertColor",
                                                             "texCoords");
    @Getter @Setter public wVector3f.ByValue vertPos;
    @Getter @Setter public wVector3f.ByValue vertNormal;
    @Getter @Setter public wColor4s.ByValue  vertColor;     // The 32bit ARGB color of the vertex
    @Getter @Setter public wVector2f.ByValue texCoords;

    public wVert(wVector3f vertPos, wVector3f vertNormal, wColor4s vertColor, wVector2f texCoords) {
        this.vertPos = (wVector3f.ByValue) vertPos;
        this.vertNormal = (wVector3f.ByValue) vertNormal;
        this.vertColor = (wColor4s.ByValue) vertColor;
        this.texCoords = (wVector2f.ByValue) texCoords;
    }
    
    @Override
    protected List<String> getFieldOrder() {
        return FIELDS;
    }
    
    public static class ByReference extends wVert implements Structure.ByReference {};
    public static class ByValue extends wVert implements Structure.ByValue {};
}
