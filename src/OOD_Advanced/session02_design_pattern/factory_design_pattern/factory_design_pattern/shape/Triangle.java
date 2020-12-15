package OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape;

public class Triangle extends Shape {
	
	public Triangle() {
		super("Triangle");
	}
	
	@Override
	public void draw() {
		// draw a triangle
		System.out.println("Draw a Rectangle");
		
	}
}
