package meats;

public class chickenMeat extends meat {
    public chickenMeat(int meatPrice, int meatStock) {
        super(meatPrice, meatStock);
    }

    public void display(){
        println("Meat Type: Chicken Meat");
        println("Price: "+getMeatPrice());
        println("Stock: "+getMeatStock());

    }
}
