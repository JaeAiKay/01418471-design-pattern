package composite;

import models.Quackable;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;

public class Flock implements Quackable {
    ArrayList<Quackable> quackers;

    public Flock() {
        quackers = new ArrayList();
    }

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        int i=1;
        for(Quackable quacker : quackers){
            if(i==1){
                quacker.quack();
                quacker.quack();
                quacker.quack();
                i=0;
            }
            quacker.quack();
        }

    }
}
