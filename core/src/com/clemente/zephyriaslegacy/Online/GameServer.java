package com.clemente.zephyriaslegacy.Online;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class GameServer extends Thread {
    private DatagramSocket socket;
    private byte[] buffer;

    public GameServer() {
        buffer = new byte[8]; // Assuming card position data consists of 2 floats (8 bytes)

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

                byte[] receivedData = Arrays.copyOf(packet.getData(), packet.getLength());

                float cardX = byteArrayToFloat(Arrays.copyOfRange(receivedData, 0, 4));
                float cardY = byteArrayToFloat(Arrays.copyOfRange(receivedData, 4, 8));

                System.out.println("Received card position: X=" + cardX + ", Y=" + cardY);

                // Implement logic to relay the received card position to the other client(s)
                relayCardPosition(packet.getData(), packet.getLength(), packet.getAddress(), packet.getPort());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void relayCardPosition(byte[] data, int length, InetAddress senderAddress, int senderPort) throws IOException {
        // Assuming you have the addresses and ports of the other clients stored somewhere
        // Replace these with the actual addresses and ports of the other client(s)
        InetAddress receiverAddress = senderAddress; // Replace this with the actual receiver's address
        int receiverPort = senderPort; // Replace this with the actual receiver's port

        DatagramPacket relayPacket = new DatagramPacket(data, length, receiverAddress, receiverPort);
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
