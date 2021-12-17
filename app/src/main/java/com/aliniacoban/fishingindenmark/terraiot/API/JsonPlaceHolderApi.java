
package com.aliniacoban.fishingindenmark.terraiot.API;



import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
/////////////////////////////////////
//                                //
//Whole class is written by Alin  //
//                                //
////////////////////////////////////
public interface JsonPlaceHolderApi {



    @GET("terrariums")
    Call<List<Terrarium>> getTerrarium();
//Alin's code ends here

//Yuhao's code starts here
    @GET("level")
    Call<List<Level>> getLevel();
}//Yuhao's code ends here
