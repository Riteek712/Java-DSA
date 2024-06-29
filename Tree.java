import java.util.*;

class Tree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int value){
            // Object self;
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }


    static class BinaryTree {
        static int idx = -1;
        public static Node buildNode(int nodes[])
        {
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildNode(nodes);
            newNode.right = buildNode(nodes);
            return newNode;
        }
        

    }
    static public void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
        } 
    static public void inorder(Node root){
        if(root == null) return;
        preorder(root.left);
        System.out.print(root.data+ " ");
        preorder(root.right);
    } 
    static public void postorder(Node root){
        if(root == null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data+ " ");
        
    }
    public static void levelOrder( Node root)
    {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()) break;
                else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
            }
        }

    }
    public static int countNodes(Node root)
    {
        if(root == null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes +rightNodes +1;
    }

    public static int sumOfNodes(Node root)
    {
        if(root == null) return 0;
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);
        return (leftsum +rightsum +root.data);

    }
    public static int height(Node root)
    {
        if(root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH, rightH)+1;

    }
    public static int diameter(Node root)
    {
        if(root == null) return 0;
        int d1 = diameter(root.left);
        int d2 = diameter(root.right);
        int d3 = height(root.left) +height(root.right) +1;
        return Math.max(d3, Math.max(d2, d1));
    }
    static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int h, int d){
            this.ht = h;
            this.dia = d;
        }
    }
    public static TreeInfo diameter2(Node root){
        if (root == null ) {
            return new TreeInfo(0, 0);
        }

        TreeInfo lefttf = diameter2(root.left);
        TreeInfo righttf = diameter2(root.right);

        int myHeight = Math.max(lefttf.ht, righttf.ht) +1;

        int dia1 = lefttf.dia;
        int dia2 = righttf.dia;
        int dia3 = lefttf.ht + righttf.ht +1;

        int myDia = Math.max(Math.max(dia1, dia2), dia3); 

        TreeInfo myInfo = new TreeInfo(myHeight, myDia);
        return myInfo;



    }


    

    public static void main(String[] args)
    {
        System.out.println("Hello WOrld!");
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildNode(nodes);
        System.out.println(root.data);
        preorder(root);
        System.out.println(" ");
        inorder(root);
        System.out.println(" ");
        postorder(root);
        System.out.println(" ");
        levelOrder(root);
        System.out.println("Count of nodes: " + countNodes(root));
        System.out.println("Sum of nodes: " + sumOfNodes(root));
        System.out.println("Diameter in O(n^2): " + diameter(root));
        System.out.println("Diameter in O(n): " + diameter2(root).dia);

    }
}