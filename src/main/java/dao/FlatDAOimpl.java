package dao;

import model.Flat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlatDAOimpl implements FlatDAO {
    private final Connection conn;

    public FlatDAOimpl(Connection conn) {
        this.conn = conn;
    }

    public void initDB() {
        try {
            Statement st = conn.createStatement();
//            st.execute("DROP TABLE IF EXISTS Flats");
            st.execute("CREATE TABLE IF NOT EXISTS Flats (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "district VARCHAR (128) NOT NULL, " +
                    "address VARCHAR (128) NOT NULL, " +
                    "area INT DEFAULT NULL, " +
                    "numOFRoom INT DEFAULT NULL, " +
                    "price BIGINT DEFAULT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFlat(Flat flat) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Flats (district, address, area, numOfRoom, price) " +
                "VALUES (?,?,?,?,?) ")){
            ps.setString(1,flat.getDistrict());
            ps.setString(2,flat.getAddress());
            ps.setInt(3, flat.getArea());
            ps.setInt(4,flat.getNumOfRoom());
            ps.setLong(5,flat.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFlats() {
        try {
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM Flats");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flat> getFlats() {
        List<Flat> flats = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM Flats");
            while (resultSet.next()){
                Flat flat = new Flat();
                flat.setId(resultSet.getInt(1));
                flat.setDistrict(resultSet.getString(2));
                flat.setAddress(resultSet.getString(3));
                flat.setArea(resultSet.getInt(4));
                flat.setNumOfRoom(resultSet.getInt(5));
                flat.setPrice(resultSet.getLong(6));
                flats.add(flat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flats;
    }
}