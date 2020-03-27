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
        return ws3d.wFontGetTextSize(pointer, (text + '\0').toCharArray());
    }
    
    public void setKerningSize(wVector2u kerning) {
        ws3d.wFontSetKerningSize(pointer, kerning.ByValue());
    }
    
    public wVector2u getKerningSize() {
        return ws3d.wFontGetKerningSize(pointer);
    }
    
    public int getCharacterFromPos(String text, int xPixel) {
        return ws3d.wFontGetCharacterFromPos(pointer, (text + '\0').toCharArray(), xPixel);
    }
    
    public void wFontSetInvisibleCharacters(String s) {
        ws3d.wFontSetInvisibleCharacters(pointer, (s + '\0').toCharArray());
    }    
    
    public void load(String path) {
        isTtf = false;
        setPointer(ws3d.wFontLoad(path));  
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }
    }
    
    public void loadFromTtf(String path, int size) {
        loadFromTtf(path, size, false, true);
    }
    
    public void loadFromTtf(String path, int size, boolean antialias, boolean transparency) {
        isTtf = true;
        setPointer(ws3d.wFontLoadFromTTF(path, size, antialias, transparency));          
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
                ws3d.wFontDraw(pointer, (text + '\0').toCharArray(), fromPos.ByValue(), toPos.ByValue(), color.ByValue());
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
        ws3d.wFontDrawAsTTF(pointer, (text + '\0').toCharArray(), fromPos.ByValue(), toPos.ByValue(), color.ByValue(), hcenter, vcenter);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            ws3d.wFontDestroy(pointer);
        }
    }
}
