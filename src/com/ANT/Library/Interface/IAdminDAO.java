package com.ANT.Library.Interface;

import java.sql.SQLException;

import com.ANT.Library.Implment.Admin;

public interface IAdminDAO extends IDAO<String,Admin> {
/**
* ʵ���û���¼������
* @param vo ��ʾҪִ�м��Ķ���aid,password,flag��
* @return �Է�����true��ʧ�ܷ���false��
* @throws SQLException
*/
public boolean findLogin(Admin vo)throws SQLException;

/**
* ʵ���û����ݸ��²���
* @param aid ��ʾҪ���µ�����
* @return
* @throws SQLException
*/
public boolean doUpdateByLastDate(String aid)throws SQLException;
}
