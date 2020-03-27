package jworldsim3d.enums;

/**
 *
 * @author Vuvk
 */
public interface wDebugMode {
    public static final int wDM_OFF = 0;
    public static final int wDM_BBOX = 1;
    public static final int wDM_NORMALS = 2;
    public static final int wDM_SKELETON = 4;
    public static final int wDM_MESH_WIRE_OVERLAY = 8;
    public static final int wDM_HALF_TRANSPARENCY = 16;
    public static final int wDM_BBOX_BUFFERS = 32;
    public static final long wDM_FULL = 0xffffffffL;	
}
