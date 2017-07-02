package ir.mirrajabi.firebasecoolchat.infrastructure.di.modules;

import dagger.Module;
import dagger.Provides;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.login.LoginView;

@Module
public class LoginModule {
    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginView provideView(){
        return view;
    }
}
