package com.example.hospital.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalDao {
    @Query("SELECT * FROM vital_entries ORDER BY date DESC")
    fun getAllVitals(): Flow<List<VitalEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVital(vital: VitalEntry)

    @Update
    suspend fun updateVital(vital: VitalEntry)

    @Delete
    suspend fun deleteVital(vital: VitalEntry)

    @Query("DELETE FROM vital_entries")
    suspend fun deleteAllVitals()
}
