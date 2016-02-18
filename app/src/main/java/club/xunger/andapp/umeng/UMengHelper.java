package club.xunger.andapp.umeng;

import android.content.Context;

import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by zhaoxunyi on 2016/2/18.
 */
public final class UMengHelper {

    private volatile static UMengHelper instance;

    private UMengHelper() {

    }

    public static UMengHelper getInstance() {
        if (instance == null) {
            synchronized (UMengHelper.class) {
                if (instance == null) {
                    instance = new UMengHelper();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        initAnalyticsConfig(context);
        UMengSocialHelper.getInstance().init();
    }

    public void initAnalyticsConfig(Context context) {
        MobclickAgent.setDebugMode(true);
        AnalyticsConfig.enableEncrypt(false);
        AnalyticsConfig.setAppkey(context, "56c53447e0f55a4b84001514");
        AnalyticsConfig.setChannel("yingyongbao");
    }

}
