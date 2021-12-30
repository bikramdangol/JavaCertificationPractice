package com.company.ocp.iofundamentals;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/18/2019 12:29 PM.
 */
public class IOBasics {
    public static void main(String[] args) throws IOException{
        doIOBasics();
        fileCopyUsingFileReader();
    }

    private static void fileCopyUsingFileReader() throws IOException{
        File source = new File("C:\\etc\\data\\zoo.txt");
        File destination = new File("C:\\etc\\data\\zooCopy.txt");
        try(InputStream in = new FileInputStream(source)){
            int b;
            byte[] buffer = new byte[100];
            while ((b = in.read(buffer)) != -1) {
                System.out.print(Arrays.toString(buffer));
                //Arrays.stream(buffer, 0, 5).sum();
                //System.out.println((char) b);
            }
        }

        List<String> data = readFile(source);
        for(String record: data) {
            System.out.println(record);
        }
        writeFile(data, destination);
    }

    private static void writeFile(List<String> data, File destination) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String s: data) {
                writer.write(s);
            }
        }
    }

    private static List<String> readFile(File source) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))){ // it takes String source path as well.
            String s;
            while((s = reader.readLine()) != null) {
                data.add(s);
            }
        }
        return data;
    }

    private static void doIOBasics() {

        System.out.println("File Seperator String: ");
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        File fileWithRelativePath = new File("log.txt");
        System.out.println(fileWithRelativePath.separatorChar);

        System.out.println();
        if (fileWithRelativePath.exists()) {
            System.out.println("Absolute path of the file is: " + fileWithRelativePath.getAbsolutePath());
        }

        File file = new File("C:\\etc\\data\\zoo.txt");
        //File file = new File("C:\\etc\\data");
        System.out.println("File Exists: " + file.exists());
        System.out.println();
        if(file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            System.out.println();
            if(file.isFile()) {
                System.out.println("File getName: " + file.getName());
                System.out.println("File size: " + file.length());
                System.out.println("File lastModified: " + file.lastModified());
            } else {
                System.out.println("Current dir: " + file.getName());
                System.out.println("Files in the current directory are:");
                for (File subfile: file.listFiles()) {
                    System.out.println("\t\tname\t\t" + subfile.getName());
                    System.out.println("\tabsolutePath\t" + subfile.getAbsolutePath());
                }
            }
        }
    }
}
