package kr.code6150.data.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UserInfoPacket extends Packet{

    public static int ID = 0x01;

    private int number;
    private String id;
    private String password;
    private String nickname;

    public UserInfoPacket() {}
    public UserInfoPacket(String id, String password) {
        this(-1, id, password, null);
    }
    public UserInfoPacket(int number, String id, String password, String nickname) {
        this.number = number;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }

    @Override
    public void read(DataInputStream dis) throws IOException{
        number = dis.readInt();
        id = dis.readUTF();
        password = dis.readUTF();
        if (nickname.isEmpty()) nickname = null;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeInt(number);
        dos.writeUTF(id);
        dos.writeUTF(password);
        dos.writeUTF(nickname == null ? "" : nickname);
    }

}
