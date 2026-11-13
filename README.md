# PULLPADAM – Where the Game Begins ⚽

[![Android Studio](https://img.shields.io/badge/Android%20Studio-2024.2+-brightgreen.svg)](https://developer.android.com/studio)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blue.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-green.svg)](https://developer.android.com/jetpack/compose)
[![API Level](https://img.shields.io/badge/Target%20SDK-37-orange.svg)](https://developer.android.com)

**PULLPADAM** is a modern, premium dark-themed football turf booking, player discovery, and AI-driven matchmaking Android application developed using **Kotlin** and **Jetpack Compose** in Android Studio.

Designed to make football more accessible, organized, and enjoyable for players, teams, and turf owners, PULLPADAM combines turf reservations, squad organization, player recruitment, and intelligent AI features into a single unified mobile platform under the vision: **"PULLPADAM – Where the Game Begins."**

---

## ✨ Key Features & Highlights

### 🏟️ 1. Turf Discovery & Slot Booking System
- **Browse Nearby Turfs**: Discover local synthetic turfs in Kannur, Thana, South Bazar, and Valapattanam.
- **Detailed Venue Information**: Inspect photographs, facilities (Floodlights, Dressing Room, Parking), ratings (4.9 ★), and hourly prices (₹1,000 – ₹1,500/hr).
- **Pitch Format Selectors**: Choose between 5v5, 7v7, and 11v11 pitches.
- **Booking Management**: Confirm reservations, select preferred date/time slots, and track booking history in **My Bookings**.

### 🌟 2. Revolving Neon Light Trail Border
- **PathMeasure Native Animation**: Uses native Jetpack Compose `PathMeasure` on `asAndroidPath()` to calculate the exact rounded rectangle perimeter (`23.dp` corner radius).
- **Revolving Neon Light Beam**: A bright white/neon-green (`#B6FF3B`) light beam continuously travels clockwise around all 4 sides and rounded corners of the **PULLPADAM AI Card** and **AI Recruiter Card**.

### 🤖 3. Universal Floating AI Chatbot Assistant
- **2D Freely Movable FAB Icon**: Draggable neon-green static emblem (`AI ASSISTANT`) that can be placed anywhere on screen.
- **Drag Down to Close**: Dragging the chat window or icon downwards past the gesture threshold automatically dismisses the chatbot.
- **Step-by-Step Guided Search**:
  - **Find Players Wizard**: Guided steps for Position (*Midfielder, Striker, Defender, Goalkeeper, Winger*) $\rightarrow$ Location (*Kannur, Thana, Valapattanam*) $\rightarrow$ Compatibility Style (*Box-to-Box, Counter-Attacker*).
  - **Turf Slots Wizard**: Guided steps for Location $\rightarrow$ Budget Range (*₹1,000–₹1,500*, *₹1,500–₹2,000*, *₹2,000–₹2,500*) $\rightarrow$ Format (*5v5, 7v7, 11v11*).
- **Context-Aware Data Reader**: Reads active turf slots, player databases, and team rosters to answer queries in real time.

### 👥 4. My Team Squad & Availability Organiser
- **Team Roster Manager**: Add squad players with positions and skill levels.
- **Live Availability Toggles**: Interactive `AVAILABLE ✓` / `UNAVAILABLE ✕` status switches for every team member.
- **AI Lineup Generator**: Automatically arranges available players into starting XI lineups and tactical pitch formations (*2-3-1 Tactical Pitch*, *1-2-1 Diamond Pitch*).

---

## 🚀 The 20 AI Features Suite

| # | Feature Domain | Description |
| :-: | :--- | :--- |
| **1** | **AI Player Matching System** | Matches solo players with compatible teams using weighted scoring (96%, 91%). |
| **2** | **AI Team Squad Merging** | Merges incomplete teams (e.g. 3 + 2 players) to complete a full pitch match. |
| **3** | **AI Game Discovery & Matching** | Discovers open local games looking for extra players based on format & time. |
| **4** | **AI Team Formation Assistant** | Auto-balances 10 to 14 players into 2 fair teams with equal skill ratings. |
| **5** | **AI Player Performance Analysis** | Generates stats reports (goals, assists, key passes, tackles, saves, win rate). |
| **6** | **AI Skill Development Coach** | Position-specific training drill programs (Finishing, Jockeying, 360° Ball Control). |
| **7** | **AI Position Recommendation** | Recommends optimal pitch positions based on physical attributes & play style. |
| **8** | **AI Turf Recommendation** | Ranks nearby turfs by user preferences, facilities, and star ratings. |
| **9** | **AI Smart Booking Assistant** | Parses natural language search queries (*"Find a 5-a-side turf near me under ₹1500"*). |
| **10** | **AI Cancellation Replacement** | Instantly finds nearby replacement candidates when a player cancels last minute. |
| **11** | **AI Match Prediction** | Predicts win probabilities and key tactical battles between opposing teams. |
| **12** | **AI Player Chemistry & Synergy** | Evaluates attacking/defensive synergy scores between player pairs. |
| **13** | **AI Football Chatbot Assistant** | Embedded chatbot answering questions about turfs, drills, rules, and match slots. |
| **14** | **AI Schedule Optimisation** | Recommends optimal kickoff time slots considering availability, weather, & costs. |
| **15** | **AI Smart Notifications** | Sends real-time alerts for nearby match vacancies, replacements, and turf deals. |
| **16** | **AI Community Recommendations** | Discovers nearby football clubs, turf alliances, and local tournament groups. |
| **17 & 18** | **AI Video Analysis & Highlights** | Generates video match reports, possession stats, heatmaps, and highlight logs. |
| **19** | **AI Account Trust Verifier** | Calculates account trust scores (e.g., 98% Trust Score) to detect spam/fake profiles. |
| **20** | **AI Tournament Manager** | Generates knockout brackets, fixture schedules, and league standings tables. |

---

## 🛠️ Tech Stack & Architecture

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
- **Architecture Pattern**: MVVM (Model-View-ViewModel) + StateFlow
- **Navigation**: Jetpack Navigation Compose
- **Asynchronous Programming**: Kotlin Coroutines & StateFlow
- **AI Matching Engine**: `LocalMatchEngine.kt` (Offline-first weighted scoring) + Google Gemini API SDK (`generativeai:0.9.0`)
- **JSON Parsing**: Gson (`2.11.0`)
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 37 (Android 15)

---

## 📁 Project Structure

```
com.example.pullpadamwherethegamebegins/
├── data/
│   ├── api/
│   │   ├── LocalMatchEngine.kt    # Deterministic local AI Engine (20 AI features)
│   │   └── GeminiApiService.kt    # Google Gemini Generative AI SDK client
│   ├── model/
│   │   └── AIApiModels.kt         # Data models for matches, squads, turfs, and chat
│   └── repository/
│       └── AIMatchRepository.kt   # Repository bridging ViewModel & AI Engine
├── navigation/
│   ├── AppNavigation.kt          # Main NavHost graph & Floating AI Chatbot Overlay
├── screens/
│   ├── HomeScreen.kt              # Dashboard with revolving neon AI Card & Turfs
│   ├── AIFeaturesHubScreen.kt     # 5-tab 20 AI Features Control Center
│   ├── PullpadamAIScreen.kt       # AI Ecosystem Dashboard & Squad Organiser
│   ├── AIRecruitmentScreen.kt     # AI Recruiter Status Card with revolving border
│   ├── AIGameMatchesScreen.kt     # AI Game Discovery results
│   ├── AIPlayerMatchesScreen.kt   # AI Player recruitment results
│   ├── AITeamMatchesScreen.kt     # AI Team merge recommendations
│   ├── TurfListScreen.kt          # Turf discovery list
│   ├── TurfDetailsScreen.kt       # Venue details, photos, and time slot selector
│   ├── MyBookingsScreen.kt        # Active reservations & booking history
│   ├── ProfileScreen.kt           # Player profile, stats, & recruitment toggle
│   └── LoginScreen.kt             # User authentication screen
└── viewmodel/
    └── AIMatchViewModel.kt        # StateFlow ViewModel managing AI feature states
```

---

## 🚀 Getting Started

### Prerequisites
- **Android Studio** Ladybug (2024.2.1) or higher
- **JDK**: 11 or higher
- **Android SDK**: API 34+

### Installation & Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/abhijithdineshpuliyeri/Pullpadam-Football-App.git
   ```
2. **Open in Android Studio**:
   - Select `File -> Open` and navigate to the cloned project folder.
3. **Sync Gradle**:
   - Wait for Gradle to download dependencies and sync project files.
4. **Run the App**:
   - Connect an Android device (via USB/Wi-Fi) or launch an Android Emulator (API 24+).
   - Press **Run `app`** (`Shift + F10`).

---

## 📄 License

Distributed under the MIT License. See `LICENSE` for details.

---

**PULLPADAM – Where the Game Begins** ⚽
Developed by **Abhijith Dinesh Puliyeri**


