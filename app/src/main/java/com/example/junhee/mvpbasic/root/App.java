package com.example.junhee.mvpbasic.root;

import android.app.Application;

import com.example.junhee.mvpbasic.LoginModule;

/**
 * Created by JunHee on 2017. 12. 10..
 */

public class App extends Application {

    private ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }
}
