package com.ANT.Action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ANT.Library.DAOFactory.ServiceFactory;
import com.ANT.Library.Implment.Admin;
import com.ANT.Library.Implment.Author;
import com.ANT.Library.Implment.Books;
import com.ANT.Library.util.ValidateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport
{
	private String name="";
	private String aname="";
	private String isbn="";
	private String note="";
	private String credate="";
	private String publisher="";
	private String price="";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCredate() {
		return credate;
	}

	public void setCredate(String credate) {
		this.credate = credate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String BooksDeleteAction()
	{
		String msg = "";
        String url = "";
        try
        {
        	if(ServiceFactory.getIBooksServiceInstance().deleteByBookName(name))
        	{
        		msg= "删除成功！";
        		url="/pages/back/mediate5.jsp";
        	}
        	else 
        	{
        		msg = "删除失败！";
        		url="/pages/back/mediate5.jsp";
        	}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        ServletActionContext.getRequest().setAttribute("msg",msg);
        ServletActionContext.getRequest().setAttribute("url",url);
		return "success";
	}
	public String BooksInsertAction()
	{
		String msg = "";
        String url = "";
        try 
        {
			String aid = ServiceFactory.getIAuthorServiceInstance().name2Id(aname);
			if(ValidateUtils.validateEmpty(name) && ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(note) )
			{
				Books vo = new Books();
	            vo.setName(name);
	            vo.setCredate(credate);
	            vo.setIsbn(isbn);
	            vo.setNote(note);
	            vo.setPrice(price);
	            vo.setPublisher(publisher);
	            vo.setStatus(1); // 1表示上架 0表示下架操作
	            Author author = new Author();
	            author.setAid(aid);
	            vo.setAuthor(author);
	            try 
	            {
	                if (ServiceFactory.getIBooksServiceInstance().insert(vo))
	                {
	                    msg = "数据已经增加成功！";
	                    url = "/pages/back/mediate2.jsp";
	                }
	                else
	                {
	                    msg = "你输入的信息有误，请重新输入";
	                    url = "/pages/back/mediate2.jsp";
	                }
	            } 
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
			}
			else
			{
		            msg = "你输入的内容为空，请重新输入";
		            url = "/pages/back/mediate2.jsp";
			}	
		} 
        catch (Exception e1) 
        {
			e1.printStackTrace();
		}
        ServletActionContext.getRequest().setAttribute("msg",msg);
        ServletActionContext.getRequest().setAttribute("url",url);
        return "success";
	}
	public String BooksInsertProAction()
	{
		List<Author> allAuthor;
		try
		{
			allAuthor = ServiceFactory.getIAuthorServiceInstance().list();
			ServletActionContext.getRequest().setAttribute("allAuthor", allAuthor);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}
	public String FindBooksAction()
	{
		List<Books> allBooks;
		try
		{   allBooks = ServiceFactory.getIBooksServiceInstance().findAllBooksByAuthorName(aname);
			ServletActionContext.getRequest().setAttribute("allBooks", allBooks);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 通过书的名字找到书和作者的所有信息。
	 * @return
	 */
	public String BooksCheckAction()
	{
		Map<String,Object> map = null;
		try
		{
			Books bo = ServiceFactory.getIBooksServiceInstance().findInfoByBookName(name);
			ServletActionContext.getRequest().setAttribute("Info" , bo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}
	public String BooksCheckProAction()
	{
		List<Books> allBooks = null;
		try
		{
			allBooks = ServiceFactory.getIBooksServiceInstance().list();
			ServletActionContext.getRequest().setAttribute("allBooks" , allBooks);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "success";
	}
	public String BooksUpdateAction()
	{
		String msg="";
		String url="";
		try
		{
			String aid = ServiceFactory.getIAuthorServiceInstance().name2Id(aname);
			Books bo = new Books();
			bo.setIsbn(isbn);
			bo.setName(name);
			bo.setNote(note);
			bo.setPrice(price);
			bo.setPublisher(publisher);
			bo.setCredate(credate);
			Author ao = new Author();
			ao.setAid(aid);
			ao.setName(aname);
			bo.setAuthor(ao);
			if(ServiceFactory.getIBooksServiceInstance().update(bo))
			{
				msg = "更新成功！";
				url = "/pages/back/mediate6.jsp";
			}
			else
			{
				msg = "更新失败！";
				url = "/pages/back/mediate6.jsp";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ServletActionContext.getRequest().setAttribute("msg",msg);
        ServletActionContext.getRequest().setAttribute("url",url);
		return "success";
	}
	public String BooksUpdateProAction()
	{
		List<Books> allBooks = null;
		List<Author> allAuthor = null;
		try
		{
			allBooks = ServiceFactory.getIBooksServiceInstance().list();
			allAuthor = ServiceFactory.getIAuthorServiceInstance().list();
			ServletActionContext.getRequest().setAttribute("allBooks" , allBooks);
			ServletActionContext.getRequest().setAttribute("allAuthor" , allAuthor);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
	}
}
