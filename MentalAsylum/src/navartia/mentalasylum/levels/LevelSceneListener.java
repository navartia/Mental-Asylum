package navartia.mentalasylum.levels;

import org.andengine.engine.camera.ZoomCamera;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.PinchZoomDetector;
import org.andengine.input.touch.detector.PinchZoomDetector.IPinchZoomDetectorListener;

import android.view.MotionEvent;

public class LevelSceneListener implements IOnSceneTouchListener, IPinchZoomDetectorListener {
	//Scrolling
	private float mTouchX = 0, mTouchY = 0, mTouchOffsetX = 0, mTouchOffsetY = 0;
	private ZoomCamera camera;
	
	public LevelSceneListener(ZoomCamera camera) {
		this.camera = camera;
	}
	
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

	@Override
	public void onPinchZoom(PinchZoomDetector arg0, TouchEvent arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPinchZoomFinished(PinchZoomDetector arg0, TouchEvent arg1,
			float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPinchZoomStarted(PinchZoomDetector arg0, TouchEvent arg1) {
		// TODO Auto-generated method stub
		
	}
}
