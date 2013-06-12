package calc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import calc.operator.OperatorManager;
import calc.stack.CalculatorStack;

/**
 * <p>RPN電卓</p>
 * 
 * RPN（逆ポーランド記法）電卓の実装。
 *
 * ありきたりのRPN電卓だけど演算子を後々追加できるような実装萌え。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class RPNCalculator implements ICalculator {

	/**
	 * <p>演算子設定ファイル</p>
	 */
	public static final String OPERATOR_CONFIG = "operator-config.xml";
	
	/**
	 * <p>RPN電卓中で使用する演算子を管理するクラス</p>
	 */
	private final OperatorManager operatorManager;
	
	
	/**
	 * <p>コンストラクタ</p>
	 */
	public RPNCalculator() {
		
		operatorManager = new OperatorManager();
		
		/*
		 * RPN電卓で使用する演算子の初期化
		 */
		
		InputStream is = null;
		
		try {
			is = getClass().getClassLoader().getResourceAsStream(OPERATOR_CONFIG);
			load(is);
		} catch (Exception e) {
			System.err.println("RPN電卓の初期化に失敗しました");
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
			} catch (IOException e) { /* noop */ }
		}
	}
	
	/**
	 * <p></p>
	 * @param is
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	private final void load(InputStream is) throws SAXException, IOException, ParserConfigurationException {
		
		final DocumentBuilder docBuilder = 
			DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		final Document doc = docBuilder.parse(is);
		final NodeList nodes = doc.getDocumentElement().getElementsByTagName("operator");
		
		for (int i = 0; i < nodes.getLength(); i++) {
			try {
				Element element = (Element) nodes.item(i);
				operatorManager.add(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.lang.String)
	 */
	@Deprecated
	public Expression calculate(String expression) throws IllegalArgumentException {
		throw new RuntimeException("実装してません");
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.util.Scanner)
	 */
	public Expression calculate(Scanner expression) throws IllegalArgumentException {
		
		final CalculatorStack stack = new CalculatorStack();
		
		// 分解した式に未来があるまで...
		while (expression.hasNext()) {
			
			/*
			 * トークンが数字の場合
			 */
			if (expression.hasNextDouble()) {
				final Value v = new Value(expression.nextDouble());
				stack.push(v);
				continue;
			}
			
			/*
			 * 演算子が来た場合
			 */
			
			String operator = expression.next();
			if (operatorManager.containsKey(operator)) {
				operatorManager.getHandler(operator).handle(stack);
				continue;
			}
		}
		return stack.pop();
	}
	
}
