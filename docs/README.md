# Duke User Guide

// Update the title above to match the actual product name

// Product screenshot goes here

// Product intro goes here

## Adding deadlines

// Describe the action and its outcome.

// Give examples of usage

Example: `keyword (optional arguments)`

// A description of the expected outcome goes here

```
expected output
```

## Feature ABC

// Feature details


## Feature XYZ

// Feature details


## Convert to .jar file in vscode

Run ``javac -d bin src/main/java/*.java`` to put all compiled .class files into a 'bin' folder.

Create a **manifest.txt** file to indicate the primary file which contains main e.g. ``Main-Class: Sugon``

Run ``jar cfm Sugon.jar manifest.txt -C bin .`` to create new jar, output file name and use manifest.txt file

Run ``java -jar Sugon.jar`` to run the jar file created
