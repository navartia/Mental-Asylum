package navartia.mentalasylum;

import java.io.IOException;

import navartia.mentalasylum.system.ResourceManager;
import navartia.mentalasylum.system.SceneManager;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.util.DisplayMetrics;

public class GameActivity extends BaseGameActivity {
	private int CAMERA_WIDTH, CAMERA_HEIGHT;
	protected ZoomCamera chaseCamera;
	protected float maxZoom = 0;
	protected float zoomDepth = 2;
	
	//Called when making the Game Engine for the Activity
	@Override
	public EngineOptions onCreateEngineOptions() {
		final DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		CAMERA_WIDTH = displayMetrics.widthPixels;
		CAMERA_HEIGHT = displayMetrics.heightPixels;
		
		chaseCamera = new ZoomCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		chaseCamera.setZoomFactor(zoomDepth);
		
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
	            new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), chaseCamera);
	    
	    engineOptions.getAudioOptions().setNeedsSound(true);
	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
	    
	    return engineOptions;
	}
	
	@Override
	public Engine onCreateEngine(EngineOptions engineOptions) {
		return new LimitedFPSEngine(engineOptions, 60);
	}
	
	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException {
		ResourceManager.initialize(mEngine, this, chaseCamera);
		
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException {
		SceneManager.getInstance().createLevelScene(pOnCreateSceneCallback);
		
	}

	@Override
	public void onPopulateScene(Scene arg0, OnPopulateSceneCallback arg1)throws IOException {
		// TODO Auto-generated method stub
		
	}

}
