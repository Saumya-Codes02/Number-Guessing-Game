# 🎮 Number Guessing Game

A console-based Number Guessing Game built in **Java** using **Object-Oriented Programming (OOP)** and **Maven**.

This project was built as part of my Java Backend Development journey to practice clean code, project architecture, exception handling, and package organization.

---

## 📸 Preview

```text
========== Game Started ==========

Choose Difficulty

1. Easy (1 - 10)
2. Medium (1 - 100)
3. Hard (1 - 1000)

Choice: 1

Enter Guess: 5
⬆ Too Low!

Enter Guess: 8
🎉 Congratulations!
Attempts Used: 2
```

---

# ✨ Features

- 🎯 Three difficulty levels
  - Easy (1–10)
  - Medium (1–100)
  - Hard (1–1000)

- 🎲 Random number generation
- ✅ Input validation
- ⚠️ Custom exception handling
- 🔁 Play Again option
- 📊 Game statistics
  - Games Played
  - Games Won
  - Games Lost
  - Best Score
  - Average Attempts
  - Win Rate

---

# 🏗️ Project Structure

```text
src
└── main
    └── java
        └── com
            └── saumya
                └── guessinggame
                    │
                    ├── Main.java
                    │
                    ├── exception
                    │     └── InvalidInputException.java
                    │
                    ├── game
                    │     ├── Difficulty.java
                    │     ├── Game.java
                    │     └── GameStats.java
                    │
                    ├── service
                    │     └── GameService.java
                    │
                    └── util
                          └── InputHelper.java
```

---

# 🧠 Concepts Practiced

- Object-Oriented Programming (OOP)
- Enums
- Classes & Objects
- Exception Handling
- Package Organization
- Separation of Concerns
- Maven Project Structure
- Java Collections (planned)
- Clean Code Principles

---

# 🛠️ Technologies Used

- Java
- Maven
- IntelliJ IDEA
- Git
- GitHub

---

# ▶️ Running the Project

### Clone the repository

```bash
git clone https://github.com/Saumya-Codes02/number-guessing-game.git
```

### Navigate to the project

```bash
cd number-guessing-game
```

### Run

Using IntelliJ IDEA:

- Open the project
- Run `Main.java`

or using Maven:

```bash
mvn compile
mvn exec:java
```

---

# 🚀 Future Improvements

- Save high scores to a file
- Unit testing with JUnit
- Better console UI
- Guess history
- Hint system
- Spring Boot REST API version
- Docker support

---

# 📚 What I Learned

While building this project, I practiced:

- Designing applications using OOP
- Creating reusable utility classes
- Working with enums
- Custom exception handling
- Organizing Java projects using Maven
- Separating business logic from utility code

---

## 👨‍💻 Author

**Saumya Shukla**

GitHub: https://github.com/Saumya-Codes02

---

⭐ If you found this project useful or interesting, consider giving it a star!
