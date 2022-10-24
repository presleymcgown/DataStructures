public class Hawaiian extends PizzaBase{

    public void Hawaiian(int sliceCount){

        this.sliceCount = sliceCount;

    }

    @Override
    protected void whatToppings() {

        System.out.println("Sauce, Cheese, Pineapple, Ham");

    }

    @Override
    protected void cook() {

        System.out.println("Extra Crispy");

    }

}
