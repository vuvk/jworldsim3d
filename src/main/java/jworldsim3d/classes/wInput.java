package jworldsim3d.classes;

import jworldsim3d.structs.input.wJoystickEvent;
import jworldsim3d.structs.input.wJoystickInfo;
import jworldsim3d.structs.input.wKeyEvent;
import jworldsim3d.structs.input.wMouseEvent;
import jworldsim3d.structs.math.wVector2f;
import jworldsim3d.structs.math.wVector2i;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public final class wInput {
    private final static LibWS3D WS3D = LibWS3D.INSTANCE;
    
    ///keyboard///
    ///Get character without waiting for Return to be pressed.
    public static boolean waitKey() {
        return WS3D.wInputWaitKey();
    }
    
    public static boolean isKeyEventAvailable() {
        return WS3D.wInputIsKeyEventAvailable();
    }
    
    public static wKeyEvent readKeyEvent() {
        return WS3D.wInputReadKeyEvent();        
    }
    
    public static boolean isKeyUp(int keyCode) {
        return WS3D.wInputIsKeyUp(keyCode);            
    }
    
    public static boolean isKeyHit(int keyCode) {
        return WS3D.wInputIsKeyHit(keyCode);            
    }
    
    public static boolean isKeyPressed(int keyCode) {
        return WS3D.wInputIsKeyPressed(keyCode);            
    }
    
    ///mouse///
    public static boolean isMouseEventAvailable() {
        return WS3D.wInputIsMouseEventAvailable();
    }
    
    public static wMouseEvent readMouseEvent() {
        return WS3D.wInputReadMouseEvent();
    }
    
    public static void setCursorVisible(boolean boShow) {
        WS3D.wInputSetCursorVisible(boShow);
    }
    
    public static boolean isCursorVisible() {
        return WS3D.wInputIsCursorVisible();
    }
    
    public static void setMousePosition(wVector2i position) {
        WS3D.wInputSetMousePosition((wVector2i.ByReference) position);
    }
    
    public static wVector2i getMousePosition() {
        wVector2i position = new wVector2i();
        WS3D.wInputGetMousePosition((wVector2i.ByReference) position);
        return position;
    }
    
    public static void setMouseLogicalPosition(wVector2f position) {
        WS3D.wInputSetMouseLogicalPosition((wVector2f.ByReference) position);
    }
    
    public static wVector2f getMouseLogicalPosition() {
        wVector2f position = new wVector2f();
        WS3D.wInputGetMouseLogicalPosition((wVector2f.ByReference) position);
        return position;        
    }
    
    public static float getMouseWheel() {
        return WS3D.wInputGetMouseWheel();
    }
    
    public static wVector2i getMouseDelta() {
        wVector2i deltaPos = new wVector2i();
        WS3D.wInputGetMouseDelta((wVector2i.ByReference) deltaPos);
        return deltaPos;        
    }
    
    public static boolean isMouseUp(int mouseButtons) {
        return WS3D.wInputIsMouseUp(mouseButtons);
    }
    
    public static boolean isMouseHit(int mouseButtons) {
        return WS3D.wInputIsMouseHit(mouseButtons);
    }
    
    public static boolean isMousePressed(int mouseButtons) {
        return WS3D.wInputIsMouseHit(mouseButtons);
    }
    
    public static int getMouseX() {
        return WS3D.wInputGetMouseX();
    }
    
    public static int getMouseY() {
        return WS3D.wInputGetMouseY();
    }
    
    public static int getMouseDeltaX() {
        return WS3D.wInputGetMouseDeltaX();
    }
    
    public static int getMouseDeltaY() {
        return WS3D.wInputGetMouseDeltaY();
    }
    
    ///joystick///
    public static boolean activateJoystick() {
        return WS3D.wInputActivateJoystick();
    }
    
    public static int getJoysitcksCount() {
        return WS3D.wInputGetJoysitcksCount();
    }
    
    public static wJoystickInfo getJoystickInfo(int joyIndex) {
        wJoystickInfo info = new wJoystickInfo();
        WS3D.wInputGetJoystickInfo(joyIndex, (wJoystickInfo.ByReference) info);
        return info;
    }
    
    public static boolean isJoystickEventAvailable() {
        return WS3D.wInputActivateJoystick();
    }
    
    public static wJoystickEvent readJoystickEvent() {
        return WS3D.wInputReadJoystickEvent();
    }
    
    private wInput(){}
}
