package club.xunger.andapp;

import android.app.Application;

import club.xunger.andapp.umeng.UMengHelper;

public class XungerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        UMengHelper.getInstance().init(getApplicationContext());
    }

}
