package com.cleo.revision.asynchronous;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class AsyncShop {

    private static final Random RANDOM = new Random(0);
    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        this.random = new Random(name.charAt(0)*name.charAt(1)*name.charAt(2));
    }

    public Future<Double> getPrice(String product){
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }
    private double calculatePrice(String product){
        delay();
        if(true){
            throw new RuntimeException("Product not Available");
        }
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));

    }

    public String getName() {
        return name;
    }
    public static void delay() {
        int delay = 1000;
        //int delay = 500 + RANDOM.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {

        return CompletableFuture.supplyAsync(()->futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.<T>toList()));
    }

    public Random getRandom() {
        return random;
    }

    public static double format(double number) {
        synchronized (formatter) {
            return new Double(formatter.format(number));
        }
    }

}
