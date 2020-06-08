package by.gstu.model.interfaces;

import by.gstu.model.enities.Reader;

import java.util.List;

public interface MySqlReaderDAO {
    List<Reader> getAllReaders();
    void deleteReaderById(int id);
    void updateReaderById(int id);
}
