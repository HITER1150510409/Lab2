package com.ANT.Library.Interface;

import java.sql.SQLException;
import java.util.List;

import com.ANT.Library.Implment.Books;

public interface IBooksDAO extends IDAO<Integer,Books> {
	//根据书的名字查找某本书的信息。
	public Books show(String name) throws SQLException;
	//根据作者的id查找该作者的所有书籍
	public List<Books> findAllBooksByAid(String aid) throws SQLException;
	//根据书籍的名称查找作者的编号
	public String findAidByBookName(String name) throws SQLException;
	//根据书籍的名称删除某本书籍
	public boolean deleteByBookName(String name) throws SQLException;
	//更新书籍的信息
	public boolean update(Books bo) throws SQLException;
}


