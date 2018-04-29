package ir.pahmadvand.jokeslist.mvp.model;

import javax.inject.Inject;

import ir.pahmadvand.jokeslist.Api;
import ir.pahmadvand.jokeslist.Contains;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataProvider {

    private Api api;


    @Inject
    public DataProvider(Api api) {
        this.api = api;

    }

    public void dataProviderMethode( final Contains.ModelData.MyCallback myCallBack)
    {


            api.callForJson().enqueue(new Callback<BaseModel>() {
                @Override
                public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                    if (response.isSuccessful()) {

                        if (response.body().getValue().size()>0) {

                            myCallBack.onSuccess(response.body().getValue());

                        } else {
                            myCallBack.onNull();
                        }
                    }

                    else{

                        myCallBack.onErorr();
                    }


                                        }

                @Override
                public void onFailure(Call<BaseModel> call, Throwable throwable) {
                    myCallBack.onErorr();
                }
            });


    }





}


