package effectivejava.item2;

// Javabeans pattern - allows inconsistency. mandates mutability.

public class NutritionFacts_JavaBeansPattern {

    // parameters initialized to default values (if any)

    private int servingsSize = -1;
    private int servings = -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbs = 0;

    public NutritionFacts_JavaBeansPattern() {
    }

    public void setServingsSize(int servingsSize) {
        this.servingsSize = servingsSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    @Override
    public String toString() {
        return "NutritionFacts_JavaBeansPattern{" +
                "servingsSize=" + servingsSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbs=" + carbs +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts_JavaBeansPattern cocaCola = new NutritionFacts_JavaBeansPattern();
        cocaCola.setServingsSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbs(27);

        System.out.println(cocaCola.toString());
    }
}
