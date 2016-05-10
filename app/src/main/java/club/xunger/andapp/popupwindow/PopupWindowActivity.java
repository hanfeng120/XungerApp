package club.xunger.andapp.popupwindow;

import android.view.View;

import club.xunger.xungerapp.R;
import cn.xunger.xungerbaselibrary.framework.BaseActivity;

public class PopupWindowActivity extends BaseActivity {

    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_popup_window;
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
        findViewById(R.id.show_popupwindow).setOnClickListener(getOnClickListener());
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
}
