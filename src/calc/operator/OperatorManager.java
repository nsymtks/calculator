package calc.operator;

import java.util.HashMap;

import org.w3c.dom.Element;

import calc.stack.CalculatorStackHandler;

/**
 * <p></p>
 * @author T.Nishiyama
 * @version 1.0
 */
public class OperatorManager {

	/**
	 * <p></p>
	 */
	private HashMap<String, OperatorConfig> configContainer = null;
	/**
	 * <p></p>
	 */
	private HashMap<String, CalculatorStackHandler> handlerContainer = null;
	
	
	/**
	 * <p>コンストラクタ</p>
	 */
	public OperatorManager() {
		configContainer = new HashMap<String, OperatorConfig>();
		handlerContainer = new HashMap<String, CalculatorStackHandler>();
	}
	
	
	/**
	 * <p>新しく管理する演算子を追加します。</p>
	 * @param element
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Element element) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		final OperatorConfig oc = new OperatorConfig(element);
		
		CalculatorStackHandler handler = 
			(CalculatorStackHandler) Class.forName(oc.getClassName()).newInstance();
		
		// 演算子クラスの場合は演算子を設定する
		if (handler instanceof Operator) {
			((Operator) handler).setOperator(oc.getOperator());
		}
		
		configContainer.put(oc.getClassName(), oc);
		handlerContainer.put(oc.getOperator(), handler);
	}
	
	/**
	 * <p>管理している演算子を全て削除します。</p>
	 */
	public void clear() {
		configContainer.clear();
	}
	
	/**
	 * <p>演算子が使用可能か調べます。</p>
	 * @param operator
	 * @return
	 */
	public boolean containsKey(String operator) {
		return handlerContainer.containsKey(operator);
	}
	
	/**
	 * <p></p>
	 * @param operator
	 * @return
	 */
	public CalculatorStackHandler getHandler(String operator) {
		return handlerContainer.get(operator);
	}
}
