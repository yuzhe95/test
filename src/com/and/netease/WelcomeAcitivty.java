package com.and.netease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class WelcomeAcitivty extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_welcome);

		ImageView flag = (ImageView) findViewById(R.id.img_logo);
		AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
		anim.setDuration(3000);
		anim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				Intent intent = new Intent(WelcomeAcitivty.this,
						MainActivity.class);
				WelcomeAcitivty.this.startActivity(intent);
				WelcomeAcitivty.this.finish();
			}
		});
//		bg.setAnimation(anim);
		flag.setAnimation(anim);
		anim.start();
	}
}
