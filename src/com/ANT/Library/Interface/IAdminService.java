package com.ANT.Library.Interface;

import com.ANT.Library.Implment.Admin;

public interface IAdminService {
    /**
     * ʵ�ֹ���Ա��¼������������IAdminDAO�ӿ��е�findLogin()����
     * @param vo ��ʾҪ�����Ķ��󣬰���aid,password
     * @return �ɹ�����true,���ҽ����һ�ε�¼���ڴ��ݵ�ҳ�棬ʧ��false
     * @throws Exception
     */
    public boolean login(Admin vo)throws Exception;

}

