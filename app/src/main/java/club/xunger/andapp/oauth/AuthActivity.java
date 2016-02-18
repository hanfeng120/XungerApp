package club.xunger.andapp.oauth;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import club.xunger.andapp.framework.BaseActivity;
import club.xunger.xungerapp.R;

public class AuthActivity extends BaseActivity {

    private Button btnAcquire;
    private Button btnAccredit;
    private TextView tvShow;

    private UMShareAPI mShareAPI;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_auth;
    }

    @Override
    protected View getContentRootView() {
        return null;
    }

    @Override
    protected boolean initBackActionBar() {
        return true;
    }

    @Override
    protected void initTopBar() {

    }

    @Override
    protected void initContent() {
        btnAccredit = (Button) findViewById(R.id.accredit);
        btnAcquire = (Button) findViewById(R.id.acquire_info);
        tvShow = (TextView) findViewById(R.id.show_info);

        btnAccredit.setOnClickListener(getOnClickListener());
        btnAcquire.setOnClickListener(getOnClickListener());

        mShareAPI = UMShareAPI.get(getContext());
    }

    @Override
    protected void initBottomBar() {

    }

    @Override
    protected void initData() {

    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed >> " + data.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void refreshView(int viewId) {

    }

    @Override
    public void onClick(View v) {
        SHARE_MEDIA platform = SHARE_MEDIA.QQ;
        switch (v.getId()) {
            case R.id.accredit:
                mShareAPI.doOauthVerify(this, platform, umAuthListener);
                break;
            case R.id.acquire_info:
                mShareAPI.getPlatformInfo(this, platform, acquireInfoListener);
                break;
        }
    }

    private UMAuthListener acquireInfoListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Log.d("auth callbacl", "getting data" + data.toString());
            if (data != null) {
                Log.d("auth callbacl", "getting data");
                Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "get fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "get cancel", Toast.LENGTH_SHORT).show();
        }
    };
}
