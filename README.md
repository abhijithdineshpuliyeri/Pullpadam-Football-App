# PULLPADAM – Where the Game Begins ⚽

[![Android Studio](https://img.shields.io/badge/Android%20Studio-2024.2+-brightgreen.svg)](https://developer.android.com/studio)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blue.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-green.svg)](https://developer.android.com/jetpack/compose)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-37-orange.svg)](https://developer.android.com)

**PULLPADAM** is a modern, premium dark-themed football turf booking, player discovery, and AI-driven matchmaking Android application developed using **Kotlin** and **Jetpack Compose** in Android Studio.

Designed to make football more accessible, organized, and enjoyable for players, teams, and turf owners, PULLPADAM combines turf reservations, squad organization, player recruitment, and intelligent AI features into a single unified mobile platform under the vision: **"PULLPADAM – Where the Game Begins."**

---

## 📱 Application Screenshots & User Interface Showcase

| 1. Welcome & Branding | 2. Home Dashboard & Revolving AI Card | 3. Turf Discovery & Slot Selection | 4. AI Matchmakers Suite |
| :-: | :-: | :-: | :-: |
| *Splash Screen & Official Logo* | *Main AI Card with Revolving Light Beam* | *Nearby Turfs, Facilities & Slots* | *Compatibility Scoring (96% Match)* |

| 5. AI Recruiter & Squad Organiser | 6. Universal Floating AI Chatbot | 7. Booking Confirmation | 8. Player Profile & Stats |
| :-: | :-: | :-: | :-: |
| *Status Card & Live Availability* | *Guided Step-by-Step Search Chips* | *Confirmed Reservation Receipt* | *Player Appearances, Goals & Win Rate* |

---

## 🎥 Commercial Advertisements & AI Video Blueprint (60 Seconds)

PULLPADAM includes a complete 60-second production video trailer divided into 6 precise 10-second scenes for promotional launch campaigns:

### 🎬 60-Second Video Script & Scene Breakdown

- **Scene 1 (0:00 - 0:10) – Brand Reveal & App Launch**:
  - *Visual*: Dark stadium floodlights turning on. Sleek smartphone floating in 3D displaying the glowing neon-green PULLPADAM logo.
  - *Voiceover*: *"Welcome to PULLPADAM — the ultimate football community platform for players, teams, and turf owners. Stop searching for players manually. Experience modern turf booking and AI-driven matchmaking in one single mobile app. Where the game begins."*

- **Scene 2 (0:10 - 0:20) – Home Dashboard & Revolving AI Card**:
  - *Visual*: Camera pans over the Home Screen. The main PULLPADAM AI Card has a vivid neon-green/white light continuously revolving around its border.
  - *Voiceover*: *"Explore nearby football turfs, inspect venue amenities, prices, and available time slots. With our revolving AI engine card, discover personalized game recommendations crafted specifically for your playing style."*

- **Scene 3 (0:20 - 0:30) – AI Matchmaking Suite**:
  - *Visual*: Dynamic split screen of Find Game, Find Team, and Find Player showing match compatibility scores (96%, 92%, 88%).
  - *Voiceover*: *"Playing alone? Find an open match looking for a player like you. Short on numbers? Connect with another incomplete team and merge your squads. Need a defender or striker? Recruit local players matched by position, location, and skill level."*

- **Scene 4 (0:30 - 0:40) – AI Recruiter & Squad Organiser**:
  - *Visual*: Showcase of the AI Recruiter status card with revolving light trail, toggling live player availability (`AVAILABLE ✓`), and starting XI lineup.
  - *Voiceover*: *"Manage your team roster effortlessly. Toggle live player availability with a single tap, and let our AI Squad Assistant automatically divide your available roster into fair, balanced starting lineups."*

- **Scene 5 (0:40 - 0:50) – Universal Floating AI Chatbot**:
  - *Visual*: User drags the neon-green floating AI Assistant icon. The open chat window answers live questions about available slots in Kannur and Thana.
  - *Voiceover*: *"Have questions? Drag and talk to our Universal AI Assistant from anywhere in the app. Ask about open evening slots, search defenders in your area, or request custom budget filters from ₹1,000 to ₹1,500."*

- **Scene 6 (0:50 - 1:00) – Turf Booking & Grand Outro**:
  - *Visual*: Montage of reservation confirmation, player stats report, and players celebrating on a synthetic pitch under night floodlights. Final logo text: **PULLPADAM – Where the Game Begins**.
  - *Voiceover*: *"Lock your turf slot instantly, track your match appearances, goals, and win rates, and elevate your football experience. PULLPADAM — Where the Game Begins. Download the app today on Google Play!"*

---

## 📄 Product Specifications & Documentation (PDF Specification)

The technical architecture and AI engine design of PULLPADAM are fully documented in our technical specifications:

- **Local Deterministic AI Engine (`LocalMatchEngine.kt`)**: Weighted scoring algorithms operating offline for compatibility calculations ($S_{\text{overall}} = 0.4 S_{\text{pos}} + 0.3 S_{\text{dist}} + 0.2 S_{\text{skill}} + 0.1 S_{\text{avail}}$).
- **Google Gemini Generative AI SDK (`GeminiApiService.kt`)**: Fallback integration using `gemini-1.5-flash` with structured JSON response parsing.
- **Native Render Graphics**: Custom Jetpack Compose `PathMeasure` revolving border modifier (`aiRecruiterGlowingBorder` & `revolvingNeonBorderForAiCard`).

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


