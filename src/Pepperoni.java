public class Pepperoni extends PizzaBase{

    public void Pepperoni(int sliceCount){

        this.sliceCount = sliceCount;

    }

    @Override
    protected void whatToppings() {

        System.out.println("Sauce, Cheese, Pepperoni");

    }

    @Override
    protected void cook() {

        System.out.println("Crispy");

    }
}
