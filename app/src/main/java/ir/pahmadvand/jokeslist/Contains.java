package ir.pahmadvand.jokeslist;



import java.util.List;

import ir.pahmadvand.jokeslist.mvp.model.DataModel;

public class Contains {

    public  interface ViewShow{
    void showData(List<DataModel> models);}

    public  interface ModelData{

        void getData(MyCallback callback);


        public  interface  MyCallback{

            void onSuccess(List<DataModel> models);
            void onErorr();
            void onNull();

        }
    }



}
