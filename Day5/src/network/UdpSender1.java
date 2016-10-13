package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSender1 {
	public static void main(String[] args) throws IOException  {
		DatagramSocket socket = new DatagramSocket();
		
		for (int i=0;i<10;i++) {
			String msg = "¾È³çÇÏ¼¼¿ä?!? "+ i;
			byte[] bytes = msg.getBytes("UTF-8");
			
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
			packet.setSocketAddress(new InetSocketAddress ("127.0.0.1", 50005));
			
			socket.send(packet);
		}
		
		socket.close();
	}
}
