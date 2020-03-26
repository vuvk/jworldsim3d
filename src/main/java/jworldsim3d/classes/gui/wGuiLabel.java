package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.classes.ClassWrap;
import jworldsim3d.classes.wFont;
import jworldsim3d.structs.math.wVector2i;
import jworldsim3d.structs.wColor4s;

/**
 *
 * @author Vuvk
 */
public class wGuiLabel extends ClassWrap {
    
    public wGuiLabel(String text, wVector2i minPos, wVector2i maxPos) {
        this(text, minPos, maxPos, false, true);
    }
    
    public wGuiLabel(String text, wVector2i minPos, wVector2i maxPos, boolean boBorder, boolean boWordWrap) {
        pointer = ws3d.wGuiLabelCreate((text + '\0').toCharArray(), minPos, maxPos, boBorder, boWordWrap);
    }
    
    public wVector2i getTextSize() {
        return ws3d.wGuiLabelGetTextSize(pointer);
    }
    
    public void setOverrideFont(wFont font) {
        ws3d.wGuiLabelSetOverrideFont(pointer, font.getPointer());
    }
    
    public wFont getOverrideFont() {
        return new wFont(ws3d.wGuiLabelGetOverrideFont(pointer));
    }
    
    public wFont getActiveFont() {
        return new wFont(ws3d.wGuiLabelGetActiveFont(pointer));
    }
    
    public void enableOverrideColor(boolean value) {
        ws3d.wGuiLabelEnableOverrideColor(pointer, value);
    }
    
    public boolean isOverrideColor() {
        return ws3d.wGuiLabelIsOverrideColor(pointer);
    }
    
    public void setOverrideColor(wColor4s color) {
        ws3d.wGuiLabelSetOverrideColor(pointer, color);
    }
    
    public wColor4s getOverrideColor() {
        return ws3d.wGuiLabelGetOverrideColor(pointer);
    }
    
    public void setDrawBackground(boolean value) {
        ws3d.wGuiLabelSetDrawBackground(pointer, value);
    }
    
    public boolean wGuiLabelIsDrawBackGround() {
        return ws3d.wGuiLabelIsDrawBackGround(pointer);
    }
    
    public void setDrawBorder(boolean value) {
        ws3d.wGuiLabelSetDrawBorder(pointer, value);
    }
    
    public boolean wGuiLabelIsDrawBorder() {
        return ws3d.wGuiLabelIsDrawBorder(pointer);
    }
    
    public void wGuiLabelSetTextAlignment(int horGuiAlignment, int verGuiAlignment) {
        ws3d.wGuiLabelSetTextAlignment(pointer, horGuiAlignment, verGuiAlignment);
    }
    
    public void setWordWrap(boolean value) {
        ws3d.wGuiLabelSetWordWrap(pointer, value);
    }
    
    public boolean isWordWrap() {
        return ws3d.wGuiLabelIsWordWrap(pointer);
    }
    
    public void setBackgroundColor(wColor4s color) {
        ws3d.wGuiLabelSetBackgroundColor(pointer, color);
    }
    
    public wColor4s getBackgroundColor() {
        return ws3d.wGuiLabelGetBackgroundColor(pointer);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            //ws3d.wGuiObjectDestroy(pointer);
        }
    }
}
