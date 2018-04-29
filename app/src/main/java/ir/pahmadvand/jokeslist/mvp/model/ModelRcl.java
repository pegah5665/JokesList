package ir.pahmadvand.jokeslist.mvp.model;

import ir.pahmadvand.jokeslist.Contains;

/**
 * Created by Arash on 4/29/2018.
 */

public class ModelRcl implements Contains.ModelData {

   private DataProvider dataProvider;

    public ModelRcl(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void getData(MyCallback callback) {
        dataProvider.dataProviderMethode(callback) ;

    }
}
