package calc.stack;

import java.util.EmptyStackException;

/**
 * <p>電卓スタックを操作するためのインターフェース</p>
 * @author T.Nishiyama
 * @version 1.0
 */
public interface CalculatorStackHandler {

	/**
	 * <p>電卓スタックを操作します。</p>
	 * 
	 * 式をスタックに積む。
	 * 
	 * @param stack
	 * @throws EmptyStackException
	 */
	abstract void handle(CalculatorStack stack) throws EmptyStackException;
	
}
