package trees;

public class BinaryTree {

    private NodeTree root;

    public BinaryTree() {
    }

    public void addNode(int data, String name) {
        NodeTree nodeTree = new NodeTree(data, name);
        if (isEmpty()) {
            root = nodeTree;
        } else {
            NodeTree aux = root;
            NodeTree parent = null;
            while (true) {
                parent = aux;
                if (data < aux.getData()) {
                    aux = aux.getLeftChild();
                    if (aux == null) {
                        parent.setLeftChild(nodeTree);
                        return;
                    }
                } else {
                    aux = aux.getRightChild();
                    if (aux == null) {
                        parent.setRightChild(nodeTree);
                        return;
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void inOrder(NodeTree root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root);
            inOrder(root.getRightChild());
        }
    }

    public NodeTree getRoot() {
        return root;
    }
}
