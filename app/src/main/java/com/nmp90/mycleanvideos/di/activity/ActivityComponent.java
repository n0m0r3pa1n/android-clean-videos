package com.nmp90.mycleanvideos.di.activity;

import com.nmp90.mycleanvideos.list.MainActivity;

import dagger.Subcomponent;

/**
 * Created by nmp on 12.11.17.
 */

@Subcomponent(modules=ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
