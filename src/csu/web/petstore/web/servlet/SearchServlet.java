package csu.web.petstore.web.servlet;

import csu.web.petstore.domain.Product;
import csu.web.petstore.persistence.ProductDao;
import csu.web.petstore.persistence.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    private static String SEARCH_RESULT="/WEB-INF/jsp/catalog/searchresult.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao=new ProductDaoImpl();
       String keyword=req.getParameter("keyword");
       List<Product> products=productDao.searchProductList(keyword);
        HttpSession session=req.getSession();
        session.setAttribute("products",products);


        req.getRequestDispatcher(SEARCH_RESULT).forward(req, resp);



    }
}
