package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;
import edu.smith.cs.csc262.coopsh.InputLine;

public class Tail extends Task {

    /** The number of elements to print out inputted by user. */
    private int numToPrint;

    /** Array that stores all elements that will get printed out. */
    private String[] elementsToPrint;

    public Tail(ShellEnvironment env, String[] args) {
        super(env, args);
        try {
            numToPrint = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
            caughtFatalException("Please input a number!", e);
        }
        // Make the size of the array to be numToPrint.
        elementsToPrint = new String[numToPrint];
    }

    @Override
    protected void update(){
        InputLine inputs = this.input.poll();
        if (inputs.isEndOfFile()) {
            // If reached the end of file, print out every non-null element in the array.
            for (String str : elementsToPrint) {
                if (str != null) {
                    this.println(str);
                }
            }
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Shift all elements in the array to the left side by one.
        // Ensure that the array contains only the last numToPrint elements.
        for (int i = 0; i < numToPrint-1; i ++) {
            elementsToPrint[i] = elementsToPrint[i + 1];
        }
        // Let the last element of the array to be the most recently read input.
        elementsToPrint[numToPrint-1] = inputs.get();
    }
}

