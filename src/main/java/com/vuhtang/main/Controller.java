package com.vuhtang.main;

import com.vuhtang.main.parsers.ShotsParserFromBean;
import com.vuhtang.main.repository.DataManagerDB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("controller")
@ApplicationScoped
public class Controller {
    @Inject
    private DataManagerDB manager;

    public void takeShot(SessionBean bean) {
        Shot newShot = ShotsParserFromBean.parseShot(bean.getX(), bean.getY(), bean.getR());
        manager.add(newShot);
    }

    public void clearHistory(SessionBean bean) {
        bean.setCurrentPage(0);
        manager.removeAll();
    }
}
