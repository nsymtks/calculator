package calc;

import java.util.Scanner;

/**
 * <p>���ʂ̓d��</p>
 * 
 * �ʏ�̎�����������d��̎����B
 * 
 * �]�����鎮�Ƃ���
 * 
 * (1 + 2 + 3) * 4
 * 
 * �̂悤�Ȏ����󂯎�����ꍇ��
 * 
 * 1 2 + 3 + 4 *
 * 
 * �̂悤�ɋt�|�[�����h�L�@�ɕϊ�����RPNCalculator�N���X�ɏ������Ϗ����܂��B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class Calculator implements ICalculator {

	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.lang.String)
	 */
	@Deprecated
	public Expression calculate(String expression) throws IllegalArgumentException {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.util.Scanner)
	 */
	public Expression calculate(Scanner expression) throws IllegalArgumentException {
		return null;
	}
	
}
