package simulator;

public class InvalidOperationException extends AssemblyException {
	private final String op;
	
	public InvalidOperationException(int line, String op) {
		super(line);
		this.op = op;
	}

	public String toString() {
		return "INVALID OPERATION: "+ op + " @ line " + line + " is unknown.";
	}
}