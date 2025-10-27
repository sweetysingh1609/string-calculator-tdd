# String Calculator TDD

A **Spring Boot-based String Calculator** project built using **Test-Driven Development (TDD)** principles.  
It takes an input string of numbers separated by delimiters and returns their sum — following progressive implementation stages with test coverage.

---

## 🧩 Features Implemented

### ✅ 1. Basic Requirements
- Handles empty string → returns 0  
- Handles one or more numbers separated by commas  
  Example: `"1,2,3"` → **6**

### ✅ 2. New Line as Delimiter
- Supports both commas `,` and new lines `\n` as delimiters.  
  Example: `"1\n2,3"` → **6**

### ✅ 3. Custom Delimiters
- Custom delimiter syntax supported using prefix `//`  
  Example: `"//;\n1;2"` → **3**  
- Throws exception for invalid format (e.g., missing delimiter line).

### ✅ 4. Negative Number Handling
- Throws exception with a list of negative numbers.  
  Example: `"1,-2,-3"` → **Exception: negative numbers not allowed [-2, -3]**

### ✅ 5. UI Layer
- A simple **Spring Boot Web UI** for testing inputs dynamically.  
  You can enter numbers or use custom delimiters in the browser.

---
### Screenshot of UI:

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/47c8563e-6a34-4463-bb9c-55b75247e340" />


## 🚀 How to Run the Project

### Prerequisites
- Java 17+ installed  
- Maven installed  
- Git installed

### Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/sweetysingh1609/string-calculator-tdd.git
   cd string-calculator-tdd
   ```

2. **Run the Spring Boot Application**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the UI**
   Open browser and go to:  
   👉 [http://localhost:8080](http://localhost:8080)

   Enter input strings like:
   - `1,2,3`
   - `1\n2,3`
   - `//;\n1;2`
   - `1,-3,4` (to see error handling)

---

## 🧪 Running Tests

To execute all test cases (unit tests for `StringCalculator`):

```bash
mvn test
```

This runs all **JUnit** test cases verifying:
- Empty inputs  
- Comma and newline handling  
- Custom delimiters  
- Negative number validation

---

## 🗂️ Project Structure

```
string-calculator-tdd/
│
├── src/main/java/com/example/stringcalculator/
│   ├── controller/
│   │   └── CalculatorController.java       # UI Controller
│   ├── service/
│   │   └── StringCalculator.java           # Core calculator logic
│   └── StringCalculatorApplication.java    # Spring Boot entry point
│
├── src/test/java/com/example/stringcalculator/
│   └── StringCalculatorTest.java           # JUnit test cases
│
├── src/main/resources/templates/
│   └── index.html                          # Frontend UI for calculator
│
└── README.md
```

---

## 💡 Example Inputs & Outputs

| Input | Output | Description |
|-------|---------|-------------|
| `""` | `0` | Empty string |
| `"1"` | `1` | Single number |
| `"1,2,3"` | `6` | Multiple numbers |
| `"1\n2,3"` | `6` | Newline support |
| `"//;\n1;2"` | `3` | Custom delimiter |
| `"1,-2,-3"` | Exception | Negative numbers not allowed |

---

---

## 🧑‍💻 Author
**Sweety Singh**  
A passionate software engineer exploring backend, frontend, and AI-driven solutions.  
📍 GitHub: [sweetysingh1609](https://github.com/sweetysingh1609)
