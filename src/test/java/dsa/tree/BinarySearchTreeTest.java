package dsa.tree;

import dsa.tree.binary.search.BinarySearchTree;
import dsa.tree.binary.search.BinarySearchTreeImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    @Test
    public void createTree() {
        BinarySearchTree tree = new BinarySearchTreeImp(1);

        assertNotNull(tree);
    }

    @Test
    public void addElementThatIsSmallerThanRoot() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(5);

        tree.add(4);
    }

    @Test
    public void addTwoElementsThatAreSmallerThanRoot() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(5);

        tree.add(4);
        tree.add(3);
    }

    @Test
    public void addElementThatIsBiggerThanRoot() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(5);

        tree.add(10);
    }

    @Test
    public void addFewElementsThatAreBiggerThanRoot() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(5);

        tree.add(10);
        tree.add(15);
    }

    @Test
    public void addToLeftNodeOfRootLeftAndRightSubNode() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);

        tree.add(2);
        tree.add(8);
    }

    @Test
    public void addToRightNodeOfRootLeftAndRightSubNode() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(15);

        tree.add(12);
        tree.add(20);
    }

    @Test
    public void addSameElementToTree() {
        BinarySearchTree tree = new BinarySearchTreeImp(10);

        Exception exception = assertThrows(Exception.class, () -> tree.add(10));
        assertEquals("ElementMustBeUniqueThisElementAlreadyExist", exception.getMessage());
    }

    @Test
    public void addSameElementIfSameElementExistInLeftSide() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);
        tree.add(2);
        tree.add(8);

        assertThrows(Exception.class, () -> tree.add(2));
        assertThrows(Exception.class, () -> tree.add(8));
    }

    @Test
    public void addSameElementIfSameElementExistInRightSide() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(20);
        tree.add(15);
        tree.add(25);

        assertThrows(Exception.class, () -> tree.add(15));
        assertThrows(Exception.class, () -> tree.add(25));
    }

    @Test
    public void removeRootNodeIfItDoesNotHaveSubNodes() {
        BinarySearchTree tree = new BinarySearchTreeImp(10);

        var e = assertThrows(Exception.class, () -> tree.remove(10));
        assertEquals("YouCanNotRemoveRootNodeIfRootNodeDoesNotHaveSubNodes", e.getMessage());
    }

    @Test
    public void removeNodeIfItDoesNotExist() {
        BinarySearchTree tree = new BinarySearchTreeImp(10);

        var e = assertThrows(Exception.class, () -> tree.remove(5));
        assertEquals("NoSuchNode", e.getMessage());
    }

    @Test
    public void removeNodeIfBothSubTreeIsNull() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);
        tree.add(15);

        tree.remove(5);
        tree.remove(15);
    }

    @Test
    public void removeNodeIfBothSubTreeIsNul2() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);
        tree.add(2);
        tree.add(15);
        tree.add(17);

        tree.remove(2);
        tree.remove(17);
    }

    @Test
    public void removeNodeIfNodeHaveOnlyLeftSubTree() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);

        tree.add(8);
        tree.add(6);
        tree.add(7);
        tree.add(5);

        tree.remove(8);

        tree.add(15);
        tree.add(12);
        tree.add(13);
        tree.add(11);

        tree.remove(15);
    }

    @Test
    public void removeNodeIfNodeHaveLeftAndRightSubTree() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);

        tree.add(8);
        tree.add(6);
        tree.add(7);
        tree.add(5);

        tree.add(9);
        tree.remove(8);

        tree.add(15);
        tree.add(12);
        tree.add(13);
        tree.add(11);

        tree.add(16);
        tree.remove(15);
    }

    @Test
    public void removeNodeIfOnlyRightSubTreeExist() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        tree.remove(5);

        tree.add(15);
        tree.add(17);
        tree.add(16);
        tree.add(18);

        tree.remove(15);
    }
    @Test
    public void traverseThroughTree() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);
        tree.add(4);
        tree.add(8);
        tree.add(15);
        tree.add(11);
        tree.add(16);

        assertEquals("10,5,4,8,15,11,16", tree.traverse());
    }
    @Test
    public void tdfd() throws Exception {
        BinarySearchTree tree = new BinarySearchTreeImp(10);
        tree.add(5);
        tree.add(4);
        tree.add(8);
        tree.add(15);
        tree.add(11);
        tree.add(16);

        System.out.println(tree.traverse());
    }

}























