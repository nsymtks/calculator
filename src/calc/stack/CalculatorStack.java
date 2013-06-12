package calc.stack;

import java.util.EmptyStackException;
import java.util.Stack;

import calc.Expression;

/**
 * <p>電卓スタック</p>
 * 
 * 式を積むためのスタック。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class CalculatorStack {

	/**
	 * <p>スタック</p>
	 */
	private Stack<Expression> stack = null;
	
	
	/**
	 * <p>コンストラクタ</p>
	 */
	public CalculatorStack() {
		stack = new Stack<Expression>();
	}
	
	
	/**
	 * <p>スタックに式を追加します。</p>
	 * @param expression
	 */
	public void push(Expression expression) {
		stack.push(expression);
	}
	
	/**
	 * <p>スタックの先頭から式を取得し、先頭の式はスタックから削除します。</p>
	 * @return
	 * @throws EmptyStackException
	 */
	public Expression pop() throws EmptyStackException {
		return stack.pop();
	}
	
	/**
	 * <p>スタックの先頭から式を取得します。このとき先頭の式は削除されません。</p>
	 * @return
	 * @throws EmptyStackException
	 */
	public Expression peek() throws EmptyStackException {
		return stack.peek();
	}
	
	/**
	 * <p>スタックを空にします。</p>
	 */
	public void clear() {
		stack.clear();
	}
	
	/**
	 * <p>スタックが空かどうか調べます。</p>
	 * @return
	 */
	public boolean empty() {
		return stack.empty();
	}
	
	/**
	 * <p>スタックに積まれている要素数を取得します。</p>
	 * @return
	 */
	public int size() {
		return stack.size();
	}
	
}
