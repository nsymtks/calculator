package calc.operator;

import calc.Expression;
import calc.stack.CalculatorStackHandler;

/**
 * <p>���Z�q�̒��ۃN���X</p>
 * 
 * {@link Expression#eval()}�͂��̃N���X�̋�ۃN���X�Ŏ�������K�v������܂��B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public abstract class Operator implements Expression, CalculatorStackHandler {

	/**
	 * <p>���Z�q��\��������</p>
	 */
	private String operator = null;
	
	
	/**
	 * <p>���Z�q���擾���܂��B</p>
	 * @return operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * <p>���Z�q��ݒ肵�܂��B</p>
	 * @param operator ���Z�q��\��������
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
