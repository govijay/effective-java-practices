package effectivejava.item2.HierarchiesExample;

public class PizzaDriver {

    public static void main(String[] args) {

        NyPizza.Builder builder =  new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).self();


        NyPizza pizza = builder.build();

        NyPizza pizza2 = builder.build();

        NyPizza pizza1 =  new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.MUSHROOM).build();

        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(pizza2);
        System.out.println(pizza1);

        System.out.println(calzone );
    }
}
