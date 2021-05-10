import java.util.ArrayList;
import java.util.Array;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.PrintStream;

class BinaryTree{

    class Node {
        int value;
        Node left, right;
    
        Node(int value) {
            this.value = value;
            left = right = null;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
        }
    }

    Node root;

    BinarySearchTree(){  
        root = null;  
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public String traversePreOrder(Node node) {

        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }


    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
            paddingBuilder.append("│  ");
            } else {
            paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);

        }
    }

    public void print(PrintStream os, Node node) {
        os.print(traversePreOrder(node));
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    // public void inorder(){  
    //         System.out.println("Tree Elements are:");
    //         inorderRec(root);  
    // } 
      
    // void inorderRec(Node root) { 
    //     if (root != null) { 
    //         inorderRec(root.left);
    //         System.out.print(" ");
    //         System.out.print(root.value); 
    //         inorderRec(root.right); 
    //     } 
    // } 
}

class BinarySearchTree {
    
    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree(); 

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to create a new tree");
        System.out.println("(e.g., 1, 5, 2, 7, 100, 3, 10, 23)");
        String line = scanner.nextLine();
        String[] numberStrs = line.split(", ");
        int[] numbers = new int[numberStrs.length];
        int menuNum;

        for(int i = 0;i < numberStrs.length;i++){
            numbers[i] = Integer.parseInt(numberStrs[i]);
            tree.add(numbers[i]);
        };

        do{

            System.out.println(" ");
            System.out.println("******************");
            System.out.println("1 : Add a node ");
            System.out.println("2 : Delete a node ");      
            System.out.println("3 : Print the tree ");
            System.out.println("9 : Exit");
            System.out.println("******************");
            
            menuNum = scanner.nextInt();

            switch(menuNum){
            case 1:
                {
                    System.out.println("Enter the new node element :");
                    int addNode = scanner.nextInt();
                    tree.add(addNode);
                    break;
                }
          
            case 2:
                {
                    System.out.println("Enter the node element to be deleted :");
                    int deleteNode = scanner.nextInt();
                    tree.delete(deleteNode);
                    break;
                }
          
            case 3:
                {
                    //tree.inorder();
                    System.out.println();
                    tree.print(System.out, tree.root);
                    break;
                }

            case 9:
                {
                    System.out.println("Bye!!");
                    break;
                }
              
            default:
                System.out.println("Wrong number");
            }

        }while(menuNum != 9);
    }
}
