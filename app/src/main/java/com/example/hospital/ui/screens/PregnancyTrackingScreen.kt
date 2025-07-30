package com.example.hospital.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hospital.ui.components.AddVitalsDialog
import com.example.hospital.ui.components.VitalEntryCard
import com.example.hospital.ui.theme.PurplePrimary
import com.example.hospital.viewmodel.PregnancyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PregnancyTrackingScreen(
    openAddVitalsDialog: Boolean = false,
    viewModel: PregnancyViewModel = viewModel(factory = PregnancyViewModel.Factory)
) {
    val vitals by viewModel.vitals.collectAsState()
    var showAddDialog by remember { mutableStateOf(openAddVitalsDialog) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Track My Pregnancy",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
            if (vitals.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "No vitals recorded yet",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Tap + to add your first entry",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(vitals) { vital ->
                        VitalEntryCard(
                            vital = vital,
                            onDeleteClick = { viewModel.deleteVital(vital) }
                        )
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { showAddDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = PurplePrimary,
            contentColor = Color.White,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Vitals"
            )
        }
        if (showAddDialog) {
            AddVitalsDialog(
                onDismiss = { showAddDialog = false },
                onSubmit = { systolic, diastolic, heartRate, weight, babyKicks ->
                    viewModel.addVital(systolic, diastolic, heartRate, weight, babyKicks)
                    showAddDialog = false
                }
            )
        }
    }
}
