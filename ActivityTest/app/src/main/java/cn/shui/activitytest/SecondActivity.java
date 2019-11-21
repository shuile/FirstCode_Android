package cn.shui.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String data = intent.getStringExtra("extra_data");
        String data1 = intent.getStringExtra("param1");
        String data2 = intent.getStringExtra("param2");
        Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate: param1 = " + data1 + "  param2=" + data2);
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent();
//                intent1.putExtra("data_return", "Hello FirstActivity");
//                setResult(RESULT_OK, intent1);
//                finish();
                Intent intent1 = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
