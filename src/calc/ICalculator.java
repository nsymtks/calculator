package calc;

import java.util.Scanner;

/**
 * <p>�d��C���^�[�t�F�[�X</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public interface ICalculator {

	/**
	 * <p>����]�����܂��B</p>
	 * 
	 * <b><i>{@link Scanner}�Ȃ�ĕ֗��ȃN���X������̂ł��̃��\�b�h�͂��Ԃ�������܂���B</i></b>
	 * 
	 * @param expression
	 * @return
	 * @throws IllegalArgumentException
	 */
	@Deprecated
	public Expression calculate(String expression) throws IllegalArgumentException;
	
	/**
	 * <p>����]�����܂��B</p>
	 * @param expression
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Expression calculate(Scanner expression) throws IllegalArgumentException;
	
}
