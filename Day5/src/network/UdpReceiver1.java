package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver1 {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(50005);
		byte[] buf = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		while (true) {
			socket.receive(packet);
			
			String msg = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
			System.out.println("Received msg :"+msg);
		}
	}
}