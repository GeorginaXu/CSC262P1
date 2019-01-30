package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class Echo extends Task{

    /** User inputs after echo command. */
    private String[] inputs;

    public Echo(ShellEnvironment env, String[] args) {
        super(env, args);
        this.inputs = args;
    }

    @Override
    protected void update(){
        // Convert the array of inputs into string.
        String output = "";
        for (String word : this.inputs) {
            output += word + " ";
        }
        this.println(output);
        this.closeOutput();
        this.exit(0);
        return;
    }
}
