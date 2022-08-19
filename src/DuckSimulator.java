import adapter.GooseAdapter;
import adapter.PigeonAdapter;
import composite.Flock;
import decorator.QuackCounter;
import decorator.QuackEcho;
import factory.AbstractDuckFactory;
import factory.CountingDuckFactory;
import factory.CountingEchoDuckFactory;
import factory.DuckFactory;
import models.*;

import java.nio.channels.FileLock;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory){
//        models.Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck())) ;
//        models.Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));
//        models.Quackable duckCall = new QuackCounter(new QuackEcho(new DuckCall()));
//        models.Quackable rubberDuck = new QuackCounter(new QuackEcho(new RubberDuck()));

//        models.Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck())) ;
//        models.Quackable redheadDuck = new QuackEcho(new QuackCounter(new RedheadDuck()));
//        models.Quackable duckCall = new QuackEcho(new QuackCounter(new DuckCall()));
//        models.Quackable rubberDuck = new QuackEcho(new QuackCounter(new RubberDuck()));

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);
        flockOfDucks.add(flockOfMallards);

//        System.out.println("\nDuck Simulator");

//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);
//        simulate(pigeon);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        System.out.println("The duck quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
