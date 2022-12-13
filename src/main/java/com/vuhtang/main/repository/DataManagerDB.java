package com.vuhtang.main.repository;

import com.google.gson.Gson;
import com.vuhtang.main.Shot;
import com.vuhtang.main.utils.HibernateUtil;
import com.vuhtang.main.utils.ShotChecker;
import com.vuhtang.main.utils.ShotCheckerImpl;
import com.vuhtang.main.utils.Shots;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named("dataManagerCool")
@ApplicationScoped
@DatabaseManager
public class DataManagerDB implements DataManager {

    @PostConstruct
    private void initHibernateUtil() {
        HibernateUtil.init();
    }

    @PreDestroy
    private void deInitHibernateUtil() {
        HibernateUtil.closeSessionFactory();
    }

    @Override
    public void add(Shot shot) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(shot);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Shot> getShots(int pageFrom, int pageSize) {
        Transaction transaction = null;
        int from = pageFrom * pageSize;
        from = from > getCount() ? (pageFrom - 1) * pageSize : from;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Shot> resultList = session.createQuery("From Shot ")
                    .setFirstResult(from)
                    .setMaxResults(pageSize).list();
            transaction.commit();
            return resultList;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            int resultCount = session.createQuery("SELECT count(s) FROM Shot s", Number.class)
                    .getSingleResult().intValue();
            transaction.commit();
            return resultCount;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return 0;
    }

    @Override
    public void removeAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Shot").executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public int getLastPageNumber(int pageSize) {
        int numberOfRecords = getCount();
        if (numberOfRecords % pageSize == 0) return numberOfRecords / pageSize - 1;
        return getCount() / pageSize;
    }

    public String shotsJSON(int from, int count) {
        Shots shots = new Shots(getShots(from, count));
        return new Gson().toJson(shots);
    }

    public void addOneHundredShots() {
        ShotChecker checker = new ShotCheckerImpl();
        Shot shot;
        List<Double> rPossibleValues = List.of(new Double[]{1.0, 1.5, 2.0, 2.5, 3.0});
        for (int i = 0; i < 100; i++) {
            shot = checker.takeShot(
                    Math.random() * 4 - 2,
                    Math.random() * 4 - 2,
                    rPossibleValues.get(ThreadLocalRandom.current().nextInt(rPossibleValues.size()))
            );
            add(shot);
        }
    }
}
