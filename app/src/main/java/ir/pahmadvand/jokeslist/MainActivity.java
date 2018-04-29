package ir.pahmadvand.jokeslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ir.pahmadvand.jokeslist.mvp.PresenterRcl;
import ir.pahmadvand.jokeslist.mvp.model.DataProvider;
import ir.pahmadvand.jokeslist.mvp.model.ModelRcl;
import ir.pahmadvand.jokeslist.mvp.view.MyAdapter;
import ir.pahmadvand.jokeslist.mvp.view.ViewRcl;


public class MainActivity extends AppCompatActivity {

    @Inject
    public DataProvider dataProvider;

   private PresenterRcl presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getAppComponent().injectorToMainAct(this);

        MyAdapter adapter=new MyAdapter(this);

        ViewRcl view=new ViewRcl(this,adapter);
        setContentView(view);

        ModelRcl model=new ModelRcl(dataProvider);

        presenter=new PresenterRcl(model,view);
        presenter.onCreat();


    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
