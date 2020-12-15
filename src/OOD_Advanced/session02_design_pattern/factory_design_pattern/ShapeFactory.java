package OOD_Advanced.session02_design_pattern.factory_design_pattern;

public class ShapeFactory {
	
	public static Shape createShape(ShapeType type) {
		switch (type) {
			case Triangle:
				return new Triangle();
			case Circle:
				return new Circle();
			default:
				throw new IllegalArgumentException("Unknown shape type");
		}
	}
}
