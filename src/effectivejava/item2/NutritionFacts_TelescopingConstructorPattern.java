package effectivejava.item2;

public class NutritionFacts_TelescopingConstructorPattern {

    // Telescoping constructor pattern does  not scale well.

    private final int servingSize; // required
    private final int servings;  // required
    private final int calories; // optional
    private final int fat; // optional
    private final int sodium; // optional
    private final int carbs; // optional

    public NutritionFacts_TelescopingConstructorPattern(int servingSize, int servings) {
        this(servingSize,servings,0);
    }



    public NutritionFacts_TelescopingConstructorPattern(int servingSize, int servings , int calories){
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts_TelescopingConstructorPattern(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories,fat,0);
    }


    public NutritionFacts_TelescopingConstructorPattern(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts_TelescopingConstructorPattern(int servingSize, int servings, int calories, int fat, int sodium, int carbs) {

        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbs = carbs;
    }

    @Override
    public String toString() {
        return "NutritionFacts_TelescopingConstructorPattern{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbs=" + carbs +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts_TelescopingConstructorPattern cocaCola = new NutritionFacts_TelescopingConstructorPattern(240,8,
                100,0,35,27);

        System.out.println(cocaCola.toString());
    }
}
