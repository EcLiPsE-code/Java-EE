package by.gstu.controller;

import by.gstu.model.enities.Reader;
import by.gstu.model.interfaces.MySqlReaderDAO;
import by.gstu.model.mysql.MySqlReaderDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Readers", urlPatterns = {"/readers"})
public class Servlet extends HttpServlet {

    private static long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MySqlReaderDAO mySqlReaderDAO = new MySqlReaderDAOImpl();
        Reader[] readers = mySqlReaderDAO.getAllReaders().toArray(Reader[]::new);
        req.setAttribute("readers", readers);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MySqlReaderDAO mySqlReaderDAO = new MySqlReaderDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
