package gaming;
import java.util.Scanner;
import java.util.Stack;
public class Calculator
{
	static Stack<Integer> stk;
	static Stack<Character> infixStack;
	/*
	 * 
	 */
	public static String infixToPostfix(String str){
		
		infixStack = new Stack<Character>();
	    String postfix = "";
	    for(int i = 0 ; i < str.length() ; i++){
	        char st = str.charAt(i);
	        if(st == ' ' || st == ',') {continue;}

	        else if(Operator(st)){
	            while(!infixStack.isEmpty() && infixStack.peek() != '(' && Precedence(infixStack.peek(),st)) { 
	                postfix += infixStack.peek();
	                infixStack.pop();
	            }
	            infixStack.push(st);
	        }
	        else if(Operand(st))
	            postfix += st;
	        else if (st == '(')
	            infixStack.push(st);
	        else if(st == ')')
	        {
	            while(!infixStack.isEmpty() && infixStack.peek() !=  '(') {
	                postfix += infixStack.peek();
	                infixStack.pop();
	            }
	            infixStack.pop();
	        }
	    }

	    while(!infixStack.isEmpty() && infixStack.peek() !=  '(') {
	        postfix += infixStack.peek();
	        infixStack.pop();
	    }

	    return postfix;
	}
	
	public static boolean Operand(char st) {
		if(st >= '0' && st <= '9')
			return true;
        else 
        	return false;
	}
	
	public static boolean Operator(char st) {
	    if(st == '+' || st == '-' || st == '*' || st == '/')
	    	return true;
	    else 
	    	return false;
	}
	
	public static int OperatorWeight(char st) {
	    int weight = -1;
	    switch(st){
	    case '(': return weight = 0;
	    case ')': return weight = 0;
	    case '+': return weight = 1;
	    case '-': return weight = 1;
	    case '*': return weight = 2;
	    case '/': return weight = 2;
	    default: return weight;
	    }
	}
	
	public static boolean Precedence(char operand1, char operand2) {
	    int op1Weight = OperatorWeight(operand1);
	    int op2Weight = OperatorWeight(operand2);

	    if(op1Weight >= op2Weight)
	       return true;
	    else 
	    	return false;
	}
	
	public static int evalRPN(String str) {
		
		int rNum, lNum;
		str = infixToPostfix(str.trim());
		stk = new Stack<Integer>();
		
		for(int i = 0; i<str.length(); i++){
			if(nextIsOperator(str.charAt(i))){
				switch (str.charAt(i)){
				case '+': {
					rNum = stk.pop();
					lNum = stk.pop();
					stk.push(rNum + lNum);
					break;
				}
			    case '-': {
			    	rNum = stk.pop();
					lNum = stk.pop();
					stk.push(lNum - rNum);
					break;
			    }
			    case '*': {
			    	rNum = stk.pop();
					lNum = stk.pop();
					stk.push(lNum * rNum);
					break;
			    }
			    default:{
			    	rNum = stk.pop();
					lNum = stk.pop();
					stk.push(lNum/rNum);
					break;
			    }}
			}
			else
				stk.push(Character.getNumericValue(str.charAt(i)));
		}
		return stk.peek();
    }
	
	public static boolean nextIsOperator(char next) {
	    switch (next){
	    case '+': return true;
	    case '-': return true;
	    case '*': return true;
	    case '/': return true;
	    default: return false;
	    }  
	  }
}
