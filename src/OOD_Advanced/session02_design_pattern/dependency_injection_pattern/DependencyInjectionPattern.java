package OOD_Advanced.session02_design_pattern.dependency_injection_pattern;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.dependencyInjectionDesignPattern
//ClassName: DependencyInjectionPattern
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 23:26

// class Client {
//
// 	private ServerInterface server;
//
// 	public Client() {
// 		server = new Server();
// 	}
//
// }

public class DependencyInjectionPattern {
	
	public static void main(String[] args) {
		Client clientA = new Client(new ServerA());
		clientA.processRequest();
		
		Client clientB = new Client(new ServerB());
		clientB.processRequest();
	}
}

