package navartia.mentalasylum.scene;

import navartia.mentalasylum.scene.SceneManager.SceneType;
import navartia.mentalasylum.system.ResourceManager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

public abstract class BaseScene extends Scene {
    protected Engine engine;
    protected BaseGameActivity activity;
    protected ResourceManager resourceManager;
    protected ZoomCamera camera;
    protected VertexBufferObjectManager vbom;
    
    public BaseScene() {
        this.resourceManager = ResourceManager.getInstance();
        this.engine = resourceManager.engine;
        this.activity = resourceManager.activity;
        this.camera = resourceManager.camera;
        this.vbom = resourceManager.vbom;
        
        initialize();
        createScene();
    }
    
    //---------------------------------------------
    // ABSTRACT METHODS
    //---------------------------------------------
    public abstract void initialize();
    
	public abstract void createScene();
	
	public abstract void disposeScene();
	
	public abstract SceneType getSceneType();
}
