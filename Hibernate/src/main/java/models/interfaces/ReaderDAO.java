package models.interfaces;

import models.entities.Reader;

import java.util.List;

public interface ReaderDAO {
    void add(Reader reader);
    void delete(Reader reader);
    void delete(int id);
    void update(Reader reader);
    List<Reader> getReaders();
    Reader getReader(Reader reader);
    Reader getReaderById(int id);
}
