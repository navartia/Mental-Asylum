/* IntroScene.java
 * Handles the Scene on the Main Menu
 * This will contain the following
 * 	1.) New Game
 * 	2.) Settings/Options
 *  3.) Links to other games (in the future)
 */

package navartia.mentalasylum.scene;

import navartia.mentalasylum.scene.SceneManager.SceneType;
import navartia.mentalasylum.scene.listeners.MenuSceneListener;

public class MenuScene extends BaseScene {
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		super.setOnSceneTouchListener(new MenuSceneListener());
	}
	
	@Override
	public void createScene() {

	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}
}
