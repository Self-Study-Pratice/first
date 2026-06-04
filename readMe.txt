Project Name: Java Trigonometry Formula Database

Description:
A terminal-based Java application built to store, search, and manage mathematical formulas. The system is designed to operate without external database dependencies, relying purely on core Java logic and standard File I/O for data persistence.

Current Architecture:
- Formula.java: The data model defining the structure and attributes (ID, expression, type, category, and keyword lists) of a single formula.
- Database.java: The central management class utilizing dynamic ArrayList structures to store and retrieve Formula objects in memory.
- Main.java: The execution entry point containing the Scanner input system and the continuous while-loop routing menu.

Current Development State:
- Data structures and object relationships are established.
- Dynamic storage (ArrayList) and basic iteration (List All) are implemented.
- The interactive terminal menu (Scanner) is fully functional.
- Next integration phase: Implement String manipulation to process user input, clean whitespace, and auto-generate search keywords for the "Add Formula" function.

How to Run:
1. Navigate to the project root directory.
2. Ensure all files are compiled into the appropriate package structure.
3. Execute the main controller via the command line (adjust paths as necessary for your local or production environment): 
   java -cp bin working.Main
