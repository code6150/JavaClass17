package kr.code6150.db;

public class DBContext {

    public static final String CREATE_TABLE_QUERY =
            "create table if not exists `users` (" +
                    "`num` int primary key auto_increment, " +
                    "`id` char(36) unique not null, " +
                    "`pw` char (36) not null, " +
                    "`nick` char(36) not null)";

    public static final String INSERT_USER_QUERY =
            "insert into `users`(`id`, `pw`, `nick`) values (?,?,?)";

    public static final String SEARCH_USER_QUERY =
            "select * from `users` where `id`=? and `pw`=?";

}
