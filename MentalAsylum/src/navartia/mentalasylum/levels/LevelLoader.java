package navartia.mentalasylum.levels;

import java.util.ArrayList;

import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.tmx.TMXLayer;
import org.andengine.extension.tmx.TMXLoader;
import org.andengine.extension.tmx.TMXTiledMap;
import org.andengine.extension.tmx.util.constants.TMXIsometricConstants;
import org.andengine.extension.tmx.util.exception.TMXLoadException;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import android.util.Log;

public class LevelLoader {
	
	public TMXTiledMap loadMapIso(BaseGameActivity pActivity, String filepath) {
		final TMXLoader tmxLoader = new TMXLoader(pActivity.getAssets(), pActivity.getTextureManager(),
								TextureOptions.DEFAULT, pActivity.getVertexBufferObjectManager());
		
		tmxLoader.setAllocateTiles(false);
		tmxLoader.setUseLowMemoryVBO(true);
		tmxLoader.setStoreGID(true);
		
		TMXTiledMap map = null;
		try {
			map = tmxLoader.loadFromAsset(filepath);
			map.setIsometricDrawMethod(TMXIsometricConstants.DRAW_METHOD_ISOMETRIC_CULLING_TILED_SOURCE);
			//map.setIsometricDrawMethod(TMXIsometricConstants.DRAW_METHOD_ISOMETRIC_ALL);
		} 
		catch (final TMXLoadException e) {
			Debug.e(e);
			Log.i("maploading","map failed");
		}
		
		return map;
	}
	
	public void attachMap(Scene parent, TMXTiledMap map) {
		parent.detachChildren();
		
		ArrayList<TMXLayer> layers = map.getTMXLayers();
		int i = -1;
		for (TMXLayer tmxLayer : layers) {
			attachLayer(parent, tmxLayer, i);
			i--;
		}
	}
	
	public void attachMap(Scene parent, BaseGameActivity pActivity, String filepath) {
		attachMap(parent, loadMapIso(pActivity, filepath));
	}
	
	public void attachLayer(Scene parent, final TMXLayer layer, int index) {
		if (layer != null) {
			IEntity pEntity = (IEntity) layer;
			pEntity.setZIndex(index);
			pEntity.setSkipSort(true);
			parent.attachChild(pEntity);
		}
	}
	
	public void detachLayer(Scene parent, final TMXLayer pLayer) {
		if (pLayer != null) {
			parent.detachChild(pLayer);
		}
	}
}
