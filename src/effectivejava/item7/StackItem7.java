package effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackItem7 {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackItem7(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0) throw new EmptyStackException();
        Object res =  elements[--size];
        elements[size] = null;
        return res;
        
    }

    private void ensureCapacity(){
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size +1);
    }
}

class StackItem7Main{
    public static void main(String[] args) {
        StackItem7 stackItem7 = new StackItem7();
        stackItem7.push(1);
        stackItem7.push(2);
        stackItem7.push(3);
        stackItem7.pop();
    }
}
