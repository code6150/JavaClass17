package kr.code6150.db;

import java.sql.SQLException;

@FunctionalInterface
public interface ExceptionHandleFunction <T,R>{

    R apply(T t) throws SQLException;

}
