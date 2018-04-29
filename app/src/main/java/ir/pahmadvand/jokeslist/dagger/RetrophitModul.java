package ir.pahmadvand.jokeslist.dagger;

import dagger.Module;
import dagger.Provides;
import ir.pahmadvand.jokeslist.Common;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ClientModul.class)
public class RetrophitModul {

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient)
    {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Common.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
