package com.zxing.activity;

import android.content.Intent;
import android.util.Log;

/**
 * Created by HanFeng on 2015/11/5.
 */
public class CompleteScan {

    public OnCompleteListener listener;

    private static CompleteScan completeScan = new CompleteScan();

    private CompleteScan() {

    }

    public static CompleteScan getInstance() {
        return completeScan;
    }

    public void onCompleteScan(Intent intent) {
        if (listener != null) {

            listener.onComplete(intent);

        } else {
            Log.e("TAG", "is null .......");
        }
    }

    public void setOnCompleteListener(OnCompleteListener listener) {
        this.listener = listener;
    }

}
