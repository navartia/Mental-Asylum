package navartia.mentalasylum.scene;

import navartia.mentalasylum.system.ResourceManager;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

public class SceneManager {	
	private static SceneManager INSTANCE;
	
	private BaseScene introScene;
	private BaseScene menuScene;
	private BaseScene optionScene;
	private BaseScene loadingScene;
	private BaseScene levelScene;
	private BaseScene currentScene;
	
	private Engine engine = ResourceManager.getInstance().engine;
	private SceneType currentSceneType = SceneType.SCENE_INTRO;
	
    public enum SceneType {
        SCENE_INTRO,
        SCENE_MENU,
        SCENE_OPTION,
        SCENE_LEVEL,
        SCENE_LOADING,
    }
    
    //---------------------------------------------
    // SCENE SWITCHING
    //---------------------------------------------
    public void setScene(SceneType sceneType) {
        switch (sceneType) {
            case SCENE_MENU:
                setScene(menuScene);
                break;
            case SCENE_OPTION:
                setScene(optionScene);
                break;
            case SCENE_LEVEL:
                setScene(levelScene);
                break;
            case SCENE_INTRO:
                setScene(introScene);
                break;
            case SCENE_LOADING:
                setScene(loadingScene);
                break;
            default:
                break;
        }
    }
    
	public void setScene(BaseScene scene) {
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }
	
	//---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------
	public static SceneManager getInstance() {
		//Lazy instantiation
		if (INSTANCE == null)
			INSTANCE = new SceneManager();
		
		return INSTANCE;
	}
	
    public BaseScene getCurrentScene() {
        return currentScene;
    }
    
    public SceneType getCurrentSceneType() {
        return currentSceneType;
    }
    
    //---------------------------------------------
    // SCENE CREATION
    //---------------------------------------------
	public void createIntroScene(OnCreateSceneCallback pOnCreateSceneCallback) {
	    ResourceManager.getInstance().loadIntroScene();
	    introScene = new IntroScene();
	    currentScene = introScene;
	    pOnCreateSceneCallback.onCreateSceneFinished(introScene);
	}
	
    public void createLevelScene(OnCreateSceneCallback pOnCreateSceneCallback) {
		ResourceManager.getInstance().loadLevelScene();
	    levelScene = new LevelScene();
	    currentScene = levelScene;
	    pOnCreateSceneCallback.onCreateSceneFinished(levelScene);
	}
}
