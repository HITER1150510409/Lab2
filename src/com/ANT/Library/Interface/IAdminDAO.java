package com.ANT.Library.Interface;

import java.sql.SQLException;

import com.ANT.Library.Implment.Admin;

public interface IAdminDAO extends IDAO<String,Admin> {
/**
* 实现用户登录检查操作
* @param vo 表示要执行检查的对象（aid,password,flag）
* @return 吃饭返回true，失败返回false；
* @throws SQLException
*/
public boolean findLogin(Admin vo)throws SQLException;

/**
* 实现用户数据更新操作
* @param aid 表示要更新的主键
* @return
* @throws SQLException
*/
public boolean doUpdateByLastDate(String aid)throws SQLException;
}
