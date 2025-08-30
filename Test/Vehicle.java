class Vehicle {
    public void accelerate() {
        System.out.println("The vehicle is accelerating...");
    }

    public void accelerate(String mode) {
        System.out.println("The vehicle is accelerating in " + mode + " mode.");
    }
    
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        Vehicle bicycle = new Bicycle();
    
        car.accelerate();
        car.accelerate("sport");

        motorcycle.accelerate();
        motorcycle.accelerate("eco");
        
        bicycle.accelerate();
        bicycle.accelerate("normal");
    }
}

class Car extends Vehicle {
    public void accelerate() {
        System.out.println("Car is accelerating smoothly...");
    }

    public void accelerate(String mode) {
        System.out.println("Car is accelerating in " + mode + " mode.\n");
    }
}

class Motorcycle extends Vehicle {
    public void accelerate() {
        System.out.println("Motorcycle is revving up and accelerating...");
    }

    public void accelerate(String mode) {
        System.out.println("Motorcycle is accelerating in " + mode + " mode.\n");
    }
}

class Bicycle extends Vehicle {
    public void accelerate() {
        System.out.println("Bicycle is pedaling faster...");
    }

    public void accelerate(String mode) {
        System.out.println("Bicycle is in " + mode + " mode.\n");
    }
}