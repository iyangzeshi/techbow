package OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern;

import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.Shape;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape.ShapeType;

public class DrawingClient {
	
	public static void main(String[] args) {
		DrawingClient client = new DrawingClient();
		client.draw(ShapeType.TRIANGLE);
		client.draw(ShapeType.CIRCLE);
		client.draw(ShapeType.SQUARE);
	}
	
	public DrawingClient() {
		// ......
	}
	
	public void draw(ShapeType type) {
		Shape shape = ShapeFactory.createShape(type);
		shape.draw();
	}
	
}
