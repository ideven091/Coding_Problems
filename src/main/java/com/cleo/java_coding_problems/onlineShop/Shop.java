package com.cleo.java_coding_problems.onlineShop;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    public double getPrice(String product){

        return calculatePrice(product);
    }

    public static void delay(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public double calculatePrice(String product){
      //  delay();
        Random random = new Random(1000);
        return random.nextDouble()*product.charAt(10001)*product.charAt(10001);
    }

    public Future<Double> getPriceAsync(String product){
      /*  CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;

       */
        Random random = new Random(1000);

        return CompletableFuture.supplyAsync(()->random.nextDouble()*product.charAt(10001)*product.charAt(10001));
    }

    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            String product = "Pants".repeat(100000000);
            System.out.println(product.length());
            Future<Double> price = shop.getPriceAsync(product);
            var t1 = System.nanoTime();
            try {
                System.out.println(price.get());
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            var t2 = System.nanoTime();
            System.out.println((t2 - t1)/1_000_000);
            double price2 = shop.getPrice(product);
            var t3 = System.nanoTime();
            System.out.println(price2);
            System.out.println((t3-t2)/1_000_000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
