package cui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import calc.Expression;
import calc.RPNCalculator;

/**
 * <p>CUI�R�}���h���C��</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public class CUICommand {

	/**
	 * <p>�v�����v�g</p>
	 */
	public static final String C_PROMPT = ">> ";
	/**
	 * <p>�R�}���h���[�h�̃v���t�B�b�N�X</p>
	 */
	public static final String C_COMMAND_PREFIX = ":";
	/**
	 * <p>�I��</p>
	 */
	public static final String C_QUIT_S = "q";
	/**
	 * <p>�I��</p>
	 */
	public static final String C_QUIT_L = "quit";
	/**
	 * <p>�w���v</p>
	 */
	public static final String C_HELP_S = "?";
	/**
	 * <p>�w���v</p>
	 */
	public static final String C_HELP_L = "help";
	
	
	public static void main(String args[]) {
		
		final RPNCalculator calculator = new RPNCalculator();
		
		final BufferedReader r;
		
		try {
			
			r = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("RPN Calculator Ver1.0");
			
			System.out.print(C_PROMPT);
			
			String types = null;
			while((types = r.readLine()) != null) {
				
				types = types.trim();
				
				if (types == null || types.equals("")) {
					System.out.print(C_PROMPT);
					continue;
				}
				
				// �R�}���h���[�h
				if (types.startsWith(C_COMMAND_PREFIX)) {
					
					final Scanner sc = new Scanner(types.substring(1));
					if (!sc.hasNext()) {
						System.out.println("Command unknown");
						System.out.print(C_PROMPT);
						continue;
					}
					
					final String command = sc.next();
					
					// �I��
					if (command.equals(C_QUIT_S) || command.equals(C_QUIT_L)) {
						System.out.println("bye...");
						System.exit(0);
					}
					// �w���v
					else if (command.equals(C_HELP_S) || command.equals(C_HELP_L)) {
						System.out.println("('A`) mando...");
					} else {
						System.err.println("Unknown command: " + command);
					}
					
				}
				// �d�샂�[�h
				else {
					try {
						Expression e = calculator.calculate(new Scanner(types));
						if (e != null) {
							System.out.println("expr = " + e);
							System.out.println("answer = " + e.eval());
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
				
				System.out.print(C_PROMPT);
			}
			
		} catch (Exception e) {
			System.err.println("");
			System.exit(-1);
		}
	}
}
