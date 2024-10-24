interface Transport{
    abstract double calculatefare(double distance);
}
class car implements Transport{
    @Override
    public double calculatefare(double distance){
        double rateperkm=10.0;
        return distance*rateperkm;
    }
}
class bus implements Transport{
    @Override
    public double calculatefare(double distance){
        double rateperkm=6.0;
        return distance*rateperkm;
    }
}
class train implements Transport{
    @Override
    public double calculatefare(double distance){
        double rateperkm=18.0;
        return distance*rateperkm;
    }
}
public class Transportsystem {
    public static void displayfare(Transport t,double distance){
        double fare=t.calculatefare(distance);
        System.out.println("Fare for" + t.getClass().getSimpleName()+ "over"+ distance+ "km is:" +fare+ "units");
    }
    public static void main(String[]args){
        double distance=50;
        Transport car=new car();
        Transport bus=new bus();
        Transport train=new train();
        displayfare(car,distance);
        displayfare(bus,distance);
        displayfare(train,distance);
    }
}