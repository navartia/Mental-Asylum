package navartia.mentalasylum;

import java.io.IOException;

import navartia.mentalasylum.scene.SceneManager;
import navartia.mentalasylum.system.ResourceManager;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.util.DisplayMetrics;
import android.util.Log;

public class GameActivity extends BaseGameActivity {
	private int CAMERA_WIDTH, CAMERA_HEIGHT;
	protected ZoomCamera camera;
	protected float zoomDepth = 2;
	
	//Called when making the Game Engine for the Activity
	@Override
	public EngineOptions onCreateEngineOptions() {
		final DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		CAMERA_WIDTH = displayMetrics.widthPixels;
		CAMERA_HEIGHT = displayMetrics.heightPixels;
		
		camera = new ZoomCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		camera.setZoomFactor(zoomDepth);
		
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
	            new FillResolutionPolicy(), camera);
	    
	    engineOptions.getAudioOptions().setNeedsSound(true);
	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
	    
	    Log.i("Mental Asylum", "Engine options complete");
	    
	    return engineOptions;
	}
	
	@Override
	public Engine onCreateEngine(EngineOptions engineOptions) {
		Log.i("Mental Asylum", "Create engine complete");
		
		return new LimitedFPSEngine(engineOptions, 60);
	}
	
	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException {
		ResourceManager.initialize(mEngine, this, camera, getVertexBufferObjectManager());
		
		pOnCreateResourcesCallback.onCreateResourcesFinished();
		Log.i("Mental Asylum", "Create resources complete");
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException {
		SceneManager.getInstance().createLevelScene(pOnCreateSceneCallback);	
		
		Log.i("Mental Asylum", "Create scene complete");
	}

	@Override
	public void onPopulateScene(Scene scene, OnPopulateSceneCallback pOnPopulateSceneCallback)throws IOException {
		// TODO Auto-generated method stub
		
	}
}
