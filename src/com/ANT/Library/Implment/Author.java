package com.ANT.Library.Implment;

//Serializable接口：类通过实现 java.io.Serializable 接口以启用其序列化功能。
//未实现此接口的类将无法使其任何状态序列化或反序列化。可序列化类的所有子类型本身都是可序列化的。
//序列化接口没有方法或字段，仅用于标识可序列化的语义。
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Author implements Serializable {
    private String aid;
    private String name;
    private String age;
    private String country;
    private List<Books> books; // 一个作者可以出版多本图书
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
