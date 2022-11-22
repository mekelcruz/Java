package meats;

public abstract class meat {

    private int meatPrice;
    private int meatStock;

    public meat(int meatPrice, int meatStock){
        this.meatPrice = meatPrice;
        this.meatStock = meatStock;
        println("Meat added");
    }
    public abstract void display();
    void println(Object o){
        System.out.println(o);
    }
    // Setters

    public void setMeatPrice(int meatPrice){
        this.meatPrice = meatPrice;
    }
    public void setMeatStock(int meatStock){
        this.meatStock = meatStock;
    }
    // Getters
    public int getMeatPrice(){
        return this.meatPrice;
    }
    public int getMeatStock(){
        return this.meatStock;
    }
}
