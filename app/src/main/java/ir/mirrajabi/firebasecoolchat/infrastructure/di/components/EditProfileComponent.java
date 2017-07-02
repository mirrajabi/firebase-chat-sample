package ir.mirrajabi.firebasecoolchat.infrastructure.di.components;

import dagger.Component;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.EditProfileModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.FirebaseModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.modules.RegisterModule;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;
import ir.mirrajabi.firebasecoolchat.presentation.activities.auth.register.RegisterActivity;
import ir.mirrajabi.firebasecoolchat.presentation.activities.editprofile.EditProfileActivity;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},
        modules = {EditProfileModule.class, FirebaseModule.class})
public interface EditProfileComponent {
    void inject(EditProfileActivity editProfileActivity);
}
