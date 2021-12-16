package com.aliniacoban.fishingindenmark;

import static org.junit.Assert.assertEquals;


import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;

import org.junit.Test;

public class TerrariumTest {
    Terrarium terrarium = new Terrarium("B", "C");


    @Test
    public void getTerrariumName(){assertEquals("B", terrarium.getTerrariumName());}

    @Test
    public void setTerrariumName() {
        terrarium.setTerrariumName("test");
        assertEquals("test", terrarium.getTerrariumName());
    }

    @Test
    public void getReptileLivingInTerrarium(){assertEquals("C", terrarium.getReptileLivingInTerrarium());}

    @Test
    public void setReptileLivingInTerrarium(){
        terrarium.setReptileLivingInTerrarium("Crocodile");
        assertEquals("Crocodile", terrarium.getReptileLivingInTerrarium());
    }




}