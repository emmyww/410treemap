Basic Tree Map

You will write code that implements and exercises a basic Tree Map. The TreeMap is a MAP ADT built on a Binary Search Tree (BST).

There are plenty of implementations of "tree" stuff out there. Please do not copy those. You may read them for ideas and understanding, but I want you to write your own code and follow the structure I outline below.

The learning in this activity comes from actually powering through all the reasoning needed to get the pointers (object references) and recursive calls hooked up correctly.

In our program, we will have one object (class) as "the TreeMap". We will call the various MAP interface functions such as put, get, hasKey. on that object. There is a field in the TreeMap object that is a link to the root data cell. If the field is null, then there are no nodes in the tree, and its size is 0.

You must write recursive methods yourself to get this assignment correct. The methods that must be recursive are noted in the interface notes following. The BST implementation examples in your text are good patterns to follow in structuring your solution. Note that many are recursive methods.

Keep in mind that many of your methods in TreeMap are similar to BST operations, but are not directly the same... due to the extra MAP behavior and structure mixed in.

The Map Interface

To be as abstract as we can, your code templates below contains two top level interfaces: Map, and TreeMap. The Map interface contains operations that are common to a Map implementation whether it is done via BST or Hash table (or LIST... or any other method). These methods are the put, get, remove, hasKey, and size operations. The put and remove operations are basic data add and delete functions; get is finding data in the structure, specifically giving a key and retrieving the associated value; hasKey tells if a key is already mapped to some value in the Map; size tells how many (key,value) pairs are in the Map. These functions are defined without reference to BST (or any other implementation structure).

Using a Tree to build a Map

We ultimately are implementing a MAP behavior and we are using a BST to provide it. A MAP stores (key,value) pairs, and any specific key can be in the MAP at most once. Said another way, the keys in a MAP must be unique.

To implement a MAP we can use any data organization that allows us to keep track of a collection of (key,value) pairs, to add them and remove them, and to check the uniqueness of any key we try to add. A LIST would do, and would give us O(N) worst case behavior when adding a new pair (since the LIST would be searched to ensure the new key was not already there).

A BST is another option... and we will use a BST in this assignment. Using a BST to implement a MAP allows us to store and retrieve (key,value) pairs in O(log N) average time, so we expect greatly improved execution times than with a LIST. We will see later that a Hash table can also serve as the implementation vehicle and give us O(1) expected times; this speed comes at a cost in other areas... specifically you cannot do one of the things a TreeMap allows -- getting keys out in sorted order. In the Java collections library, you will find both TreeMap and HashMap as implementations of MAP.

In this assignment, the basic idea is to build a BST using the keys (strings here) as data elements for determining cell placement in the tree. Comparing string for "greater than" and "lesser than" will mean using alphabetic order (or dictionary order). The tree cells will also contain a field for the Value object of a (key,value) pair. When you put a (key,value) pair into the MAP, you first add a cell to the BST using the key, and once it is added you put the value object into the tree cell containing the key. See the interface behavior for details. Note that sometimes put does not make a new cell, but alters one already in the tree; this is part of why we said the TreeMap code is not directly BST code.

The TreeMap Interface

The TreeMap interface extends the Map interface and adds a few operations that are possible because the implementation method will be a BST. These include minKey, maxKey, and getKeys (in sorted order). Note that these are possible with a Hash implementation, but they are not efficient. With a BST we can get this information with O(log N) algorithms (as we studied in class).