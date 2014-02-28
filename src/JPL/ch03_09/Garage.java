package ch03_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garage implements Cloneable{
	private List<Vehicle> ownVehicle;
	
	Garage(Vehicle... vihicle){
		this.ownVehicle = new ArrayList<Vehicle>(Arrays.asList(vihicle));
	}
	
	public void AddVehicle(Vehicle vehicle){
		this.ownVehicle.add(vehicle);
	}
	
	public Vehicle getVehicle(int index){
		return ownVehicle.get(index);
	}
	
	public int getNumVehicle(){
		return this.ownVehicle.size();
	}
	
	public String toString(){
		String desc ="";
		for(int i = 0; i < this.ownVehicle.size(); i++){
			desc += this.ownVehicle.get(i) + "\n";
		}
		return desc;
	}
	
	public Garage clone(){
		try{
			Garage copyGarage = (Garage)super.clone();
			copyGarage.ownVehicle = new ArrayList<Vehicle>();
			for (int i = 0; i < this.ownVehicle.size(); i++) {
				copyGarage.AddVehicle(this.ownVehicle.get(i).clone());
			}
			return copyGarage;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}

	public static void main(String[] args) {
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B", "B2",
				"B3");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");
		Vehicle Taxi = new Vehicle("Taxi", 230, -50, "D", "D1");
		Vehicle Bus = new Vehicle("Bus", 2230, -230, "E", "E1", "E2", "E3", "E4");
		
		Garage garage = new Garage(Benz, Corolla, Crown, Taxi, Bus);
		Garage garage2 = garage.clone();
		
		
		//Test
		
		boolean test = true;
		if(garage.getNumVehicle() != garage2.getNumVehicle()){
			System.err.println("Failure:Clone is fail: NumVehicle");
			test = false;
		}

		
		for(int i = 0; i < garage.getNumVehicle(); i++){
			
			if( ! garage.getVehicle(i).getCarName().equals(garage2.getVehicle(i).getCarName())){
				System.err.println("Failure:Clone is fail: CarName");
				test = false;
			}
			
			if(! (garage.getVehicle(i).getSpeed() == garage2.getVehicle(i).getSpeed())){
				System.err.println("Failure:Clone is fail: speed");
				test = false;
			}
			
			if(! (garage.getVehicle(i).getAngle() == garage2.getVehicle(i).getAngle())){
				System.err.println("Failure:Clone is fail:angle");
				test = false;
			}
			
			for (int num_owner = 0; num_owner < Benz.getOwner().size(); num_owner++) {
				if( ! garage.getVehicle(i).getOwner().get(num_owner)
						.equals( garage2.getVehicle(i).getOwner().get(num_owner))){
					System.err.println("Failure:Clone is fail: owner");
				test = false;
				}
			}
		}
		
		if(test == true)
			System.out.println("Succeed:Clone is succeed!");
		
	}
}
