package com.cleo.revision.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingLongWords {

    public static void main(String[] args) throws IOException {


        String contents = Files.readString(Paths.get("alice.txt"));

        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Stream<String> song = Stream.of("gently", "down","the", "stream");
        System.out.println(List.of(song));
        var list = song.collect(Collectors.toList());
        System.out.println(list);
        long count = 0;

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 4).count();
        System.out.println("Words greater than length 4 are " + count);

    }
}
