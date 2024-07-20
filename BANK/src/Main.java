import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class BankAccount {

    public double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public boolean deposit(double amount) {
        if (amount>0) {
            balance+=amount;
            return true;
        }
        return false;
    }
    public boolean withdraw(double amount) {
        if (amount>0 && amount<=balance) {
            balance-=amount;
            return true;
        }
        return false;
    }
}
class ATM extends JFrame {
    public BankAccount account;
    public JTextField amountField;
    public JTextArea display;
    JButton depositButton;

    public ATM(BankAccount account) {
        this.account = account;
        design();
    }
    public void design() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        JButton withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");
        depositButton.setPreferredSize(new Dimension(50, 40));
        display= new JTextArea();
        display.setPreferredSize(new Dimension(380, 150));

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Withdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Deposit();
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(exitButton);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(display), BorderLayout.SOUTH);
    }

    public void Withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdraw(amount)) {
                display.append("Withdrawal successful. Amount withdrawn: $" + amount + "\n");
            } else {
                display.append("Withdrawal failed.Invalid amount.\n");
            }
        } catch (NumberFormatException e) {
            display.append("Invalid amount entered.\n");
        }
        amountField.setText("");
    }
    public void Deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.deposit(amount)) {
                display.append("Deposit successful. Amount deposited: $" + amount + "\n");
            } else {
                display.append("Deposit failed. Invalid amount.\n");
            }
        } catch (NumberFormatException e) {
            display.append("Invalid amount entered.\n");
        }
        amountField.setText("");
    }
    public void checkBalance() {
        display.append("Current balance: $" + account.getBalance() + "\n");
    }
}
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        SwingUtilities.invokeLater(() -> {
            ATM atm = new ATM(account);
            atm.setVisible(true);
        });
    }
}
