package meats;

public class pork extends meat {
    public pork(int meatPrice, int meatStock) {
        super(meatPrice, meatStock);
    }

    public void display(){
        println("Meat Type: Pork");
        println("Price: "+getMeatPrice());
        println("Stock: "+getMeatStock());

    }

}
