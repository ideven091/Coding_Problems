package com.cleo.revision.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter base directory");
            String directory = in.nextLine();
            System.out.println("Enter Keyword");
            String keyword = in.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory), keyword);
            FutureTask<Long> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();
            try{
                System.out.println(task.get() +  " matching files");
            }catch (ExecutionException e){
                e.printStackTrace();
            }


        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MatchCounter implements Callable<Long>{

    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Long call() throws Exception {
        long count = 0;
        try{
            var files = directory.listFiles();
            List<Future<Long>> results = new ArrayList<>();

            for(var file: files){
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword);
                    FutureTask<Long> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }else{
                    if(search(file)) count++;
                }
                for(Future<Long> result: results){
                    try{
                        count+=result.get();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }
    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword))
                        found = true;
                }
                return found;
            }
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
