package jworldsim3d.classes.gui;

import com.sun.jna.Pointer;
import jworldsim3d.classes.ClassWrap;
import jworldsim3d.classes.wFont;
import jworldsim3d.enums.gui.wGuiDefaultFont;
import jworldsim3d.structs.wColor4s;

/**
 *
 * @author Vuvk
 */
public class wGuiSkin extends wGuiObject {   
    
    public wGuiSkin(Pointer pointer) {
        setPointer(pointer);
    } 
    
    public wGuiSkin(int guiSkinSpace) {
        pointer = ws3d.wGuiSkinCreate(guiSkinSpace);
    }
    
    public wColor4s getColor(int guiDefaultColor) {
        return ws3d.wGuiSkinGetColor(pointer, guiDefaultColor);
    }
    
    public void setColor(int guiDefaultColor, wColor4s color) {
        ws3d.wGuiSkinSetColor(pointer, guiDefaultColor, color.ByValue());
    }
    
    public void setSize(int guiDefaultSize, int newSize) {
        ws3d.wGuiSkinSetSize(pointer, guiDefaultSize, newSize);
    }
    
    public int getSize(int guiDefaultSize) {
        return ws3d.wGuiSkinGetSize(pointer, guiDefaultSize);
    }
    
    public String getDefaultText(int guiDefaultText) {
        return new String(ws3d.wGuiSkinGetDefaultText(pointer, guiDefaultText));
    }
    
    public void setDefaultText(int guiDefaultText, String newText) {
        ws3d.wGuiSkinSetDefaultText(pointer, guiDefaultText, (newText + '\0').toCharArray());
    }
    
    public void setFont(wFont font) {
        setFont(font, wGuiDefaultFont.wGDF_DEFAULT);
    }
    
    public void setFont(wFont font, int guiDefaultFont) {
        ws3d.wGuiSkinSetFont(pointer, font.getPointer(), guiDefaultFont);
    }
    
    public wFont getFont() {
        return getFont(wGuiDefaultFont.wGDF_DEFAULT);
    }
    
    public wFont getFont(int guiDefaultFont) {
        return new wFont(ws3d.wGuiSkinGetFont(pointer, guiDefaultFont));
    }
    
    //void wGuiSkinSetSpriteBank(Pointer skin, Pointer bank);
    //Pointer wGuiSkinGetSpriteBank(Pointer skin);
    
    public void setIcon(int guiDefaultIcon, int index) {
        ws3d.wGuiSkinSetIcon(pointer, guiDefaultIcon, index);
    }
    
    public int getIcon(int guiDefaultIcon) {
        return ws3d.wGuiSkinGetIcon(pointer, guiDefaultIcon);
    }
        
    public int getType() {
        return ws3d.wGuiSkinGetType(pointer);
    } 
}
