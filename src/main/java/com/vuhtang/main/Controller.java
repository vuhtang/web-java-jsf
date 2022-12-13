package com.vuhtang.main;

import com.vuhtang.main.parsers.ShotsParserFromBean;
import com.vuhtang.main.repository.DataManager;
import com.vuhtang.main.repository.DatabaseManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("controller")
@ApplicationScoped
public class Controller {
    @Inject
    @DatabaseManager
    private DataManager manager;

    public void takeShot(SessionBean bean) {
        Shot newShot = ShotsParserFromBean.parseShot(bean.getX(), bean.getY(), bean.getR());
        manager.add(newShot);
        int curr = bean.getCurrentShotsOnPage();
        if (curr == 10) {
            bean.setCurrentPage(manager.getLastPageNumber(bean.getEntitiesOnPage()));
            bean.setCurrentShotsOnPage(0);
            return;
        }
        curr += 1;
        bean.setCurrentShotsOnPage(curr);
        System.out.println();
    }

    public List<Shot> getShotsList(SessionBean bean) {
        List<Shot> list = manager.getShots(bean.getCurrentPage(), bean.getEntitiesOnPage());
        bean.setCurrentShotsOnPage(list.size());
        return list;
    }

    public void clearHistory(SessionBean bean) {
        bean.setCurrentPage(0);
        manager.removeAll();
    }
}
