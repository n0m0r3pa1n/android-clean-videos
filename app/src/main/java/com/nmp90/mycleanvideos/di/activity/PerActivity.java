package com.nmp90.mycleanvideos.di.activity;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by nmp on 12.11.17.
 */

@Scope
@Retention(CLASS)
public @interface PerActivity {
}
