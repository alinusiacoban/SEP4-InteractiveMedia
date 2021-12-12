package com.aliniacoban.fishingindenmark.terraiot.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "terrarium_table")

public class Terrarium {

    @PrimaryKey(autoGenerate = true)

    private int terrariumId;
    private String terrariumName;
    private String reptileLivingInTerrarium;

    public Terrarium(int terrariumId, String terrariumName, String reptileLivingInTerrarium)
    {
        this.terrariumId = terrariumId;
        this.terrariumName = terrariumName;
        this.reptileLivingInTerrarium = terrariumName;
    }

    @Ignore
    public Terrarium(){

    }

    @Ignore
    public Terrarium(String terrariumName, String reptileLivingInTerrarium){
        this.terrariumName = terrariumName;
        this.reptileLivingInTerrarium = reptileLivingInTerrarium;
    }

    public int getTerrariumId(){
        return terrariumId;
    }
    public void setTerrariumId(int terrariumId)
    {
        this.terrariumId = terrariumId;
    }
    public String getTerrariumName()
    {
        return terrariumName;
    }
    public void setTerrariumName()
    {
        this.terrariumName = terrariumName;
    }
    public String getReptileLivingInTerrarium()
    {
        return reptileLivingInTerrarium;
    }
    public void setReptileLivingInTerrarium(String reptileLivingInTerrarium)
    {
        this.reptileLivingInTerrarium = reptileLivingInTerrarium;
    }
}
