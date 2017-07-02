package ir.mirrajabi.firebasecoolchat.infrastructure.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.ApplicationModule;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Context context();
}
