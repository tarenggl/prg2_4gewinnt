package com.viergewinnt.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

public class NetworkHelper {

	public static Object read(DatagramSocket datagramSocket) throws IOException, ClassNotFoundException {
		byte[] recvBuf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
		datagramSocket.receive(packet);
		ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
		ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
		Object o = is.readObject();
		is.close();
		return o;
	}

	public static void send(Object transferObject, DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
		try {

			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024);
			ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
			os.flush();
			os.writeObject(transferObject);
			os.flush();
			byte[] sendBuf = byteStream.toByteArray();
			DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, datagramPacket.getAddress(),
					datagramPacket.getPort());
			datagramSocket.send(packet);
			os.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}