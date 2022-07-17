# Truth-Table-Gen-Swing
This is a truth table generator built with Java and the Swing package to make a desktop GUI, which takes in a propositional logic formula, generates all combinations of true/false for the formula, and then displays the results of these combinations in a table.

Originally, I was using Java Swing to display the GUI, as this was a desktop application.  However, because Swing is deprecated and this works better as accessed in a web browser, the current target is migrating over to Java Spring.

Most of the logic has been created.  Right now, the program can evaluate a propositional logic formula given explicit true and false values (e.g. something of the form true /\ false, which would return false), count how many variables are in a given formula, and generate all 2^n combinations of true and false for those n variables.  However, it does not yet evaluate those combinations or display them in a truth table.  Furthermore, because I am moving away from using Swing, the program takes input directly via the console, and the GUI doesn't do anything.
