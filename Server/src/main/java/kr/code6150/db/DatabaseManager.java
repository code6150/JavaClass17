
package kr.code6150.db;

import javax.swing.plaf.nimbus.State;
import java.io.DataInputStream;
import java.sql.*;
import java.util.function.Consumer;

public class DatabaseManager {

    private static DatabaseManager instance;

    public static DatabaseManager getInstance() {
        if(instance == null) instance = new DatabaseManager();
        return instance;
    }

    private final String host;
    private final String user;
    private final String password;
    private final int port;
    private final String database;

    private Connection con;

    private DatabaseManager() {
        host = "localhost"; // db server 가 다른 곳에 있다면?
        user = "root";      // 회사, ~ 환경에 따라 사용하는 user 가 다름
        password = "1234";
        port = 3306;
        database = "practice17";
    }

    public boolean connect() {
        try {
            if (con != null && !con.isClosed()) return false;
            con = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + database,user,password);
            return true;
        } catch (SQLException e) { return false; }


    }

    public void execute(String query) {
        // 데이터베이스 연결에 실패한경우 아예 쿼리문을 전달하지 않음
        if (!connect()) return;

        try (Statement stmt = con.createStatement();) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> T execute(String query, ExceptionHandleConsumer<PreparedStatement> cons) {
        if (!connect()) return null;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            cons.accept(pstmt);
            try (ResultSet re = pstmt.executeQuery()) {
                if(re.next() == true)

                else
                    return null;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    // User 의 데이터는 Server 뿐만이 아니라, Client 에서도 가지고 있어야한다.

    public <T> T execute(String query, ExceptionHandleConsumer<PreparedStatement> cons, ExceptionHandleFunction<ResultSet, T> resultCons) {
        if (!connect()) return null;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            cons.accept(pstmt);
            try (ResultSet re = pstmt.executeQuery()) {
                if(re.next() == true)
                    return resultCons.apply(re);
                else
                    return null;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }




}
