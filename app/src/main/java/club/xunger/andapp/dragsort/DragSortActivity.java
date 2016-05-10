package club.xunger.andapp.dragsort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import club.xunger.andapp.framework.dragsort.DragSortController;
import club.xunger.andapp.framework.dragsort.DragSortListView;
import club.xunger.xungerapp.R;
import cn.xunger.xungerbaselibrary.framework.BaseActivity;

public class DragSortActivity extends BaseActivity {

    private DragSortListView sortListView;
    private DragSortController controller;
    private DragSortAdapter adapter;
    public int removeMode = DragSortController.FLING_REMOVE;
    public boolean sortEnabled = true;
    public boolean dragEnabled = true;
    public int dragStartMode = DragSortController.ON_DRAG;
    public boolean removeEnabled = true;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_drag_sort;
    }

    @Override
    protected View getContentRootView() {
        return null;
    }

    @Override
    protected void initTopBar() {

    }

    @Override
    protected void initContent() {
        adapter = new DragSortAdapter();
        sortListView = (DragSortListView) findViewById(R.id.listview);
        sortListView.setDropListener(new DragSortListView.DropListener() {
            @Override
            public void drop(int from, int to) {
                String item = adapter.getItem(from);
                adapter.remove(item);
                adapter.insert(item, to);
            }
        });
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        sortListView.setRemoveListener(new DragSortListView.RemoveListener() {
            @Override
            public void remove(int which) {
                adapter.remove(which);
            }
        });
        controller = buildController(sortListView);
        sortListView.setFloatViewManager(controller);
        sortListView.setDragEnabled(dragEnabled);
        sortListView.setOnTouchListener(controller);
        sortListView.setAdapter(adapter);
    }

    public DragSortController buildController(DragSortListView dslv) {
        DragSortController controller = new DragSortController(dslv);
        controller.setSortEnabled(sortEnabled);
        controller.setDragInitMode(dragStartMode);
        controller.setRemoveMode(removeMode);
        controller.setRemoveEnabled(removeEnabled);
        controller.setDragHandleId(R.id.drag);
        return controller;
    }

    @Override
    protected void initBottomBar() {

    }

    @Override
    protected void initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("Test Data" + i);
        }
        adapter.setData(data);
    }

    @Override
    protected void refreshView(int viewId) {

    }

    class DragSortAdapter extends BaseAdapter {

        private List<String> data;
        private LayoutInflater inflater = getLayoutInflater();

        public void setData(List<String> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        public void remove(String item) {
            data.remove(item);
            notifyDataSetChanged();
        }

        public void remove(int position) {
            data.remove(position);
            notifyDataSetChanged();
        }

        public void insert(String item, int position) {
            data.add(position, item);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.drag_sort_item, null);
            }

            TextView name = (TextView) convertView.findViewById(R.id.name);
            name.setText(getItem(position));

            return convertView;
        }
    }

}
