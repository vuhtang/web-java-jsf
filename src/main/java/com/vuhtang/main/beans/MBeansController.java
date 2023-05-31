package com.vuhtang.main.beans;

import com.vuhtang.main.Shot;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("mController")
@SessionScoped
public class MBeansController implements Serializable {

    @Inject
    private ShotsCounter shotsCounter;

    @Inject
    private MeanInterval meanInterval;

    private void handleCounter(Shot shot) {
        if (shot.getResult().equals("HIT")) {
            shotsCounter.incHitsNumber();
        } else {
            shotsCounter.incShotsNumber();
        }
    }

    private void handleMean(Shot shot) {
        meanInterval.handleInterval(shot.getCurrTime());
    }
    public void handleShot(Shot shot) {
        handleCounter(shot);
        handleMean(shot);
    }
}
