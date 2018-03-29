package com.example.has.asapp.Page.fgt;

/**
 * Created by has on 2018/3/23.
 */
public abstract class LazyFragment extends BaseFragment {
        protected boolean isVisible;
        protected boolean isPrepared;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            isVisible=true;
            onVisible();
        }else{
            isVisible=false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }
    protected void onInvisible() {
    }
    protected abstract void lazyLoad();
}
