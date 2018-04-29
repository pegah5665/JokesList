package ir.pahmadvand.jokeslist.database;


import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ir.pahmadvand.jokeslist.mvp.model.DataModel;

public class MyQuery {



    public void setDataToTable(List<DataModel> list){


        Realm realm= Realm.getDefaultInstance();
        realm.beginTransaction();




        for (DataModel model: list) {

            RealmResults<JokeTable> jokeItem = realm.where(JokeTable.class).equalTo("id",model.getId()).findAll();

            if(jokeItem.size()==0){
                    JokeTable joke = new JokeTable();
                    joke.setId(model.getId());
                    joke.setJoke(model.getJoke());
                    realm.copyToRealm(joke);}

        }



        realm.commitTransaction();
        realm.close();

    }



    
    public List<DataModel> getDataFromTable(){
        List<DataModel> dataModels=new ArrayList<>();

        Realm realm= Realm.getDefaultInstance();

        RealmResults<JokeTable> joke = realm.where(JokeTable.class).findAll();



        for (int i = 0; i < joke.size(); i++) {
            DataModel model=new DataModel();
            model.setId(joke.get(i).getId());
            model.setJoke(joke.get(i).getJoke());
            dataModels.add(model);
        }
        realm.close();
        return dataModels;
    }
}
