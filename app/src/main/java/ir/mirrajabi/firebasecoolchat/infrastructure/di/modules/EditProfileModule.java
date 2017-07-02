package ir.mirrajabi.firebasecoolchat.infrastructure.di.modules;

import dagger.Module;
import dagger.Provides;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.editprofile.EditProfileView;
import ir.mirrajabi.firebasecoolchat.presentation.activities.main.MainView;

@Module
public class EditProfileModule {
    private EditProfileView view;

    public EditProfileModule(EditProfileView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    EditProfileView provideView(){
        return view;
    }
}
