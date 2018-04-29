package ir.pahmadvand.jokeslist.dagger;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;


@Module(includes = ContextModule.class)
public class ClientModul {

    @Provides
    public OkHttpClient client()
    {
        return new OkHttpClient.Builder()
                //.connectTimeout(60, TimeUnit.SECONDS)
                //.writeTimeout(60, TimeUnit.SECONDS)
               // .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }




}
