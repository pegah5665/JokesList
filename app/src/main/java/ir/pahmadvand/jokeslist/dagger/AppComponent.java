package ir.pahmadvand.jokeslist.dagger;


import dagger.Component;
import ir.pahmadvand.jokeslist.MainActivity;


@Component(modules = {ApiService.class})
public interface AppComponent {

    void injectorToMainAct(MainActivity mainActivity);

}
