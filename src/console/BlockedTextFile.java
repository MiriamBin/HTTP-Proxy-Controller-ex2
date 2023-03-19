package console;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.FileWriter;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.Scanner;

import java.io.*;
import java.util.Scanner;

public class BlockedTextFile {
    static final String FILENAME = "blocked.txt";
    static File file = null;
    BufferedWriter writer;
    BufferedReader reader;

    public BlockedTextFile() throws IOException {
        file = new File(FILENAME);
        if (!file.exists()) {
            file.createNewFile();
        }

        writer = new BufferedWriter(new FileWriter(FILENAME, true));
        reader = new BufferedReader(new FileReader(FILENAME));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
        writer.flush();
    }

//    public void eraseLine(String lineToRemove) throws IOException {
//        String currentLine;
//        StringBuffer buffer = new StringBuffer();
//
//        while ((currentLine = reader.readLine()) != null) {
//            if (currentLine.equalsIgnoreCase(lineToRemove)) {
//                continue;
//            }
//            buffer.append(currentLine);
//            buffer.append(System.lineSeparator());
//        }
//
//        // Write the updated contents back to the file
//        writer = new BufferedWriter(new FileWriter(FILENAME));
//        writer.write(buffer.toString());
//        writer.flush();
//    }

    public void close() throws IOException {
        writer.close();
        reader.close();
    }
}

