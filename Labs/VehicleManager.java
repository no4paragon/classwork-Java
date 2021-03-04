import java.util.Scanner;

public class VehicleManager {

    Car[] cars;
    Motorcycle[] Motorcycles;

    public void run(){
        Motorcycle oMotorcycle = new Motorcycle();
        Motorcycle oMotorcycle2 = new Motorcycle();
        Motorcycle oMotorcycle3 = new Motorcycle();
        Car oCar = new Car();
        Car oCar2 = new Car();
        Car oCar3 = new Car();
        oCar.running = false;
        oCar2.running = false;
        oCar3.running = false;
        oMotorcycle.running = false;
        oMotorcycle2.running = false;
        oMotorcycle3.running = false;
        oMotorcycle.make = "Honda";
        oMotorcycle2.make = "Yamaha";
        oMotorcycle3.make = "Kawasaki";
        oCar.make = "Toyota";
        oCar2.make = "Nissan";
        oCar3.make = "BMW";
        oCar.ev = false;
        oCar3.ev = false;
        oMotorcycle.color = "Red";
        oMotorcycle2.color = "Blue";
        oMotorcycle3.color = "Green";

        cars = new Car[3];
        Motorcycles = new Motorcycle[3];
        cars[0] = oCar;
        cars[1] = oCar2;
        cars[2] = oCar3;
        Motorcycles[0] = oMotorcycle;
        Motorcycles[1] = oMotorcycle2;
        Motorcycles[2] = oMotorcycle3;

        Scanner input = new Scanner(System.in);

        System.out.println("Choose which car to START");
        System.out.println("1. " + oCar.make);
        System.out.println("2. " + oCar2.make);
        System.out.println("3. " + oCar3.make);
        int menu = input. nextInt();
        cars[menu-1].Start();

        System.out.println("Choose which Motorcycle to START");
        System.out.println("1. " + oMotorcycle.make);
        System.out.println("2. " + oMotorcycle2.make);
        System.out.println("3. " + oMotorcycle3.make);
        menu = input. nextInt();
        Motorcycles[menu-1].Start();

        System.out.println("Choose which car to STOP");
        System.out.println("1. " + oCar.make);
        System.out.println("2. " + oCar2.make);
        System.out.println("3. " + oCar3.make);
        menu = input. nextInt();
        cars[menu-1].Stop();

        System.out.println("Choose which Motorcycle to STOP");
        System.out.println("1. " + oMotorcycle.make);
        System.out.println("2. " + oMotorcycle2.make);
        System.out.println("3. " + oMotorcycle3.make);
        menu = input. nextInt();
        Motorcycles[menu-1].Stop();

        System.out.println(cars[0].make + ": " + cars[0].running);
        System.out.println(cars[1].make + ": " + cars[1].running);
        System.out.println(cars[2].make + ": " + cars[2].running);


        System.out.println(Motorcycles[0].make + ": " + Motorcycles[0].running);
        System.out.println(Motorcycles[1].make + ": " + Motorcycles[1].running);
        System.out.println(Motorcycles[2].make + ": " + Motorcycles[2].running);



    }

}
