package openNeo;

import java.util.List;
import java.util.Vector;

public interface CreateFileInterface {

    default void add(String item) {
    }

    default void add(List<String> items) {
    }

    void add(Vector<String> items);

    default void remove(String egg) {
    }

    default void remove(List<String> eggs) {
    }

    void remove(Vector<String> items);

    default void clear() {
    }

    default void setPath(String path) {
    }


    default void generate() {
    }


    default void print() {
    }


    default void save() {
    }

}
