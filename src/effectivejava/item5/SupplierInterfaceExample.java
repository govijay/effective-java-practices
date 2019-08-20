package effectivejava.item5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierInterfaceExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();

        names.add("Test1");
        names.add("Test2");
        names.add("Test3");

        names.stream().forEach((item) -> {
            printNames(() -> item);
        });
    }

    public static void printNames(Supplier<String> stringSupplier){
        System.out.println(stringSupplier.get());
    }
}
