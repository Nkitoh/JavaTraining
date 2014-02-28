package ch05_02;

import java.util.LinkedList;

public class BankAccount {
	private long number;
	private long balance ;
	private Action lastAct;
	private History history = new History();
	
	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}
		public String toString() {
			return number + ":" + act + " " + amount;
		}
	}
	
	public class History {
		private LinkedList<Action> actionArray = new LinkedList<Action>();
		private int count = 0;
		private final int MAX_HISTORY = 10;
		
		Action next(){
			Action retAction;
			if(count < actionArray.size()){
				retAction = actionArray.get(count);
				count++;
			}
			else
				retAction = null;
			
			return retAction;
		}
		
		void clear_count(){
			count = 0;
		}
		
		void add() {
			if(actionArray.size() < MAX_HISTORY)
				actionArray.add(lastAct);
			else {
				actionArray.removeFirst();
				actionArray.add(lastAct);
			}
		}
		
		Action getAction(){
			if(count == actionArray.size())
				return null;
			return actionArray.get(count);
		}
	}
	
	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.add();
	}
	
	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		history.add();
	}
	
	public History history(){
		return history;
	}
}
