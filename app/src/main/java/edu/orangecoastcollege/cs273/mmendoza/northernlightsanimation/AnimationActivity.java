package edu.orangecoastcollege.cs273.mmendoza.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    // AnimationDrawable used for frame animations
    private AnimationDrawable frameAnim;
    // Animation class used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * Plays the animation from frame_anim.xml
     * Cycles through the drawables to represent a slideshow
     *
     * @param view
     */
    public void toggleFrameAnim(View view)
    {
        // Hasn't been initialized yet
        if (frameAnim == null)
        {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        // if frameAnim is running, stop it
        if (frameAnim.isRunning())
            frameAnim.stop();
        // else start it
        else
            frameAnim.start();
    }

    /**
     * Plays the animation from rotate_anim.xml
     * Rotates the image
     *
     * @param view
     */
    public void toggleRotateAnim(View view)
    {
        // hasn't been initialized yet
        if (rotateAnim == null)
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        // if hasn't started yet or it has ended, then start it
        if (!rotateAnim.hasStarted() || rotateAnim.hasEnded())
            // Connect it to the Image View
            lightsImageView.startAnimation(rotateAnim);
        else
            lightsImageView.clearAnimation();
    }

    /**
     * Plays the animation from shake_anim.xml
     * Shakes the image horizontally
     *
     * @param view
     */
    public void toggleShakeAnim(View view)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }

    /**
     * Plays the animation from custom_anim.xml
     * Fades the image out then back in
     *
     * @param view
     */
    public void toggleCustomAnim(View view)
    {
        customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        lightsImageView.startAnimation(customAnim);
    }
}
