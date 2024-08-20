import java.util.*;

public class BinaryTreeVer2
{
    static class Node
    {
        int data;
        Node right;
        Node left;

        Node(int data)
        {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree
    {
        static int index = -1;

        public static Node buildTree(int nodes[])
        {
            index++;

            if(nodes[index] == -1)
            {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void inOrder(Node root)       // LEFT - ROOT - RIGHT
        {
            if(root == null)
            {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void preOrder(Node root)       // ROOT - LEFT - RIGHT
        {
            if(root == null)
            {
                return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void postOrder(Node root)       // LEFT - RIGHT - ROOT
        {
            if(root == null)
            {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root)
        {
            if(root == null)
            {
                System.out.println("Tree is Empty!");
                return;
            }

            Queue<Node> q = new LinkedList<>();
            
            q.add(root);
            q.add(null);

            while(!q.isEmpty())
            {
                Node currentNode = q.remove();

                if(currentNode==null)
                {
                    System.out.println();

                    if(q.isEmpty())
                    {
                        break;
                    }

                    else
                    {
                        q.add(null);
                    }
                }

                else
                {
                    System.out.print(currentNode.data+" ");

                    if(currentNode.left != null)
                    {
                        q.add(currentNode.left);
                    }

                    if(currentNode.right != null)
                    {
                        q.add(currentNode.right);
                    }
                }
            }
        }
    }

    public static void main(String [] args)
    {
        int nodes[] = {1,2,4,8,-1,-1,9,-1,-1,5,10,-1,-1,11,-1,-1,3,6,-1,13,-1,-1,7,14,-1,-1,-1};
        
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Checking  
    
        tree.inOrder(root);
        System.out.println();
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        System.out.println();
        tree.levelOrder(root);
        System.out.println();
    }
}
