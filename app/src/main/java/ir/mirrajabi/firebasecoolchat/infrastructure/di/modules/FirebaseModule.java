package ir.mirrajabi.firebasecoolchat.infrastructure.di.modules;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;
import ir.mirrajabi.firebasecoolchat.infrastructure.di.scopes.ActivityScope;

@Module
public class FirebaseModule {
    public FirebaseModule() {}

    @Provides
    @ActivityScope
    FirebaseAnalytics provideFirebaseAnalytics(Context context){
        return FirebaseAnalytics.getInstance(context);
    }
    @Provides
    @ActivityScope
    FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    @Provides
    @ActivityScope
    FirebaseDatabase provideFirebaseDatabase(){
        return FirebaseDatabase.getInstance();
    }
}
