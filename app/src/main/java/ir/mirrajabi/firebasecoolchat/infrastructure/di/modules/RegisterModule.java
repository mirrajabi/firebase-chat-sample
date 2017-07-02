package ir.mirrajabi.firebasecoolchat.infrastructure.di.modules;

import dagger.Module;
import dagger.Provides;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register.RegisterView;

@Module
public class RegisterModule {
    private RegisterView view;

    public RegisterModule(RegisterView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RegisterView provideView(){
        return view;
    }
}
