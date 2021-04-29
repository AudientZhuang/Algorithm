package com.audient._559;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.ArrayList;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {

        Node secondChildren = new Node(2);
        Node thirdChildren = new Node(4);

        Node first_firstChildren = new Node(5);
        Node second_firstChildren = new Node(6);
        List<Node> firstChildrenList = new ArrayList();
        firstChildrenList.add(first_firstChildren);
        firstChildrenList.add(second_firstChildren);
        Node firstChildren = new Node(3,firstChildrenList);
        List<Node> rootChildrenList = new ArrayList<>();
        rootChildrenList.add(firstChildren);
        rootChildrenList.add(secondChildren);
        rootChildrenList.add(thirdChildren);
        Node root = new Node(1,rootChildrenList);

        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);

    }


    static int maxDept = 0;

    public static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            dfs(root, 1);
            return maxDept;

        }
    }

    static void dfs(Node node, int dept) {
        if (node.children == null || node.children.isEmpty()) {
            if (dept > maxDept) {
                maxDept = dept;
            }
            return;
        }
        int index = 0;
        while (index < node.children.size()) {
            index++;
            dept += 1;
            dfs(node.children.get(index - 1), dept);
            dept -= 1;
        }

    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}