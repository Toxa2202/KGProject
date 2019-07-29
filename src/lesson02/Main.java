package lesson02;

/**
 * Created by anton.sviatov on 17.07.2019.
 */
public class Main {
    public static void main(String[] args) {
        Transport transport = new Car("Honda", 200);
        transport.setName("Audi");
        transport.move("Kyiv");
        System.out.println(transport);

        Bicicle bicicle1 = new Bicicle("Ukraine", 2);
        bicicle1.move("Stadium");
        System.out.println(bicicle1);

//        car1.setName("AUDI");
//        System.out.println(car1.getName());
//        car1.drive();

//        House house1 = new House("Gorodotska 1", 100);
//        house1.setStreet("Svobody 21");
//        System.out.println(house1.getStreet());
//        house1.check();
    }
}
