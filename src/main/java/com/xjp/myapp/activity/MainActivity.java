package com.xjp.myapp.activity;

import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.xjp.myapp.R;
import com.xjp.myapp.adapter.MainAdapter;
import com.xjp.myapp.beans.Category.Category;
import com.xjp.myapp.beans.Category.Result;
import com.xjp.myapp.utils.ShowDialog;
import com.xjp.myapp.utils.Urls;

import java.util.List;


public class MainActivity extends BaseHttpActivity implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private MainAdapter mCategotyAdapter;
    List<Result> resultList;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mGridView = (GridView) findViewById(R.id.gv_category);
    }

    @Override
    protected void initData() {
        mCategotyAdapter = new MainAdapter(this);
        mCategotyAdapter.initAllData(null);
        mGridView.setAdapter(mCategotyAdapter);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    protected void loadData() {
        get(Urls.ALL_CATEGORY, Category.class);
    }

    @Override
    protected void reLoad() {
        this.loadData();
    }


    @Override
    public void onSuccess(Object response) {
        resultList = ((Category) response).getResult();
        mCategotyAdapter.initAllData(resultList);
    }

    @Override
    public void onFailed(VolleyError error) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Result result = resultList.get(position);
        ShowDialog.showCategoryDialog(MainActivity.this, result);
    }
}
