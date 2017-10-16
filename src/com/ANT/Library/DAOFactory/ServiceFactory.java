package com.ANT.Library.DAOFactory;

import com.ANT.Library.Implment.AdminServiceImpl;
import com.ANT.Library.Implment.AuthorServiceImpl;
import com.ANT.Library.Implment.BooksServiceImpl;
import com.ANT.Library.Interface.IAdminService;
import com.ANT.Library.Interface.IAuthorService;
import com.ANT.Library.Interface.IBooksService;

public class ServiceFactory {
    public static IAdminService getIAdminServiceInstance(){
        return  new AdminServiceImpl();
    }
    public static IBooksService getIBooksServiceInstance(){
        return new BooksServiceImpl();
    }
    public static IAuthorService getIAuthorServiceInstance(){
        return new AuthorServiceImpl();
    }
}

