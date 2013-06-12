package calc.operator;

import org.w3c.dom.Element;

/**
 * <p></p>
 * @author T.Nishiyama
 * @version 1.0
 */
public class OperatorConfig {

	/**
	 * <p></p>
	 */
	public static final String ATTRIBUTE_ID = "id";
	/**
	 * <p></p>
	 */
	public static final String ATTRIBUTE_CLASSNAME = "className";
	/**
	 * <p></p>
	 */
	public static final String ELEMENT_NAME = "name";
	/**
	 * <p></p>
	 */
	public static final String ELEMENT_DESCRIPTION = "description";
	
	
	/**
	 * <p>���Z�q</p>
	 */
	private String operator = null;
	/**
	 * <p>�N���X��</p>
	 */
	private String className = null;
	/**
	 * <p>���O</p>
	 */
	private String name = null;
	/**
	 * <p>����</p>
	 */
	private String description = null;
	
	
	/**
	 * <p>�R���X�g���N�^</p>
	 */
	public OperatorConfig(Element element) {
		
		operator = element.getAttribute(ATTRIBUTE_ID);
		
		className = element.getAttribute(ATTRIBUTE_CLASSNAME);
		
		try {
			name =
				element.getElementsByTagName(ELEMENT_NAME).item(0).getFirstChild().getNodeValue();
			name.trim();
		} catch (Exception e) {
			// noop
		}
		try {
			description = 
				element.getElementsByTagName(ELEMENT_DESCRIPTION).item(0).getFirstChild().getNodeValue();
			description.trim();
		} catch (Exception e) {
			// noop
		}
		
	}
	
	
	/**
	 * <p>���Z�q���擾���܂��B</p>
	 * @return operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * <p>�N���X�����擾���܂��B</p>
	 * @return className
	 */
	public String getClassName() {
		return className;
	}
	
	/**
	 * <p>���O���擾���܂��B</p>
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <p>�ڍׂ��擾���܂��B</p>
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
}
