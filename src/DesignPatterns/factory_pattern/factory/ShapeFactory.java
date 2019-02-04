package DesignPatterns.factory_pattern.factory;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null)
            return null;
        else if (shapeType.equalsIgnoreCase("RECTANGULAR"))
            return new Rectangular();
        else if (shapeType.equalsIgnoreCase("SQUARE"))
            return new Square();

        return null;
    }
}
