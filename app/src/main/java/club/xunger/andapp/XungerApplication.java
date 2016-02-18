package club.xunger.andapp;

import android.app.Application;

import club.xunger.andapp.share.ShareManager;

/**
 * Created by zhaoxunyi on 2016/2/18.
 */
public class XungerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        ShareManager.getInstance().init();
    }

}
