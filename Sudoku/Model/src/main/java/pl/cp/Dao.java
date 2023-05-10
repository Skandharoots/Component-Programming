package pl.cp;

public interface Dao<T> extends AutoCloseable {
    T read();

    void write(T object);
}
