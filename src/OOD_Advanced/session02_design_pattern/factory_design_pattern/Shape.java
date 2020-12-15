package OOD_Advanced.session02_design_pattern.factory_design_pattern;

public abstract class Shape {
	
	private String shapeName;
	
	abstract void draw();
	
	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
}
