package test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.rxjavasamples.R;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2018/4/29.
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.testlayout);
//        Button button = findViewById(R.id.button);

    }



    public void click(View view) {
        Log.w("activityThreadId=", String.valueOf(Thread.currentThread().getId()));
        startService(new Intent(this,Myservice.class));
//        try {
//            sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ((Button)findViewById(R.id.button)).setText("结束");
    }
}
