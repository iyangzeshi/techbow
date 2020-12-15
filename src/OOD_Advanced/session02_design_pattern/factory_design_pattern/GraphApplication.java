package OOD_Advanced.session02_design_pattern.factory_design_pattern;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.factoryDesignPattern
//ClassName: GraphApplication
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 0:02

public class GraphApplication {
	
	abstract class Shape {
		
		private String shapeName;
		
		abstract void draw();
		
		public Shape(String shapeName) {
			this.shapeName = shapeName;
		}
	}
	
	class Rectangle extends Shape {
		
		public Rectangle() {
			super("Rectangle");
		}
		
		@Override
		public void draw() {
			// draw a rectangle
		}
	}
	
	class Circle extends Shape {
		
		public Circle() {
			super("Circle");
		}
		
		@Override
		public void draw() {
			// draw a Circle
		}
	}
	
	class Triangle extends Shape {
		
		public Triangle() {
			super("Triangle");
		}
		
		@Override
		public void draw() {
			// draw a Triangle
		}
	}
	
	enum ShapeType {
		Rectangle,
		Circle,
		Triangle;
	}
	
	public void draw(ShapeType type) { // // 实际app产品中，这段代码在用户手机本地客户端上
		// get shape by type
		Shape shape = null;
		switch (type) {
			case Rectangle:
				shape = new Rectangle();
				break;
			case Circle:
				shape = new Circle();
				break;
			case Triangle:
				shape = new Triangle();
				break;
			default:
				throw new IllegalArgumentException();
		}
		shape.draw();
	}
}

