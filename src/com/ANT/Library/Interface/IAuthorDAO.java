package com.ANT.Library.Interface;

import java.sql.SQLException;

import com.ANT.Library.Implment.Author;

public interface IAuthorDAO extends IDAO<String,Author> {
/**
* ʵ�ֲ���ĳ�����ߵĲ���
*/
public Author findAuthorInfoByName(Author ao)throws SQLException;

/**
* ʵ�������������Ӳ���
* 
*/
public boolean doCreate(Author ao)throws SQLException;
/**
 * ʵ�������������ٲ���
 */
public boolean doDelete(Author ao)throws SQLException;
/**
 * ʵ��������Ϣ�ĸ��Ĳ���
 */
public boolean doChange(Author ao)throws SQLException;
/**
 * �������ߵ����֣����ظ����ߵ�id
 */
public String name2Id(String name)throws SQLException;
/**
* �������ߵ�id����ĳ�����ߵĲ���
*/
public Author findByAid(String aid)throws SQLException;

}



