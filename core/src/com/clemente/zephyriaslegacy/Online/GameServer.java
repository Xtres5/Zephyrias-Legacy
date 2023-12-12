package com.clemente.zephyriaslegacy.Online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import com.clemente.zephyriaslegacy.Player;

public class GameServer {
    private DatagramSocket socket;
    private byte[] buffer;

    public GameServer() {
        try {
            socket = new DatagramSocket(5000); // Puerto a utilizar
            buffer = new byte[1024];
            System.out.println("Servidor iniciado. Esperando jugadores...");
            
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                
                // Procesar la información recibida y responder si es necesario
                System.out.println("Mensaje recibido: " + new String(packet.getData(), 0, packet.getLength()));
                
                // Aquí podrías realizar la lógica del juego y la gestión de múltiples conexiones
                
                // Por ejemplo, puedes enviar una respuesta al cliente
                String mensajeRespuesta = "MOVIMIENTO-1-1-1";
                byte[] mensajeRespuestaBytes = mensajeRespuesta.getBytes();
                DatagramPacket respuesta = new DatagramPacket(mensajeRespuestaBytes, mensajeRespuestaBytes.length, packet.getAddress(), packet.getPort());
                socket.send(respuesta);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
    
    
    public static void main(String[] args) {
        new GameServer();
    }
}