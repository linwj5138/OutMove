package com.project.tank.outmove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.project.tank.outmove.utils.AppStatusManager;

/**
 * @description: activity基类
 * @auther linweijie
 * @time 2018/10/31 19:19
 */

public class BaseActivity extends AppCompatActivity{
    private static final String TAG = BaseActivity.class.getSimpleName();
    /**获取登录数据**/
    protected static final int LOGIN = 1;
    /** 获取工单 **/
    protected static final int GET_TASK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        checkAppStatus();
//        AppStatusManager.getInstance().setAppStatus(AppStatusManager.AppStatusConstant.APP_NORMAL);
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
        //禁止屏幕截图,android P 无效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }

    @Override
    protected void onResume() {
        if (!getClass().getSimpleName().equals(LoginActivity.class.getSimpleName())){
            //停留在LoginActivity不调用超时弹出
//            Factory.resumeActivity(getApplicationContext());
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    /**
     * TRIM_MEMORY_COMPLETE：内存不足，并且该进程在后台进程列表最后一个，马上就要被清理
     TRIM_MEMORY_MODERATE：内存不足，并且该进程在后台进程列表的中部。
     TRIM_MEMORY_BACKGROUND：内存不足，并且该进程是后台进程。
     TRIM_MEMORY_UI_HIDDEN：内存不足，并且该进程的UI已经不可见了
     TRIM_MEMORY_COMPLETE这个监听的时候有时候监听不到，建议监听TRIM_MEMORY_MODERATE，在这个里面处理退出程序操作。
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if(level == TRIM_MEMORY_MODERATE){
            Log.i(TAG, "即将被清理");
            if (!getClass().getSimpleName().equals(LoginActivity.class.getSimpleName())){
                //内存不足,且不是停留在登陆页

            }
        }
    }


    private void checkAppStatus() {
        if(AppStatusManager.getInstance().getAppStatus()==AppStatusManager.AppStatusConstant.APP_FORCE_KILLED) {
            //该应用已被回收，执行相关操作（下面有详解）
            Log.i(TAG, "该应用已被回收");
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
