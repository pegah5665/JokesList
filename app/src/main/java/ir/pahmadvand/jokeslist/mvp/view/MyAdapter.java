package ir.pahmadvand.jokeslist.mvp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ir.pahmadvand.jokeslist.R;
import ir.pahmadvand.jokeslist.mvp.model.DataModel;



public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;

    public MyAdapter(Context context) {

        this.context = context;
    }

    private List<DataModel> list=new ArrayList<>();


    public void setData(List<DataModel> list) {
        this.list.addAll(list) ;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (viewType==0)
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_infinite,parent,false));
       else
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_infinite1,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myHolder=(MyViewHolder)holder;
        myHolder.setData(list.get(position));

    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0)
            return  0;
        else
            return 1;
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}
