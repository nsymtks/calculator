package calc.stack;

import java.util.EmptyStackException;

/**
 * <p>�d��X�^�b�N�𑀍삷�邽�߂̃C���^�[�t�F�[�X</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public interface CalculatorStackHandler {

	/**
	 * <p>�d��X�^�b�N�𑀍삵�܂��B</p>
	 * 
	 * �����X�^�b�N�ɐςށB
	 * 
	 * @param stack
	 * @throws EmptyStackException
	 */
	abstract void handle(CalculatorStack stack) throws EmptyStackException;
	
}
