package com.nmp90.mycleanvideos.utils;

import android.app.Activity;

import com.nmp90.mycleanvideos.VideosApplication;
import com.nmp90.mycleanvideos.di.ApplicationComponent;
import com.nmp90.mycleanvideos.di.activity.ActivityComponent;
import com.nmp90.mycleanvideos.di.activity.ActivityModule;

/**
 * Created by nmp on 12.11.17.
 */

public class InjectHelper {
    public static ApplicationComponent getApplicationComponent() {
        return VideosApplication.getApplicationComponent();
    }

    public static ActivityComponent getActivityComponent(Activity activity) {
        return VideosApplication.getApplicationComponent().plus(new ActivityModule(activity));
    }
}
