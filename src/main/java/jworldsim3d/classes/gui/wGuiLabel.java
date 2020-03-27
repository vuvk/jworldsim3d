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
public class wGuiLabel extends wGuiObject {
    
    public wGuiLabel(String text, wVector2i minPos, wVector2i maxPos) {
        this(text, minPos, maxPos, false, true);
    }
    
    public wGuiLabel(String text, wVector2i minPos, wVector2i maxPos, boolean boBorder, boolean boWordWrap) {
        pointer = WS3D.wGuiLabelCreate((text + '\0').toCharArray(), minPos.ByValue(), maxPos.ByValue(), boBorder, boWordWrap);
    }
    
    public wVector2i getTextSize() {
        return WS3D.wGuiLabelGetTextSize(pointer);
    }
    
    public void setOverrideFont(wFont font) {
        WS3D.wGuiLabelSetOverrideFont(pointer, font.getPointer());
    }
    
    public wFont getOverrideFont() {
        return new wFont(WS3D.wGuiLabelGetOverrideFont(pointer));
    }
    
    public wFont getActiveFont() {
        return new wFont(WS3D.wGuiLabelGetActiveFont(pointer));
    }
    
    public void enableOverrideColor(boolean value) {
        WS3D.wGuiLabelEnableOverrideColor(pointer, value);
    }
    
    public boolean isOverrideColor() {
        return WS3D.wGuiLabelIsOverrideColor(pointer);
    }
    
    public void setOverrideColor(wColor4s color) {
        WS3D.wGuiLabelSetOverrideColor(pointer, color.ByValue());
    }
    
    public wColor4s getOverrideColor() {
        return WS3D.wGuiLabelGetOverrideColor(pointer);
    }
    
    public void setDrawBackground(boolean value) {
        WS3D.wGuiLabelSetDrawBackground(pointer, value);
    }
    
    public boolean wGuiLabelIsDrawBackGround() {
        return WS3D.wGuiLabelIsDrawBackGround(pointer);
    }
    
    public void setDrawBorder(boolean value) {
        WS3D.wGuiLabelSetDrawBorder(pointer, value);
    }
    
    public boolean wGuiLabelIsDrawBorder() {
        return WS3D.wGuiLabelIsDrawBorder(pointer);
    }
    
    public void wGuiLabelSetTextAlignment(int horGuiAlignment, int verGuiAlignment) {
        WS3D.wGuiLabelSetTextAlignment(pointer, horGuiAlignment, verGuiAlignment);
    }
    
    public void setWordWrap(boolean value) {
        WS3D.wGuiLabelSetWordWrap(pointer, value);
    }
    
    public boolean isWordWrap() {
        return WS3D.wGuiLabelIsWordWrap(pointer);
    }
    
    public void setBackgroundColor(wColor4s color) {
        WS3D.wGuiLabelSetBackgroundColor(pointer, color.ByValue());
    }
    
    public wColor4s getBackgroundColor() {
        return WS3D.wGuiLabelGetBackgroundColor(pointer);
    }
}
