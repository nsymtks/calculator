package calc.operator;

import java.util.EmptyStackException;

import calc.Expression;
import calc.stack.CalculatorStack;

/**
 * <p>�񍀉��Z�q�̒��ۃN���X</p>
 * 
 * �񍀉��Z�q�͍��I�y�����h�ƉE�I�y�����h�̂Q�����B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public abstract class BinaryOperator extends Operator {

	/**
	 * <p>���I�y�����h</p>
	 */
	private Expression leftOperand = null;
	/**
	 * <p>�E�I�y�����h</p>
	 */
	private Expression rightOperand = null;
	
	
	/**
	 * <p>���I�y�����h���擾���܂��B</p>
	 * @return leftOperand
	 */
	public Expression getLeftOperand() {
		return leftOperand;
	}
	
	/**
	 * <p>���I�y�����h��ݒ肵�܂��B</p>
	 * @param leftOperand ���I�y�����h
	 */
	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}
	
	/**
	 * <p>�E�I�y�����h���擾���܂��B</p>
	 * @return rightOperand
	 */
	public Expression getRightOperand() {
		return rightOperand;
	}
	
	/**
	 * <p>�E�I�y�����h��ݒ肵�܂��B</p>
	 * @param rightOperand �E�I�y�����h
	 */
	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}
	
	/**
	 * <p>�I�y�����h��ݒ肵�܂��B</p>
	 * @param leftOperand ���I�y�����h
	 * @param rightOperand �E�I�y�����h
	 */
	public void setOperands(Expression leftOperand, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%s %s %s)", getLeftOperand(), getOperator(), getRightOperand());
	}
	
	/* (non-Javadoc)
	 * @see calc.stack.CalculatorStackHandler#handle(calc.stack.CalculatorStack)
	 */
	public void handle(CalculatorStack stack) throws EmptyStackException {
		try {
			final BinaryOperator operator = getClass().newInstance();
			operator.setOperator(getOperator());
			operator.setRightOperand(stack.pop());
			operator.setLeftOperand(stack.pop());
			stack.push(operator);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
