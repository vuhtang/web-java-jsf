package com.vuhtang.main.beans;

import com.vuhtang.main.beans.mbean.MeanIntervalMXBean;
import com.vuhtang.main.utils.jmx.MBeansRegistrator;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;

@Named("meanInterval")
@SessionScoped
public class MeanInterval implements Serializable, MeanIntervalMXBean {

    private static final String packageName = "com.vuhtang.main.beans:type=userMetrics,name=interval";
    private Date lastShotTime;
    private long intervalsSum;
    private long shotsNumber;
    private long meanInterval;

    public MeanInterval() {
        this.intervalsSum = 0;
        this.shotsNumber = 0;
        this.meanInterval = 0;
        MBeansRegistrator.registerBean(packageName, this);
    }

    @PostConstruct
    private void selfRegister() {
        MBeansRegistrator.registerBean(packageName, this);
    }

    private void incShots() {
        shotsNumber++;
    }

    private void updateMeanInterval() {
        meanInterval = intervalsSum / shotsNumber;
    }

    public long getMeanInterval() {
        if (shotsNumber > 1)
            return meanInterval;
        return 0;
    }

    public void handleInterval(Date time) {
        incShots();
        if (lastShotTime != null)
            intervalsSum += time.getTime() - lastShotTime.getTime();
        lastShotTime = time;
        updateMeanInterval();
    }


}
