package navartia.mentalasylum.scene.listeners;


import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.ScrollDetector;

import android.util.Log;

public class LevelSceneListener extends BaseSceneListener {
	//Scrolling
	//private float mTouchX = 0, mTouchY = 0, mTouchOffsetX = 0, mTouchOffsetY = 0;
	
	ScrollDetector scrollDetector = new ScrollDetector(this);
	
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent touchEvent) {
		Log.i("Mental Asylum", "Touch event");
		if(scrollDetector != null) {
			scrollDetector.onTouchEvent(touchEvent);
		}
		return true;
	}
	
	@Override
	public void onScroll(ScrollDetector scrollDetector, int pointerID, float distX, float distY) {
		Log.i("Mental Asylum", "Scroll event");
		
		camera.offsetCenter(distX, distY);
		//camera.setCenter(touchOffsetX, touchOffsetY);
	}
	
	/*
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent touchEvent) {
		Log.i("Mental Asylum", "Level Touch Event");
		
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
	}*/
}
