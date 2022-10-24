public abstract class PizzaBase {

    public boolean hasCheese = true;
    public boolean hasSauce = true;
    public boolean hasToppings = true;
    public int sliceCount = 8;

    public void PizzaBase(boolean hasCheese, boolean hasSauce, boolean hasToppings, int sliceCount){

        this.hasCheese = hasCheese;
        this.hasSauce = hasSauce;
        this.hasToppings = hasToppings;
        this.sliceCount = sliceCount;

    }

    protected abstract void whatToppings();

    protected abstract void cook();

    public void finished(){

        System.out.println("Your pizza is finished, enjoy!");

    }



}
