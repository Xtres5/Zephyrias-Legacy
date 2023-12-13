package com.clemente.zephyriaslegacy.Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class GameServer extends Thread {
    private DatagramSocket socket;
    private byte[] buffer;

    public GameServer() {
        buffer = new byte[8]; // Assuming card position data consists of 2 floats (8 bytes)

        try {
            socket = new DatagramSocket(6000); // Using port 6000 for communication
            System.out.println("Server started. Waiting for players...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                byte[] receivedData = Arrays.copyOf(packet.getData(), packet.getLength());

                float cardX = byteArrayToFloat(Arrays.copyOfRange(receivedData, 0, 4));
                float cardY = byteArrayToFloat(Arrays.copyOfRange(receivedData, 4, 8));

                System.out.println("Received card position: X=" + cardX + ", Y=" + cardY);

                relayCardPosition(packet.getData(), packet.getLength(), packet.getAddress(), packet.getPort());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void relayCardPosition(byte[] data, int length, InetAddress senderAddress, int senderPort) throws IOException {
        // Logic for forwarding the received card position to other client(s) goes here
        // For example, you might have a list of client addresses and ports
        // Loop through the list and send the data to each client, except the sender

        // Dummy example of sending the data back to the sender
        DatagramPacket relayPacket = new DatagramPacket(data, length, senderAddress, senderPort);
        socket.send(relayPacket);
    }

    private float byteArrayToFloat(byte[] bytes) {
        return java.nio.ByteBuffer.wrap(bytes).getFloat();
    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start(); // Start the server thread
    }
}
