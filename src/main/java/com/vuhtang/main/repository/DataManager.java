package com.vuhtang.main.repository;

import com.vuhtang.main.Shot;

import java.util.List;

public interface DataManager {
    void add(Shot shot);

    List<Shot> getShots(int from, int count);

    int getCount();

    void removeAll();
}
