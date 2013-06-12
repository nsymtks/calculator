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
	 * <p>演算子</p>
	 */
	private String operator = null;
	/**
	 * <p>クラス名</p>
	 */
	private String className = null;
	/**
	 * <p>名前</p>
	 */
	private String name = null;
	/**
	 * <p>説明</p>
	 */
	private String description = null;
	
	
	/**
	 * <p>コンストラクタ</p>
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
	 * <p>演算子を取得します。</p>
	 * @return operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * <p>クラス名を取得します。</p>
	 * @return className
	 */
	public String getClassName() {
		return className;
	}
	
	/**
	 * <p>名前を取得します。</p>
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <p>詳細を取得します。</p>
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
}
