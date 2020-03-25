package jworldsim3d.wrapper;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import jworldsim3d.Constants;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.wVector2i;
import jworldsim3d.structs.wVector2u;

/**
 *
 * @author Vuvk
 */
public interface LibWS3D extends StdCallLibrary {  
    public final static LibWS3D INSTANCE = (LibWS3D)Native.load(Constants.LIB_NAME, LibWS3D.class);
    
    boolean wEngineStart(int iDevice,
                         wVector2u size,
                         int iBPP,
                         boolean boFullscreen,
                         boolean boShadows,
                         boolean boCaptureEvents,
                         boolean vsync);
    void wEngineCloseByEsc();
    void wEngineYield();
    boolean wEngineRunning();
    ///Pause execution and let other processes to run for a specified amount of time.
    void wEngineSleep(int ms, boolean pauseTimer);
    boolean wEngineStop(boolean closeDevice);
    void wEngineSetFPS(int limit);
    int wEngineGetFPS();
    
    Pointer wFontLoad(String fontPath);
    void wFontDraw(Pointer font,
                   char[] text,
                   wVector2i fromPos,
                   wVector2i toPos,
                   wColor4s color);
    void wFontDestroy(Pointer font);

    void wWindowSetCaption(char[] wcptrText);        

    boolean wSceneBegin (wColor4s color);
    void wSceneDrawAll();
    boolean wSceneEnd();
}