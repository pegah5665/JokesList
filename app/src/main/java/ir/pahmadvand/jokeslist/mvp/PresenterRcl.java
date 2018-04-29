package ir.pahmadvand.jokeslist.mvp;

import android.util.Log;

import java.util.List;

import ir.pahmadvand.jokeslist.Contains;
import ir.pahmadvand.jokeslist.database.MyQuery;
import ir.pahmadvand.jokeslist.mvp.model.DataModel;
import ir.pahmadvand.jokeslist.Presenter;



public class PresenterRcl  implements Presenter,Contains.ModelData.MyCallback{


    private Contains.ModelData model;
    private Contains.ViewShow view;

    public PresenterRcl(Contains.ModelData model, Contains.ViewShow view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCreat() {
        model.getData(this);

    }


    @Override
    public void onSuccess(List<DataModel> models) {
        view.showData(models);

       new MyQuery().setDataToTable(models);
    }

    @Override
    public void onErorr() {
        List<DataModel> models =new MyQuery().getDataFromTable();
        Log.i("pegah", "onErorr: "+models.size());
        view.showData(models);
    }

    @Override
    public void onNull() {
        List<DataModel> models =new MyQuery().getDataFromTable();
        view.showData(models);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onBack() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }


}
