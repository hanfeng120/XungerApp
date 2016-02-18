package club.xunger.andapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import club.xunger.andapp.barcode.CodeActivity;
import club.xunger.andapp.framework.BaseActivity;
import club.xunger.andapp.oauth.AuthActivity;
import club.xunger.andapp.share.ShareActivity;
import club.xunger.xungerapp.R;

public class MainActivity extends BaseActivity {

    private ListView listView;
    private String[] data = new String[]{"BarCode", "UMengShare", "OAuth"};

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

    }

    @Override
    protected void initContent() {
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, CodeActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ShareActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, AuthActivity.class));
                        break;
                }
            }
        });
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
