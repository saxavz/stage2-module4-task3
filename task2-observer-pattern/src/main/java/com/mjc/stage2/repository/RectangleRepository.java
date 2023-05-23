package com.mjc.stage2.repository;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.impl.RectangleObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleRepository {
    private static RectangleRepository instance;
    private List<Rectangle> rectangles;
    private final RectangleObserver warehouseObserver;

    private RectangleRepository() {
        rectangles = new ArrayList<>();
        warehouseObserver = new RectangleObserver();
    }

    public static RectangleRepository getInstance() {
        if (instance == null) {
            instance = new RectangleRepository();
        }
        return instance;
    }

    public boolean add(Rectangle rectangle) {
        rectangle.addObserver(warehouseObserver);
        return rectangles.add(rectangle);
    }

    public boolean remove(Rectangle rectangle) {
        return rectangles.remove(rectangle);
    }

    public Rectangle getRectangle(int index) {
        return rectangles.get(index);
    }

    public List<Rectangle> getRectangles() {
        return Collections.unmodifiableList(rectangles);
    }

//    public static void main(String[] args) {
//        RectangleRepository repo = RectangleRepository.getInstance();
//        repo.add(new Rectangle(1,1,1));
//        repo.add(new Rectangle(11,2,2));
//        repo.add(new Rectangle(111,3,3));
//        repo.add(new Rectangle(1111,4,4));
//
//        repo.getRectangle(0).setSideA(0.9d);
//        repo.getRectangle(1).setSideA(0.7d);
//    }
}
