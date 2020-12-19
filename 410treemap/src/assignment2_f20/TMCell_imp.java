//-------------------------------------------------------------------
// put this Interface and Implementation into your code as is
// the grader may need these methods to examine the structure
// that your code creates
//-------------------------------------------------------------------
// you may add methods and structure as you need to
// for example, you may want a toString to help with your debugging
// but to not remove what we have given here
//-------------------------------------------------------------------

package assignment2_f20;

public class TMCell_imp implements TMCell {
	public String key;
	public Value val;
	public TMCell LC;
	public TMCell RC;

	TMCell_imp(String k, Value v) { key = k; val = v; LC = RC = null;}

	@Override
	public void setKey(String newKey) {
		key = newKey;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setValue(Value newValue) {
		val = newValue;
	}

	@Override
	public Value getValue() {
		return val;
	}

	@Override
	public void setLeft(TMCell newLeft) {
		LC = newLeft;
	}

	@Override
	public TMCell getLeft() {
		return LC;
	}

	@Override
	public void setRight(TMCell newRight) {
		RC = newRight;
	}

	@Override
	public TMCell getRight() {
		return RC;
	}
}