package com.bapp.ui.home;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bapp.R;
import com.bapp.base.BaseActivity;
import com.bapp.base.BaseFragment;
import com.bapp.view.GridSpacingItemDecoration;

import butterknife.BindView;

/**
 * 网格布局
 */
public class AndroidFragment extends BaseFragment<AndroidView, AndroidPresenter> implements AndroidView {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recycleView)
    RecyclerView mRecyclerView;

    @Override
    protected AndroidPresenter createPresenter() {

        return new AndroidPresenter((BaseActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_android;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public SwipeRefreshLayout getSwipeRefresh() {
        return mSwipeRefreshLayout;
    }

    @Override
    public void initData() {

        Log.e("---",":-----");
        mPresenter.loadData();
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 10, false));
        mRecyclerView.setHasFixedSize(true);
    }

    public void refresh(){

        mPresenter.onRefresh();
    }
}
