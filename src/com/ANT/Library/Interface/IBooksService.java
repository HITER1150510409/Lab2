package com.ANT.Library.Interface;

import java.util.List;
import java.util.Map;

import com.ANT.Library.Implment.Author;
import com.ANT.Library.Implment.Books;

public interface IBooksService {
    /**
     * 增加图书详情
     * @param vo 表示要执行数据增加的对象
     * @return 成功返回true,失败返回false
     * @throws Exception
     */
    public boolean insert(Books vo)throws Exception;
    /**
     * 展示数据库books中的所有书籍
     */
	public List<Books> list() throws Exception;
	/**
	 * 根据作者的名字查询该作者的所有书籍
	 * 
	 */
	public List<Books>findAllBooksByAuthorName(String name)throws Exception;
	/**
	 * 根据书的名字查找书的本书和作者的所有信息
	 */
	public Books findInfoByBookName(String name)throws Exception;
	/**
	 * 根据书籍的名字找到作者的id
	 */
	public String findAidByBookName(String name) throws Exception;
	/**
	 * 根据图书的名字删除某本书
	 */
	public boolean deleteByBookName(String name) throws Exception;
	/**
	 * 更新书籍的信息
	 */
	public boolean update(Books bo) throws Exception;
}
