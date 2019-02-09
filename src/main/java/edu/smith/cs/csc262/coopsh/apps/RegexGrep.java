package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.util.regex.Pattern;

public class RegexGrep extends Task {
    /** Regex to grep inputted by the user. */
    private Pattern regex;

    /** The constructor compiles the user input regex into a pattern. */
    public RegexGrep(ShellEnvironment env, String[] args) {
        super(env, args);
        this.regex = Pattern.compile(args[0]);
    }

    @Override
    protected void update(){
        InputLine inputs = this.input.poll();
        // If the end of file is reached, close the file and output.
        if (inputs.isEndOfFile()) {
            this.closeOutput();
            this.exit(0);
            return;
        } else {
            // If regex is found in the current line, print it out.
            if(regex.matcher(inputs.get()).find()) {
                this.println(inputs.get());
            }
        }

    }
}
