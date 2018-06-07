package test;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cqc.myapp.R;

import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2018/4/29.
 */

public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.testlayout);
//        Button button = findViewById(R.id.button);
        Log.d("TestActivity","和是："+add(9,34));

    }

    public int add(int a, int b) {

        try {
            Log.d("TestActivity","try 语句块");
            return a + b;

        } catch (Exception e) {

            Log.d("TestActivity","catch 语句块");

        } finally {

            Log.d("TestActivity","finally 语句块");

        }

        return 0;
    }


    public void click(View view) {

        Log.w("activityThreadId=", String.valueOf(Thread.currentThread().getId()));
        startService(new Intent(this, Myservice.class));
    }
}
