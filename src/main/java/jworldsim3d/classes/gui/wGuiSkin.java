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
        pointer = WS3D.wGuiSkinCreate(guiSkinSpace);
    }
    
    public wColor4s getColor(int guiDefaultColor) {
        return WS3D.wGuiSkinGetColor(pointer, guiDefaultColor);
    }
    
    public void setColor(int guiDefaultColor, wColor4s color) {
        WS3D.wGuiSkinSetColor(pointer, guiDefaultColor, color.ByValue());
    }
    
    public void setSize(int guiDefaultSize, int newSize) {
        WS3D.wGuiSkinSetSize(pointer, guiDefaultSize, newSize);
    }
    
    public int getSize(int guiDefaultSize) {
        return WS3D.wGuiSkinGetSize(pointer, guiDefaultSize);
    }
    
    public String getDefaultText(int guiDefaultText) {
        return new String(WS3D.wGuiSkinGetDefaultText(pointer, guiDefaultText));
    }
    
    public void setDefaultText(int guiDefaultText, String newText) {
        WS3D.wGuiSkinSetDefaultText(pointer, guiDefaultText, (newText + '\0').toCharArray());
    }
    
    public void setFont(wFont font) {
        setFont(font, wGuiDefaultFont.wGDF_DEFAULT);
    }
    
    public void setFont(wFont font, int guiDefaultFont) {
        WS3D.wGuiSkinSetFont(pointer, font.getPointer(), guiDefaultFont);
    }
    
    public wFont getFont() {
        return getFont(wGuiDefaultFont.wGDF_DEFAULT);
    }
    
    public wFont getFont(int guiDefaultFont) {
        return new wFont(WS3D.wGuiSkinGetFont(pointer, guiDefaultFont));
    }
    
    //void wGuiSkinSetSpriteBank(Pointer skin, Pointer bank);
    //Pointer wGuiSkinGetSpriteBank(Pointer skin);
    
    public void setIcon(int guiDefaultIcon, int index) {
        WS3D.wGuiSkinSetIcon(pointer, guiDefaultIcon, index);
    }
    
    public int getIcon(int guiDefaultIcon) {
        return WS3D.wGuiSkinGetIcon(pointer, guiDefaultIcon);
    }
        
    public int getType() {
        return WS3D.wGuiSkinGetType(pointer);
    } 
}
