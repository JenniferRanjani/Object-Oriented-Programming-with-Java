//Source: https://www.journaldev.com/1540/decorator-design-pattern-in-java-example

//For simplicity public modifier is removed from all the interfaces and classes.

interface Car {
	public void assemble();
}

class BasicCar implements Car {

	@Override
	public void assemble() {
		System.out.println("Basic Car.");
	}
}

class CarDecorator implements Car {

	protected Car car;
	String color= null;
	String steering =null;
	
	public CarDecorator(Car c){
		car=c;
	}
	
	@Override
	public void assemble() {
		car.assemble();
	}
}

class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.print("Adding features of Sports Car.");
		steering();
	}
	
	public void steering() {
		steering = "Four-wheel Steering";
		System.out.println(" The sports Car has "+steering+".");
	}
}

class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.print("Adding features of Luxury Car.");
		color();
	}
	
	public void color() {
		color = "Red";
		System.out.println(" Color of the Luxury Car is "+color+".");
	}
}

public class DecoratorEx {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}
}

