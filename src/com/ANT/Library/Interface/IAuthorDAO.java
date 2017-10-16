package com.ANT.Library.Interface;

import java.sql.SQLException;

import com.ANT.Library.Implment.Author;

public interface IAuthorDAO extends IDAO<String,Author> {
/**
* 实现查找某个作者的操作
*/
public Author findAuthorInfoByName(Author ao)throws SQLException;

/**
* 实现作者数量增加操作
* 
*/
public boolean doCreate(Author ao)throws SQLException;
/**
 * 实现作者数量减少操作
 */
public boolean doDelete(Author ao)throws SQLException;
/**
 * 实现作者信息的更改操作
 */
public boolean doChange(Author ao)throws SQLException;
/**
 * 输入作者的名字，返回该作者的id
 */
public String name2Id(String name)throws SQLException;
/**
* 根据作者的id查找某个作者的操作
*/
public Author findByAid(String aid)throws SQLException;

}



