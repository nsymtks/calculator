package calc;

/**
 * <p>数値を表すクラス</p>
 * 
 * このクラスは内部でプリミティブなdouble型を扱います。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public class Value implements Expression, Comparable<Value> {

	/**
	 * <p>非数 (NaN) 値を保持する定数</p>
	 */
	public static final Value NaN = new Value(Double.NaN);
	/**
	 * <p>負の無限大値を保持する定数</p>
	 */
	public static final Value NEGATIVE_INFINITY = new Value(Double.NEGATIVE_INFINITY);
	/**
	 * <p>正の無限大値を保持する定数</p>
	 */
	public static final Value POSITIVE_INFINITY = new Value(Double.POSITIVE_INFINITY);
	
	
	/**
	 * <p>数値</p>
	 */
	private final double value;
	
	
	/**
	 * <p>コンストラクタ</p>
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
