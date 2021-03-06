package lj_3d.pulltorefreshsample.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by liubomyr on 06.10.16.
 */

public class GridViewActivity extends PullToRefreshHeaderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        initHeaderUI();

        final GridView pullToRefreshGridView = (GridView) findViewById(R.id.gv_pull_to_refresh);
        pullToRefreshGridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder;
                if (convertView == null) {
                    convertView = View.inflate(getApplicationContext(), R.layout.scrollable_item, null);
                    viewHolder = new ViewHolder(convertView);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }

                viewHolder.item.setText("item" + position);
                return convertView;
            }

            final class ViewHolder {

                final TextView item;

                public ViewHolder(final View item) {
                    this.item = (TextView) item.findViewById(R.id.txt_item);
                    item.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
