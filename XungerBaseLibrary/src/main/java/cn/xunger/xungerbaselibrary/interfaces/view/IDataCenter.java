package cn.xunger.xungerbaselibrary.interfaces.view;

public interface IDataCenter {

    void registerListener(int key, OnDataChangeListener onDataChangeListener);

    void unregisterListener(int key);

    void notifyDataChanged(int key);

    void requestLoadData(int key);

    void onPause(int key);

    void onResume(int key);

    void onDestroy(int key);

}
