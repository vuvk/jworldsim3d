package jworldsim3d.classes;

import jworldsim3d.enums.wDriverTypes;
import jworldsim3d.structs.math.wVector2u;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wEngine {
    private final static LibWS3D WS3D = LibWS3D.INSTANCE;
    
    public static boolean start() { 
        return start(wDriverTypes.wDRT_SOFTWARE, wVector2u.DEFAULT_SCREENSIZE); 
    }
    
    public static boolean start(int iDevice, wVector2u size) { 
        return start(iDevice, size, 32, false, true, true, true); 
    }
    
    public static boolean start(int iDevice,
                                wVector2u size,
                                int iBPP,
                                boolean boFullscreen,
                                boolean boShadows,
                                boolean boCaptureEvents,
                                boolean vsync) {
        return WS3D.wEngineStart(iDevice, size.ByValue(), iBPP, boFullscreen, boShadows, boCaptureEvents, vsync);
    }
    
    public static void closeByEsc() {
        WS3D.wEngineCloseByEsc();
    }
    
    public static void yield() {
        WS3D.wEngineYield();
    }

    public static boolean isRunning() {
        return WS3D.wEngineRunning();
    }
    
    public static void sleep(int ms, boolean pauseTimer) {
        WS3D.wEngineSleep(ms, pauseTimer);
    }
    
    public static void sleep(int ms) {
        sleep(ms, false);
    }

    public static boolean stop(boolean closeDevice) {
        return WS3D.wEngineStop(closeDevice);
    }
    
    public static boolean stop() { 
        return stop(true); 
    }
    
    public static void setFpsLimit(int limit) {
        WS3D.wEngineSetFPS(limit);
    }
    
    public static int getFps() {
        return WS3D.wEngineGetFPS();
    }
    
    private wEngine() {}
}
