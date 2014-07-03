package navartia.mentalasylum.system;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.ui.activity.BaseGameActivity;

public class ResourceManager {
	protected Engine engine;
	protected BaseGameActivity activity;
	protected ZoomCamera camera;

	private static ResourceManager INSTANCE;
	
	public static void initialize(Engine engine, BaseGameActivity activity, ZoomCamera camera) {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
    }
	
	public void loadLevelScene() {
		
	}
	
	public static ResourceManager getInstance() {
		//Lazy instantiation
		if (INSTANCE == null)
			INSTANCE = new ResourceManager();
		
		return INSTANCE;
	}
}
