package jworldsim3d;

import java.io.File;
import java.nio.file.Paths;

/**
 *
 * @author Vuvk
 */
public final class jWorldSim3D {
    /**
     * Для работы с движком ОБЯЗАТЕЛЬНО сначала выполнить эту функцию для инициализации путей
     */
    public final static void init() {  
        String osName = System.getProperty("os.name").toLowerCase();
        
        String osDir = null;
        if (osName.indexOf("win") >= 0) {
            osDir = "win";
        } else if (osName.indexOf("nix") >= 0) {
            osDir = "linux";        
        }
        
        if (osDir == null) {
            System.out.println("I don''t know your OS!");
            return;
        }
        
        String initPath = Paths.get(".").toAbsolutePath().normalize().toString();
        if (System.getProperty("os.arch").equals("x86")) {
            initPath += File.separator + osDir + "-x86";
        } else {
            initPath += File.separator + osDir + "-x86_64";            
        }        
        
        System.setProperty("jna.library.path", initPath);
        System.setProperty("java.library.path", initPath);
        
        
    }
    
    private jWorldSim3D() {}
}
