package main.repository;

import com.vuhtang.main.Shot;
import com.vuhtang.main.repository.DataManagerDB;
import com.vuhtang.main.utils.data.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataManagerTest {

    private Shot createShot(){
        return new Shot(1,1.0,1.0,1.0, new Date(),1231L,"Result");
    }

    private static final DataManagerDB dataManagerDB = new DataManagerDB();

    @BeforeAll
    static void setUp() {
        HibernateUtil.init();
        dataManagerDB.removeAll();
    }

    @AfterAll
    static void close() {
        HibernateUtil.closeSessionFactory();
    }

    @AfterEach
    void cleanDB(){
        dataManagerDB.removeAll();
    }


    @Test
    public void removeAll_DBHasShot_successRemove(){
        //given
        Shot shot = createShot();
        dataManagerDB.add(shot);

        //when
        dataManagerDB.removeAll();

        //then
        assertEquals(0, dataManagerDB.getCount());
    }

    @Test
    public void add_addShotToDB_successfulAdd(){
        //given
        Shot shot = createShot();

        //when
        dataManagerDB.add(shot);

        //then
        assertEquals(1, dataManagerDB.getCount());
    }

    @Test
    public void getShot_DBHasShot_successfulGet(){
        //given
        DataManagerDB dataManagerDB = new DataManagerDB();
        Shot shot = createShot();
        dataManagerDB.add(shot);

        //when
        List<Shot> shots = dataManagerDB.getShots(0,1);

        //then
        assertAll(
                () -> assertEquals(1, shots.size()),
                () -> assertEquals(1.0, shots.get(0).getX()),
                () -> assertEquals("Result", shots.get(0).getResult())
        );
    }

    @Test
    public void getCount_DBHasShot_successfulGet(){
        //given
        Shot shot = createShot();
        dataManagerDB.add(shot);

        //when
        Integer shotsCount = dataManagerDB.getCount();

        //then
       assertEquals(1, shotsCount);
    }




}
