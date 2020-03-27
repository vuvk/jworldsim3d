package jworldsim3d.enums;

/**
 *
 * @author Vuvk
 */
public interface wMaterialFlags {
    public static final int wMF_WIREFRAME = 0;
    public static final int wMF_POINTCLOUD = 1;
    public static final int wMF_GOURAUD_SHADING = 2;
    public static final int wMF_LIGHTING = 3;
    public static final int wMF_ZBUFFER = 4;
    public static final int wMF_ZWRITE_ENABLE = 5;
    public static final int wMF_BACK_FACE_CULLING = 6;
    public static final int wMF_FRONT_FACE_CULLING = 7;
    public static final int wMF_BILINEAR_FILTER = 8;
    public static final int wMF_TRILINEAR_FILTER = 9;
    public static final int wMF_ANISOTROPIC_FILTER = 10;
    public static final int wMF_FOG_ENABLE = 11;
    public static final int wMF_NORMALIZE_NORMALS = 12;
    public static final int wMF_TEXTURE_WRAP = 13;
    public static final int wMF_ANTI_ALIASING = 14;
    public static final int wMF_COLOR_MASK = 15;
    public static final int wMF_COLOR_MATERIAL = 16;
}
