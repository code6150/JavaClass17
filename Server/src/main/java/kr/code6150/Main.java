package kr.code6150;

import kr.code6150.data.User;
import kr.code6150.db.DBContext;
import kr.code6150.db.DatabaseManager;

public class Main {
    public static void main(String[] args) {

        User user = DatabaseManager.getInstance().execute(DBContext.SEARCH_USER_QUERY, (pstmt) -> {

        }, (result) -> new User(
                result.getInt("num"),
                result.getString("id"),
                result.getString("pw"),
                result.getString("nick")));

    }
}