package com.cleo.revision.modernJava.ch04;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class PrintFiles extends SimpleFileVisitor<Path> {



    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isSymbolicLink()){
            System.out.printf("File is a symbolic link %s", file);
        }else if(attrs.isRegularFile()){
            System.out.printf("Regular %s", file);
        }else{
            System.out.printf("Other %S", file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.printf("Directory %s", dir);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Path startingDir =Path.of("/Users/admin");
        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        PrintFiles pf = new PrintFiles();
        Files.walkFileTree(startingDir,pf);

    }
}
