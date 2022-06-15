package com.cleo.revision.socketServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {

    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(3333)){
            DatagramPacket dp = new DatagramPacket(new byte[16],16);
            socket.receive(dp);
            for(var b:dp.getData()){
                System.out.println(Character.toString(b));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
