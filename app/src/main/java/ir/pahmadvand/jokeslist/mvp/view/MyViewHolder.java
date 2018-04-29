package ir.pahmadvand.jokeslist.mvp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.pahmadvand.jokeslist.R;
import ir.pahmadvand.jokeslist.mvp.model.DataModel;


/**
 * Created by Pegah on 4/24/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.txtDetaile)
    TextView txtDetaile;



    public MyViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setData(DataModel data) {

        txtDetaile.setText(data.getJoke());



    }
}
