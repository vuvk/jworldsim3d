package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.math.wVector2i;
import jworldsim3d.structs.math.wVector2u;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wFont extends ClassWrap {  
    
    private boolean isTtf = false;
    
    public static wFont getDefault() {
        return new wFont(LibWS3D.INSTANCE.wFontGetDefault());
    }
    
    public wFont(Pointer pointer) {
        setPointer(pointer);
    }
    
    public wFont(String path) {
        load(path);
    }
           
    public wVector2u getTextSize(String text) {
        return WS3D.wFontGetTextSize(pointer, (text + '\0').toCharArray());
    }
    
    public void setKerningSize(wVector2u kerning) {
        WS3D.wFontSetKerningSize(pointer, kerning.ByValue());
    }
    
    public wVector2u getKerningSize() {
        return WS3D.wFontGetKerningSize(pointer);
    }
    
    public int getCharacterFromPos(String text, int xPixel) {
        return WS3D.wFontGetCharacterFromPos(pointer, (text + '\0').toCharArray(), xPixel);
    }
    
    public void wFontSetInvisibleCharacters(String s) {
        WS3D.wFontSetInvisibleCharacters(pointer, (s + '\0').toCharArray());
    }    
    
    public void load(String path) {
        isTtf = false;
        setPointer(WS3D.wFontLoad(path));  
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }
    }
    
    public void loadFromTtf(String path, int size) {
        loadFromTtf(path, size, false, true);
    }
    
    public void loadFromTtf(String path, int size, boolean antialias, boolean transparency) {
        isTtf = true;
        setPointer(WS3D.wFontLoadFromTTF(path, size, antialias, transparency));          
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }
    }
    
    public void draw(String text, wVector2i fromPos, wVector2i toPos) {
        draw(text, fromPos, toPos, wColor4s.WHITE);
    }
    
    public void draw(String text, wVector2i fromPos, wVector2i toPos, wColor4s color) {
        if (pointer != null) {
            if (!isTtf) {
                WS3D.wFontDraw(pointer, (text + '\0').toCharArray(), fromPos.ByValue(), toPos.ByValue(), color.ByValue());
            } else {
                drawAsTtf(text, fromPos, toPos, color);
            }
        }
    }
        
    public void drawAsTtf(String text, wVector2i fromPos, wVector2i toPos, wColor4s color) {
        drawAsTtf(text, fromPos, toPos, color, false, false);
    }
    
    public void drawAsTtf(String text,
                          wVector2i fromPos,
                          wVector2i toPos,
                          wColor4s color,
                          boolean hcenter,
                          boolean vcenter) {
        WS3D.wFontDrawAsTTF(pointer, (text + '\0').toCharArray(), fromPos.ByValue(), toPos.ByValue(), color.ByValue(), hcenter, vcenter);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            WS3D.wFontDestroy(pointer);
        }
    }
}
