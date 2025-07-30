package com.example.hospital.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context

@Database(
    entities = [VitalEntry::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PregnancyDatabase : RoomDatabase() {

    abstract fun vitalDao(): VitalDao

    companion object {
        @Volatile
        private var INSTANCE: PregnancyDatabase? = null

        fun getDatabase(context: Context): PregnancyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PregnancyDatabase::class.java,
                    "pregnancy_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
