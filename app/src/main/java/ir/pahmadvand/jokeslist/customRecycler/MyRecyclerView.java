package ir.pahmadvand.jokeslist.customRecycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by Pegah on 4/23/2018.
 */

public class MyRecyclerView extends android.support.v7.widget.RecyclerView {

    private EndListScroll endListScroll;
    private ListenEndScroll listenEndScroll;




    public void setListenEndScroll(ListenEndScroll listenEndScroll) {
        this.listenEndScroll = listenEndScroll;
    }


    public  void setLoading(boolean loading){
        endListScroll.setLoading(loading);
    }


    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        if(!(layout instanceof LinearLayoutManager)){
            throw new RuntimeException();}

        endListScroll=new EndListScroll(layout) {

            @Override
            void onMoreLoad() {
                if(listenEndScroll!=null){
                listenEndScroll.loadeMore();}
            }
        };

        addOnScrollListener(endListScroll);

        super.setLayoutManager(layout);
    }
}
