package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.classes.ClassWrap;
import jworldsim3d.structs.math.wVector2i;

/**
 *
 * @author Vuvk
 */
public class wGuiScrollBar extends wGuiObject {
    
    public wGuiScrollBar(boolean horizontal, wVector2i minPos, wVector2i maxPos) {
        pointer = WS3D.wGuiScrollBarCreate(horizontal, minPos.ByValue(), maxPos.ByValue());
    }
    
    public void setMaxValue(int max) {
        WS3D.wGuiScrollBarSetMaxValue(pointer, max);
    }
    
    public int getMaxValue() {
        return WS3D.wGuiScrollBarGetMaxValue(pointer);
    }
    
    public void setMinValue(int min) {
        WS3D.wGuiScrollBarSetMinValue(pointer, min);
    }
    
    public int getMinValue() {
        return WS3D.wGuiScrollBarGetMinValue(pointer);
    }
    
    public void setValue(int value) {
        WS3D.wGuiScrollBarSetValue(pointer, value);
    }
    
    public int getValue() {
        return WS3D.wGuiScrollBarGetValue(pointer);
    }
    
    public void setSmallStep(int step) {
        WS3D.wGuiScrollBarSetSmallStep(pointer, step);
    }
    
    public int getSmallStep() {
        return WS3D.wGuiScrollBarGetSmallStep(pointer);
    }
    
    public void setLargeStep(int step) {
        WS3D.wGuiScrollBarSetLargeStep(pointer, step);
    }
    
    public int getLargeStep() {
        return WS3D.wGuiScrollBarGetLargeStep(pointer);
    } 
}
