package com.clemente.zephyriaslegacy.Online;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.function.Consumer;

import com.clemente.zephyriaslegacy.Board;

public class GameClient extends Thread {
    private DatagramSocket socket;
    private static InetAddress address;
    private static Board board;
    public Consumer<DatagramPacket> callback;
   
    public GameClient(Consumer<DatagramPacket> callback) {
    	
    	this.callback = callback;
    	
    	
        try {
        	
            socket = new DatagramSocket();
            address = InetAddress.getByName("192.168.0.1"); // Cambia esta dirección por la del servidor en LAN

            // Envío de mensaje al servidor
            String mensaje = "Hola, servidor!";
            byte[] mensajeBytes = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(mensajeBytes, mensajeBytes.length, address, 5000); // Puerto del servidor
            socket.send(packet);

            // Mantener la consola abierta durante unos segundos antes de cerrarla
            Thread.sleep(3000); // Espera 3 segundos (puedes ajustar este tiempo)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void setBoard(Board gameBoard) {
        board = gameBoard;
    }
   
    @Override
    public void run() {
    	while (!Thread.interrupted()) {
    		try {
    	        
                byte[] buffer = new byte[1024];
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
                socket.receive(respuesta);
                	
                callback.accept(respuesta);
                
            } catch (Exception e) {
                e.printStackTrace();
            } 
			
		}
    	 
    	
    	super.run();
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

    
}