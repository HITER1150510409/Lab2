package com.ANT.Library.Interface;
//����һ�������࣬ʵ��DAO�ӿ��е�һЩ��������
import java.sql.Connection;
//PreparedStatement�ӿڣ���ʾԤ�����SQL���Ķ���SQL��䱻Ԥ���벢�洢��PreparedStatement�����У�
//Ȼ�����ʹ�øö����θ�Ч��ִ�и���䡣
import java.sql.PreparedStatement;

public abstract class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;

    public AbstractDAOImpl(Connection conn){
        this.conn= conn;
    }
}
