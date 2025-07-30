package com.example.hospital.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.hospital.data.PregnancyDatabase
import com.example.hospital.data.VitalEntry
import com.example.hospital.data.VitalRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.*

class PregnancyViewModel(private val repository: VitalRepository) : ViewModel() {

    val vitals: StateFlow<List<VitalEntry>> = repository.getAllVitals()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addVital(
        systolicBP: String,
        diastolicBP: String,
        heartRate: String,
        weight: String,
        babyKicks: String,
        notes: String = ""
    ) {
        viewModelScope.launch {
            val newVital = VitalEntry(
                date = Date(),
                systolicBP = systolicBP.toIntOrNull(),
                diastolicBP = diastolicBP.toIntOrNull(),
                heartRate = heartRate.toIntOrNull(),
                weight = weight.toDoubleOrNull(),
                babyKicks = babyKicks.toIntOrNull(),
                notes = notes
            )
            repository.insertVital(newVital)
        }
    }
    fun deleteVital(vital: VitalEntry) {
        viewModelScope.launch {
            repository.deleteVital(vital)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as android.app.Application
                val database = PregnancyDatabase.getDatabase(application)
                val repository = VitalRepository(database.vitalDao())
                PregnancyViewModel(repository)
            }
        }
    }
}
