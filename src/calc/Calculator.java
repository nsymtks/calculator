package calc;

import java.util.Scanner;

/**
 * <p>普通の電卓</p>
 * 
 * 通常の式を処理する電卓の実装。
 * 
 * 評価する式として
 * 
 * (1 + 2 + 3) * 4
 * 
 * のような式を受け取った場合に
 * 
 * 1 2 + 3 + 4 *
 * 
 * のように逆ポーランド記法に変換してRPNCalculatorクラスに処理を委譲します。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class Calculator implements ICalculator {

	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.lang.String)
	 */
	@Deprecated
	public Expression calculate(String expression) throws IllegalArgumentException {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.util.Scanner)
	 */
	public Expression calculate(Scanner expression) throws IllegalArgumentException {
		return null;
	}
	
}
