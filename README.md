🩺 Health Tracking App
A comprehensive Android application built with Kotlin and Jetpack Compose to help users track their health vitals with automated reminders and persistent data storage.

📱 Features
Core Functionality
📊 Vitals Tracking: Log blood pressure (systolic/diastolic), heart rate, weight, and movement count

💾 Persistent Storage: All data saved using Room Database for offline access

🔄 Live Updates: Real-time UI updates using StateFlow and Jetpack Compose

📝 Easy Data Entry: Intuitive dialog-based form with input validation

🗑️ Data Management: Delete individual vitals entries with swipe actions

Smart Reminder System

⏰ 5-Hour Reminders: Automated notifications every 5 hours using WorkManager

🔔 Custom Notifications:

Title: "Time to log your vitals!"

Message: "Stay on top of your health. Please update your vitals now!"

🚀 Direct App Access: Clicking notifications opens app directly to logging screen

📱 Background Operation: Reminders work even when app is closed

User Interface
🎨 Modern Material Design 3: Purple-themed, health-friendly interface

📱 Responsive Layout: Optimized for different screen sizes

📋 LazyColumn Display: Smooth scrolling list of vitals history

➕ Floating Action Button: Quick access to add new vitals

🗓️ Date Formatting: Clear timestamp display for each entry

🏗️ Tech Stack
Language: Kotlin

UI Framework: Jetpack Compose

Architecture: MVVM (Model-View-ViewModel)

Database: Room Database with SQLite

Background Tasks: WorkManager

State Management: StateFlow & ViewModel

Notifications: Android Notification API

Build System: Gradle with KSP
![c](https://github.com/user-attachments/assets/1b7082b5-5860-45f0-ac2f-f5628390008d)
![b](https://github.com/user-attachments/assets/d8e88c97-cd2a-4369-97fa-3058e4d2729e)
![a](https://github.com/user-attachments/assets/809ae320-b3cc-4736-8943-e106f564aa58)
![1000101005](https://github.com/user-attachments/assets/82589482-2515-44fe-af7e-ee75928abe77)

