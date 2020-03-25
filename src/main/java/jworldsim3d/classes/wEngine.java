package jworldsim3d.classes;

import jworldsim3d.enums.wDriverTypes;
import jworldsim3d.structs.wVector2u;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wEngine {
    private final static LibWS3D ws3d = LibWS3D.INSTANCE;
    
    public static boolean start(int iDevice,
                                      wVector2u size,
                                      int iBPP,
                                      boolean boFullscreen,
                                      boolean boShadows,
                                      boolean boCaptureEvents,
                                      boolean vsync) {
        return ws3d.wEngineStart(iDevice, size, iBPP, boFullscreen, boShadows, boCaptureEvents, vsync);
    }
    
    public static boolean start(int iDevice, wVector2u size) { 
        return start(iDevice, size, 32, false, true, true, true); 
    }
    
    public static boolean start() { 
        return start(wDriverTypes.wDRT_SOFTWARE, wVector2u.DEFAULT_SCREENSIZE); 
    }
    
    public static void closeByEsc() {
        ws3d.wEngineCloseByEsc();
    }
    
    public static void yield() {
        ws3d.wEngineYield();
    }

    public static boolean isRunning() {
        return ws3d.wEngineRunning();
    }
    
    public static void sleep(int ms, boolean pauseTimer) {
        ws3d.wEngineSleep(ms, pauseTimer);
    }
    
    public static void sleep(int ms) {
        sleep(ms, false);
    }

    public static boolean stop(boolean closeDevice) {
        return ws3d.wEngineStop(closeDevice);
    }
    
    public static boolean stop() { 
        return stop(true); 
    }
    
    public static void setFpsLimit(int limit) {
        ws3d.wEngineSetFPS(limit);
    }
    
    public static int getFps() {
        return ws3d.wEngineGetFPS();
    }
    
    private wEngine() {}
}
