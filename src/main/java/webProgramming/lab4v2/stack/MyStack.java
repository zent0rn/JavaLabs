package webProgramming.lab4v2.stack;

import lombok.Getter;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

@Getter
public class MyStack<T> implements Iterable<T>{
    private T largestValue;
    private Stack<T> stack;

    public MyStack(){

    }

    public MyStack(List<T> data){

    }

    public void push(T data){

    }

    public void pop(){

    }

    public T top(){
        return null;
    }

    public List<T> getAllData(){
        return List.of();
    }

    public T getLargestValue(){
        return null;
    }

    public int getSize(){
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
        return iter;
    }

    public static MyStack<String> getStringStack(List<String> data){
        return new MyStack<>();
    }
}
