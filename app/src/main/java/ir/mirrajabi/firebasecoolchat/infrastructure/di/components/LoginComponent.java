package ir.mirrajabi.firebasecoolchat.infrastructure.di.components;

import dagger.Component;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.FirebaseModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.LoginModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login.LoginActivity;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},
        modules = {LoginModule.class, FirebaseModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
