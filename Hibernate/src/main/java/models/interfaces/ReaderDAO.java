package models.interfaces;

import models.entities.Reader;

import java.util.Iterator;

public interface ReaderDAO {
    boolean add(Reader reader);
    boolean remove(Reader reader);
    boolean update(Reader reader);
    Iterator<Object> getAllReaders();
}
