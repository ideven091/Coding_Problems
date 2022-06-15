package com.cleo.revision.socketServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName("localhost");

            DatagramPacket packet=new DatagramPacket("Hi".getBytes(),"Hi".length(),address,3333);
            socket.send(packet);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
