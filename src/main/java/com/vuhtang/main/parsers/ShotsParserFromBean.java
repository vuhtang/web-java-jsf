package com.vuhtang.main.parsers;

import com.vuhtang.main.Shot;
import com.vuhtang.main.utils.ShotChecker;
import com.vuhtang.main.utils.ShotCheckerImpl;

public class ShotsParserFromBean {
    private static final ShotChecker checker = new ShotCheckerImpl();

    public static Shot parseShot(Double x, Double y, Double r) {
        return checker.takeShot(x, y, r);
    }
}
