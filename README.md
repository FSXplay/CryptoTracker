# CryptoTracker

CryptoTracker is an Android app built with **Jetpack Compose** and **Material Design 3** that displays live cryptocurrency prices fetched from the CoinGecko API.

---

## Core Features

- **Live cryptocurrency price list**
  - Fetches **top 10 coin market data** from *CoinGecko*
  - Displays each coin with name and formatted price plus selected currency
- **Currency selection**
  - Settings screen lets users switch between `USD`, `EUR`, `AUD`, and `SGD`
  - Changing currency reloads the live price data automatically
- **Modern Compose UI**
  - Bottom navigation with `Home` and `Settings`
  - Card-based coin layout for a polished mobile experience
- **ViewModel-driven state**
  - Uses `CryptoViewModel` to manage loading state, selected currency, and coin data

---

## Implementation Overview

### `MainActivity.kt`
- Hosts the main Compose UI and app navigation
- Uses `Scaffold` with a top app bar and bottom navigation bar
- Switches between the home screen and settings screen
- Passes the shared `CryptoViewModel` into both screens

### `CryptoViewModel.kt`
- Stores current state in Compose-friendly `mutableStateOf` variables
- Keeps track of:
  - `coins` — current list of `CoinPrice`
  - `currency` — selected currency code
  - `isLoading` — whether data is being fetched
- Loads coin data on initialization and whenever the currency changes
- Uses `viewModelScope.launch` for asynchronous network calls

### `CryptoRepository.kt`
- Implements the data layer using Retrofit
- Defines a `CoinGeckoApi` interface for the `/coins/markets` endpoint
- Fetches the top 10 coins for the selected currency

### `CoinPrice.kt`
- Data model for parsed API responses
- Maps JSON fields to Kotlin properties using `@SerializedName`

### `CoinCard.kt`
- Reusable composable for each cryptocurrency item
- Displays coin name and formatted price with selected currency
- Styled as a rounded card with clear visual hierarchy

---

## Screens

### Home Screen
- Shows a header card with the active currency
- Displays a loading indicator while fetching data
- Renders each coin in a styled `CoinCard`
- Uses `LazyColumn` for performant vertical scrolling

### Settings Screen
- Shows the currently selected currency
- Offers currency option buttons for quick switching
- Updates the app theme colors and data immediately after selection

---

## How to Run

1. Open the project in Android Studio
2. Sync Gradle dependencies
3. Run the app on an emulator or physical device
4. Recommended API level: **26+**

---

## File Structure

- `app/src/main/java/.../MainActivity.kt` — app entry point and screen navigation
- `app/src/main/java/.../ui/home_view/CryptoViewModel.kt` — state and data loading
- `app/src/main/java/.../data/CryptoRepository.kt` — Retrofit data layer
- `app/src/main/java/.../data/CoinPrice.kt` — API response model
- `app/src/main/java/.../ui/home_view/composables/CoinCard.kt` — coin item UI
- `app/src/main/java/.../ui/theme/Theme.kt` — app theming and colors

---

## Notes

- The app uses the demo *CoinGecko API* and does not require an API key.