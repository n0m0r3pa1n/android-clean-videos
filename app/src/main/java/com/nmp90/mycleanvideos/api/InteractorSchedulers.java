package com.nmp90.mycleanvideos.api;

/**
 * Created by nmp on 12.11.17.
 */

import io.reactivex.Scheduler;

public interface InteractorSchedulers {
    Scheduler getExecutionScheduler();
    Scheduler getPostExecutionScheduler();
}
