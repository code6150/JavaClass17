package kr.code6150.db;

import java.sql.SQLException;

@FunctionalInterface
public interface ExceptionHandleConsumer<T> {

    void accept(T t) throws SQLException;

}
