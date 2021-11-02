package repository;

import java.util.List;

public interface GlobalRepository<T> {

    T save(T t);

    List<T> findAll();

    default T findById(int id) {
        return null;
    }
}