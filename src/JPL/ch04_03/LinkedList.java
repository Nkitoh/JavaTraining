package ch04_03;

interface LinkedList{
	
	Vehicle getVehicle() ;
	
	void setVehicle(Vehicle value) ;
	
	LinkedList getNextLink() ;
	
	LinkedList addListFront(Vehicle value) ;

	void addListEnd(Vehicle value) ;

	LinkedList addMultiList(Vehicle... value) ;
	
	public String toString() ;

	public int inccounter() ;
	
	public LinkedListImpl clone();

}