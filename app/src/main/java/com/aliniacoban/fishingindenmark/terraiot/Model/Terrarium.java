package com.aliniacoban.fishingindenmark.terraiot.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "terrarium_table")

public class Terrarium {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @PrimaryKey(autoGenerate = true)

   private int terrariumId;
    private String terrariumName;
    private String reptileLivingInTerrarium;

    public Terrarium(int terrariumId, String terrariumName, String reptileLivingInTerrarium)
    {
        this.terrariumId = terrariumId;
        this.terrariumName = terrariumName;
        this.reptileLivingInTerrarium = reptileLivingInTerrarium;
    }

    @Ignore
    public Terrarium(){

    }

    @Ignore
    public Terrarium(String terrariumName, String reptileLivingInTerrarium){
        this.name = name;
        this.type = type;
    }


}
