package meats;

public class beef extends meat{
    public beef(int meatPrice, int meatStock) {
        super(meatPrice, meatStock);
    }

    public void display(){
        println("Meat Type: Beef");
        println("Price: "+getMeatPrice());
        println("Stock: "+getMeatStock());

    }
}
