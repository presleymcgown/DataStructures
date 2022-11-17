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

        String[] labels = { "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "(", "0", ")", "/",
                "C", "<", "=", "." };

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
    public void actionPerformed(ActionEvent ae){

        switch(ae.getActionCommand()){

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

                if(display.getLabel().length()>0){

                    StringBuilder sb = new StringBuilder(display.getLabel());
                    sb = sb.deleteCharAt(display.getLabel().length() - 1);
                    display.setLabel(sb.toString());

                }

            default:

                display.setLabel(display.getLabel() + ae.getActionCommand());

        }

    }

    private int evaluate(String input){

        int strlen = input.length();

        Stack<Integer> ns = new Stack<>();
        Stack<Character> op = new Stack<>();

        return 0;

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
