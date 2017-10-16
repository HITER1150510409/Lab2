package com.ANT.Action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.ANT.Library.DAOFactory.ServiceFactory;
import com.ANT.Library.Implment.Admin;
import com.ANT.Library.util.MD5Code;
import com.ANT.Library.util.ValidateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport
{
	private String aid;
	private String password;
	private String msg = ""; //表示提示信息
    private String url = ""; // 表示跳转路径
	
	public String execute()
	{
        // 判断数据是否为空
        if(ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){ // 表示数据存在
            Admin vo = new Admin();
            vo.setAid(aid); // 取得参数
            vo.setPassword(password); // 需要加盐处理
            try {
                if (ServiceFactory.getIAdminServiceInstance().login(vo)){
                    ServletActionContext.getRequest().getSession().setAttribute("aid", aid); 
                    ServletActionContext.getRequest().getSession().setAttribute("password", password); 
                    msg = "登录成功！";
                    url = "/pages/index.jsp";
                    System.out.println("在这里多加一些东西");
                }else{
                    msg = "登录失败，错误的ID或密码!";
                    url = "/login.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            msg = "数据不能为空!";
            url = "/login.jsp";
        }
        ServletActionContext.getRequest().setAttribute("msg",msg);
        ServletActionContext.getRequest().setAttribute("url",url);
        return "success";
	}
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
