package com.cleo.revision.java_coding_problems.item2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO {

    public static void relativePaths(){
        Path path = Paths.get("/Users/ankster/Java.pdf");
        System.out.println(path);
        Path path1 = Paths.get("/User/ankster","Java.pdf");
        System.out.println(path1);

        Path fileSystem = FileSystems.getDefault().getPath("/Users/ankster/","Java.pdf");
        System.out.println(fileSystem);
    }

    public static void main(String[] args) {
        relativePaths();
    }
}
