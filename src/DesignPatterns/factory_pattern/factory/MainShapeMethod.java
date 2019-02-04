package DesignPatterns.factory_pattern.factory;

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
