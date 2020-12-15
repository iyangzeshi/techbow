package OOD_Advanced.session02_design_pattern.factory_design_pattern.factory_design_pattern.shape;

public abstract class Shape {
	
	private String shapeName;
	
	public abstract void draw();
	
	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
}
