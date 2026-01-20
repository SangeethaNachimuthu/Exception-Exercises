## Exception – Exercises

### Exercise 1: Basic Exception Handling
Write a program that asks the user to input two integers and then divides the first number by the second.
Implement exception handling to manage the scenario where the user inputs zero as the second number.

### Exercise 2: Multiple Exception Types
Create a method that reads an integer from the user and checks whether it is within a certain range (e.g., 1 to 100).

Handle exceptions for: - Invalid input (non-integer input) - Out-of-range values

### Exercise 3: Custom Exception
Define a custom exception InsufficientBalanceException that is thrown when a withdrawal amount exceeds the account balance.

Implement a simple banking system that allows deposits and withdrawals, and handles the custom exception appropriately.

### Exercise 4: Nested try-catch Blocks
Write a program that attempts to read a file and parse its contents as integers.

Implement nested try-catch blocks to handle: - NoSuchFileException - IOException - NumberFormatException

### Exercise 5: finally Block
Modify the program from Exercise 1 to include a finally block that always executes.

### Exercise 6: Throwing Exceptions
Write a method that takes a string as input and checks if it is a valid email address.

If the input is invalid, throw an IllegalArgumentException with an appropriate message.

### Exercise 7: Custom Exceptions for List Operations
Create a program that manages a list of names.

Implement: - A method to find a name in the list
- Throw NameNotFoundException if the name is not found - A method to add a name to the list
- Throw DuplicateNameException if the name already exists

### Exercise 8: Try-with-Resources
Create a Java application that writes a string of text to a file.

Use the try-with-resources statement to ensure resources are automatically closed after the operation is complete.