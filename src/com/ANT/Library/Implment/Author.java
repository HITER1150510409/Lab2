package com.ANT.Library.Implment;

//Serializable�ӿڣ���ͨ��ʵ�� java.io.Serializable �ӿ������������л����ܡ�
//δʵ�ִ˽ӿڵ��ཫ�޷�ʹ���κ�״̬���л������л��������л�������������ͱ����ǿ����л��ġ�
//���л��ӿ�û�з������ֶΣ������ڱ�ʶ�����л������塣
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Author implements Serializable {
    private String aid;
    private String name;
    private String age;
    private String country;
    private List<Books> books; // һ�����߿��Գ���౾ͼ��
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
    
    
}
