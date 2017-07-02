package ir.mirrajabi.firebasecoolchat.infrastructure.di.components;

import dagger.Component;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.FirebaseModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.RegisterModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register.RegisterActivity;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},
        modules = {RegisterModule.class, FirebaseModule.class})
public interface RegisterComponent {
    void inject(RegisterActivity registerActivity);
}
