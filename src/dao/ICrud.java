package dao;

import java.util.List;

public interface ICrud<T> {

    void create(T t) throws Exception;
    List<T> readAll() throws Exception;
    void update(T t) throws Exception;
    void  delete(int id) throws Exception;
    void readById(int id) throws Exception;

}