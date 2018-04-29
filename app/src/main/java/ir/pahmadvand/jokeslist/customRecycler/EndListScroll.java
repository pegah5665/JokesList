package ir.pahmadvand.jokeslist.customRecycler;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public abstract class EndListScroll extends RecyclerView.OnScrollListener {

    private  int allSize;
    private  int lastVisibleItem;
    private int visibleThreshold=1;



    private boolean loading;

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    private  RecyclerView.LayoutManager layoutManager;

    public EndListScroll(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        allSize=layoutManager.getItemCount();
        lastVisibleItem=((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();

        if(!loading&&allSize<=lastVisibleItem+visibleThreshold){
            loading=true;
            onMoreLoad();
        }
        super.onScrolled(recyclerView, dx, dy);

    }

    abstract void onMoreLoad();
}
