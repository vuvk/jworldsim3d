package examples;

import jworldsim3d.classes.wEngine;
import jworldsim3d.classes.wFont;
import jworldsim3d.classes.wScene;
import jworldsim3d.classes.wWindow;
import jworldsim3d.structs.wColor4s;
import jworldsim3d.structs.wVector2i;


/**
 * Test
 * @author Vuvk
 */
public class Example01 {

    public static void main(String[] args) {    
        int prevFps = 0, 
            curFps = 0;   
        String wndCaption = "Example 01";
        
        wEngine.start();
        
        wFont font = new wFont("myfont.bmp");
        wVector2i fromPos  = new wVector2i(120, 80);
        wVector2i toPos    = new wVector2i(250, 96);
        wColor4s backColor = new wColor4s(255, 255, 0, 0);
        wColor4s fontColor = new wColor4s(255, 0, 125, 0);
                
        wWindow.setCaption(wndCaption);
        
        while (wEngine.isRunning()) {
            wScene.begin(backColor);
            wScene.drawAll();
            font.draw("Hello, Java!", fromPos, toPos, fontColor);
            wScene.end();
            
            wEngine.yield();
            wEngine.closeByEsc();
            
            /// update FPS
            curFps = wEngine.getFps();
            if (prevFps != curFps) {
                prevFps = curFps;
                wWindow.setCaption(wndCaption + " FPS: " + curFps);
            }
        }
        
        wEngine.stop();
    }
}
