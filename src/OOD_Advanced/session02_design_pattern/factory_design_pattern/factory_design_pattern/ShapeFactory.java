package OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern;

import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.Circle;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.Shape;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.ShapeType;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.Square;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.Triangle;

public class ShapeFactory {
	
	public static Shape createShape(ShapeType type) {
		switch (type) {
			case TRIANGLE:
				return new Triangle();
			case CIRCLE:
				return new Circle();
			case SQUARE:
				return new Square();
			default:
				throw new IllegalArgumentException("Unknown shape type");
		}
	}
}
