package trees;

public class NodeTree {

    private int data;
    private String name;
    private NodeTree leftChild;
    private NodeTree rightChild;

    public NodeTree(int data, String name) {
        this.data = data;
        this.name = name;
    }

    public String toString() {
        return String.format("%s its date is %s", name, data);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeTree leftChild) {
        this.leftChild = leftChild;
    }

    public NodeTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeTree rightChild) {
        this.rightChild = rightChild;
    }
}
