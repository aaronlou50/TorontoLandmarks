package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database




import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// If you have migrations, import androidx.room.migration.Migration and androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [LandmarkEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun landmarkDao(): LandmarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null




        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "landmark_database")
                    .createFromAsset("database/landmark.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}

