package ch06_05;

enum Signal {
	RED{
		Color getColor(){
			return new Color("RED");
		}
	},
	
	YELLOW{
		Color getColor(){
			return new Color("YELLOW");
		}
	},
	
	GREEN{
		Color getColor(){
			return new Color("GREEN");
		}
	};	
	
	abstract Color getColor();
}
