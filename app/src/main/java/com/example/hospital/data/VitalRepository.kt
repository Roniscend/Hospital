package com.example.hospital.data

import kotlinx.coroutines.flow.Flow

class VitalRepository(private val vitalDao: VitalDao) {

    fun getAllVitals(): Flow<List<VitalEntry>> = vitalDao.getAllVitals()

    suspend fun insertVital(vital: VitalEntry) = vitalDao.insertVital(vital)

    suspend fun updateVital(vital: VitalEntry) = vitalDao.updateVital(vital)

    suspend fun deleteVital(vital: VitalEntry) = vitalDao.deleteVital(vital)

    suspend fun deleteAllVitals() = vitalDao.deleteAllVitals()
}
