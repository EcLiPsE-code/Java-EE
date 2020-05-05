package models.mysql;

import models.entities.Reader;
import models.interfaces.ReaderDAO;

import java.util.Iterator;

public class MySqlReaderDAO implements ReaderDAO {
    @Override
    public boolean add(Reader reader) {
        return false;
    }

    @Override
    public boolean remove(Reader reader) {
        return false;
    }

    @Override
    public boolean update(Reader reader) {
        return false;
    }

    @Override
    public Iterator<Object> getAllReaders() {
        return null;
    }
}
