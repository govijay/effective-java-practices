package effectivejava.item2;

public class NutritionFacts_BuilderPattern {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbs;

    public static class Builder {
        private final int servingSize; // required
        private final int servings;  // required

        // optional parameters - initialized to default valuess.
        private  int calories = 0;
        private  int fat = 0;
        private  int sodium = 0;
        private  int carbs = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public Builder carbs(int val){
            carbs = val;
            return this;
        }

        public NutritionFacts_BuilderPattern build(){
            return new NutritionFacts_BuilderPattern(this);
        }

    }

    // NutritionFacts_BuilderPattern is immutable.

    private NutritionFacts_BuilderPattern(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbs = builder.carbs;
    }

    @Override
    public String toString() {
        return "NutritionFacts_BuilderPattern{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbs=" + carbs +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts_BuilderPattern cocaCola = new Builder(240,8).calories(100).sodium(35).carbs(27).build();

        System.out.println(cocaCola.toString());

    }



}
