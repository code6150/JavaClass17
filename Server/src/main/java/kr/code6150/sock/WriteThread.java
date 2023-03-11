package kr.code6150.sock;

import kr.code6150.data.packet.UserInfoPacket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WriteThread extends Thread{

    private Socket socket;
    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true) {
            try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    if(UserInfoPacket)
                }
            } catch (IOException e) {

            }
        }
    }

}

