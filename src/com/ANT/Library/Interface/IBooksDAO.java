package com.ANT.Library.Interface;

import java.sql.SQLException;
import java.util.List;

import com.ANT.Library.Implment.Books;

public interface IBooksDAO extends IDAO<Integer,Books> {
	//����������ֲ���ĳ�������Ϣ��
	public Books show(String name) throws SQLException;
	//�������ߵ�id���Ҹ����ߵ������鼮
	public List<Books> findAllBooksByAid(String aid) throws SQLException;
	//�����鼮�����Ʋ������ߵı��
	public String findAidByBookName(String name) throws SQLException;
	//�����鼮������ɾ��ĳ���鼮
	public boolean deleteByBookName(String name) throws SQLException;
	//�����鼮����Ϣ
	public boolean update(Books bo) throws SQLException;
}


