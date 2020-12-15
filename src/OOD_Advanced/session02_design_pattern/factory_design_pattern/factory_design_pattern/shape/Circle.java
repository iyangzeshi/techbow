package OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape;

public class Circle extends Shape {
	
	public Circle() {
		super("Circle");
	}
	
	@Override
	public void draw() {
		// draw a circle
		System.out.println("Draw a Circle");
	}
}
