package com.example.hospital.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "vital_entries")
data class VitalEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val date: Date = Date(),
    val systolicBP: Int? = null,
    val diastolicBP: Int? = null,
    val heartRate: Int? = null,
    val weight: Double? = null,
    val babyKicks: Int? = null,
    val notes: String = ""
)
