package cn.xunger.xungerbaselibrary.framework;


import cn.xunger.xungerbaselibrary.interfaces.view.IDataRefreshTask;

public class DataRefreshTask implements IDataRefreshTask {
    private final int taskId;
    private final int refreshPeriod;

    public DataRefreshTask(int taskId, int refreshPeriod) {
        this.taskId = taskId;
        this.refreshPeriod = refreshPeriod;
    }

    @Override
    public int getTaskId() {
        return taskId;
    }

    @Override
    public int getRefreshPeriod() {
        return refreshPeriod;
    }
}
