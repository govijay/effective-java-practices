package effectivejava.item8;

import java.lang.ref.Cleaner;

// An autocloseable class using a cleaner as a safety net.
public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. Must not refer to Room!.  Hence it is static nested class because
    // non-static nested class contain references to their enclosing instances. Also lambda becuase they can
    // easily capture references to enclosing objects.
    private static class State implements Runnable{
        int numJunkPiles;

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        // invoked by close method or cleaner.
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;

        }
    }

    // state of this room instance, shared with cleanable.
    private final State state;

    // cleanable cleans the room when it is eligible for gc.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this,state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}

