package club.xunger.xuegerapp.barcodedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zxing.activity.CaptureActivity;

import club.xunger.xungerapp.R;


public class CodeActivity extends Activity {

    private Button btnScan;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);

        btnScan = (Button) findViewById(R.id.scan);
        tvContent = (TextView) findViewById(R.id.content);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(CodeActivity.this, CaptureActivity.class), 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String result = data.getExtras().getString("result");
            tvContent.setText(result);
        }
    }
}
