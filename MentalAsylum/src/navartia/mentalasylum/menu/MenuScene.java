/* IntroScene.java
 * Handles the Scene on the Main Menu
 * This will contain the following
 * 	1.) New Game
 * 	2.) Settings/Options
 *  3.) Links to other games (in the future)
 */

package navartia.mentalasylum.menu;

import navartia.mentalasylum.MainGameActivity;

import org.andengine.entity.scene.Scene;

public class MenuScene extends Scene {
	MainGameActivity parent;
	
	public MenuScene(MainGameActivity parent) {
		this.parent = parent;
		initialize();
	}
	
	private void initialize() {
		super.setOnSceneTouchListener(new MenuSceneListener(parent.getCamera()));
	}
}
