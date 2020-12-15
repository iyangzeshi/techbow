package OOD_Advanced.session02_design_pattern.factory_design_pattern;

public class DrawingClient {
	
	public DrawingClient() {
		// ......
	}
	
	public void draw(ShapeType type) {
		Shape shape = ShapeFactory.createShape(type);
		shape.draw();
	}
}
