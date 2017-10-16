package com.ANT.Library.Interface;

import com.ANT.Library.Implment.Admin;

public interface IAdminService {
    /**
     * 实现管理员登录检查操作，调用IAdminDAO接口中的findLogin()方法
     * @param vo 表示要操作的对象，包括aid,password
     * @return 成功返回true,并且将最后一次登录日期传递到页面，失败false
     * @throws Exception
     */
    public boolean login(Admin vo)throws Exception;

}

