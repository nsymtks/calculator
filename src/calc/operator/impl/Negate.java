package calc.operator.impl;

import calc.operator.UnaryOperator;


/**
 * <p></p>
 * @author T.Nishiyama
 * @version 1.0
 */
public class Negate extends UnaryOperator {

	/*
	 * (non-Javadoc)
	 * @see calc.Expression#eval()
	 */
	public double eval() {
		return - getOperand().eval();
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.operator.UnaryOperator#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%s(%s))", getOperator(), getOperand());
	}
	
}
