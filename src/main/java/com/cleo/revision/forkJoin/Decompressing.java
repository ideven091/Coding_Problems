package com.cleo.revision.forkJoin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressing {

    public static void main(String[] args) throws IOException {
        GZIPInputStream inputStream = new GZIPInputStream(new FileInputStream("src/main/resources/objects.inv"));
    }
}
