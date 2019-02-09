package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;
import edu.smith.cs.csc262.coopsh.InputLine;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Sort extends Task {

    /** List that will store all inputs individually, which makes it easier to sort. */
    private List<String> inputs = new ArrayList<>();

    public Sort(ShellEnvironment env, String[] args) {
        super(env, args);
    }

    @Override
    protected void update() {
        InputLine current = this.input.poll();
        if (current.isEndOfFile()) {
            // Sort all inputs.
            Collections.sort(inputs);
            for (String str : inputs) {
                this.println(str);
            }
            this.closeOutput();
            this.exit(0);
            return;
        }
        // if not end of file, add the input into the List.
        inputs.add(current.get());
    }
}
