package calc.stack;

import java.util.EmptyStackException;
import java.util.Stack;

import calc.Expression;

/**
 * <p>�d��X�^�b�N</p>
 * 
 * ����ςނ��߂̃X�^�b�N�B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class CalculatorStack {

	/**
	 * <p>�X�^�b�N</p>
	 */
	private Stack<Expression> stack = null;
	
	
	/**
	 * <p>�R���X�g���N�^</p>
	 */
	public CalculatorStack() {
		stack = new Stack<Expression>();
	}
	
	
	/**
	 * <p>�X�^�b�N�Ɏ���ǉ����܂��B</p>
	 * @param expression
	 */
	public void push(Expression expression) {
		stack.push(expression);
	}
	
	/**
	 * <p>�X�^�b�N�̐擪���玮���擾���A�擪�̎��̓X�^�b�N����폜���܂��B</p>
	 * @return
	 * @throws EmptyStackException
	 */
	public Expression pop() throws EmptyStackException {
		return stack.pop();
	}
	
	/**
	 * <p>�X�^�b�N�̐擪���玮���擾���܂��B���̂Ƃ��擪�̎��͍폜����܂���B</p>
	 * @return
	 * @throws EmptyStackException
	 */
	public Expression peek() throws EmptyStackException {
		return stack.peek();
	}
	
	/**
	 * <p>�X�^�b�N����ɂ��܂��B</p>
	 */
	public void clear() {
		stack.clear();
	}
	
	/**
	 * <p>�X�^�b�N���󂩂ǂ������ׂ܂��B</p>
	 * @return
	 */
	public boolean empty() {
		return stack.empty();
	}
	
	/**
	 * <p>�X�^�b�N�ɐς܂�Ă���v�f�����擾���܂��B</p>
	 * @return
	 */
	public int size() {
		return stack.size();
	}
	
}
