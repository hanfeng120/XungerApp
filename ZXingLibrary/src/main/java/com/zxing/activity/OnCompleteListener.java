package com.zxing.activity;

import android.content.Intent;

/**
 * Created by HanFeng on 2015/11/5.
 */
public interface OnCompleteListener {

    void onComplete(Intent intent);

    void onCameraLight(boolean open);


}
