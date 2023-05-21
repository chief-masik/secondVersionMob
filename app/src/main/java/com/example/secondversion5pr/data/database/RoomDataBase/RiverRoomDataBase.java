package com.example.secondversion5pr.data.database.RoomDataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.secondversion5pr.R;
import com.example.secondversion5pr.data.database.dao.RiverDao;
import com.example.secondversion5pr.data.database.entity.RiverEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RiverEntity.class}, version = 1, exportSchema = false)
public abstract class RiverRoomDataBase extends RoomDatabase {
    public abstract RiverDao riverDao();
    private static volatile RiverRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static RiverRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RiverRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RiverRoomDataBase.class, "river_database")
                            .addCallback(sRoomDatabaseCallback).build();}}
        }
        return INSTANCE;
    }
    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                RiverDao dao = INSTANCE.riverDao();
                dao.deleteAll();
                RiverEntity river = new RiverEntity(R.drawable.river_ob, "Река Обь");
                dao.insert(river);
                river = new RiverEntity(R.drawable.river_volga, "Река Волга");
                dao.insert(river);
                river = new RiverEntity(R.drawable.river_yenisey, "Река Енисей");
                dao.insert(river);
            });
        }
    };
}
