package com.ANT.Library.Interface;

import java.util.List;
import java.util.Map;

import com.ANT.Library.Implment.Author;
import com.ANT.Library.Implment.Books;

public interface IBooksService {
    /**
     * ����ͼ������
     * @param vo ��ʾҪִ���������ӵĶ���
     * @return �ɹ�����true,ʧ�ܷ���false
     * @throws Exception
     */
    public boolean insert(Books vo)throws Exception;
    /**
     * չʾ���ݿ�books�е������鼮
     */
	public List<Books> list() throws Exception;
	/**
	 * �������ߵ����ֲ�ѯ�����ߵ������鼮
	 * 
	 */
	public List<Books>findAllBooksByAuthorName(String name)throws Exception;
	/**
	 * ����������ֲ�����ı�������ߵ�������Ϣ
	 */
	public Books findInfoByBookName(String name)throws Exception;
	/**
	 * �����鼮�������ҵ����ߵ�id
	 */
	public String findAidByBookName(String name) throws Exception;
	/**
	 * ����ͼ�������ɾ��ĳ����
	 */
	public boolean deleteByBookName(String name) throws Exception;
	/**
	 * �����鼮����Ϣ
	 */
	public boolean update(Books bo) throws Exception;
}
