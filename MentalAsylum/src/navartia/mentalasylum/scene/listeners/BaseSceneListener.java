package navartia.mentalasylum.scene.listeners;

import navartia.mentalasylum.system.ResourceManager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.andengine.ui.activity.BaseGameActivity;

public class BaseSceneListener implements IOnSceneTouchListener, IScrollDetectorListener {
    protected Engine engine;
    protected BaseGameActivity activity;
    protected ResourceManager resourceManager;
    protected ZoomCamera camera;

	public BaseSceneListener() {
        this.resourceManager = ResourceManager.getInstance();
        this.engine = resourceManager.engine;
        this.activity = resourceManager.activity;
        this.camera = resourceManager.camera;
	}

	@Override
	public boolean onSceneTouchEvent(Scene arg0, TouchEvent arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onScroll(ScrollDetector arg0, int arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrollFinished(ScrollDetector arg0, int arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrollStarted(ScrollDetector arg0, int arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		
	}
}
