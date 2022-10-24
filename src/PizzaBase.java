public abstract class PizzaBase {

    public int sliceCount = 8;

    public void PizzaBase(int sliceCount){

        this.sliceCount = sliceCount;

    }

    protected abstract void whatToppings();

    protected abstract void cook();

    public void finished(){

        System.out.println("Your pizza is finished, enjoy!");

    }

    public void slices(){

        System.out.println("This pizza has " + sliceCount + " slices.");

    }



}
