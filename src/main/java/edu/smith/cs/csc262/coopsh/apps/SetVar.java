package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class SetVar extends Task {

    private ShellEnvironment env;
    private String[] inputs;

    public SetVar(ShellEnvironment env, String[] args) {
        super(env, args);
        this.inputs = args;
        this.env = env;
    }

    @Override
    protected void update(){
        try {
            env.setVariable(inputs[0], inputs[1]);
        } catch (IndexOutOfBoundsException e) {
            caughtFatalException("Please input two arguments!", e);
        }
        this.closeOutput();
        this.exit(0);
    }
}
