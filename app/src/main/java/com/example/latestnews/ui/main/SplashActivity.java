package com.example.latestnews.ui.main;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.example.latestnews.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.white); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(100); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_TOP);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.mipmap.news); //or any other drawable
        configSplash.setAnimLogoSplashDuration(200); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

/*
        //Customize Path
        configSplash.setPathSplash(SyncStateContract.Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.accent); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.Wheat); //path object filling color
*/

        //Customize Title
        configSplash.setTitleSplash("ايه الاخبار؟");
        configSplash.setTitleTextColor(R.color.red);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(4000);
        configSplash.setAnimTitleTechnique(Techniques.FadeInUp);
        //configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/

    }



    @Override
    public void animationsFinished() {
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}