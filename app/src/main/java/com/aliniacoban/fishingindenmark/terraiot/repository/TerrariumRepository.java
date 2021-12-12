package com.aliniacoban.fishingindenmark.terraiot.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;
import com.aliniacoban.fishingindenmark.terraiot.Model.database.AppDao;
import com.aliniacoban.fishingindenmark.terraiot.Model.database.AppDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TerrariumRepository {
    private final AppDao dao;
    private static TerrariumRepository instance;

    private final MutableLiveData<List<Terrarium>> terrariums;

    public TerrariumRepository(Application app){
        AppDatabase appDatabase = AppDatabase.getInstance(app);
        dao = appDatabase.appDao();
        terrariums = new MutableLiveData<>();
    }
    public static synchronized TerrariumRepository getInstance(Application app){
        if(instance==null){
            instance = new TerrariumRepository(app);
        }
        return instance;
    }

    public void insert (Terrarium terrarium) throws ExecutionException, InterruptedException{
        new TerrariumRepository.InsertAsyncTask(dao).execute(terrarium);

        List<Terrarium> terrariums = getTerrariumsFromDB();
        this.terrariums.postValue(terrariums);
    }

    public List<Terrarium> getTerrariumsFromDB() throws ExecutionException, InterruptedException{
        return new GetTerrariums(dao).execute().get();
    }

    public LiveData<List<Terrarium>> getTerrariums(){
        return terrariums;
    }

    public void removeTerrarium(int pos) throws ExecutionException, InterruptedException{
        List<Terrarium> list = getTerrariumsFromDB();
        Terrarium temp = list.get(pos);
        new RemoveItemAsync(dao).execute(temp);
    }

    public static class RemoveItemAsync extends AsyncTask<Terrarium, Void, Void>{
        private final AppDao dao;

        private RemoveItemAsync(AppDao dao){
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Terrarium... terrariums){
            dao.removeTerraium(terrariums[0]);
            return null;
        }
    }

    public static class GetTerrariums extends AsyncTask<Void, Void, List<Terrarium>>{
        private final AppDao dao;

        private GetTerrariums(AppDao dao){
            this.dao = dao;
        }
        @Override
        protected List<Terrarium> doInBackground(Void... voids){
            return dao.getTerrariums();
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Terrarium, Void, Void> {
        private final AppDao dao;
        private InsertAsyncTask(AppDao appDao){
            this.dao = appDao;
        }
        @Override
        protected Void doInBackground(Terrarium... terrariums){
            dao.insertTerrarium(terrariums[0]);
            return null;
        }
    }


}
