package club.xunger.andapp.gesture;

import android.content.Intent;
import android.view.View;

import club.xunger.andapp.framework.BaseActivity;
import club.xunger.xungerapp.R;

public class GestureActivity extends BaseActivity {

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_gesture;
    }

    @Override
    protected View getContentRootView() {
        return null;
    }

    @Override
    protected void initTopBar() {

    }

    @Override
    protected void initContent() {
        findViewById(R.id.setPassword).setOnClickListener(getOnClickListener());
        findViewById(R.id.verifyPassword).setOnClickListener(getOnClickListener());
    }

    @Override
    protected void initBottomBar() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void refreshView(int viewId) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setPassword:
                startActivity(new Intent(getContext(), GestureEditActivity.class));
                break;
            case R.id.verifyPassword:
                startActivity(new Intent(getContext(), GestureVerifyActivity.class));
                break;
        }
    }
}
