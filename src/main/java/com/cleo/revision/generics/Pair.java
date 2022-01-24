package com.cleo.revision.generics;

public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }


}


class ArrayAlgorithm{

    public static Pair<String> minMax(String[] a){

        if(a==null||a.length==0)
            return null;

        var min = a[0];
        var max = a[0];

        for (int i = 1; i < a.length; i++) {

            if(min.compareTo(a[i])>0)
                min = a[i];
             if(max.compareTo(a[i])<0)
                max = a[i];


        }
        return new Pair<>(min,max);

    }
}

class PairTest{
    public static void main(String[] args) {
        var word = new String[]{"deven","kalra","hello","hi"};
        Pair<String> mm = ArrayAlgorithm.minMax(word);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
    }
}