package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;
import edu.smith.cs.csc262.coopsh.InputLine;

public class Head extends Task {

    /** The number that is inputted by user. */
    private int numToPrint;

    public Head(ShellEnvironment env, String[] args) {
        super(env, args);
        try {
            this.numToPrint = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
            caughtFatalException("Please input a number!", e);
        }
    }

    @Override
    protected void update() {
        InputLine inputs = this.input.poll();
        if (inputs.isEndOfFile() || numToPrint == 0) {
            this.closeOutput();
            this.exit(0);
            return;
        } else {
            this.println(inputs.get());
            numToPrint --;
        }
    }
}
