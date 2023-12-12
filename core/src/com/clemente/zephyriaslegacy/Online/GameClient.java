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
	private final static int PORT = 5000;
    private volatile boolean running = true; // Flag to control the loop
    private DatagramSocket socket;
    private static InetAddress address;
    private static Board board;
    public Consumer<DatagramPacket> callback;
   
    public GameClient(Consumer<DatagramPacket> callback) {
        this.callback = callback;
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("192.168.0.10"); // Change this address to the server's LAN address

            // Sending a message to the server
            String message = "Hello, server!";
            byte[] messageBytes = message.getBytes();
            DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, address, PORT); // Server port
            socket.send(packet);

            // Keeping the console open for a few seconds before closing it
            Thread.sleep(3000); // Wait for 3 seconds (you can adjust this time)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void setBoard(Board gameBoard) {
        board = gameBoard;
    }
    
    public static void sendCardPosition(float cardX, float cardY) {
        try {
            // Convert card position to bytes
            ByteBuffer buffer = ByteBuffer.allocate(8); // Allocate 8 bytes (for 2 floats)
            buffer.putFloat(cardX);
            buffer.putFloat(cardY);
            byte[] positionData = buffer.array(); // Convert to byte array

            // Create a DatagramPacket containing position data
            DatagramPacket packet = new DatagramPacket(positionData, positionData.length, address, PORT);

            // Console message before sending data to server
            System.out.println("Sending card position data to server...");

            // Send the DatagramPacket from client to server
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            // Console message after sending data to server
            System.out.println("Card position data sent to server.");

            // Close the socket after sending data (if necessary)
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., failed sending)
        }
    }
   
    @Override
    public void run() {
        while (running) { // Loop continues while the flag is true
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                callback.accept(response);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle exceptions here
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
            // Handle errors when sending the message to the server
        }
    }
}
