package effectivejava.item3;

public enum EnumSingleton {

    INSTANCE;

    int value;

    EnumSingleton(){

    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class EnumSingletonMain {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        System.out.println(enumSingleton.getValue());
        enumSingleton.setValue(2);
        System.out.println(enumSingleton.getValue());

    }
}
