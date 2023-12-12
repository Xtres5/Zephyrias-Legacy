package com.clemente.zephyriaslegacy.Online;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import com.clemente.zephyriaslegacy.Board;

public class GameClient {
    private DatagramSocket socket;
    private static InetAddress address;
    private static Board board;
    
    public GameClient() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("192.168.0.10"); // Cambia esta dirección por la del servidor en LAN

            // Envío de mensaje al servidor
            String mensaje = "Hola, servidor!";
            byte[] mensajeBytes = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(mensajeBytes, mensajeBytes.length, address, 5000); // Puerto del servidor
            socket.send(packet);

            // Espera una respuesta del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socket.receive(respuesta);

            // Mostrar la respuesta del servidor
            String mensajeRespuesta = new String(respuesta.getData(), 0, respuesta.getLength());
            System.out.println("Respuesta del servidor: " + mensajeRespuesta);

            // Mantener la consola abierta durante unos segundos antes de cerrarla
            Thread.sleep(3000); // Espera 3 segundos (puedes ajustar este tiempo)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
    
    public static void setBoard(Board gameBoard) {
        board = gameBoard;
    }
    
    public static void recibirMensajeDelServidor(String mensaje) {
        if (mensaje.startsWith("MOVIMIENTO-")) {
            String[] partes = mensaje.split("-");
            if (partes.length == 4) {
                int cardID = Integer.parseInt(partes[1]);
                int x = Integer.parseInt(partes[2]);
                int y = Integer.parseInt(partes[3]);
                board.moverCarta(cardID, x, y);
            }
        }
        
        
        // Otros casos para procesar mensajes del servidor
    }
    
    public static void enviarMensajeAlServidor(String mensaje) {
        try {
            Socket socket = new Socket(address, 5000);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(mensaje);
            outputStream.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores al enviar el mensaje al servidor
        }
    }

    public static void main(String[] args) {
        new GameClient();
    }
}