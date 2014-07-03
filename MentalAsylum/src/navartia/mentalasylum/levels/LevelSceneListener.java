package navartia.mentalasylum.levels;

import navartia.mentalasylum.system.BaseSceneListener;

import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import android.view.MotionEvent;

public class LevelSceneListener extends BaseSceneListener {
	//Scrolling
	private float mTouchX = 0, mTouchY = 0, mTouchOffsetX = 0, mTouchOffsetY = 0;
	
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent touchEvent) {
		if(touchEvent.getAction() == MotionEvent.ACTION_DOWN) {
			mTouchX = touchEvent.getMotionEvent().getX();
			mTouchY = touchEvent.getMotionEvent().getY();
		}
		else if(touchEvent.getAction() == MotionEvent.ACTION_MOVE) {
			float newX = touchEvent.getMotionEvent().getX();
			float newY = touchEvent.getMotionEvent().getY();
           
            mTouchOffsetX =  (newX - mTouchX);
            mTouchOffsetY = -(newY - mTouchY);
           
            float newScrollX = camera.getCenterX() - mTouchOffsetX;
            float newScrollY = camera.getCenterY() - mTouchOffsetY;
           
            camera.setCenter(newScrollX, newScrollY);
           
            mTouchX = newX;
            mTouchY = newY;
		}
		
		return true;
	}
}
