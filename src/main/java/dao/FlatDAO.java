package dao;

import model.Flat;

import java.util.List;

public interface FlatDAO {
    void initDB();
    void addFlat(Flat flat);
    void deleteFlats ();
    List<Flat> getFlats();

}
