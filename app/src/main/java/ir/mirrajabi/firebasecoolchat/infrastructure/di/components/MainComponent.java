package ir.mirrajabi.firebasecoolchat.infrastructure.di.components;

import dagger.Component;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.FirebaseModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.MainModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.main.MainActivity;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},
        modules = {MainModule.class, FirebaseModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
