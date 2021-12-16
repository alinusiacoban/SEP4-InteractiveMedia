package com.aliniacoban.fishingindenmark;

import static org.junit.Assert.assertEquals;

import com.aliniacoban.fishingindenmark.terraiot.API.Level;

import org.junit.Test;

public class LevelTest {

    Level level = new Level("A", "B", "C");

    @Test
    public void getCo2() {assertEquals("A", level.getCo2());}

    @Test
    public void setCo2() {
        level.setCo2("test");
        assertEquals("test", level.getCo2());
    }

    @Test
    public void getHumidity() {
        assertEquals("B", level.getHumidity());
    }

    @Test
    public void setHumidity() {
        level.setHumidity("test");
        assertEquals("test", level.getHumidity());
    }

    @Test
    public void getTemperature() { assertEquals("C", level.getTemperature()); }

    @Test
    public void setTemperature() { level.setTemperature("test");
    assertEquals("test", level.getTemperature());}
}
