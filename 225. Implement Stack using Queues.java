/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False


Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.

Follow-up: Can you implement the stack using only one queue?
*/





import java.util.*;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }
    
    public void push(int x) {
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        queue2.add(x);
        while(!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
    }
    
    public int pop() {
        return queue2.poll();
    }
    
    public int top() {
        return queue2.peek();
    }
    
    public boolean empty() {
        return queue2.isEmpty();
    }

    // Driver Code
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());   // Should print 30
        System.out.println("Pop element: " + stack.pop());   // Should print 30
        System.out.println("Top after pop: " + stack.top()); // Should print 20
        System.out.println("Is stack empty? " + stack.empty()); // Should print false

        stack.pop(); // removes 20
        stack.pop(); // removes 10

        System.out.println("Is stack empty after popping all? " + stack.empty()); // Should print true
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */