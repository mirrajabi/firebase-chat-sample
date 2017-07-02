package ir.mirrajabi.firebasecoolchat.infrastructure.di.modules;

import dagger.Module;
import dagger.Provides;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.main.MainView;

@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainView provideView(){
        return view;
    }
}
