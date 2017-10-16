package com.ANT.Library.Interface;
//定义一个抽象类，实现DAO接口中的一些公共方法
import java.sql.Connection;
//PreparedStatement接口：表示预编译的SQL语句的对象，SQL语句被预编译并存储在PreparedStatement对象中，
//然后可以使用该对象多次高效的执行该语句。
import java.sql.PreparedStatement;

public abstract class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;

    public AbstractDAOImpl(Connection conn){
        this.conn= conn;
    }
}
