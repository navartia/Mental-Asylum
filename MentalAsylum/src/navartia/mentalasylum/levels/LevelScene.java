package navartia.mentalasylum.levels;

import navartia.mentalasylum.MainGameActivity;

import org.andengine.engine.camera.ZoomCamera;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.tmx.TMXTiledMap;

public class LevelScene extends Scene {
	MainGameActivity parent;
	LevelLoader loader;
	
	TMXTiledMap currentLevel;
	int level = 1;
	
	public LevelScene(MainGameActivity parent) {
		this.parent = parent;
		initialize();
	}
	
	private void initialize() {
		loader = new LevelLoader();
		super.setOnSceneTouchListener(new LevelSceneListener(parent.getCamera()));
	}
	
	public void loadScene() {
		currentLevel = loader.loadMapIso(parent, "tmx/Hospital.tmx");
		loader.attachMap(this, currentLevel);
		setupCamera(currentLevel);
	}
	
	private void setupCamera(TMXTiledMap map) {
		float height = 0;
		float width = 0;
		height = map.getTileRows() * (map.getTileWidth() / 2);
		width = map.getTileColumns() * (map.getTileWidth());
		setupCameraIsometric(height, width);
	}
	
	public void setupCameraIsometric(final float height, final float width) {
		ZoomCamera camera = parent.getCamera();
		
		if (camera.getWidth() / height >= camera.getHeight() / width) {
			parent.setMaxZoom(camera.getWidth() / height);
		} else {
			parent.setMaxZoom(camera.getHeight() / width);
		}
		/*
		 * We have to consider the map rows and columns do not match,
		 * so the xMin works out the bounds to the left of scene x=0,
		 * xMax to the right of scene x=0.
		 * The left hand side of the map is the rows, while the right is columns.
		 * We need to calculate the length of these for use in the bounds
		 * 
		 * We have to take into account the placement of the tile.
		 * The very left edge of the first tile is X = 0
		 * So when halving the width the right hand side is short changed by 
		 * half a tile width and the left gains, so add half a tile width to 
		 * the xMin and xMax to even this out.
		 */
		final float MAX_CAMERA_BOUND_ADDITION = 60;
		final float halfTileWidth = currentLevel.getTileWidth() / 2;
		final float xMin = currentLevel.getTileRows() * halfTileWidth;
		final float xMax = currentLevel.getTileColumns() * halfTileWidth;
		final float pBoundsXMin = halfTileWidth - xMin - MAX_CAMERA_BOUND_ADDITION;
		final float pBoundsYMin = -height + MAX_CAMERA_BOUND_ADDITION;
		final float pBoundsXMax = halfTileWidth + xMax + MAX_CAMERA_BOUND_ADDITION;
		final float pBoundsYMax = MAX_CAMERA_BOUND_ADDITION;
		camera.setBounds(pBoundsXMin, pBoundsYMin, pBoundsXMax, pBoundsYMax);
		camera.setBoundsEnabled(true);
		
		camera.setZoomFactor(parent.getZoomDepth());
		//camera.setCenter(0, 0);
	}
	
	protected int getLevel() {
		return level;
	}
	
	protected MainGameActivity getActivity() {
		return parent;
	}
}
