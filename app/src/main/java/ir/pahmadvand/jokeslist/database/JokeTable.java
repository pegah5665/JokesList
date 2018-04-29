package ir.pahmadvand.jokeslist.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class JokeTable extends RealmObject {

    @PrimaryKey
    private int id;
    private String joke;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
