package com.company.ocp.iofundamentals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by bikra on 12/18/2019 10:49 PM.
 */
public class PrintWriterBasics {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //writeWithDirectFileName();
        //writeWithFileWriterAndAppend();
        Files.writeString(Path.of("new.txt"), "Hello this is a test write.");
        System.out.println(Files.readString(Path.of("new.txt")));
        Path p1 = Paths.get("data/dir1");
        Path p2 = Paths.get("dir2/log.txt");
        Path p3 = p1.resolve(p2);
        System.out.println(p3);
        copyFileUsingCopy();




    }

    private static void copyFileUsingCopy() throws IOException{
        try(InputStream is = new FileInputStream(new File("log.txt"));
            OutputStream os = new FileOutputStream(new File("path-to-os/log-copied.txt"));) {

            Files.copy(is, Paths.get("is-to-path/log-copied.txt"));
            Files.copy(Paths.get("log.txt"), os);
        }



    }

    private static void writeWithFileWriterAndAppend() throws IOException{
        try(PrintWriter printWriter = new PrintWriter(new FileWriter("log.txt", true))){
            printWriter.println();
            printWriter.println(51);
            printWriter.println("Hello this is appended text.");
            printWriter.format("There are %d houses.", 300);
            printWriter.println();
            printWriter.write("This is another appended line.");
            printWriter.flush();
        }
    }

    private static void writeWithDirectFileName() throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("log.txt");){
            printWriter.println(5);
            printWriter.println("Hello this is a log file.");
            printWriter.write("This is another line.");
            printWriter.flush();
        }
    }
}
