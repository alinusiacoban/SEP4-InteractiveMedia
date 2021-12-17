package com.aliniacoban.fishingindenmark.terraiot.Model.database;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;

import java.util.List;
/////////////////////////////////////
//                                //
//Whole class is written by Alin  //
//                                //
////////////////////////////////////
@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setTerrarium(Terrarium terrarium);

    @Insert
    void insertTerrarium(Terrarium terrarium);

    @Query("SELECT * FROM terrarium_table")
    List<Terrarium> getTerrariums();

    @Delete
    void removeTerraium(Terrarium terraium);
}
