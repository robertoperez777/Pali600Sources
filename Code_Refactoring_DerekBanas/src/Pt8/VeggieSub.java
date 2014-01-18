package Pt8;

public class VeggieSub extends Sandwich {

	// BAD WAY
	/*
	 * private boolean customerWantsCondiments = true;
	 * 
	 * VeggieSub(boolean wantsCondiments){
	 * 
	 * customerWantsCondiments = wantsCondiments;
	 * 
	 * }
	 * 
	 * public void makeSandwich(){
	 * 
	 * cutBun();
	 * 
	 * addVegetables();
	 * 
	 * if(customerWantsCondiments()){
	 * 
	 * addCondiments();
	 * 
	 * }
	 * 
	 * wrapSandwich();
	 * 
	 * }
	 */

	@Override
	boolean customerWantsMeat() {
		return false;
	}

	@Override
	void addMeat() {

	}

	@Override
	void addCondiments() {

		System.out.println("Vinegar and Oil Added");

	}

}