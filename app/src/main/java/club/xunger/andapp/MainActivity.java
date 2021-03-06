package club.xunger.andapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import club.xunger.andapp.barcode.CodeActivity;
import club.xunger.andapp.core.utils.XungerPackageNames;
import club.xunger.andapp.core.utils.XungerToast;
import club.xunger.andapp.dragsort.DragSortActivity;
import club.xunger.andapp.gesture.GestureActivity;
import club.xunger.andapp.oauth.AuthActivity;
import club.xunger.andapp.share.ShareActivity;
import club.xunger.andapp.window.WindowManagerActivity;
import club.xunger.xungerapp.R;
import cn.xunger.xungerbaselibrary.framework.BaseActivity;

public class MainActivity extends BaseActivity {

    private ListView listView;
    private String[] data = new String[]{"BarCode", "UMengShare", "OAuth", "DragSortListView", "WindowManager", "Dialog & Window", "GesturePassword", "ViewDemo"};

    @Override

    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected View getContentRootView() {
        return null;
    }

    @Override
    protected void initTopBar() {
        ArrayList<String> list = new ArrayList<>();
    }

    @Override
    protected void initContent() {
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.setClass(getContext(), CodeActivity.class);
                        break;
                    case 1:
                        intent.setClass(getContext(), ShareActivity.class);
                        break;
                    case 2:
                        intent.setClass(getContext(), AuthActivity.class);
                        break;
                    case 3:
                        intent.setClass(getContext(), DragSortActivity.class);
                        break;
                    case 4:
                        intent.setClass(getContext(), WindowManagerActivity.class);
                        break;
                    case 5:
                        break;
                    case 6:
                        intent.setClass(getContext(), GestureActivity.class);
                        break;
                    case 7:
                        startApp(XungerPackageNames.PACKAGE_NAME_VIEWDEMO);
                        return;
                }
                startActivity(intent);
            }
        });
    }

    private void startApp(String appPackageName) {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(appPackageName);
            startActivity(intent);
        } catch (Exception e) {
            XungerToast.shortToast("未安装该应用");
        }
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

    }
}
