package com.cleo.revision.socketServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class MultiClient {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",999);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str;
        while((str=br.readLine())!=null) {
            System.out.println(str);
        }
            br.close();
            s.close();

        }

}
