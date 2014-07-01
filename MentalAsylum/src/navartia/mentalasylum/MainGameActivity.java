/* MainGameActivity.java
 * This is the first activity to be launched by the app
 * Handles the IntroScene and the MenuScene
 * This will also handle all the resource loading from the start related to main menu
 */

package navartia.mentalasylum;

import navartia.mentalasylum.levels.LevelScene;

import org.andengine.engine.camera.ZoomCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.DisplayMetrics;

public class MainGameActivity extends SimpleBaseGameActivity {
	private int CAMERA_WIDTH, CAMERA_HEIGHT;
	
	protected ZoomCamera chaseCamera;
	protected float maxZoom = 0;
	protected float zoomDepth = 2;
	
    private BitmapTextureAtlas playerTexture;
    private TiledTextureRegion playerRegion;
    private Sprite player;
    
    /*private Scene introScene, menuScene, optionsScene,*/
    private LevelScene levelScene;

	//Called when making the Game Engine for the Activity
	@Override
	public EngineOptions onCreateEngineOptions() {
		final DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		CAMERA_WIDTH = displayMetrics.widthPixels;
		CAMERA_HEIGHT = displayMetrics.heightPixels;
		chaseCamera = new ZoomCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		chaseCamera.setZoomFactor(zoomDepth);
		
	    EngineOptions engine = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
	            new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), chaseCamera);
	    
	    engine.getAudioOptions().setNeedsSound(true);
	    
	    return engine;
	}

	//Called when loading the resources needed for the Activity
	@Override
	public void onCreateResources() {		
		loadGraphics();
	}
	
	//Called when rendering the scene for different parts of the Game
	@Override
	public Scene onCreateScene() {
		/*
		introScene = new IntroScene();
		resourceCallback.onCreateSceneFinished(introScene);
		
		menuScene = new MenuScene();
		
		optionsScene = new OptionsScene();
		resourceCallback.onCreateSceneFinished(optionsScene);
		*/
		levelScene = new LevelScene(this);
		levelScene.loadScene();
		
		/* Calculate the coordinates for the face, so its centered on the camera. */
		final float centerX = (CAMERA_WIDTH - playerRegion.getWidth()) / 2;
		final float centerY = (CAMERA_HEIGHT - playerRegion.getHeight()) / 2;
		
		/* Setting player sprite and sets the chase entity */
		player = new Sprite(centerX, centerY, playerRegion, this.getVertexBufferObjectManager());
		player.setRotation(45.0f);
		//chaseCamera.setChaseEntity(player);
		
		return levelScene;
	}
	
	//Load the graphic related resources to the Activity
	private void loadGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("graphics/");
		
		// Loading texture for player
		playerTexture = new BitmapTextureAtlas(getTextureManager(),			//Texture manager
								64, 64,										//Size of the bitmap
								TextureOptions.BILINEAR_PREMULTIPLYALPHA);	//Texture options
		
		playerRegion = BitmapTextureAtlasTextureRegionFactory.
						createTiledFromAsset(playerTexture, 				//Texture atlas
											this.getAssets(),				//Asset manager
											"player.png",					//File path
											0, 0, 							//Starting coordinates
											1, 1);							//Sprite row and column
		
		playerTexture.load();
	}
	
	public ZoomCamera getCamera() {
		return chaseCamera;
	}
	
	public float getZoomDepth() {
		return zoomDepth;
	}
	
	public void setMaxZoom(float maxZoom) {
		this.maxZoom = maxZoom;
	}
}