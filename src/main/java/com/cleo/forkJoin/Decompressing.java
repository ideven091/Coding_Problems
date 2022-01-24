package com.cleo.forkJoin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompressing {

    public static void main(String[] args) throws IOException {
        GZIPInputStream inputStream = new GZIPInputStream(new FileInputStream("src/main/resources/objects.inv"));
    }
}
