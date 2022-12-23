import java.awt.Color; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI {

	Color buttonsColor = new Color(158, 196, 216);
	Color framesColor = new Color(10, 56, 81);
	BankSystem bankSystem = new BankSystem();

	public GUI() {
		Frame frame1 = new Frame("Bank System");
		JButton button1 = new JButton("login");
		JButton button2 = new JButton("Sign up");
		JButton button3 = new JButton("Exit");
		ImageIcon mainIcon = new ImageIcon("image/final-01.png");
		JLabel mainImage = new JLabel(mainIcon);

		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame3 = new Frame("Login");
				JButton button5 = new JButton("login");
				JLabel label1 = new JLabel("user name");
				JLabel label2 = new JLabel("password");
				JTextField username = new JTextField(20);
				JTextField password = new JTextField(20);
				ActionListener al5 = new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (bankSystem.openAccount(username.getText(), password.getText(), frame3)) {
							frame3.dispose();
							new SelectEvent(bankSystem);
						} 
					}
				};

				ImageIcon loginIcon = new ImageIcon("image/final-01.png");
				JLabel loginImage = new JLabel(loginIcon);
				loginImage.setBounds(10, -35, 350, 315);
				frame3.add(loginImage);

				button5.addActionListener(al5);
				label1.setBounds(116, 228, 80, 20);
				label2.setBounds(116, 278, 80, 20);
				label1.setForeground(Color.white);
				label2.setForeground(Color.white);
				username.setBounds(115, 250, 150, 20);
				password.setBounds(115, 300, 150, 20);
				button5.setBackground(buttonsColor);
				button5.setBounds(137, 343, 100, 30);

				frame3.setBounds(400, 200, 400, 450);
				frame3.getContentPane().setBackground(framesColor);
				frame3.add(label1);
				frame3.add(username);
				frame3.add(label2);
				frame3.add(password);
				frame3.add(button5);
				frame3.setLayout(null);
			}
		};

		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame2 = new Frame("Sign Up");
				JButton button4 = new JButton("sign up");
				JLabel label1 = new JLabel("name");
				JLabel label2 = new JLabel("User Name");
				JLabel label3 = new JLabel("Password");
				ImageIcon signUpIcon = new ImageIcon("image/final-01.png");
				JLabel signUpImg = new JLabel(signUpIcon);
				JTextField textField1 = new JTextField(20);
				JTextField textField2 = new JTextField(20);
				JTextField textField3 = new JTextField(20);

				ActionListener al4 = new ActionListener() {
					public void actionPerformed(ActionEvent ae) {

						if (!(bankSystem.addAccount(textField1.getText(), textField2.getText(), textField3.getText(),
								frame2))) {
							double balancetest = moneyExceptions(frame2);
							if (balancetest != 0) {
								bankSystem.getAccounts()[bankSystem.getCNum() - 1].setBalance(balancetest);
								frame2.dispose();
							} else {
								bankSystem.getAccounts()[bankSystem.getCNum() - 1] = null;
								bankSystem.setCNum(bankSystem.getCNum() - 1);
							}

						}
					}
				};

				button4.addActionListener(al4);

				label1.setBounds(114, 198, 80, 20);
				label2.setBounds(114, 248, 80, 20);
				label3.setBounds(114, 298, 80, 20);
				label1.setForeground(Color.WHITE);
				label2.setForeground(Color.WHITE);
				label3.setForeground(Color.WHITE);
				textField1.setBounds(113, 220, 150, 20);
				textField2.setBounds(113, 270, 150, 20);
				textField3.setBounds(113, 320, 150, 20);
				signUpImg.setBounds(10, -35, 350, 315);
				button4.setBounds(137, 358, 100, 30);
				button4.setBackground(buttonsColor);
				frame2.add(label1);
				frame2.add(textField1);
				frame2.add(label2);
				frame2.add(textField2);
				frame2.add(label3);
				frame2.add(textField3);
				frame2.add(button4);
				frame2.setBounds(400, 200, 400, 450);
				frame2.getContentPane().setBackground(framesColor);
				frame2.add(signUpImg);
				frame2.setLayout(null);
			}
		};

		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.dispose();
			}
		};

		// button1.setForeground(new Color(239, 194, 93));
		/*
		 * button1.setBorder(null);
		 * 
		 * 
		 * button1.setHorizontalAlignment(SwingConstants.CENTER); button1.setFont(new
		 * Font("Dialog", Font.PLAIN, 16));
		 */

		button1.addActionListener(al1);
		button2.addActionListener(al2);
		button3.addActionListener(al3);
		button1.setBounds(150, 265, 80, 20);
		button2.setBounds(150, 305, 80, 20);
		button3.setBounds(150, 345, 80, 20);
		mainImage.setBounds(10, -10, 350, 315);
		button1.setBackground(buttonsColor);
		button2.setBackground(buttonsColor);
		button3.setBackground(buttonsColor);
		frame1.setBounds(400, 200, 400, 450);
		frame1.getContentPane().setBackground(framesColor);
		frame1.add(button1);
		frame1.add(button2);
		frame1.add(button3);
		frame1.add(mainImage);
	}

	public double moneyExceptions(Frame frame) {
		double leastMoney = 100;

		if (bankSystem.getAccounts()[bankSystem.getCNum() - 1].getAccountType().equals("VIP")) {
			leastMoney = 50000;
		}
		while (true)
			try {

				double money = Double
						.parseDouble(JOptionPane.showInputDialog(frame, "entre money at least $" + leastMoney));
				if (money >= leastMoney) {
					return money;
				} else
					JOptionPane.showMessageDialog(frame, "please enter at least $" + leastMoney);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(frame, "please enter numbers");
				return 0;
			}
	}

}
