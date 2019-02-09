package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.io.*;

/**
 * Implementation of bash command "grep"
 * It finds lines in the input file with an argument string on them.
 **/
public class SimpleGrep extends Task {

    /** BufferedReader to help read the input file. */
    private BufferedReader current = null;
    /** Word to grep inputted by the user. */
    private String wordToFind;

    /** The constructor reads the input file and stores the word to find. */
    public SimpleGrep(ShellEnvironment env, String[] args) {
        super(env, args);
        if (args.length < 2) {
            System.err.println("grep command takes at least two arguments.");
        }
        this.wordToFind = args[0];
        File input = env.makeFile(args[1]);
        try {
            this.current = new BufferedReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            caughtFatalException("Cannot open file.", e);
        }
    }

    @Override
    protected void update(){
        String nextLine;
        try {
            nextLine = this.current.readLine();
        } catch (IOException e) {
            caughtFatalException("Reading File Error.", e);
            return;
        }

        // If the end of file is reached, close the file and output.
        if (nextLine == null) {
            this.closeOutput();
            this.exit(0);
            try {
                this.current.close();
            } catch (IOException e) {
                caughtFatalException("Cannot Close File.", e);
                return;
            }
            this.current = null;
        } else {
            // If wordToFind is found in the current line, print it out.
            if(nextLine.contains(wordToFind)) {
                this.println(nextLine);
            }
        }

    }
}
