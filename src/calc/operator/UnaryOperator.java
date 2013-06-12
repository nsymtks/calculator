package calc.operator;

import java.util.EmptyStackException;

import calc.Expression;
import calc.stack.CalculatorStack;

/**
 * <p>単項演算子の抽象クラス</p>
 * 
 * 単項演算子はオペランドを１つだけ持つ。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public abstract class UnaryOperator extends Operator {

	/**
	 * <p>オペランド</p>
	 */
	private Expression operand = null;
	
	
	/**
	 * <p>オペランドを取得します。</p>
	 * @return operand
	 */
	public Expression getOperand() {
		return operand;
	}
	
	/**
	 * <p>オペランドを設定します。</p>
	 * @param operand オペランド
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
