package com.clemente.zephyriaslegacy.Online;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.function.Consumer;

import com.clemente.zephyriaslegacy.Board;

public class GameClient extends Thread {
    private final static int PORT = 7000;
    private volatile boolean running = true;
    private DatagramSocket socket;
    private static InetAddress address;
    private static Board board;
    public Consumer<DatagramPacket> callback;

    public GameClient(Consumer<DatagramPacket> callback) {
        this.callback = callback;
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("192.168.0.10"); // Change this address to the server's LAN address
            String message = "Hello, server!";
            byte[] messageBytes = message.getBytes();
            DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, address, PORT);
            socket.send(packet);

            Thread.sleep(3000);
            // Instead of an infinite loop for receiving, you might handle this in the main game loop
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setBoard(Board gameBoard) {
        board = gameBoard;
    }

    public static void sendCardPosition(float cardX, float cardY) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.putFloat(cardX);
            buffer.putFloat(cardY);
            byte[] positionData = buffer.array();

            DatagramPacket packet = new DatagramPacket(positionData, positionData.length, address, PORT);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                callback.accept(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to stop the client
    public void stopClient() {
        running = false;
        socket.close(); // Close the socket to unblock the socket.receive() call
    }

    public static void sendToServer(String message) {
        try {
            Socket socket = new Socket(address, 5000);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(message);
            outputStream.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
