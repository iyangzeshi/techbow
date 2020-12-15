package OOD_Advanced.session02_design_pattern.dependency_injection_pattern;

public class ServerB implements ServerInterface {
	
	private String serverName;
	
	public ServerB() {
		serverName = "serverB";
	}
	
	@Override
	public void processRequest() {
		System.out.println("Process requests using the rules of " + this.serverName);
	}
}
