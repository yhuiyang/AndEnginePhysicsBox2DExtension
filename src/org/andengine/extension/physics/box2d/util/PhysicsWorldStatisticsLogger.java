package org.andengine.extension.physics.box2d.util;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.debug.Debug;

public class PhysicsWorldStatisticsLogger implements IUpdateHandler {
	
	private final static float DEFAULT_FLUSH_TIME = 1.0f;
	private float mFlushTime;
	private PhysicsWorld mWorld;
	private float mTotalElapsedSeconds;

	public PhysicsWorldStatisticsLogger(final PhysicsWorld physicsWorld) {
		this(physicsWorld, DEFAULT_FLUSH_TIME);
	}
	
	public PhysicsWorldStatisticsLogger(final PhysicsWorld physicsWorld, final float second) {
		mWorld = physicsWorld;
		mFlushTime = second;
		mTotalElapsedSeconds = 0;
	}
	
	@Override
	public void onUpdate(float pSecondsElapsed) {
		mTotalElapsedSeconds += pSecondsElapsed;
		if (mTotalElapsedSeconds >= mFlushTime) {
			if (mWorld != null) {
				Debug.d("Bodies:" + mWorld.getBodyCount() + " Contacts:" + mWorld.getContactCount() + " Joints:" + mWorld.getJointCount());
			}
			mTotalElapsedSeconds = 0;
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

}
