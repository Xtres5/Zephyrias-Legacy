package com.clemente.zephyriaslegacy.Online.Server;

import java.net.InetAddress;

public class StoreClientData {
	
	public InetAddress ip;
	public int port;
	
	public StoreClientData(InetAddress ip, int port) {
		this.ip = ip;
		this.port = port;
	}
}