package com.qc.loglibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * PackageName: com.qc.loglibrary
 * ClassName: Toastc
 * Author: cuiqingchao
 * CreateDate: 2018/6/7 19:05
 * Description:
 *
 * -----------------------------------Version Info----------------------------------------------
 * Version: V0.1    UpdateUser: cuiqingchao    UpdateDate: 2018/6/7 19:05   UpdateRemark:
 *
 *
 * ---------------------------------------------------------------------------------------------
 */
public class Toastc {
    private static Context sContext;
    private static Toast sToast;

    public static void init(Context context)
    {
        sContext = context.getApplicationContext();
        sToast = Toast.makeText(sContext, "", Toast.LENGTH_SHORT);
    }


    public static void s(String msg)
    {
        if(sToast == null){
            return;
        }
        sToast.setText(msg);
        sToast.setDuration(Toast.LENGTH_SHORT);
        sToast.show();
    }


    public static void l(String msg)
    {
        if(sToast == null){
            return;
        }
        sToast.setText(msg);
        sToast.setDuration(Toast.LENGTH_LONG);
        sToast.show();
    }
}
