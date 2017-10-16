package com.ANT.Library.Interface;

import java.util.List;

import com.ANT.Library.Implment.Author;

public interface IAuthorService {
	/**
     * 实现数据增加操作
     * @param ao 表要执行增加的对象
     * @return
     * @throws Exception
     */
    public boolean insert(Author ao)throws Exception;
    /**
     * 定义数据全部查询操作接口，在新增图书之前查询所有的作者名单
     * @return
     * @throws Exception
     */
    public List<Author> list()throws Exception;
    
    /**
     * 执行删除某个作者的操作
     */
    public boolean remove(Author ao)throws Exception;
    
    /**
     * 执行更改某个作者信息的操作
     */
    public boolean change(Author ao)throws Exception;
    /**
     * 根据作者的id找到该作者的全部信息
     */
    public Author findAuthorInfoByAuthorId(String aid)throws Exception;
    /**
     * 根据作者的名字返回作者的id
     */
    public String name2Id(String name)throws Exception;
}
