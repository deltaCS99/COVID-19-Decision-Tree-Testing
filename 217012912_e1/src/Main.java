import java.util.Iterator;
import java.util.Scanner;

//Overall correctness: 15 marks **********************************************************************
//Overall for Main class: 10 marks *******************************************************************
//COVID-19 decision tree based on www.holzer.org/app/files/public/1265/COVID-19-Decision-Tree-Testing.jpg
public class Main {
	
	public static void main(String[] args) {		
		
		BTNode<String> rootNode = new BTNode<String>(null, null, null, "Are you having COVID-19 symptoms? (Y/N)");		
		
		BTNode<String> leftParentNode = new BTNode<String>(rootNode, null, null, "Are your symptoms severe? (Y/N)");
		rootNode.setLeft(leftParentNode);
		
		BTNode<String> leftKidNode = new BTNode<String>(leftParentNode, null, null, "Call your doctor.");
		leftParentNode.setLeft(leftKidNode);

		BTNode<String> rightKidNode = new BTNode<String>(leftParentNode, null, null, "Are you over 60 years old? (Y/N)");
		leftParentNode.setRight(rightKidNode);
		
		BTNode<String> leftGrandKidNode = new BTNode<String>(rightKidNode, null, null, "Call your doctor to determine if testing is needed.");
		rightKidNode.setLeft(leftGrandKidNode);
		
		BTNode<String> rightGrandKidNode = new BTNode<String>(rightKidNode, null, null, "Testing is not needed. Self-quaratine for 14 days.");
		rightKidNode.setRight(rightGrandKidNode);
		
		BTNode<String> rightParentNode = new BTNode<String>(rootNode, null, null, "Testing is not needed.");
		rootNode.setRight(rightParentNode);							
		
		
		BinaryTree<String> bt = new BinaryTree<String>(rootNode);
		
		System.out.println("Pre-order traversal test:");
		PositionList<String> out = new PositionList<String>();
		bt.PreorderElementTraversal(out, bt.root());		
		System.out.println(out);
		System.out.println("");
		
		System.out.println("In-order traversal test:");
		out = new PositionList<String>();
		bt.InorderElementTraversal(out, bt.root());		
		System.out.println(out);
		System.out.println("");
		
		System.out.println("Post-order traversal test:");
		out = new PositionList<String>();
		bt.PostOrderElementTraversal(out, bt.root());		
		System.out.println(out);
		System.out.println("");
					
		System.out.println("====================================================");
		System.out.println("	Starting COVID-19 Testing Decision Program");
		System.out.println("====================================================");
		System.out.println("");
		
		/*
		 * Using the built decision tree ask the user and provide the appropriate answers, 
		 * so that they may be able to determine if they need to be tested and terminate
		 * once a final answer is given. 
		 */
		//10 marks ***********************************************************************************
		//TODO: Complete
		
		Scanner in = new Scanner(System.in);
		
		BTPosition<String> ref = bt.root();
		
		while(ref.right()!= null && ref.left()!= null) {
			
			System.out.println(ref.toString());
			
			String ans = in.nextLine();
			
			if(ans.equalsIgnoreCase("N")) {
				
				ref = ref.right();
				
				if(ref.right()== null && ref.left()== null)
					System.out.println(ref.toString());
				
			}else if(ans.equalsIgnoreCase("Y")) {
				ref = ref.left();

				if(ref.right()== null && ref.left()== null)
					System.out.println(ref.toString());
			}
				
		}
		
	}
	
}
