package lj_3d.pulltorefreshsample.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by liubomyr on 06.10.16.
 */

public class RecyclerViewActivity extends PullToRefreshHeaderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initHeaderUI();
        initUI();
    }

    void initUI() {
        final RecyclerView pullToRefreshRecyclerView = (RecyclerView) findViewById(R.id.rv_pull_to_refresh);
        pullToRefreshRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pullToRefreshRecyclerView.setAdapter(new PullToRefreshAdapter());
    }

    class PullToRefreshAdapter extends RecyclerView.Adapter<PullToRefreshAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View item = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.scrollable_item, null);
            return new ViewHolder(item);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ViewHolder extends RecyclerView.ViewHolder {


            public ViewHolder(View itemView) {
                super(itemView);
            }
        }

    }

}
