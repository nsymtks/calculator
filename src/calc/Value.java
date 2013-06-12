package calc;

/**
 * <p>���l��\���N���X</p>
 * 
 * ���̃N���X�͓����Ńv���~�e�B�u��double�^�������܂��B
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class Value implements Expression, Comparable<Value> {

	/**
	 * <p>�� (NaN) �l��ێ�����萔</p>
	 */
	public static final Value NaN = new Value(Double.NaN);
	/**
	 * <p>���̖�����l��ێ�����萔</p>
	 */
	public static final Value NEGATIVE_INFINITY = new Value(Double.NEGATIVE_INFINITY);
	/**
	 * <p>���̖�����l��ێ�����萔</p>
	 */
	public static final Value POSITIVE_INFINITY = new Value(Double.POSITIVE_INFINITY);
	
	
	/**
	 * <p>���l</p>
	 */
	private final double value;
	
	
	/**
	 * <p>�R���X�g���N�^</p>
	 * @param value
	 */
	public Value(double value) {
		this.value = value;
	}
	
	/*
	 * (non-Javadoc)
	 * @see calc.Expression#eval()
	 */
	public double eval() {
		return value;
	}
	
	@Override
	public String toString() {
		return Double.toString(eval());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Value v) {
		return Double.compare(value, v.eval());
	}
	
}
