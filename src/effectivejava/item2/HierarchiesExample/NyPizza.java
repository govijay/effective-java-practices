package effectivejava.item2.HierarchiesExample;

import java.util.Objects;

public class NyPizza extends Pizza {

    public enum Size {SMALL , MEDIUM , LARGE}
    private final Size size;

    private final int counter;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;
        private static int counter =0;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);

        }

        @Override
        public NyPizza build() {
            counter++;
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
        counter = builder.counter;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", counter=" + counter +
                ", toppings=" + toppings +
                '}';
    }
}
