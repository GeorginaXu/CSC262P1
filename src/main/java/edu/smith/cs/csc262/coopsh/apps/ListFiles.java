package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.io.File;

public class ListFiles extends Task {
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public ListFiles(ShellEnvironment env, String[] args) {
        super(env, args);
    }

    @Override
    protected void update() {
        File path = env.currentDirectory;
        for (String file: path.list()) {
            this.println(file);
        }
        this.closeOutput();
        this.exit(0);
    }
}
