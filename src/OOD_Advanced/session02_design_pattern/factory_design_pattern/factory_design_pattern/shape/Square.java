package OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape;

//Project: techbow
//Package: OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape
//ClassName: Square
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-27 星期日 12:46
public class Square extends Shape{
	
	public Square() {
		super("Square");
	}
	
	@Override
	public void draw() {
		// draw a circle
		System.out.println("Draw a Square");
	}
	
}
