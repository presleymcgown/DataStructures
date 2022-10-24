public class Paper implements Cuttable, Colorable, Rippable{

    @Override
    public void write() {
        System.out.println("You can write on this.");
    }

    @Override
    public void erase() {
        System.out.println("You can erase what you wrote");
    }

    @Override
    public void cut() {
        System.out.println("You can cut this with scissors");
    }

    @Override
    public void tape() {
        System.out.println("You cannot un-cut or un-rip this, but you can fix it with tape.");
    }

    @Override
    public void rip() {
        System.out.println("You can rip this.");
    }

    

}
