package calc.operator;

import java.util.EmptyStackException;

import calc.Expression;
import calc.stack.CalculatorStack;

/**
 * <p>二項演算子の抽象クラス</p>
 * 
 * 二項演算子は左オペランドと右オペランドの２つを持つ。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public abstract class BinaryOperator extends Operator {

	/**
	 * <p>左オペランド</p>
	 */
	private Expression leftOperand = null;
	/**
	 * <p>右オペランド</p>
	 */
	private Expression rightOperand = null;
	
	
	/**
	 * <p>左オペランドを取得します。</p>
	 * @return leftOperand
	 */
	public Expression getLeftOperand() {
		return leftOperand;
	}
	
	/**
	 * <p>左オペランドを設定します。</p>
	 * @param leftOperand 左オペランド
	 */
	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}
	
	/**
	 * <p>右オペランドを取得します。</p>
	 * @return rightOperand
	 */
	public Expression getRightOperand() {
		return rightOperand;
	}
	
	/**
	 * <p>右オペランドを設定します。</p>
	 * @param rightOperand 右オペランド
	 */
	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}
	
	/**
	 * <p>オペランドを設定します。</p>
	 * @param leftOperand 左オペランド
	 * @param rightOperand 右オペランド
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
