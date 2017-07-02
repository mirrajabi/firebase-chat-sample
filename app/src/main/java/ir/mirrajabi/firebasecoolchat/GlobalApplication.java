package ir.mirrajabi.firebasecoolchat;

import android.app.Application;

import ir.mirrajabi.firebasecoolchat.infrastructure.di.components.ApplicationComponent;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.components.DaggerApplicationComponent;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.ApplicationModule;

public class GlobalApplication extends Application {
    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
