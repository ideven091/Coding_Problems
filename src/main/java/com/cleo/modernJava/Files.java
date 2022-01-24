package com.cleo.modernJava;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public class Files {

    public static void main(String[] args) {
        File[] files = new File("../").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        assert files!=null;
        System.out.println(List.of(files));

        System.out.println();
        var file = new File(".").listFiles(File::isHidden);
        if(file!=null)
            System.out.println(List.of(file));
    }
}
