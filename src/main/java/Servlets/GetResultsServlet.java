package Servlets;

import Utils.Filter;
import Utils.FilterPredicates;
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
import java.util.List;

@WebServlet(name = "GetResultsServlet", urlPatterns = "/results")
public class GetResultsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String district = request.getParameter("district");
        String address = request.getParameter("address");
        String areaFrom = request.getParameter("areaFrom");
        String areaTo = request.getParameter("areaTo");
        String numOfRoom = request.getParameter("numOfRoom");
        String priceFrom = request.getParameter("priceFrom");
        String priceTo = request.getParameter("priceTo");

        Connection conn = new ConnectionFactory().getConnection();
        FlatDAO flatDAO = new FlatDAOimpl(conn);
        flatDAO.initDB();
        List<Flat> flats = flatDAO.getFlats();
        if (!district.isEmpty()){
           flats = Filter.filter(flats,FilterPredicates.hasDistrict(district));
        }
        if (!address.isEmpty()){
            flats = Filter.filter(flats,FilterPredicates.hasAddress(address));
        }
        if (!areaFrom.isEmpty() && !areaTo.isEmpty()){
            flats = Filter.filter(flats,FilterPredicates.hasArea(Integer.parseInt(areaFrom),Integer.parseInt(areaTo)));
        }
        if (!numOfRoom.isEmpty()){
            flats = Filter.filter(flats,FilterPredicates.hasNumOfRoom(Integer.parseInt(numOfRoom)));
        }
        if (!priceFrom.isEmpty() && !priceTo.isEmpty()){
            flats = Filter.filter(flats,FilterPredicates.hasPrice(Long.parseLong(priceFrom),Long.parseLong(priceTo)));
        }
        if (!flats.isEmpty()){
            request.setAttribute("flats", flats);
        } else {
            response.getWriter().print("Nothing found for your request");
        }
        request.getRequestDispatcher("results.jsp").forward(request,response);
    }
}
