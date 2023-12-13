package com.clemente.zephyriaslegacy.Online.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerThread extends Thread {

    private final int maxClients = 2;
    private int connectedClients = 0;
    private DatagramSocket connection;
    private InetAddress ipServer;
    private int PORT = 35323;
    private boolean end = false;
    private StoreClientData[] clients;

    public ServerThread() {
        System.out.println("Iniciando server...");
        clients = new StoreClientData[maxClients];

        try {
            connection = new DatagramSocket(PORT);
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión");
        }
    }

    public void sendMessage(String message, InetAddress ip, int PORT) {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, ipServer, PORT);
        try {
            connection.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        do {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                connection.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            processMessage(packet);
        } while (!end);
    }

    private void processMessage(DatagramPacket packet) {
        String message = new String(packet.getData(), 0, packet.getLength()).trim();
        switch (message) {

            case "Connection": {
                if (connectedClients < 2) {
                    clients[connectedClients] = new StoreClientData(packet.getAddress(), packet.getPort());
                    System.out.println("se guardo info player");
                    System.out.println(clients[0].ip);
                    connectedClients++;
                } else {
                    System.out.println("El server esta lleno");
                }
                break;
            }

            case "CardMoved": {
                System.out.println("Received card ID from a client.");

                // Extract the card ID from the packet (assuming it's an int)
                byte[] receivedData = packet.getData();
                int cardID = byteArrayToInt(receivedData);

                // Forward the card ID to all connected clients except the sender
                sendAllExceptSender(packet.getAddress(), packet.getPort(), "CardReceived: " + cardID);
                break;
            }

        }
    }

    private void sendAllExceptSender(InetAddress senderIP, int senderPort, String message) {
        byte[] data = message.getBytes();
        try {
            for (StoreClientData client : clients) {
                if (client != null && !(client.ip.equals(senderIP) && client.port == senderPort)) {
                    DatagramPacket packet = new DatagramPacket(data, data.length, client.ip, client.port);
                    connection.send(packet);
                }
            }
        } catch (IOException e) {
            System.out.println("Error sending message to all clients except sender.");
            e.printStackTrace();
        }
    }

    private int byteArrayToInt(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                (bytes[3] & 0xFF);
    }

    public static void main(String[] args) {
        ServerThread server = new ServerThread();
        server.start(); // Start the server thread
    }
}
