package calc.operator;

import java.util.EmptyStackException;

import calc.Expression;
import calc.stack.CalculatorStack;

/**
 * <p>�P�����Z�q�̒��ۃN���X</p>
 * 
 * �P�����Z�q�̓I�y�����h���P�������B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public abstract class UnaryOperator extends Operator {

	/**
	 * <p>�I�y�����h</p>
	 */
	private Expression operand = null;
	
	
	/**
	 * <p>�I�y�����h���擾���܂��B</p>
	 * @return operand
	 */
	public Expression getOperand() {
		return operand;
	}
	
	/**
	 * <p>�I�y�����h��ݒ肵�܂��B</p>
	 * @param operand �I�y�����h
	 */
	public void setOperand(Expression operand) {
		this.operand = operand;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%s %s)", getOperator(), getOperand());
	}
	
	/* (non-Javadoc)
	 * @see calc.stack.CalculatorStackHandler#handle(calc.stack.CalculatorStack)
	 */
	public void handle(CalculatorStack stack) throws EmptyStackException {
		
		try {
			final UnaryOperator operator = getClass().newInstance();
			operator.setOperator(getOperator());
			operator.setOperand(stack.pop());
			stack.push(operator);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
