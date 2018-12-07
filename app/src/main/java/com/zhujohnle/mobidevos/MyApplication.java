package com.zhujohnle.mobidevos;

import android.app.Application;
import android.content.res.Configuration;

/**
 * @auth &{zhujiule}
 * @date 2018/12/4
 * @copyright
 **/
public class MyApplication extends Application {


   @Override
   public void onConfigurationChanged(Configuration newConfig) {
      super.onConfigurationChanged(newConfig);
   }

   @Override
   public void onCreate() {
      super.onCreate();

      MobiDevOsEngine mobiDevOsEngine =  MobiDevOsEngine.getInstace(this);
      mobiDevOsEngine.initProperties(true);



      //SecyrityCrash.install();
   }
}
