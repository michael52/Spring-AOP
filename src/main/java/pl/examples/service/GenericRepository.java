package pl.examples.service;

/**
 * Created by toustym on 08.10.2017.
 */
public interface GenericRepository<K, T> {
    T get(K id);
    void add(T obj);
}
