package ir.pahmadvand.jokeslist.dagger;

import dagger.Module;
import dagger.Provides;
import ir.pahmadvand.jokeslist.Api;
import retrofit2.Retrofit;


@Module(includes = RetrophitModul.class)
public class ApiService {

    @Provides
    public Api api(Retrofit retrofit)
    {
       return retrofit.create(Api.class);
    }
}
