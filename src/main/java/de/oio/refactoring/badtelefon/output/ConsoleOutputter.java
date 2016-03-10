package de.oio.refactoring.badtelefon.output;

public class ConsoleOutputter implements Outputter {

	/* (non-Javadoc)
	 * @see de.oio.refactoring.badtelefon.output.Outputter#writeToConsole(java.lang.String)
	 */
	@Override
	public void writeLine(String message1) {
		System.out.println(message1);
	}

}
