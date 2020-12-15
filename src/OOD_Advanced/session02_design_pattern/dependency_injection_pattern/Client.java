package OOD_Advanced.session02_design_pattern.dependency_injection_pattern;

public class Client {
	
	private ServerInterface server;
	
	public Client(ServerInterface serverImp) {
		this.server = serverImp;
	}
	
	public void processRequest() {
		this.server.processRequest();
	}
}
