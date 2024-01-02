import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] fButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, clrButton, delButton, negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1=0, num2=0, result=0;
    char operator;

    Calculator () {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 490);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(213,100,124));
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 320, 100);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(new Color(219,119,141));
        textfield.setForeground(Color.WHITE);
        frame.setForeground(Color.WHITE);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        clrButton = new JButton("C");
        divButton = new JButton("÷");
        equButton = new JButton("=");
        delButton = new JButton("D");
        negButton = new JButton("(-)");

        fButtons[0]= addButton;
        fButtons[1]= subButton;
        fButtons[2]= mulButton;
        fButtons[3]= decButton;
        fButtons[4]= clrButton;
        fButtons[5]= divButton;
        fButtons[6]= equButton;
        fButtons[7]= delButton;
        fButtons[8]= negButton;


        for(int i=0;i<9;i++) {
            fButtons[i].addActionListener(this);
            fButtons[i].setFont(myFont);
            fButtons[i].setFocusable(false);
            fButtons[i].setOpaque(true);
            fButtons[i].setContentAreaFilled(true);
            fButtons[i].setBorderPainted(false);
            fButtons[i].setBackground(new Color(231, 161, 176));
            fButtons[i].setForeground(Color.WHITE);
        }
        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setContentAreaFilled(true);
            numberButtons[i].setBorderPainted(false);
            numberButtons[i].setBackground(new Color(231,161,176));
            numberButtons[i].setForeground(Color.WHITE);
        }

        panel = new JPanel();
        panel.setBounds(50,215,315,200);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBackground(new Color(213,100,124));



        negButton.setBounds(260, 140, 103, 50);
        clrButton.setBounds(50, 140, 100, 50);
        delButton.setBounds(155, 140, 100, 50);

    


        
        frame.add(textfield);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(panel);
        frame.add(negButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        frame.setVisible(true);
        
    }


    

    public static void main(String[] args){
    Calculator calc = new Calculator();


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i ++) {
            if (e.getSource() == numberButtons[i]) {
                 textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton)
        textfield.setText(textfield.getText().concat("."));
        
        if (e.getSource() == clrButton)
            textfield.setText("");
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
            
        }
        if (e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++)
                textfield.setText(textfield.getText() + string.charAt(i));
        }
         if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText()) * -1;
            textfield.setText(String.valueOf(temp));
        }


}
}

