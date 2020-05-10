package models.interfaces;

import models.entities.Reader;

import java.util.List;

public interface ReaderDAO {
    void add(Reader reader);
    void delete(Reader reader);
    void update(Reader reader);
    List<Reader> getReaders();
    Reader getReader(Reader reader);
}
