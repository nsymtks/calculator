package calc.operator;

import calc.Expression;
import calc.stack.CalculatorStackHandler;

/**
 * <p>演算子の抽象クラス</p>
 * 
 * {@link Expression#eval()}はこのクラスの具象クラスで実装する必要があります。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public abstract class Operator implements Expression, CalculatorStackHandler {

	/**
	 * <p>演算子を表す文字列</p>
	 */
	private String operator = null;
	
	
	/**
	 * <p>演算子を取得します。</p>
	 * @return operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * <p>演算子を設定します。</p>
	 * @param operator 演算子を表す文字列
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
