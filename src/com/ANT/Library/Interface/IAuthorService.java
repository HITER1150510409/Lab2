package com.ANT.Library.Interface;

import java.util.List;

import com.ANT.Library.Implment.Author;

public interface IAuthorService {
	/**
     * ʵ���������Ӳ���
     * @param ao ��Ҫִ�����ӵĶ���
     * @return
     * @throws Exception
     */
    public boolean insert(Author ao)throws Exception;
    /**
     * ��������ȫ����ѯ�����ӿڣ�������ͼ��֮ǰ��ѯ���е���������
     * @return
     * @throws Exception
     */
    public List<Author> list()throws Exception;
    
    /**
     * ִ��ɾ��ĳ�����ߵĲ���
     */
    public boolean remove(Author ao)throws Exception;
    
    /**
     * ִ�и���ĳ��������Ϣ�Ĳ���
     */
    public boolean change(Author ao)throws Exception;
    /**
     * �������ߵ�id�ҵ������ߵ�ȫ����Ϣ
     */
    public Author findAuthorInfoByAuthorId(String aid)throws Exception;
    /**
     * �������ߵ����ַ������ߵ�id
     */
    public String name2Id(String name)throws Exception;
}
