package com.clemente.zephyriaslegacy.Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameServer extends Thread {
    private DatagramSocket socket;
    private byte[] buffer;
    private Map<Integer, InetAddress> clients;
    private Random random;

    public GameServer() {
        clients = new HashMap<>();
        buffer = new byte[1024];
        random = new Random();

        try {
            socket = new DatagramSocket(5000); // Using port 5000 for communication
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

                InetAddress clientAddress = packet.getAddress();

                if (clients.size() >= 2 && !clients.containsValue(clientAddress)) {
                    // If there are already two players and a new player tries to connect, close the game for the new player
                    System.out.println("Lobby is full. Player " + clientAddress + " was rejected.");
                    String rejectionMessage = "Lobby is full. Please try again later.";
                    DatagramPacket rejectionPacket = new DatagramPacket(
                            rejectionMessage.getBytes(),
                            rejectionMessage.getBytes().length,
                            clientAddress,
                            packet.getPort()
                    );
                    socket.send(rejectionPacket);
                    socket.close(); // Close the socket to prevent further connections
                } else {
                    int clientId = generateRandomId();
                    clients.put(clientId, clientAddress);
                    System.out.println("Player " + clientId + " connected: " + clientAddress);

                    // Process other messages or game-related logic here
                    System.out.println("Received message: " + new String(packet.getData(), 0, packet.getLength()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int generateRandomId() {
        return random.nextInt(1000); // Generate a random ID (adjust range as needed)
    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start(); // Start the server thread
    }
}
