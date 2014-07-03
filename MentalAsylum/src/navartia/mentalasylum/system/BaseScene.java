package navartia.mentalasylum.system;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

public abstract class BaseScene extends Scene {
    protected Engine engine;
    protected BaseGameActivity activity;
    protected ResourceManager resourceManager;
    protected ZoomCamera camera;
    
    public BaseScene() {
        this.resourceManager = ResourceManager.getInstance();
        this.engine = resourceManager.engine;
        this.activity = resourceManager.activity;
        this.camera = resourceManager.camera;
        
        createScene();
    }
    
    public abstract void initialize();
    
	public abstract void createScene();
	
	public abstract void disposeScene();
}
