package club.xunger.andapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import club.xunger.andapp.barcode.CodeActivity;
import club.xunger.andapp.oauth.AuthActivity;
import club.xunger.andapp.share.ShareActivity;
import club.xunger.xungerapp.R;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] data = new String[]{"BarCode", "UMengShare", "OAuth"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


}
