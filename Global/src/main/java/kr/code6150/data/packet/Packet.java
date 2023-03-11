package kr.code6150.data.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Packet {

    /*
    * static Id
    */
    static int ID = 0x01;


    public abstract void read(DataInputStream dis);
    public abstract void write(DataOutputStream dos);

}
