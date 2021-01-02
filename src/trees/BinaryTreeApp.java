package trees;

public class BinaryTreeApp {

    public static void main(String args[]) {

        BinaryTree binaryTree = new BinaryTree();
        int data[] = {4,7,5,8,23};
        for (int i = 0; i < data.length; i++) {
            binaryTree.addNode(data[i], String.format("N-%s", i));
        }

        if (!binaryTree.isEmpty()) {
            binaryTree.inOrder(binaryTree.getRoot());
        }

    }
}
