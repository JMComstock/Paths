package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        // Path within the working directory in a subdirectory names files.
        Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
        printFile(filePath);
        // Absolute path to OutThere.txt which is outside of the Paths directory altogether.
        filePath = Paths.get("C:\\Users\\jmcom\\Desktop\\java\\OutThere.txt");
        printFile(filePath);
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
