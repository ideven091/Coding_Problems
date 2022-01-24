package com.cleo.revision.streams;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * This program computes CRC checksum of a file in 4 ways<br>
 *     Usage: java streams.MemoryMapTest fileName
 * @version 1.01 2021-24-03
 * @author Deven Kalra
 */

public class MemoryMapTest {

    public static long checkInputStream(Path fileName) throws IOException{
        try(InputStream in = Files.newInputStream(fileName)) {
            CRC32 crc = new CRC32();
            int c;
            while((c=in.read())!=-1){
                crc.update(c);

            }
            return crc.getValue();
        }
    }

    public static long checkBufferedInputStream(Path fileName) throws IOException{

        try(InputStream in = new BufferedInputStream(Files.newInputStream(fileName))){
            CRC32 crc = new CRC32();
            int c;
            while((c=in.read())!=-1){
                crc.update(c);

            }//Tired and sleepy, How to design a VPN? A URL shortener..?? Ip to Same domain name..??
            return crc.getValue();
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Input Stream:");
        long start = System.currentTimeMillis();

        Path fileName = Paths.get(args[0]);

        long crcValue = checkInputStream(fileName);

        long end = System.currentTimeMillis();

        System.out.println(Long.toHexString(crcValue));
        System.out.println((end -start) + " milliseconds");
    }
}
