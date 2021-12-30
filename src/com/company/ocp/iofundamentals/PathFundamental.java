package com.company.ocp.iofundamentals;

import java.io.BufferedReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by bikra on 12/24/2019 8:07 PM.
 */
public class PathFundamental {
    public static void main(String[] args) {
        Path path1 = Paths.get("a/b/../c/.././log.txt");
        Path path2 = Paths.get("log.txt"); // this path doesn't have parent.
        Path path3 = Paths.get("data", "log.txt");
        Path path4 = FileSystems.getDefault().getPath("data", "log.txt");
        System.out.println(path4); // data\log.txt

        Path newWayPath = Path.of("log.txt");
        System.out.println("New Path: " + newWayPath);

        System.out.println(path2.normalize().toAbsolutePath());
        // throws exception if there is no parent.
        //System.out.println(path2.getParent().normalize().toAbsolutePath());
        System.out.println(path2.getParent()); // returns path object of null as there is no parent.
        System.out.println(path1.getParent().normalize().toAbsolutePath());
        // prepends home directory path
        System.out.println(path1.getParent().getParent().getParent().normalize().toAbsolutePath());

        //
        Path absolutePath = Paths.get("/data/log.txt");
        System.out.println("File name: " + absolutePath.getFileName());
        System.out.println("getName zero index on may be absolute path: " + absolutePath.getName(0));
        Path absolutePath1 = Paths.get("C:\\data\\log.txt");
        System.out.println("getName zero index on may be absolute path windows: " + absolutePath1.getName(0));
        System.out.println(absolutePath.toAbsolutePath());
        System.out.println(path3.getRoot());
        Path subPath = absolutePath.subpath(0,1);
        System.out.println("Sub Path: " + subPath);
        System.out.println("Sub Path: " + absolutePath.toAbsolutePath().subpath(0, 1));
        System.out.println("Relative path: " + path1.relativize(path2));
        System.out.println("Relative path: " + path2.relativize(path1));
        System.out.println("Relative path normalized: " + path2.relativize(path1).normalize());
        //System.out.println(absolutePath.relativize(path1));
        System.out.println("Resolve path: manual: " + path2.resolve("bikram/resume.txt"));


        absolutePath.getFileName();// returns path;
        try(BufferedReader reader = Files.newBufferedReader(path2)){
            String currentLine = null;
            while((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (Exception e) {

        }

        relativizeWithAbsolutePaths();

        // Files.list(Paths.get(".")); // throws IOException. Need to handle.

    }

    private static void relativizeWithAbsolutePaths() {
        Path absPath1 = Paths.get("C:\\a\\log.txt");
        Path absPath2 = Paths.get("C:\\b\\note.txt");
        System.out.println("relativize: " + absPath1.relativize(absPath2)); // ..\..\b\note.txt
        System.out.println("resolve: " + absPath1.resolve(absPath2)); // ..\..\b\note.txt

        Path absPath3 = Paths.get("/a/log.txt");
        Path absPath4 = Paths.get("/b/note.txt");
        System.out.println("relativize: " + absPath3.relativize(absPath4)); // ..\..\b\note.txt

    }
}
