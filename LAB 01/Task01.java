package lab01;

import java.util.Stack;

/**
 *
 * @author 17101177
 */
public class Task01 {

    public static void main(String[] args) {
        
        Stack stack = new Stack();
        
        stack.push(10);
        System.out.println("Pushing 10");
        System.out.println("Printing Top:");
        System.out.println(stack.peek());
        
        stack.push(5);
        System.out.println("Pushing 5");
        System.out.println("Printing Top:");
        System.out.println(stack.peek());
        
        stack.pop();
        System.out.println("Popping...");
        System.out.println("Printing Top:");
        System.out.println(stack.peek());
    }
    
}
