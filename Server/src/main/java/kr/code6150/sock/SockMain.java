package kr.code6150.sock;

import jdk.nashorn.internal.runtime.Scope;

import java.io.IOException;
import java.net.ServerSocket;

public class SockMain {

    private static SockMain instance;
    private static SockMain getInstance() {
        return instance == null ? new SockMain() : instance;
    }

    private final int port;

    private SockMain() {
        instance = this;
        port = 27854;
    }

    public boolean startServer() {
        try {
            ServerSocket ss = new ServerSocket(port);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
