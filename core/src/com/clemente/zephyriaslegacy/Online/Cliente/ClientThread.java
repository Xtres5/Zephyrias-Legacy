package com.clemente.zephyriaslegacy.Online.Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.clemente.zephyriaslegacy.GameScreen;


public class ClientThread extends Thread {
	private GameScreen gameScreen;
	private DatagramSocket connection;
	private InetAddress ipServer;
	private int PORT = 35323;
	private boolean end = false;
	
	public ClientThread(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		System.out.println("Iniciando cliente...");
		try {
			connection = new DatagramSocket();
			ipServer = InetAddress.getByName("255.255.255.255"); // broadcast
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Error en la conexión");
		}
		System.out.println("Enviando mensaje al servidor...");
		sendMessage("Connection");
	}
	
	public void sendMessage(String message) {
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
		System.out.println(message);
		
		switch (message) {
		
		case "CardMoved": {
			System.out.println("llego al cliente el movimiento de la carta");
			gameScreen.getBoard().dragAndDropListener.handleCardMove();
			break;
		}
		}
	}
	
}
