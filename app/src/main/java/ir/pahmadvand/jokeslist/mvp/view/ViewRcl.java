package ir.pahmadvand.jokeslist.mvp.view;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.pahmadvand.jokeslist.Contains;
import ir.pahmadvand.jokeslist.R;
import ir.pahmadvand.jokeslist.customRecycler.ListenEndScroll;
import ir.pahmadvand.jokeslist.customRecycler.MyRecyclerView;
import ir.pahmadvand.jokeslist.mvp.model.DataModel;



public class ViewRcl extends FrameLayout implements Contains.ViewShow{

    @BindView(R.id.rcl_main)
    MyRecyclerView recyclerView;

    @BindView(R.id.progress_main)
    ProgressBar progress;

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    private AppCompatActivity activity;
    private MyAdapter adapter;

    public ViewRcl(@NonNull AppCompatActivity activity, MyAdapter adapter) {
        super(activity);
        this.activity=activity;
        this.adapter=adapter;

        LayoutInflater.from(getContext()).inflate(R.layout.activity_main,this);

        ButterKnife.bind(this);

        setToolbar();
        init();
    }

    @Override
    public void showData(List<DataModel> models) {
        recyclerView.setLoading(false);
        adapter.setData(models);
        recyclerView.setAdapter(adapter);
    }


    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setListenEndScroll(new ListenEndScroll() {
            @Override
            public void loadeMore() {
                recyclerView.setLoading(false);
                Toast.makeText(activity, getResources().getString(R.string.end), Toast.LENGTH_SHORT).show();
            }
        });

        final SwipeRefreshLayout swipeRefreshLayout=findViewById(R.id.swipe_refresh_list);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(activity,R.color.colorAccent)
                ,ContextCompat.getColor(activity,R.color.colorPrimary)
        );
    }

    private void setToolbar() {

        activity.setSupportActionBar(toolbar);
        activity.setTitle(getResources().getString(R.string.jokes));
       toolbar.setTitleTextColor(ContextCompat.getColor(getContext(),R.color.white));


    }


}
