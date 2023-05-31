package com.vuhtang.main.beans;

import com.vuhtang.main.beans.mbean.ShotsCounterMXBean;
import com.vuhtang.main.utils.jmx.MBeansRegistrator;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import javax.management.*;
import java.io.Serializable;

@Named("shotsCounter")
@SessionScoped
public class ShotsCounter extends NotificationBroadcasterSupport implements Serializable, ShotsCounterMXBean {

    private static final String packageName = "com.vuhtang.main.beans:type=userMetrics,name=counter";
    private static final String notificationType = "com.vuhtang.main.beans.counter";
    private static final String message = "The number of user's shots is a multiple of 10";
    private int notificationSequence = 0;
    private final int MOD = 10;
    private int shotsNumber;
    private int hitNumber;

    public ShotsCounter() {
        this.shotsNumber = 0;
        this.hitNumber = 0;
    }

    @PostConstruct
    private void selfRegister() {
        MBeansRegistrator.registerBean(packageName, this);
    }

    private void incShots(boolean hit) {
        shotsNumber++;
        if (shotsNumber % MOD == 0)
            sendNotificationMultipleOfMOD();
        if (hit) hitNumber++;
    }

    public void incShotsNumber() {
        incShots(false);
    }

    public void incHitsNumber() {
        incShots(true);
    }

    public int getHitNumber() {
        return hitNumber;
    }

    public int getShotsNumber() {
        return shotsNumber;
    }

    private void sendNotificationMultipleOfMOD() {
        sendNotification(
                new Notification(notificationType, this, ++notificationSequence, message)
        );
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[] {
                new MBeanNotificationInfo(
                        new String[]
                                { notificationType },
                        Notification.class.getName(),
                        "User metrics notification."
                )
        };
    }
}
