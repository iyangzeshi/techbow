package OOD_Advanced.session02_design_pattern.dependency_injection_pattern;

public class ServerA implements ServerInterface {
	
	private String serverName;
	
	public ServerA() {
		serverName = "serverA";
	}
	
	@Override
	public void processRequest() {
		System.out.println("Process requests using the rules of " + this.serverName);
	}
}
