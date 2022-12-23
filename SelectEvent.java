import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SelectEvent {
	Color buttonsColor = new Color(158, 196, 216);

	public SelectEvent(BankSystem bankSystem) {

		Frame frame = new Frame("Select Event");
		JButton button1 = new JButton("Withdraw");
		JButton button2 = new JButton("Deposit");
		JButton button3 = new JButton("Transfer amount");
		JButton button4 = new JButton("Change password");
		JButton button5 = new JButton("Show information");
		JButton button6 = new JButton("Debt payment");
		JButton button7 = new JButton("Logout");
		ImageIcon logoIcon = new ImageIcon("image/final-01.png");
		JLabel sEventImg = new JLabel(logoIcon);

		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankSystem.getAccounts()[bankSystem.getIndex()].withDraw(frame);
			}
		};

		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankSystem.getAccounts()[bankSystem.getIndex()].deposit(frame);
			}
		};

		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankSystem.searchForAccount(frame);
			}
		};

		ActionListener al4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPassword = JOptionPane.showInputDialog(frame, "please enter the new password");
				if (newPassword == null) {
					// Do nothing
					// JOptionPane.showMessageDialog(frame,"please entre the new password");
				} else {
					bankSystem.getAccounts()[bankSystem.getIndex()].setPassword(newPassword);
				}
			}
		};

		ActionListener al5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, bankSystem.getAccounts()[bankSystem.getIndex()].showInfo());
			}
		};

		ActionListener al6 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankSystem.getAccounts()[bankSystem.getIndex()].pay(frame);
			}
		};

		ActionListener al7 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};

		button1.addActionListener(al1);
		button2.addActionListener(al2);
		button3.addActionListener(al3);
		button4.addActionListener(al4);
		button5.addActionListener(al5);
		button6.addActionListener(al6);
		button7.addActionListener(al7);

		button1.setBackground(buttonsColor);
		button2.setBackground(buttonsColor);
		button3.setBackground(buttonsColor);
		button4.setBackground(buttonsColor);
		button5.setBackground(buttonsColor);
		button6.setBackground(buttonsColor);
		button7.setBackground(buttonsColor);

		button1.setBounds(35, 240, 138, 30);
		button2.setBounds(225, 240, 138, 30);
		button3.setBounds(35, 280, 138, 30);
		button6.setBounds(225, 280, 138, 30);
		button5.setBounds(35, 320, 138, 30);
		button4.setBounds(225, 320, 138, 30);
		button7.setBounds(145, 360, 110, 35);
		sEventImg.setBounds(10, -35, 350, 315);
		button7.setFont(new Font(button7.getFont().getName(), button7.getFont().getStyle(), 16));
		frame.setBounds(400, 200, 400, 450);
		frame.getContentPane().setBackground(new Color(10, 56, 81));
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button6);
		frame.add(button5);
		frame.add(button4);
		frame.add(button7);
		frame.add(sEventImg);
		frame.setLayout(null);

	}
}