package com.ps.trees.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
 * Created by piyush_sagar on 9/19/18.
 *
 *                         Tree
 *
 *                          9
 *                       /     \
 *                      6      15
 *                    /  \     /  \
 *                   3   7    11   18
 *                  /
 *                 2
 */

public class BSTTest {

    BST bst = BST.create();

    @Before
    public void beforeEach() {
        bst.clear();
    }

    @Test
    public void testBSTInitialization() {
        Assert.assertEquals(0, bst.getNodeCount());
        Assert.assertEquals(null, bst.getRoot());
    }

    @Test
    public void testInsert() {
        bst.insert(5);
        bst.insert(8);
        bst.insert(8);
        Assert.assertEquals(2, bst.getNodeCount());
    }

    @Test
    public void testPreorder() {
        fillBST();
        List<Integer> expectedPreoder = Arrays.asList(9, 6, 3, 2, 7, 15, 11, 18);
        List<Integer> preorder = bst.preOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
    }

    @Test
    public void testInorder() {
        fillBST();
        List<Integer> expectedPreoder = Arrays.asList(2, 3, 6, 7, 9, 11, 15, 18);
        List<Integer> inorder = bst.inOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(inorder));
    }

    @Test
    public void testPostorder() {
        fillBST();
        List<Integer> expectedPreoder = Arrays.asList(2, 3, 7, 6, 11, 18, 15, 9);
        List<Integer> postorder = bst.postOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(postorder));
    }

    @Test
    public void testFindMin() {
        fillBST();
        Node node = bst.findMin();
        Assert.assertEquals(2, node.data);

        bst.clear();
        node = bst.findMin();
        Assert.assertEquals(null, node);
    }

    @Test
    public void testFindMax() {
        fillBST();
        Node node = bst.findMax();
        Assert.assertEquals(18, node.data);

        bst.clear();
        node = bst.findMax();
        Assert.assertEquals(null, node);
    }

    @Test
    public void testGetHeight() {
        fillBST();
        int height = bst.getHeight();
        Assert.assertEquals(3, height);

        bst.clear();
        height = bst.getHeight();
        Assert.assertEquals(0, height);
    }

    @Test
    public void testFind() {
        fillBST();
        int dataToFind = 3;
        Node node = bst.find(dataToFind);
        Assert.assertEquals(dataToFind, node.data);

        node = bst.find(dataToFind + 108);
        Assert.assertEquals(null, node);

        bst.clear();
        node = bst.find(dataToFind);
        Assert.assertEquals(null, node);
    }

    @Test @Ignore
    public void testFindSuccessor() {
        fillBST();
        Node node = bst.findSuccessor(3);
        Assert.assertEquals(6, node.data);

        node = bst.findSuccessor(18);
        Assert.assertEquals(null, node);

        bst.clear();
        node = bst.findSuccessor(18);
        Assert.assertEquals(null, node);
    }

    @Test
    public void testDelete() {
        // Delete leaf node
        fillBST();
        Node node = bst.delete(7);
        List<Integer> expectedPreoder = Arrays.asList(9, 6, 3, 2, 15, 11, 18);
        List<Integer> preorder = bst.preOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
        Assert.assertEquals(expectedPreoder.size(), bst.getNodeCount());

        // Delete node with left child
        bst.clear();
        fillBST();
        node = bst.delete(3);
        expectedPreoder = Arrays.asList(9, 6, 2, 7, 15, 11, 18);
        preorder = bst.preOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
        Assert.assertEquals(expectedPreoder.size(), bst.getNodeCount());

        // Delete node with two child
        bst.clear();
        fillBST();
        node = bst.delete(6);
        expectedPreoder = Arrays.asList(9, 7, 3, 2, 15, 11, 18);
        preorder = bst.preOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
        Assert.assertEquals(expectedPreoder.size(), bst.getNodeCount());

        bst.clear();
        fillBST();
        node = bst.delete(4);
        expectedPreoder = Arrays.asList(9, 6, 3, 2, 7, 15, 11, 18);
        preorder = bst.preOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
        Assert.assertEquals(expectedPreoder.size(), bst.getNodeCount());
    }

    @Test
    public void testMirrorTree() {
        fillBST();
        bst.mirrorTree();
        List<Integer> expectedPreoder = Arrays.asList(9, 15, 18, 11, 6, 7, 3, 2);
        List<Integer> preorder = bst.preOrderTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
        Assert.assertEquals(expectedPreoder.size(), bst.getNodeCount());
    }

    @Test
    public void testBFSTraversal() {
        fillBST();
        List<Integer> expectedPreoder = Arrays.asList(9, 6, 15, 3, 7, 11, 18, 2);
        List<Integer> preorder = bst.BFSTraversal();
        Assert.assertTrue(expectedPreoder.equals(preorder));
        Assert.assertEquals(expectedPreoder.size(), bst.getNodeCount());
    }

    private void fillBST() {
        List<Integer> nodes = Arrays.asList(9, 6, 15, 3, 7, 11, 18, 2);
        nodes.forEach(data -> bst.insert(data));
    }
}
