public class Vegan extends PizzaBase{

    public void Vegan(int sliceCount){

        this.sliceCount = sliceCount;

    }

    @Override
    protected void whatToppings() {

        System.out.println("Sauce, Basil");

    }

    @Override
    protected void cook() {

        System.out.println("Barely Cooked");

    }

}
