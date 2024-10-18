package webProgramming.lab3v1.storage;

import webProgramming.lab3v1.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeStorage {
    private List<Shape> storage;

    public ShapeStorage() {
        storage = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        storage.add(shape);
    }

    public Shape getShape(int index) {
        return storage.get(index);
    }

    public void removeShapeByIndex(int index) {
        storage.remove(index);
    }

    public void removeShapeByObject(Shape shape) {
        storage.remove(shape);
    }

    public List<Shape> getStorage(){
        return storage;
    }
}
