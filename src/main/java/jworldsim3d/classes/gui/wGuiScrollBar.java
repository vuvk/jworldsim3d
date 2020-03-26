package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.classes.ClassWrap;
import jworldsim3d.structs.math.wVector2i;

/**
 *
 * @author Vuvk
 */
public class wGuiScrollBar extends ClassWrap {
    
    public wGuiScrollBar(boolean horizontal, wVector2i minPos, wVector2i maxPos) {
        pointer = ws3d.wGuiScrollBarCreate(horizontal, minPos, maxPos);
    }
    
    public void setMaxValue(int max) {
        ws3d.wGuiScrollBarSetMaxValue(pointer, max);
    }
    
    public int getMaxValue() {
        return ws3d.wGuiScrollBarGetMaxValue(pointer);
    }
    
    public void setMinValue(int min) {
        ws3d.wGuiScrollBarSetMinValue(pointer, min);
    }
    
    public int getMinValue() {
        return ws3d.wGuiScrollBarGetMinValue(pointer);
    }
    
    public void setValue(int value) {
        ws3d.wGuiScrollBarSetValue(pointer, value);
    }
    
    public int getValue() {
        return ws3d.wGuiScrollBarGetValue(pointer);
    }
    
    public void setSmallStep(int step) {
        ws3d.wGuiScrollBarSetSmallStep(pointer, step);
    }
    
    public int getSmallStep() {
        return ws3d.wGuiScrollBarGetSmallStep(pointer);
    }
    
    public void setLargeStep(int step) {
        ws3d.wGuiScrollBarSetLargeStep(pointer, step);
    }
    
    public int getLargeStep() {
        return ws3d.wGuiScrollBarGetLargeStep(pointer);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            //ws3d.wGuiObjectDestroy(pointer);
        }
    }    
}
