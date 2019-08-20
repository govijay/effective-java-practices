package effectivejava.item5;

import java.util.Objects;

public class DependencyInjectionItem5 {

    private final String resourceId;

    public DependencyInjectionItem5(String resourceId){
        this.resourceId = Objects.requireNonNull(resourceId);
    }

    public void printResourceId(){
        System.out.println("Resource ID injected: " + resourceId );
    }


}

class DependencyInjectionItem5Main {

    public static void main(String[] args) {
        DependencyInjectionItem5 dependencyInjectionItem5 = new DependencyInjectionItem5("TEST1");
        dependencyInjectionItem5.printResourceId();
    }
}
