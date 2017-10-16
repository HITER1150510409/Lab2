package com.ANT.Library.DAOFactory;

import java.sql.Connection;

import com.ANT.Library.Implment.AdminDAOImpl;
import com.ANT.Library.Implment.AuthorDAOImpl;
import com.ANT.Library.Implment.BooksDAOImpl;
import com.ANT.Library.Interface.IAdminDAO;
import com.ANT.Library.Interface.IAuthorDAO;
import com.ANT.Library.Interface.IBooksDAO;
public class DAOFactory {
    public static IAdminDAO getIAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
    public static IBooksDAO getIBooksDAOInstance(Connection conn) {
        return new BooksDAOImpl(conn);
    }
    public static IAuthorDAO getIAuthorDAOInstance(Connection conn) {
        return new AuthorDAOImpl(conn);
    }
}

