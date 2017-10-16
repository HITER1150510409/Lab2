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
	private String msg = ""; //��ʾ��ʾ��Ϣ
    private String url = ""; // ��ʾ��ת·��
	
	public String execute()
	{
        // �ж������Ƿ�Ϊ��
        if(ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){ // ��ʾ���ݴ���
            Admin vo = new Admin();
            vo.setAid(aid); // ȡ�ò���
            vo.setPassword(password); // ��Ҫ���δ���
            try {
                if (ServiceFactory.getIAdminServiceInstance().login(vo)){
                    ServletActionContext.getRequest().getSession().setAttribute("aid", aid); 
                    ServletActionContext.getRequest().getSession().setAttribute("password", password); 
                    msg = "��¼�ɹ���";
                    url = "/pages/index.jsp";
                    System.out.println("��������һЩ����");
                }else{
                    msg = "��¼ʧ�ܣ������ID������!";
                    url = "/login.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            msg = "���ݲ���Ϊ��!";
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
