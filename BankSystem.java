import javax.swing.JOptionPane;

public class BankSystem {

	private Account[] accounts;
	private int currNum;
	private int index;

	public BankSystem() {
		accounts = new Account[1000];
		currNum = 0;
	}

	public void setCNum(int num) {
		currNum = num;
	}

	public int getCNum() {
		return currNum;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public int getIndex() {
		return index;
	}

	public boolean addAccount(String cName, String uName, String password, Frame frame) {

		boolean check = false;
		while (true) {
			if (cName.isEmpty() || uName.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Please Enter all the data required ");
				check = true;
				break;
			}
			check = false;
			for (int i = 0; i < currNum; i++) {

				if (uName.equalsIgnoreCase(accounts[i].getUserName())) {
					check = true;
					break;
				}
			}
			if (check) {
				JOptionPane.showMessageDialog(frame, "Please Enter another one it's used before");
				break;
			} else {
				String[] options = { "Personal", "VIP" };
				int i = JOptionPane.showOptionDialog(frame, "choose account type", "account type",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (i == 0) {
					accounts[currNum++] = new Personal();
					accounts[currNum - 1].readData(cName, uName, password);
					break;
				} else if (i == 1) {
					accounts[currNum++] = new VIP();
					accounts[currNum - 1].readData(cName, uName, password);
					break;
				} else {
					JOptionPane.showMessageDialog(frame, "you must chosse account type");
				}
			}
		}
		return check;
	}

	public boolean openAccount(String uName, String password, Frame frame) { // we can add method forget password to
																				// make
																				// the client reset his password
		boolean check = false;
		while (true) {
			for (int i = 0; i < currNum; i++) {
				if (uName.equalsIgnoreCase(accounts[i].getUserName())) {
					index = i;
					check = true;
					break;
				}
			}

			if (!check) {
				JOptionPane.showMessageDialog(frame, "Wrong user name");
				break;
			}

			else {
				if (!(accounts[index].getPassword().equals(password))) {
					JOptionPane.showMessageDialog(frame, "wrong password");
					check = false;
					break;
				} else {
					if (accounts[index].isBlocked()) {
						JOptionPane.showMessageDialog(frame, "Sorry,you are blocked you have to go to the bank");
						return false;
					}
					break;
				}
			}
		}
		return check;
	}

	public void searchForAccount(Frame frame) { // we should add exceptions here

		String id = JOptionPane.showInputDialog(frame, "Enter ID of the account");
		boolean check = false;
		if (id != null) {
			for (int i = 0; i < currNum; i++) {
				if (id.equals(accounts[i].getID()) && !id.equals(accounts[index].getID())) {
					check = true;
					getAccounts()[index].transferAmount(
							Double.parseDouble(JOptionPane.showInputDialog(frame, "please put amount of money")), i, this,
							frame);
				}
			}
			if (!check) {
				JOptionPane.showMessageDialog(frame, "Wrong ID");
			}
		}
	}
}