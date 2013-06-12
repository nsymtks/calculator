package calc.operator.impl;

import calc.operator.BinaryOperator;


/**
 * <p>æZƒNƒ‰ƒX</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public class Multiply extends BinaryOperator {

	/*
	 * (non-Javadoc)
	 * @see calc.Expression#eval()
	 */
	public double eval() {
		return getLeftOperand().eval() * getRightOperand().eval();
	}
	
}
