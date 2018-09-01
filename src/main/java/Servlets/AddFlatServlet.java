package Servlets;

import dao.ConnectionFactory;
import dao.FlatDAO;
import dao.FlatDAOimpl;
import model.Flat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AddFlatServlet", urlPatterns = "/add")
public class AddFlatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String district = request.getParameter("district");
        String address = request.getParameter("address");
        String area = request.getParameter("area");
        String numOfRoom = request.getParameter("numOfRoom");
        String price = request.getParameter("price");

        if (district.isEmpty() || address.isEmpty() || area.isEmpty() || numOfRoom.isEmpty() || price.isEmpty()) {
            response.getWriter().print("Error. fields not filled");
        }
        Flat flat = new Flat(district,address);
        flat.setArea(Integer.parseInt(area));
        flat.setNumOfRoom(Integer.parseInt(numOfRoom));
        flat.setPrice(Long.parseLong(price));

        Connection conn = new ConnectionFactory().getConnection();
        FlatDAO flatDAO = new FlatDAOimpl(conn);
        flatDAO.initDB();
        flatDAO.addFlat(flat);
        response.getWriter().print("Success");
    }
}
