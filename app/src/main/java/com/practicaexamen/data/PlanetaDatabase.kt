package com.practicaexamen.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practicaexamen.model.Planeta

@Database(entities=[Planeta::class], version = 1, exportSchema = false)
abstract class PlanetaDatabase : RoomDatabase() {
    abstract fun planetaDao() : PlanetaDao

    companion object{
        @Volatile
        private var INSTANCE: PlanetaDatabase? = null

        fun getDatabase(context: android.content.Context) : PlanetaDatabase {
            var instance = INSTANCE
            if(instance != null) {
                return instance
            }
            synchronized(this){
                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    PlanetaDatabase::class.java,
                    "planeta_database"
                ).build()
                INSTANCE= basedatos
                return basedatos
            }
        }
    }
}