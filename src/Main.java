import com.prog2.datastructures.ArrayList;
import com.prog2.datastructures.DoublyLinkedList;
import com.prog2.datastructures.SinglyLinkedList;

public class Main {

    static void printList(DoublyLinkedList a){
        // System.out.println("-------------------------------------------------");
        for (int i = 0; i < a.getLength(); i++) {
            System.out.println(a.get(i));
        }
        System.out.println("-------------------------------------------------");
    }

    static void test(){
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.prepend("Frodo").prepend("Sam").prepend("Merry").prepend("Pippin");

        // expected: Pippin, Merry, Sam, Frodo
        printList(list);


        list.append("Gandalf");

        // expected: Pippin, Merry, Sam, Frodo, Gandalf
        printList(list);

        list.insert(3, "Aragorn");

        // expected: Pippin, Merry, Sam, Aragorn, Frodo, Gandalf
        printList(list);

        list.insert(2, "Legolas");

        // expected: Pippin, Merry, Legolas, Sam, Aragorn, Frodo, Gandalf
        printList(list);

        list.remove(4);

        // expected: Pippin, Merry, Legolas, Sam, Frodo, Gandalf
        printList(list);

        // expected: 3
        System.out.println(list.indexOf("Sam"));

        System.out.println("-------------------------------------------------");

        // expected: "sam"
        System.out.println(list.get(3));

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.start();

    }

}
