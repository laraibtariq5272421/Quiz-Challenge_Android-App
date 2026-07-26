# Quiz Challenge App

## Objective
A simple Android quiz application built using Java and XML, focused on Pakistan General Knowledge questions. This project was built as part of my hands-on experience with Android app development, with the goal of understanding how activities, intents, and basic UI components work together in a real app flow.

## Overview
This is a multiple-choice quiz app where the user goes through 10 questions one by one, picks an answer, gets instant feedback (green for correct, red for wrong), and finally sees a results screen with their score. Questions are shuffled every time the quiz starts so it doesn't feel repetitive on retakes.

Pakistan GK was picked as the topic instead of generic trivia because it felt more relatable and useful to test on, rather than the usual "capital of France" type questions seen in every tutorial.

## Tech Stack
- Android Studio
- Java
- XML (for layouts)
- Basic Intents to move between screens and pass data (score, total questions)

## Features
- Welcome screen with a Start button
- Question screen with a live counter (Question X of 10) and progress bar
- Radio button based answer selection
- Immediate visual feedback after selecting an answer
- Score tracking in the background as the user progresses
- Final results screen showing correct/incorrect count and total score
- Restart option to attempt the quiz again with reshuffled questions

## How It Works
1. App opens on the Welcome screen.
2. User taps Start, and the quiz begins.
3. Questions load from a hardcoded list (`QuestionBank.java`) and get shuffled.
4. User selects an option — the app checks it against the correct answer and shows color feedback right away.
5. Next button moves to the following question.
6. Once all 10 questions are done, the app moves to the Result screen.
7. Result screen shows the score breakdown and gives the option to restart.

## Project Structure
- `MainActivity.java` – Welcome screen logic
- `QuizActivity.java` – Handles question flow, answer checking, and score
- `ResultActivity.java` – Displays final score and restart option
- `Question.java` – Model class for a single question
- `QuestionBank.java` – Holds all 10 questions and shuffles them

## How to Run
1. Clone or download this repository
2. Open the project in Android Studio
3. Let Gradle sync complete
4. Run the app on an emulator or a physical Android device

## Download APK
You can also directly install the app on your Android device without building it from source:
1. Download the APK file from this repository
2. Enable "Install from Unknown Sources" in your device settings (if not already enabled)
3. Open the downloaded APK file and follow the installation prompts

## Known Limitations / Possible Improvements
Right now the questions are hardcoded directly in the app. Down the line this could be improved by:
- Pulling questions from an API like OpenTriviaDB
- Adding a timer per question
- Saving high scores locally so users can track their best attempt
- Adding more categories to choose from (not just GK)

This was mainly a learning exercise, so the code is kept simple and readable rather than overly optimized.

## Author
Laraib Tariq
