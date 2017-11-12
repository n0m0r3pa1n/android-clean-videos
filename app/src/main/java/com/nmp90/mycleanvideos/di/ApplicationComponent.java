package com.nmp90.mycleanvideos.di;

import com.nmp90.mycleanvideos.di.activity.ActivityComponent;
import com.nmp90.mycleanvideos.di.activity.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nmp on 12.11.17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule module);
}
