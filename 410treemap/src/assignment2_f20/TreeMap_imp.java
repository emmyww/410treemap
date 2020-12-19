package assignment2_f20;

//--------------------------------------------------------------

public class TreeMap_imp implements TreeMap { 
  TMCell root;
  // add fields as you need to in order to provide the required behavior
  // also you may add private methods to assist you as needed
  // in implementing
  
  //-------------------------------------------------------------

  TreeMap_imp () { root = null; 
    // for added fields you can add appropriate initialization code here
  }

  //-------------------------------------------------------------

  // dont change, we need this for grading
  @Override
  public TMCell getRoot() { 
	  return this.root; 
	  }
  
  //-------------------------------------------------------------
  // "height" is a complete implementation 
  // of the public interface method height
  // it is here to illustrate fr you how the textbook sets up 
  // the method implementation as recursion
  // you may include this in your project directly

  public int height() { // public interface method signature
  // this method is the public interface method
  // it is not recursive, but it calls a recursive
  // private method and passes it access to the tree cells
    return height_r(this.getRoot());
  }
  private int height_r(TMCell c) { 
  // inner method with different signature
  // this helper method uses recursion to traverse
  // and process the recursive structure of the tree of cells
    if (c==null) return -1;
    int lht = height_r(c.getLeft());
    int rht = height_r(c.getRight());
    return Math.max(lht,rht) + 1;
  }
  
  //-------------------------------------------------------------
  // here down... you fill in the implementations for
  // the other interface methods
  //-------------------------------------------------------------
  //
  // remember to implement the required recursion as noted
  // in the interface definition
  //
  //-------------------------------------------------------------
  

@Override
public Value put(String k, Value v) {
	if (root == null) {
		root = new TMCell_imp(k,v);
		return null;
	} else {
	return put_r(root,k, v);
	}
}
private Value put_r(TMCell c, String k, Value v) {
	if (c == null) {
		c = new TMCell_imp(k,v); 
		return null;
	}
	int compare = k.compareTo(c.getKey());
	
	if (compare < 0) {
		if (c.getLeft()==null) {
			TMCell l = new TMCell_imp(k,v);
			c.setLeft(l);
			return null;
		}
		return put_r(c.getLeft(),k,v);
	} else if (compare > 0) {
		if (c.getRight()==null) {
			TMCell r = new TMCell_imp(k,v);
			c.setRight(r);
			return null;
		}
		return put_r(c.getRight(),k,v);
	} else { //if (compare == 0){
		Value old = c.getValue();
		c.setValue(v);
		return old;
	}
}

	

@Override
public Value get(String k) {
	if (root == null){
		return null;
	}
	return get_r(root,k);
	}

private Value get_r(TMCell root, String k) {
	int compare = k.compareTo(root.getKey());
	if (compare == 0) {
		return root.getValue();
	} else if (compare <0) {
		return get_r(root.getLeft(),k);
	} else {
		return get_r(root.getRight(),k);
	}
}

@Override
public void remove(String k) {
	this.root = remove_r(root,k);
	}
private TMCell remove_r(TMCell root, String k) {
	if (root == null) {
		return root;
	}
	int compare = k.compareTo(root.getKey());
	if (compare < 0) {
		root.setLeft(remove_r(root.getLeft(), k)); 
	} else if (compare > 0) {
		root.setRight(remove_r(root.getRight(), k));
	} else {
		// only one child
		if (root.getLeft() == null) {
			return root.getRight(); 
		} else if (root.getRight() == null) {
			return root.getLeft();
		}
		// two children
		root.setKey(minCell(root.getRight()).getKey());
		root.setValue(minCell(root.getRight()).getValue());
		root.setRight(remove_r(root.getRight(), minCell(root.getRight()).getKey()));
	}
	return root;
}
private TMCell minCell(TMCell c) {
	if (c.getLeft() == null) {
		return c;
	}
	return minCell(c.getLeft());
	
}

@Override
public boolean hasKey(String k) {
	this.root = hasKey_r(root,k);
	if (root != null) {
		return true;
	} else {
		return false;
	}

}
private TMCell hasKey_r(TMCell root, String k) {
	if (root == null || root.getKey().equals(k)) {
		return root;
	}
	int compare = k.compareTo(root.getKey());
	if (compare < 0) {
		return hasKey_r(root.getLeft(),k);
	} else if (compare > 0) {
		return hasKey_r(root.getRight(),k);
	} else { //if (root == null || compare ==0)
		return root;
	}
}

@Override
public int size() {
	return size_r(root);
}

private int size_r (TMCell root) {;
	if (root == null) {
		return 0;
	}
	return size_r(root.getLeft()) + 1 + size_r(root.getRight());
}

@Override
public String maxKey() {
	if (size() == 0) {
		return null;
	}
	return maxKey_r(root);
}
private String maxKey_r(TMCell root) {
	if (root == null) {
		return null;
	}
	if (root.getRight() == null) {
		return root.getKey();
	}
	return maxKey_r(root.getRight());
}


@Override
public String minKey() {
	if (size() == 0) {
		return null;
	}
	return minKey_r(root);
}
private String minKey_r(TMCell root) {
	if (root == null) {
		return null;
	}
	if (root.getLeft() == null) {
		return root.getKey();
	}
	return minKey_r(root.getLeft());
}


@Override
public String[] getKeys() {
	String [] arr = new String[size()];
	int index = 0;
	return getKeys_r(this.root, arr, index);
}
private String[] getKeys_r(TMCell root, String [] arr, int index) {
	if (root == null || size() == 0 || arr == null) {
		return null;
	}
	if (root.getLeft() != null) {
		getKeys_r(root.getLeft(), arr, index);
	}
		arr[index++] = root.getKey();
	if (root.getRight() != null) {
		getKeys_r(root.getRight(), arr, index);
	}
		return arr;
}
}


