public class Motorcycle extends MotorVehicle{
    public String color;

    public void Start (){
        running = true;
        System.out.println("started");
        System.out.println(color);
        System.out.println(make);
        System.out.println(running);
    }

    public void Stop (){
        running = false;
        System.out.println("stopped");
        System.out.println(color);
        System.out.println(make);
        System.out.println(running);
    }

}
