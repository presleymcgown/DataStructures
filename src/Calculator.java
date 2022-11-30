import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import com.prog2.stack.Stack;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class Calculator extends GraphicsProgram {

    private GLabel display = new GLabel("");

    @Override
    public void init() {


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new acm.gui.TableLayout(5, 4));

        String[] labels = {"1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "(", "0", ")", "/",
                "C", "<", "=", "."};

        for (int i = 0; i < 20; i++) {
            JButton button = new JButton(labels[i]);
            buttonPanel.add(button);
        }

        // 1 2 3 +
        // 4 5 6 -
        // 7 8 9 *
        // ( 0 ) /
        // c < = .

        add(buttonPanel, CENTER);

        addActionListeners();

        display.setFont("Times-bold-24");
        add(display, 0, 18);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {

            case "=": //case an evaluation

                System.out.flush(); // clear the console

                int response = evaluate(display.getLabel());

                StringBuilder ops = new StringBuilder();
                ops.append((response));

                String output = ops.toString();
                display.setLabel(output);

                break;

            case "C": //clear the display

                display.setLabel("");

                break;

            case "<": // delete a single character from the display IF a character exists to be deleted

                if (display.getLabel().length() > 0) {

                    StringBuilder sb = new StringBuilder(display.getLabel());
                    sb = sb.deleteCharAt(display.getLabel().length() - 1);
                    display.setLabel(sb.toString());

                }

                break;

            default:

                display.setLabel(display.getLabel() + ae.getActionCommand());

        }

    }

    private int calculate(char op, int a, int b){

        if(op == '*'){

            postMessage("You are operating with *");

            return a*b;
        }

        if(op == '/'){

            postMessage("You are operating with /");

            int ans = a / b;

            postMessage(a + "");
            postMessage(b + "");

            postMessage("" + ans);

            return b/a;
        }

        if(op == '+'){

            postMessage("You are operating with +");

            return a+b;
        }

        if(op == '-'){

            postMessage("You are operating with -");

            return a-b;
        }

        return 0;
    }

    private boolean precedence(char peek, char ch) {
        if ((peek == '*' || peek == '/') && (ch == '+' || ch == '-')) {
            return true;
        }

        // forces left to right operation
        if (peek != ch && peek != '(') {
            return true;
        }

        return false;


    }

    private int evaluate(String input) {

        int strlen = input.length();

        Stack<Integer> ns = new Stack<>();
        Stack<Character> op = new Stack<>();

        int i = 0;
        char ch;

        StringBuffer s;

        if (!input.isEmpty()) {

            postMessage("Beginning evaluation...", 100);

            // loop across input string
            while (i < strlen) {
                // store the character found at a given point (i)
                ch = input.charAt(i);
                // skip over blank spaces (this shouldn't happen)
                if (ch == ' ') {
                    i++;
                    continue;
                }

                postMessage("Searching for symbols...");
                /*
                    1) Check for numbers. Question to ask yourself: how do I handle multi-digit numbers?
                       ch <= '9' && ch >= '0' . A char can be converted to an int using Integer.parseInt(new String(s))

                    2) Check for an opening parenthesis, which would indicate the start of a block
                       that must be evaluated before all others.

                    3) Check for a closing parenthesis, which indicates the end of a block that must
                       be evaluated before all others

                    4) Check for any non-paren operator, and determine if it has a higher precedence
                       that the operator that is currently on top of the op stack. When we find an op
                       that has precedence ( '*' or '/' vs '+' or '-'), we should calculate the result
                       of the current operator immediately, and push the result onto the number stack.

                    5) As the primary loop reaches the end of an iteration, don't forget to increment.
                */

                if (ch <= '9' && ch >= '0') {

                    postMessage("Found number.");
                    s = new StringBuffer();
                    s.append(ch);
                    i++;

                    while (i < strlen && (input.charAt(i)) <= '9' && input.charAt(i) >= '0') {

                        s.append(input.charAt(i));
                        i++;

                    }

                    ns.push(Integer.parseInt(new String(s)));
                    continue;

                    // you have found a number
                    // what if the number had multiple digits though?
                    // push the complete number onto the number stack. To do so:
                    // ns.push(Integer.parseInt(new String(s)));

                } else if (ch == '(') {
                    //you have found an opening paren
                    // don't do anything yet, just add it to the op stack
                    postMessage("Found opening parenthesis.");
                    op.push(ch);
                    i++;
                } else if (ch == ')') {

                    postMessage("Found closing parenthesis.");

                    while (!op.isEmpty() && op.peek() != '(') {
                        ns.push(calculate(op.pop(), ns.pop(), ns.pop()));
                    }

                    op.pop();

                    i++;

                    // you have found a closing paren.
                    // go ahead and calculate everything on the op stack until you find the opening paren
                    // remove the opening paren

                } else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {


                    postMessage("Found operator.");

                    while (!op.isEmpty() && precedence(op.peek(), ch)) {
                        ns.push(calculate(op.pop(), ns.pop(), ns.pop()));
                    }

                    op.push(ch);

                    i++;

                }
            }

        } //primary loops over

        // it is possible that the op stack will still have contents which must  be evaluated until stacks are empty

        while (!op.isEmpty()) {

            postMessage("You are operating with a " + op.peek() + " operator.");

            ns.push(calculate(op.pop(), ns.pop(), ns.pop()));
        }

        postMessage("Evaluation complete. Your answer is:  " + ns.peek());
        return ns.pop();

        //basically, if there are still numbers on the op stack, keep calculating

        //returned  whatever is left on the number stack

    }


        

    private void postMessage(String s, int time){

        System.out.println(s);
        pause(time);

    }

    private void postMessage(String s){

        System.out.println(s);
        pause(250);

    }

}
