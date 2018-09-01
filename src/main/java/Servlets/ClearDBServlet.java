package Servlets;

import dao.ConnectionFactory;
import dao.FlatDAO;
import dao.FlatDAOimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "ClearDBServlet", urlPatterns = "/clear")
public class ClearDBServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = new ConnectionFactory().getConnection();
        FlatDAO flatDAO = new FlatDAOimpl(conn);
        flatDAO.initDB();
        flatDAO.deleteFlats();
        response.getWriter().print("database cleared");
    }
}
