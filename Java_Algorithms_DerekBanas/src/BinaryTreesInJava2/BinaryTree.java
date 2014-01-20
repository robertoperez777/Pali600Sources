package BinaryTreesInJava2;

public class BinaryTree {

	Node root;

	public void addNode(int key, String name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (this.root == null) {

			this.root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = this.root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.key) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			this.preorderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			this.preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			this.preorderTraverseTree(focusNode.leftChild);
			this.preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			this.preorderTraverseTree(focusNode.leftChild);
			this.preorderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = this.root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			// If we should search to the left

			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null) {
				return null;
			}

		}

		return focusNode;

	}

	public boolean remove(int key) {

		// Start at the top of the tree

		Node focusNode = this.root;
		Node parent = this.root;

		// When searching for a Node this will
		// tell us whether to search to the
		// right or left

		boolean isItALeftChild = true;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			parent = focusNode;

			// If we should search to the left

			if (key < focusNode.key) {

				isItALeftChild = true;

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Greater than focus node so go to the right

				isItALeftChild = false;

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null) {
				return false;
			}

		}

		// If Node doesn't have children delete it

		if ((focusNode.leftChild == null) && (focusNode.rightChild == null)) {

			// If root delete it

			if (focusNode == this.root) {
				this.root = null;
			} else if (isItALeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}

		}

		// If no right child

		else if (focusNode.rightChild == null) {

			if (focusNode == this.root) {
				this.root = focusNode.leftChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.leftChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}

		}

		// If no left child

		else if (focusNode.leftChild == null) {

			if (focusNode == this.root) {
				this.root = focusNode.rightChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.rightChild;
			} else {
				parent.rightChild = focusNode.rightChild;
			}

		}

		// Two children so I need to find the deleted nodes
		// replacement

		else {

			Node replacement = this.getReplacementNode(focusNode);

			// If the focusNode is root replace root
			// with the replacement

			if (focusNode == this.root) {
				this.root = replacement;
			} else if (isItALeftChild) {
				parent.leftChild = replacement;
			} else {
				parent.rightChild = replacement;
			}

			replacement.leftChild = focusNode.leftChild;

		}

		return true;

	}

	public Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		// While there are no more left children

		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}

		// If the replacement isn't the right child
		// move the replacement into the parents
		// leftChild slot and move the replaced nodes
		// right child into the replacements rightChild

		if (replacement != replacedNode.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;

		}

		return replacement;

	}

	public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(85, "Salesman 1");

		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 75");

		System.out.println(theTree.findNode(75));

		System.out.println("Remove Key 25");

		theTree.remove(25);

		System.out.println(theTree.findNode(25));

		theTree.inOrderTraverseTree(theTree.root);

	}
}

class Node {

	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {

		this.key = key;
		this.name = name;

	}

	@Override
	public String toString() {

		return this.name + " has the key " + this.key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}

}