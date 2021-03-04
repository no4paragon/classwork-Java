public class Car extends MotorVehicle{

    boolean ev = true;


    public void Start (){
        running = true;
        System.out.println("started");
        System.out.println(ev);
        System.out.println(make);
        System.out.println(running);
    }

    public void Stop (){
        running = false;
        System.out.println("stopped");
        System.out.println(ev);
        System.out.println(make);
        System.out.println(running);
    }

}
