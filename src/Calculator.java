import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import com.prog2.stack.Stack;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Calculator extends GraphicsProgram {

    private GLabel display = new GLabel("");

    @Override
    public void init() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new acm.gui.TableLayout(5,4));

        JButton oneButton = new JButton("1");
        buttonPanel.add(oneButton);

        JButton twoButton = new JButton("2");
        buttonPanel.add(twoButton);

        JButton threeButton = new JButton("3");
        buttonPanel.add(threeButton);

        JButton plusButton = new JButton("+");
        buttonPanel.add(plusButton);

        JButton fourButton = new JButton("4");
        buttonPanel.add(fourButton);

        JButton fiveButton = new JButton("5");
        buttonPanel.add(fiveButton);

        JButton sixButton = new JButton("6");
        buttonPanel.add(sixButton);

        JButton subtractButton = new JButton("-");
        buttonPanel.add(subtractButton);

        // 1 2 3 +
        // 4 5 6 -
        // 7 8 9 *
        // ( 0 ) /
        // c < = .

    }
}
