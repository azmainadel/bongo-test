## Answer
    interface Vehicle {
        int set_num_of_wheels()
        int set_num_of_passengers()
        boolean has_gas()
    }

> The method names in the interface denote that they are *setters*.

The design pattern used here if the **Factory Pattern**. 
Here, *Vehicle* is an interface which is to be implemented by some other classes. 
The abstract methods are implemented by child classes *Car* and *Plane* to get their respective type objects.



## (a) Creating Cars and Planes using this pattern
- The interface:

	    interface Vehicle {  
	      void set_num_of_wheels(int num_of_wheels);  
	      
	      void set_num_of_passengers(int num_of_passengers);  
	      
	      void has_gas(boolean has_gas);  
	    }

- Creating *Car* and *Plane* classes:
We implement the *Vehicle* interface to create these concrete classes. The abstract methods are overridden here. 

		class Car implements Vehicle {  
			  private int numWheels, numPassengers;  
			  private boolean hasGas;
			  
			  @Override  
			  public void set_num_of_wheels(int num_of_wheels) {  
				  this.numWheels = num_of_wheels;  
			 }  
			  @Override  
			  public void set_num_of_passengers(int num_of_passengers) {  
				  this.numPassengers = num_of_passengers;  
			 }  
			  @Override  
			  public void has_gas(boolean has_gas) {  
				  this.hasGas = has_gas;  
			 }
		 }

	
		class Plane implements Vehicle {  
			  private int numWheels, numPassengers;  
			  private boolean hasGas;
			  
			  @Override  
			  public void set_num_of_wheels(int num_of_wheels) {  
				  this.numWheels = num_of_wheels;  
			 }  
			  @Override  
			  public void set_num_of_passengers(int num_of_passengers) {  
				  this.numPassengers = num_of_passengers;  
			 }  
			  @Override  
			  public void has_gas(boolean has_gas) {  
				  this.hasGas = has_gas;  
			 }
		 }

- The *VehicleFactory* class:
This class  generates object of the class based on the *vehicleType* parameter.

		class VehicleFactory {  
			public Vehicle getVehicle(String vehicleType) {  
				if (vehicleType == null) return null;  
			  
				if (vehicleType.equalsIgnoreCase("Car")) {  
					return new Car();  
				}
				  
				if (vehicleType.equalsIgnoreCase("Plane")) {  
					return new Plane();  
				} 
				return null;  
			 }
		 }

- *Controller* class:
This class uses the *VehicleFactory* to get objects of concrete class.

		public class VehicleGenerator {  
		  
			public static void main(String[] args) {  
				VehicleFactory vehicleFactory = new VehicleFactory();  

				Vehicle car1 = vehicleFactory.getVehicle("Car");  
				car1.set_num_of_wheels(4);  
				car1.set_num_of_passengers(4);  
				car1.has_gas(true);  

				Vehicle plane1 = vehicleFactory.getVehicle("Plane");  
				plane1.set_num_of_wheels(3);  
				plane1.set_num_of_passengers(180);  
				plane1.has_gas(false);  
			}
		 }

## (b) A different approach

We can use the **Builder Pattern**
This pattern builds a complex object using simple objects and using a step by step approach.

		class Vehicle {  
			private int num_of_wheels;  
			private int num_of_passengers;  
			private boolean has_gas;  

			public static class Builder {  

				private int num_of_wheels;  
				private int num_of_passengers;  
				private boolean has_gas;  

				public Builder() {  
				}  
				
				Builder(int num_of_wheels, int num_of_passengers, boolean has_gas) {  
					this.num_of_wheels = num_of_wheels;  
					this.num_of_passengers = num_of_passengers;  
					this.has_gas = has_gas;  
				}  
				
				public Builder set_num_of_wheels(int num_of_wheels) {  
					this.num_of_wheels = num_of_wheels;  
					return Builder.this;  
				}  
				
				public Builder set_num_of_passengers(int num_of_passengers) {  
					this.num_of_passengers = num_of_passengers;  
					return Builder.this;  
				}  
				
				public Builder has_gas(boolean has_gas) {  
					this.has_gas = has_gas;  
					return Builder.this;  
			}  
			
				public Vehicle build() {  
					return new Vehicle(this);  
				} 
			}  
			
			private Vehicle(Builder builder) {  
				this.num_of_wheels = builder.num_of_wheels;  
				this.num_of_passengers = builder.num_of_passengers;  
				this.has_gas = builder.has_gas;  
			}  
			
			public void printVehicleDetails() {  
				System.out.println("Wheels: " + num_of_wheels  
				+ "\nPassengers: " + num_of_passengers  
				+ "\nGas available: " + has_gas);  
				}
		}  


		public class VehicleGenerator {  

			public static void main(String[] args) {    
				Vehicle car = new Vehicle.Builder()  
					.set_num_of_wheels(4)  
					.set_num_of_passengers(4)  
					.has_gas(true)  
					.build();  

				car.printVehicleDetails();  

				Vehicle plane = new Vehicle.Builder()  
					.set_num_of_wheels(3)  
					.set_num_of_passengers(180)  
					.has_gas(false)  
					.build();  

				plane.printVehicleDetails();  
			}
		}