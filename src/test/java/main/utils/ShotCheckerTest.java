package main.utils;

import com.vuhtang.main.Shot;
import com.vuhtang.main.utils.data.ShotCheckerImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShotCheckerTest {

    private final ShotCheckerImpl shotChecker = new ShotCheckerImpl();

    @Test
    public void takeShot__shotInArea_returnShotWithHIT(){
        //given
        double testX = 1.0;
        double testY = 2.0;
        double testR = 3.0;

        //when
        Shot shot = shotChecker.takeShot(testX, testY, testR);

        //then
        assertAll(
                () -> assertEquals("HIT", shot.getResult()),
                () -> assertEquals( 1.0, shot.getX()),
                () -> assertEquals( 2.0, shot.getY()),
                () -> assertEquals( 3.0, shot.getR())
        );

    }

    @Test
    public void takeShot__shotNotInArea_returnShotWithMISS(){
        //given
        double testX = 10.0;
        double testY = 2.0;
        double testR = 3.0;

        //when
        Shot shot = shotChecker.takeShot(testX, testY, testR);

        //then
        assertAll(
                () -> assertEquals("MISS", shot.getResult()),
                () -> assertEquals( 10.0, shot.getX()),
                () -> assertEquals( 2.0, shot.getY()),
                () -> assertEquals( 3.0, shot.getR())
        );
    }


}
