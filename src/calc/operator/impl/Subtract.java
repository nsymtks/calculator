package calc.operator.impl;

import calc.operator.BinaryOperator;


/**
 * <p>���Z�N���X</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public class Subtract extends BinaryOperator {

	/*
	 * (non-Javadoc)
	 * @see calc.Expression#eval()
	 */
	public double eval() {
		return getLeftOperand().eval() - getRightOperand().eval();
	}
	
}
