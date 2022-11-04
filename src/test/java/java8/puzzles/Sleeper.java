package java8.puzzles;

/**
 * 11/3/22 11:05
 * aiguoxin 
 * 说明:https://wouter.coekaerts.be/2012/puzzle-dreams-solution
 */
public class Sleeper {
    private int level;

    public synchronized int enter(Dream dream) {
        level++;
        try {
            dream.dream(this);
        } finally {
            level--;
        }
        return level;
    }


    public static void main(String[] args) {
        if (new Sleeper().enter(new Dream()) != 0) {
            // The goal is to reach this line
            System.out.println("Am I still dreaming?");
        }
    }
}

class Dream {
    private static void doWait(Sleeper s) {
        try {
            s.wait(200);
        } catch (InterruptedException e) {
        }
    }

    public void dream(final Sleeper s) {
        //TODO
        new Thread(() -> s.enter(new Dream() {
            @Override
            public void dream(Sleeper s1) {
                doWait(s1);
            }
        })).start();

        doWait(s);
    }
}
