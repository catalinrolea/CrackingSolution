package DesignPatterns.type_of_patterns.factory;

import org.junit.Test;

public class MainShapeMethod {

    @Test
    public void testShape() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeRectangular = shapeFactory.getShape("RECTANGULAR");
        shapeRectangular.draw();
        Shape shapeSquare = shapeFactory.getShape("SQUARE");
        shapeSquare.draw();
    }
}
