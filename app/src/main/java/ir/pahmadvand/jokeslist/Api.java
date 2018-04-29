package ir.pahmadvand.jokeslist;

import ir.pahmadvand.jokeslist.mvp.model.BaseModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("10")
    Call<BaseModel> callForJson();
}
