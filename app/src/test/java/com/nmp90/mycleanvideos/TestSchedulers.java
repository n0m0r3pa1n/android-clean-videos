package com.nmp90.mycleanvideos;

import com.nmp90.mycleanvideos.api.InteractorSchedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nmp on 12.11.17.
 */

public class TestSchedulers implements InteractorSchedulers {
    @Override
    public Scheduler getExecutionScheduler() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler getPostExecutionScheduler() {
        return Schedulers.trampoline();
    }
}
