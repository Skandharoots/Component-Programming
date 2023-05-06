package pl.cp;

public interface Dao<T> {
    T read();

    void write(T object);
}
