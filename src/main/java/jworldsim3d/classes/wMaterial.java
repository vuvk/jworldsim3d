package jworldsim3d.classes;

import com.sun.jna.Pointer;

/**
 *
 * @author Vuvk
 */
public class wMaterial extends ClassWrap {

    wMaterial(Pointer pointer) {
        setPointer(pointer);
    }
    
    public void setTexture(int texIdx, wTexture texture) {
        WS3D.wMaterialSetTexture(pointer, texIdx, texture.getPointer());
    }
    
    public wTexture getTexture(int texIdx) {
        return new wTexture(WS3D.wMaterialGetTexture(pointer, texIdx));
    }
    
    /*
    void wMaterialScaleTexture(Pointer material, int texIdx, wVector2f.ByValue scale);
    void wMaterialScaleTextureFromCenter(Pointer material, int texIdx, wVector2f.ByValue scale);
    void wMaterialTranslateTexture(Pointer material, int texIdx, wVector2f.ByValue translate);
    void wMaterialTranslateTextureTransposed(Pointer material, int texIdx, wVector2f.ByValue translate);
    void wMaterialRotateTexture(Pointer material, int texIdx, float angle);
    void wMaterialSetTextureWrapUMode(Pointer material, int texIdx, int textureClamp);
    int wMaterialGetTextureWrapUMode(Pointer material, int texIdx);
    void wMaterialSetTextureWrapVMode(Pointer material, int texIdx, int textureClamp);
    int wMaterialGetTextureWrapVMode(Pointer material, int texIdx);
    void wMaterialSetTextureLodBias(Pointer material, int texIdx, int lodBias);
    int wMaterialGetTextureLodBias(Pointer material, int texIdx);
    */
    
    public void setFlag(int materialFlag, boolean boValue) {
        WS3D.wMaterialSetFlag(pointer, materialFlag, boValue);
    }
    
    public boolean getFlag(int materialFlag) {
        return WS3D.wMaterialGetFlag(pointer, materialFlag);
    }   
    
    public void setType(int materialType) {
        WS3D.wMaterialSetType(pointer, materialType);
    }
    
    /*
    void wMaterialSetShininess(Pointer material, float shininess);
    float wMaterialGetShininess(Pointer material);
    void wMaterialSetVertexColoringMode(Pointer material, int colorMaterial);
    int wMaterialGetVertexColoringMode(Pointer material);
    void wMaterialSetSpecularColor(Pointer material, wColor4s.ByValue color);
    wColor4s.ByValue wMaterialGetSpecularColor(Pointer material);
    void wMaterialSetDiffuseColor(Pointer material, wColor4s.ByValue color);
    wColor4s.ByValue wMaterialGetDiffuseColor(Pointer material);
    void wMaterialSetAmbientColor(Pointer material, wColor4s.ByValue color);
    wColor4s.ByValue wMaterialGetAmbientColor(Pointer material);
    void wMaterialSetEmissiveColor(Pointer material, wColor4s.ByValue color); 
    wColor4s.ByValue wMaterialGetEmissiveColor(Pointer material);
    void wMaterialSetTypeParameter(Pointer material, float param1);
    float wMaterialGetTypeParameter(Pointer material);
    void wMaterialSetTypeParameter2(Pointer material, float param2);
    float wMaterialGetTypeParameter2(Pointer material);
    void wMaterialSetBlendingMode(Pointer material, int blendFactorSrc, int blendFactorDest);
    void wMaterialSetLineThickness(Pointer material, float lineThickness);
    float wMaterialGetLineThickness(Pointer material);
    void wMaterialSetColorMask(Pointer material, int colorPlane);
    int wMaterialGetColorMask(Pointer material);
    void wMaterialSetAntiAliasingMode(Pointer material, int antiAliasingMode);
    int wMaterialGetAntiAliasingMode(Pointer material);
    */

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            //WS3D.wMaterialDestroy(pointer);
        }
    }
    
}
