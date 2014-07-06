package navartia.mentalasylum.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import navartia.mentalasylum.scene.SceneManager.SceneType;

public class IntroScene extends BaseScene {
	private Sprite splash;
	
	@Override
	public void initialize() {
		splash = new Sprite(0, 0, resourceManager.splash_region, vbom) {
		    @Override
		    protected void preDraw(GLState pGLState, Camera pCamera) {
		       super.preDraw(pGLState, pCamera);
		       pGLState.enableDither();
		    }
		};	
	}

	@Override
	public void createScene() {
		splash.setScale(1.5f);
		splash.setPosition(400, 240);
		attachChild(splash);	
	}

	@Override
	public void disposeScene() {
	    splash.detachSelf();
	    splash.dispose();
	    this.detachSelf();
	    this.dispose();
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_INTRO;
	}

}
