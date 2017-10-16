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
        //接收数据
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
                    msg = "作者数据增加成功!";
                }
                else
                {
                    url = "/pages/back/author/author_insert.jsp";
                    msg = "作者数据增加失败!";
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
            msg = "数据不能为空!";
        }
        ServletActionContext.getRequest().setAttribute("url",url);
        ServletActionContext.getRequest().setAttribute("msg",msg);
		return "success";
	}
}
