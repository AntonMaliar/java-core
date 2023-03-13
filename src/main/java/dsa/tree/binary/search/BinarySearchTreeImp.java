package dsa.tree.binary.search;

public class BinarySearchTreeImp implements BinarySearchTree {
    private Node root;
    private Node previousNode;
    private Node neededNode;
    public BinarySearchTreeImp(int rootValue){
        root = new Node(rootValue);
    }

    @Override
    public void add(int value) throws Exception {
        var currentNode = root;

        while (true){
            if(currentNode.getValue() == value) throw new Exception("ElementMustBeUniqueThisElementAlreadyExist");
            //left
            if(value < currentNode.getValue()){
                if(currentNode.getLeftNode() == null){
                    currentNode.setLeftNode(new Node(value));
                    break;
                }
                currentNode = currentNode.getLeftNode();
            }else{ //right
                if(currentNode.getRightNode() == null){
                    currentNode.setRightNode(new Node(value));
                    break;
                }
                currentNode = currentNode.getRightNode();
            }
        }
    }

    @Override
    public void remove(int value) throws Exception {
        if (root.getValue() == value && root.getLeftNode() == null && root.getRightNode() == null) {
            throw new Exception("YouCanNotRemoveRootNodeIfRootNodeDoesNotHaveSubNodes");
        }
        findNode(value);
        var leftSubTree = neededNode.getLeftNode();
        var rightSubTree = neededNode.getRightNode();
        if(leftSubTree != null) {
            removeIfLeftSubTreeExist(leftSubTree, rightSubTree);
            return;
        }
        if(rightSubTree != null) {
            findPositionInPreviousNode(rightSubTree);
            return;
        }
        findPositionInPreviousNode(null);

    }
    private void findNode(int value) throws Exception {
        neededNode = root;
        //find node
        while (true) {
            if(neededNode == null) throw new Exception("NoSuchNode");
            if(neededNode.getValue() == value) break;
            if(value < neededNode.getValue()) {
                previousNode = neededNode;
                neededNode = neededNode.getLeftNode();
            }else {
                previousNode = neededNode;
                neededNode = neededNode.getRightNode();
            }
        }
    }
    private void removeIfLeftSubTreeExist(Node leftSubTree, Node rightSubTree) {
        if(rightSubTree != null) {
            if(leftSubTree.getRightNode() == null) {
                leftSubTree.setRightNode(rightSubTree);
            }else {
                var rightNodeOfLeftSubTree = leftSubTree.getRightNode();
                while (rightNodeOfLeftSubTree.getRightNode() != null) {
                    rightNodeOfLeftSubTree = rightNodeOfLeftSubTree.getRightNode();
                }
                rightNodeOfLeftSubTree.setRightNode(rightSubTree);
            }
        }
        findPositionInPreviousNode(leftSubTree);
    }
    private void findPositionInPreviousNode(Node node) {
        if(previousNode.getValue() > neededNode.getValue()) {
            previousNode.setLeftNode(node);
        }
        else {
            previousNode.setRightNode(node);
        }
    }

    @Override
    public String traverse () {
        StringBuilder result = new StringBuilder();
        result.append(root.getValue());

        traverseNode(root.getLeftNode(), result);
        traverseNode(root.getRightNode(), result);

        return result.toString();
    }

    private void traverseNode(Node node, StringBuilder result) {
        if(node != null) {
            result.append(",").append(node.getValue());
            if(node.getLeftNode() != null) traverseNode(node.getLeftNode(), result);
            if(node.getRightNode() != null) traverseNode(node.getRightNode(), result);
        }
    }

}


