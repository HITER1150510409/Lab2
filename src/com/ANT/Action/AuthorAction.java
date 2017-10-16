package com.ANT.Action;

import org.apache.struts2.ServletActionContext;

import com.ANT.Library.DAOFactory.ServiceFactory;
import com.ANT.Library.Implment.Author;
import com.ANT.Library.util.ValidateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class AuthorAction extends ActionSupport
{
	private String aid;
	private String name;
	private String age;
	private String country;
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
	
	public String AuthorInsertAction()
	{
		String url = "";
        String msg = "";
        //��������
        System.out.println(name);
        if(ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(name) && ValidateUtils.validateEmpty(country) )
        {
            Author ao = new Author();
            ao.setAid(aid);
            ao.setName(name);
            ao.setAge(age);
            ao.setCountry(country);
            try 
            {
                if (ServiceFactory.getIAuthorServiceInstance().insert(ao))
                {
                    url = "/pages/back/author/author_insert.jsp";
                    msg = "�����������ӳɹ�!";
                }
                else
                {
                    url = "/pages/back/author/author_insert.jsp";
                    msg = "������������ʧ��!";
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else
        {
            url = "/pages/back/author/author_insert.jsp";
            msg = "���ݲ���Ϊ��!";
        }
        ServletActionContext.getRequest().setAttribute("url",url);
        ServletActionContext.getRequest().setAttribute("msg",msg);
		return "success";
	}
}
