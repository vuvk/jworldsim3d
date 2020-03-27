package jworldsim3d.classes;

import com.sun.jna.Pointer;
import jworldsim3d.wrapper.LibWS3D;

/**
 *
 * @author Vuvk
 */
public class wMesh extends ClassWrap {
    
    public static wMesh create(String name) {
        return new wMesh(LibWS3D.INSTANCE.wMeshCreate(name));
    }
    
    public static wMesh createSphere(String name, float radius, int polyCount) {
        return new wMesh(LibWS3D.INSTANCE.wMeshCreateSphere(name, radius, polyCount));
    }
    
    public static wMesh createCube(String name) {
        return new wMesh(LibWS3D.INSTANCE.wMeshCreateCube());
    }
    
    public wMesh(Pointer pointer) {
        setPointer(pointer);
    }
    
    public wMesh(String path) {
        load(path);
    }
    
    public wMesh(String path, boolean tangents) {
        load(path, tangents);
    }
    
    public void load(String path) {
        load(path);
    }
    
    public void load(String path, boolean tangents) {
        destroyPointer();
        
        pointer = WS3D.wMeshLoad(path, tangents);
        if (pointer == null) {
            System.out.println("Error when loading '" + path + "'");
        }        
    }    
        
    //void wMeshAddMeshBuffer(Pointer mesh, Pointer meshbuffer);
    /**
     * 
     * @param meshFileFormat
     * @param filename
     * @return true - успешно
     */
    public boolean save(int meshFileFormat, String filename) {
        return (WS3D.wMeshSave(pointer, meshFileFormat, filename) == 3);
    }
    
    public boolean setName(String name) {
        return WS3D.wMeshSetName(pointer, name);
    }
    
    public String getName(Pointer mesh) {
        return WS3D.wMeshGetName(pointer);
    }
    
    public int getType(Pointer mesh) {
        return WS3D.wMeshGetType(pointer);
    }
    
    public void flipSurface(Pointer mesh) {
        WS3D.wMeshFlipSurface(pointer);
    }

    @Override
    protected void destroyPointer() {
        if (pointer != null) {
            WS3D.wMeshDestroy(pointer);
        }
    }
}
