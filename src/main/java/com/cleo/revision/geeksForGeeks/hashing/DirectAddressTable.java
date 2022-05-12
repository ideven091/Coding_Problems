package com.cleo.revision.geeksForGeeks.hashing;

public class DirectAddressTable {

    private static final int[] array = new int[1000];
    public void insert(int element){
        array[element] = 1;
    }

    public boolean search(int element){
        return array[element] == 1;
    }
    public void delete(int element){
        array[element] = 0;
    }

    public static void main(String[] args) {

        DirectAddressTable dat = new DirectAddressTable();
        dat.insert(119);
        dat.insert(220);
        System.out.println(dat.search(119));

    }
}
