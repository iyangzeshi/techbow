package OOD_Advanced.session02_design_pattern.factory_design_pattern;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.factoryDesignPattern
//ClassName: FactoryPattern
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 0:07
public class FactoryPattern {
	
	public static void main(String[] args) {
		DrawingClient client = new DrawingClient();
		client.draw(ShapeType.Triangle);
		client.draw(ShapeType.Circle);
	}
}

