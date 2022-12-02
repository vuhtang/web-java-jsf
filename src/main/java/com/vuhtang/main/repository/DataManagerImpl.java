package com.vuhtang.main.repository;

import com.google.gson.Gson;
import com.vuhtang.main.Shot;
import com.vuhtang.main.utils.Shots;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Named("dataManager")
@ApplicationScoped
public class DataManagerImpl implements DataManager {
    private final List<Shot> collection = Collections.synchronizedList(new LinkedList<>());


    @Override
    public void add(Shot shot) {
        collection.add(shot);
    }

    @Override
    public void removeAll() {
        collection.clear();
    }

    public String shotsJSON(int from, int count) {
        Shots shots = new Shots(getShots(0, getCount()));
        return new Gson().toJson(shots);
    }

    @Override
    public List<Shot> getShots(int from, int count) {
        return collection.stream().skip(from).limit(count).toList();
    }

    public int getCount() {
        return collection.size();
    }
}
