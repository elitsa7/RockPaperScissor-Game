import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameGUI extends JFrame implements ActionListener {
    private final JLabel player;
    private final JLabel computer;
    private final JLabel result;
    private final JButton rockButton;
    private final JButton paperButton;
    private final JButton scissorsButton;
    public GameGUI() {
        setTitle("Rock-Paper-Scissors");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        player = new JLabel("You:");
        computer= new JLabel("Computer:");
        result = new JLabel();

        JPanel resultPanel = new JPanel(new GridLayout(3, 1));
        resultPanel.add(player);
        resultPanel.add(computer);
        resultPanel.add(result);

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        int playerChoice = 0;
        if (e.getSource() == rockButton) {
            playerChoice = 1;
        } else if (e.getSource() == paperButton) {
            playerChoice = 2;
        } else if (e.getSource() == scissorsButton) {
            playerChoice = 3;
        }

        int computerChoice = new Random().nextInt(3) + 1;

        player.setText("You: " + weaponToString(playerChoice));
        computer.setText("Computer: " + weaponToString(computerChoice));

        String result = determineWinner(playerChoice, computerChoice);
        this.result.setText(result);
    }

    private String weaponToString(int weapon) {
        if (weapon == 1) {
            return "Rock";
        } else if (weapon == 2) {
            return "Paper";
        } else if (weapon == 3) {
            return "Scissors";
        } else {
            return "";
        }
    }

    private String determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return "This game is draw! Try again!";
        } else if ((playerChoice == 1 && computerChoice == 3) || (playerChoice == 2 && computerChoice == 1)
                || (playerChoice == 3 && computerChoice == 2)) {
            return "Congratulations! You WIN! :)";
        } else {
            return "Sorry! Computer win! :(";
        }
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}






