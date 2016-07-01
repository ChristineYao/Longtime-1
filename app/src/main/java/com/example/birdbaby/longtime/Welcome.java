package com.example.birdbaby.longtime;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
/**
 * Created by birdbaby on 2016/6/27.
 */
public class Welcome extends Activity {


    //重写onCreate()方法
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //隐藏默认标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉信息栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //需要加载的xml界面

        setContentView(R.layout.welcome);
        PackageManager pm = getPackageManager();
        try
        {
            PackageInfo pi = pm.getPackageInfo("com.lyt.android", 0);
            //调用TextView

            TextView versionNumber = (TextView) findViewById(R.id.versionNumber);//"imageView1"需要加载的imageView控件ID名(这个是你自定义的id名)
            versionNumber.setText("Version " + pi.versionName);
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        //
        new Handler().postDelayed(new Runnable()
        {
            //封装的run()方法，用在
            @Override
            public void run()
            {
                //页面跳转

                Intent intent = new Intent(Welcome.this,LoginActivity.class);
                //保存跳转信息
                startActivity(intent);
                //进入第二个界面前销毁当前的活动，"finish()"销毁活动
                Welcome.this.finish();
            }
            //这里的数字为延时时长
        }, 2500);
    }
}
