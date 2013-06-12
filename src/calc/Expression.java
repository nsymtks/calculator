package calc;

/**
 * <p>式を表すインターフェース</p>
 * 
 * 最小の式は数値を表す（これ、入社前に作った電卓で勉強した記憶ある・・・）
 * この実装が扱う数値は小数点が扱える最大の大きさを持つdouble型とする。
 * 
 * @author T.Nishiyama
 * @version 1.0
 */
public interface Expression {

	/**
	 * <p>式を評価します。</p>
	 * @return
	 */
	public double eval();
	
}
