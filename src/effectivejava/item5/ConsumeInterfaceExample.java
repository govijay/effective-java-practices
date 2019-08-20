package effectivejava.item5;

import java.util.function.Consumer;

public class ConsumeInterfaceExample {

    public static void main(String[] args) {

        Consumer<String> stringConsumer = ConsumeInterfaceExample::printNames;
        stringConsumer.accept("test1");
        stringConsumer.accept("test2");
    }

    public static void printNames(String name){
        System.out.println(name);

    }
}
