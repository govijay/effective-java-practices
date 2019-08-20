package effectivejava.item2.HierarchiesExample;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder pattern for class hierarchies
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM,ONION , PEPPER ,SAUSAGE}
    final Set<Topping> toppings;

/*
* Generic type with a recursive parameter.
* this, along with self method, allows method chaining to work properly in subclasses, with out need for casts.
* this workaround for the fact that Java lacks a self type is known as the "simulated self-type" idiom.*/

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // subclass must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }


}
