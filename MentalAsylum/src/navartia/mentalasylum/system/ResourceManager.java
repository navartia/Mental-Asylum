package navartia.mentalasylum.system;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

public class ResourceManager {
	public Engine engine;
	public BaseGameActivity activity;
	public ZoomCamera camera;
	public VertexBufferObjectManager vbom;
	
	private BitmapTextureAtlas splashTextureAtlas;
	public ITextureRegion splash_region;
	
	private static ResourceManager INSTANCE;
	
	public static void initialize(Engine engine, BaseGameActivity activity, ZoomCamera camera, VertexBufferObjectManager vbom) {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }
	
	//---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------
	public static ResourceManager getInstance() {
		//Lazy instantiation
		if (INSTANCE == null)
			INSTANCE = new ResourceManager();
		
		return INSTANCE;
	}
	
	//---------------------------------------------
    // RESOURCE LOADERS
    //---------------------------------------------
	public void loadIntroScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("graphics/");
		splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
		splashTextureAtlas.load();
	}
	
	public void loadLevelScene() {
		
	}
	
	//---------------------------------------------
    // RESOURCE UNLOADERS
    //---------------------------------------------
	public void unloadIntroScene() {
		splashTextureAtlas.unload();
		splash_region = null;
	}
}
