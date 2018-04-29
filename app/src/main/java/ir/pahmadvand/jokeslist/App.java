package ir.pahmadvand.jokeslist;

import android.app.Application;

import io.realm.Realm;
import ir.pahmadvand.jokeslist.dagger.AppComponent;
import ir.pahmadvand.jokeslist.dagger.ContextModule;
import ir.pahmadvand.jokeslist.dagger.DaggerAppComponent;


public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        appComponent= DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();

    }
}
