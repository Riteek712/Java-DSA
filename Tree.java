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
        

    }
}