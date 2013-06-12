package calc;

import java.util.Scanner;

/**
 * <p>電卓インターフェース</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public interface ICalculator {

	/**
	 * <p>式を評価します。</p>
	 * 
	 * <b><i>{@link Scanner}なんて便利なクラスがあるのでこのメソッドはたぶん実装しません。</i></b>
	 * 
	 * @param expression
	 * @return
	 * @throws IllegalArgumentException
	 */
	@Deprecated
	public Expression calculate(String expression) throws IllegalArgumentException;
	
	/**
	 * <p>式を評価します。</p>
	 * @param expression
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Expression calculate(Scanner expression) throws IllegalArgumentException;
	
}
