package lesson04;

/**
 * Created by anton.sviatov on 24.07.2019.
 */
public class Car {
    private String model;
    private TypeOfCar type;
    private Motor motor;

    public Car(String model, TypeOfCar type) {
        this.model = model;
        this.type = type;

        switch (type) {
            case SEDAN: {
                this.motor = new Motor("GAS", 184);
                break;
            }
            case TRAKTOR:{
                this.motor = new Motor("XTZ", 200);
                break;
            }
            default:{
                this.motor = new Motor("HONDA", 100);
                break;
            }
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypeOfCar getType() {
        return type;
    }

    public void setType(TypeOfCar type) {
        this.type = type;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void ride() {
        this.motor.startEngine();
        System.out.println("Ride.....");
    }
}

/** Composition Agregation */