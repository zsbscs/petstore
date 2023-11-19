package csu.web.petstore.web.servlet;

import csu.web.petstore.domain.Account;
import csu.web.petstore.domain.Product;
import csu.web.petstore.service.AccountService;
import csu.web.petstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserProfileServlet extends HttpServlet {
    private static final String Profile_Form = "/WEB-INF/jsp/account/profile.jsp";
    private Account account;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        account=new Account();
        account.setUsername(req.getParameter("userid"));

        account.setFirstName(req.getParameter("firstname"));
        account.setLastName(req.getParameter("lastname"));
        account.setAddress1(req.getParameter("address1"));
        account.setAddress2(req.getParameter("address2"));
        account.setCity(req.getParameter("city"));
        account.setCountry(req.getParameter("country"));
        account.setEmail(req.getParameter("email"));
        account.setState(req.getParameter("state"));
        account.setPhone(req.getParameter("phone"));

        AccountService accountService=new AccountService();
        accountService.UpdateProfile(account);





    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Profile_Form).forward(req,resp);

    }

}
