package effectivejava.item3;

import java.io.*;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

    protected Object readResolve(){
        return getInstance();
    }
}

class SerializedSingletonMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton serializedSingleton = SerializedSingleton.getInstance();

        ObjectOutput op = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        op.writeObject(serializedSingleton);
        op.close();

        ObjectInput ip = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton serializedSingleton1 = (SerializedSingleton) ip.readObject();
        ip.close();

        System.out.println("instance one hashcode " + serializedSingleton.hashCode());
        System.out.println("instance two hashcode " + serializedSingleton1.hashCode());

    }
}
