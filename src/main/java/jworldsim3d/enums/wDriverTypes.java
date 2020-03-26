package jworldsim3d.enums;

/**
 *
 * @author Vuvk
 */
public interface wDriverTypes {
    public static final int wDRT_NULL = 0;            //' a NULL device with no display
    public static final int wDRT_SOFTWARE = 1;            //' WorldSim3Ds default software renderer
    public static final int wDRT_BURNINGS_VIDEO = 2;      //     ' An improved quality software renderer
    public static final int wDRT_OPENGL = 3;              //' hardware accelerated OpenGL renderer
    public static final int wDRT_DIRECT3D9 = 4;           //' hardware accelerated DirectX 9 renderer
    public static final int wDRT_CHOICE_CONSOLE=6;     
}   
