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
 * <p>RPN�d��</p>
 * 
 * RPN�i�t�|�[�����h�L�@�j�d��̎����B
 *
 * ���肫�����RPN�d�삾���ǉ��Z�q����X�ǉ��ł���悤�Ȏ����G���B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class RPNCalculator implements ICalculator {

	/**
	 * <p>���Z�q�ݒ�t�@�C��</p>
	 */
	public static final String OPERATOR_CONFIG = "operator-config.xml";
	
	/**
	 * <p>RPN�d�쒆�Ŏg�p���鉉�Z�q���Ǘ�����N���X</p>
	 */
	private final OperatorManager operatorManager;
	
	
	/**
	 * <p>�R���X�g���N�^</p>
	 */
	public RPNCalculator() {
		
		operatorManager = new OperatorManager();
		
		/*
		 * RPN�d��Ŏg�p���鉉�Z�q�̏�����
		 */
		
		InputStream is = null;
		
		try {
			is = getClass().getClassLoader().getResourceAsStream(OPERATOR_CONFIG);
			load(is);
		} catch (Exception e) {
			System.err.println("RPN�d��̏������Ɏ��s���܂���");
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
		throw new RuntimeException("�������Ă܂���");
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.ICalculator#calculate(java.util.Scanner)
	 */
	public Expression calculate(Scanner expression) throws IllegalArgumentException {
		
		final CalculatorStack stack = new CalculatorStack();
		
		// �����������ɖ���������܂�...
		while (expression.hasNext()) {
			
			/*
			 * �g�[�N���������̏ꍇ
			 */
			if (expression.hasNextDouble()) {
				final Value v = new Value(expression.nextDouble());
				stack.push(v);
				continue;
			}
			
			/*
			 * ���Z�q�������ꍇ
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
