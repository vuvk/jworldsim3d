package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.enums.wAntiAliasingMode;
import jworldsim3d.structs.math.wVector2f;
import jworldsim3d.structs.math.wVector2i;
import jworldsim3d.structs.wColor4s;

/**
 *
 * @author Vuvk
 */
public class wTexture extends ClassWrap {
    
    public wTexture(Pointer pointer) {
        setPointer(pointer);
    }
    
    public wTexture(String name, wVector2i size, int colorFormat) {
        pointer = ws3d.wTextureCreate(name, size.ByValue(), colorFormat);
    }
    
    public wTexture(String path) {
        load(path);
    }
    
    public void load(String path) {
        destroyPointer();
        
        pointer = ws3d.wTextureLoad(path);
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }
    }
    
    public void lock() {
        pointer = ws3d.wTextureLock(pointer);
    }
    
    public void unlock() {
        ws3d.wTextureUnlock(pointer);
    }
    
    public void draw(wVector2i pos) {
        draw(pos, true, wColor4s.WHITE);
    }
    
    public void draw(wVector2i pos, boolean useAlphaChannel, wColor4s color) {
        ws3d.wTextureDraw(pointer, pos.ByValue(), useAlphaChannel, color.ByValue());
    }
    
    public void draw(wVector2i pos, wVector2f scale) {
        draw(pos, scale);
    }
    
    public void draw(wVector2i pos, wVector2f scale, boolean useAlphaChannel) {
        ws3d.wTextureDrawEx(pointer, pos.ByValue(), scale.ByValue(), useAlphaChannel);
    }
    
    public void draw(wVector2i pos,
                     wVector2i fromPos,
                     wVector2i toPos) {
        draw(pos, fromPos, toPos, true, wColor4s.WHITE);
    }
    
    public void draw(wVector2i pos,
                     wVector2i fromPos,
                     wVector2i toPos,
                     boolean useAlphaChannel,
                     wColor4s color) {
        ws3d.wTextureDrawElement(pointer, pos.ByValue(), fromPos.ByValue(), toPos.ByValue(), useAlphaChannel, color.ByValue());
    }
    
    public void draw(wVector2i destFromPos,
                     wVector2i destToPos,
                     wVector2i sourceFromPos,
                     wVector2i sourceToPos) {
        draw(destFromPos, destToPos, sourceFromPos, sourceToPos, true);
    }
    
    public void draw(wVector2i destFromPos,
                     wVector2i destToPos,
                     wVector2i sourceFromPos,
                     wVector2i sourceToPos,
                     boolean useAlphaChannel) {
        ws3d.wTextureDrawElementStretch(pointer, destFromPos.ByValue(), destToPos.ByValue(), sourceFromPos.ByValue(), sourceToPos.ByValue(), useAlphaChannel);
    }
    
    public void draw(wVector2i pos,
                     wVector2i rotPoint,
                     float rotation) {
        draw(pos, rotPoint, rotation, wVector2f.ONE);
    }
    
    public void draw(wVector2i pos,
                     wVector2i rotPoint,
                     float rotation,
                     wVector2f scale) {
        draw(pos, rotPoint, rotation, scale, true, wColor4s.WHITE, wAntiAliasingMode.wAAM_SIMPLE, true, true, true);
    }
    
    public void draw(wVector2i pos,
                     wVector2i rotPoint,
                     float rotation,
                     wVector2f scale,
                     boolean useAlphaChannel,
                     wColor4s color,
                     int antiAliasingMode,
                     boolean bFilter,
                     boolean tFilter,
                     boolean aFilter) {
        ws3d.wTextureDrawAdvanced(pointer, pos.ByValue(), rotPoint.ByValue(), rotation, scale.ByValue(), useAlphaChannel, color.ByValue(), antiAliasingMode, bFilter, tFilter, aFilter);
    }
    
    public void draw(wVector2i pos,
                     wVector2i fromPos,
                     wVector2i toPos,
                     wVector2i rotPoint,
                     float rotAngleDeg,
                     wVector2f scale) {
        draw(pos, fromPos, toPos, rotPoint, rotAngleDeg, scale, true, wColor4s.WHITE, wAntiAliasingMode.wAAM_SIMPLE, true, true, true);
    }
    
    public void draw(wVector2i pos,
                     wVector2i fromPos,
                     wVector2i toPos,
                     wVector2i rotPoint,
                     float rotAngleDeg,
                     wVector2f scale,
                     boolean useAlphaChannel,
                     wColor4s color,
                     int antiAliasingMode,
                     boolean bilinearFilter,
                     boolean trilinearFilter,
                     boolean anisotropFilter) {
        ws3d.wTextureDrawElementAdvanced(pointer, pos.ByValue(), fromPos.ByValue(), toPos.ByValue(), rotPoint.ByValue(), rotAngleDeg, scale.ByValue(), useAlphaChannel, color.ByValue(), antiAliasingMode, bilinearFilter, trilinearFilter, anisotropFilter);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            ws3d.wTextureDestroy(pointer);
        }       
    }
}
