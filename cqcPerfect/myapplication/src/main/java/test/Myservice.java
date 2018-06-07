package test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2018/4/29.
 */

public class Myservice extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Myservice","onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("Myservice","onCreate");
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Myservice","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d("Myservice","onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Myservice","onStartCommand");

//        try {
//            sleep(20001);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.w("MyserviceThreadId=", String.valueOf(Thread.currentThread().getId()));
        return super.onStartCommand(intent, flags, startId);
    }
}
