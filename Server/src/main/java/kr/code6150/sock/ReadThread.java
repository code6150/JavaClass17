package kr.code6150.sock;

import kr.code6150.data.packet.UserInfoPacket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread{

    private Socket socket;
    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true) {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    if (UserInfoPacket.ID == dis.readInt()) {
                        UserInfoPacket packet = new UserInfoPacket();
                        packet.read(dis);
                    }
                }
            } catch (IOException e) {

            }
        }
    }

}
