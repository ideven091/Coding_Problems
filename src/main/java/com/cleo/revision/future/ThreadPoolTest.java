package com.cleo.revision.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory");
            String directory = in.nextLine();
            System.out.println("Enter Keyword");
            String keyword = in.nextLine();
            ExecutorService pool = Executors.newFixedThreadPool(20);
            MatchCounter1 counter = new MatchCounter1(new File(directory), keyword,pool);
            Future<Long> result = pool.submit(counter);
            try {
                System.out.println(result.get() + " matching files");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.shutdown();
            var largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("Largest Pool size: " + largestPoolSize);
        }
    }
}
 class MatchCounter1 implements Callable<Long> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private long count;

    public MatchCounter1(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
        //this.count = count;
    }

    public Long call() {
        count = 0;

            try {
                var files = directory.listFiles();
                List<Future<Long>> results = new ArrayList<>();
                for (var file : files) {
                    if (file.isDirectory()) {
                        MatchCounter1 counter = new MatchCounter1(file, keyword, pool);
                        FutureTask<Long> task = new FutureTask<>(counter);
                        results.add(task);

                    } else if (search(file)) count++;

                    for (Future<Long> result : results) {
                        try {
                            count += result.get();
                        } catch (ExecutionException e) {
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


