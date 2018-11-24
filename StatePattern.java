//Source: https://www.journaldev.com/1751/state-design-pattern-java

// //Uncomment the following code the study the need for the state design pattern
// //TV Remote Example without state design pattern
// public class TVRemoteBasic {

// 	private String state="";
	
// 	public void setState(String state){
// 		this.state=state;
// 	}
	
// 	public void doAction(){
// 		if(state.equalsIgnoreCase("ON")){
// 			System.out.println("TV is turned ON");
// 		}else if(state.equalsIgnoreCase("OFF")){
// 			System.out.println("TV is turned OFF");
// 		}
// 	}

// 	public static void main(String args[]){
// 		TVRemoteBasic remote = new TVRemoteBasic();
		
// 		remote.setState("ON");
// 		remote.doAction();
		
// 		remote.setState("OFF");
// 		remote.doAction();
// 	}

// }


//State Design Pattern
interface State {

	public void goNext();
}

class TVStartState implements State {

	@Override
	public void goNext() {
		System.out.println("TV is turned ON");
	}

}

class TVStopState implements State {

	@Override
	public void goNext() {
		System.out.println("TV is turned OFF");
	}

}

class TVContext implements State {

	private State tvState;

	public void setState(State state) {
		tvState=state;
	}

	public State getState() {
		return tvState;
	}

	@Override
	public void goNext() {
		tvState.goNext();
	}
}


class StatePattern {

	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();
		
		context.setState(tvStartState);
		context.goNext();
		
		
		context.setState(tvStopState);
		context.goNext();
		
	}

}

