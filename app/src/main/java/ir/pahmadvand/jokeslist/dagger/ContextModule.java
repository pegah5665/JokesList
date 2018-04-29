package ir.pahmadvand.jokeslist.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;



@Module
public class ContextModule {
    public Context context;


    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context contextModMeth()
    {
        return context;
    }
}
