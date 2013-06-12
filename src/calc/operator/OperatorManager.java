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
	 * <p>�R���X�g���N�^</p>
	 */
	public OperatorManager() {
		configContainer = new HashMap<String, OperatorConfig>();
		handlerContainer = new HashMap<String, CalculatorStackHandler>();
	}
	
	
	/**
	 * <p>�V�����Ǘ����鉉�Z�q��ǉ����܂��B</p>
	 * @param element
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Element element) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		final OperatorConfig oc = new OperatorConfig(element);
		
		CalculatorStackHandler handler = 
			(CalculatorStackHandler) Class.forName(oc.getClassName()).newInstance();
		
		// ���Z�q�N���X�̏ꍇ�͉��Z�q��ݒ肷��
		if (handler instanceof Operator) {
			((Operator) handler).setOperator(oc.getOperator());
		}
		
		configContainer.put(oc.getClassName(), oc);
		handlerContainer.put(oc.getOperator(), handler);
	}
	
	/**
	 * <p>�Ǘ����Ă��鉉�Z�q��S�č폜���܂��B</p>
	 */
	public void clear() {
		configContainer.clear();
	}
	
	/**
	 * <p>���Z�q���g�p�\�����ׂ܂��B</p>
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
