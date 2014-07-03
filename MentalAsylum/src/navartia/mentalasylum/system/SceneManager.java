package navartia.mentalasylum.system;

import navartia.mentalasylum.levels.LevelScene;

import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

public class SceneManager {	
	private static SceneManager INSTANCE;
	
	private BaseScene levelScene;
	private BaseScene currentScene;
	
	public void createLevelScene(OnCreateSceneCallback pOnCreateSceneCallback) {
		ResourceManager.getInstance().loadLevelScene();
	    levelScene = new LevelScene();
	    currentScene = levelScene;
	    pOnCreateSceneCallback.onCreateSceneFinished(levelScene);
	}
	
	public static SceneManager getInstance() {
		//Lazy instantiation
		if (INSTANCE == null)
			INSTANCE = new SceneManager();
		
		return INSTANCE;
	}
}
