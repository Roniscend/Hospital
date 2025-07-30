package com.example.hospital.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.hospital.ui.theme.PurplePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (String, String, String, String, String) -> Unit
) {
    var systolicBP by remember { mutableStateOf("") }
    var diastolicBP by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var babyKicks by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add Vitals",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = systolicBP,
                        onValueChange = { systolicBP = it },
                        label = { Text("Systolic BP") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurplePrimary,
                            focusedLabelColor = PurplePrimary
                        )
                    )

                    OutlinedTextField(
                        value = diastolicBP,
                        onValueChange = { diastolicBP = it },
                        label = { Text("Diastolic BP") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurplePrimary,
                            focusedLabelColor = PurplePrimary
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = heartRate,
                    onValueChange = { heartRate = it },
                    label = { Text("Heart Rate (bpm)") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PurplePrimary,
                        focusedLabelColor = PurplePrimary
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight (kg)") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PurplePrimary,
                        focusedLabelColor = PurplePrimary
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = babyKicks,
                    onValueChange = { babyKicks = it },
                    label = { Text("Baby Kicks Count") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PurplePrimary,
                        focusedLabelColor = PurplePrimary
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        onSubmit(systolicBP, diastolicBP, heartRate, weight, babyKicks)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PurplePrimary
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Cancel",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
