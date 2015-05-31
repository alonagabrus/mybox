package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;

public class ClientUI extends JFrame {

	private JPanel contentPane;
	private JTextField IPtxt;
	private JTextField Unametxt;
	private JPasswordField passtxt;
	JLabel lblWelcomeToMybox;
	JLabel lblServerIpAddress;
	JLabel lblUserName;
	JLabel lblUserPassword;
	JButton btnSignIn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI frame = new ClientUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyBox Client");
		setTitle("Edit file details");
		setBounds(100, 100, 500, 400);
		setVisible(true);
		setResizable(false);
		ImageIcon icon =new ImageIcon(getClass().getResource("/images/icon.png"));
		setIconImage(icon.getImage());
		contentPane = new JPanel();
	    contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblWelcomeToMybox = new JLabel("Welcome to MyBox!", SwingConstants.CENTER);
		lblWelcomeToMybox.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblWelcomeToMybox.setBounds(44, 11, 367, 48);
		contentPane.add(lblWelcomeToMybox);
		
		lblServerIpAddress = new JLabel("Server IP Address:");
		lblServerIpAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblServerIpAddress.setBounds(25, 75, 152, 19);
		contentPane.add(lblServerIpAddress);
		
		lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(25, 132, 152, 19);
		contentPane.add(lblUserName);
		
		lblUserPassword = new JLabel("User Password:");
		lblUserPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserPassword.setBounds(25, 190, 152, 19);
		contentPane.add(lblUserPassword);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setBackground(new Color(245, 255, 250));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignIn.setBounds(187, 250, 98, 37);
		contentPane.add(btnSignIn);
		
		IPtxt = new JTextField();
		IPtxt.setBounds(254, 75, 180, 20);
		contentPane.add(IPtxt);
		IPtxt.setColumns(10);
		
		Unametxt = new JTextField();
		Unametxt.setBounds(254, 132, 180, 20);
		contentPane.add(Unametxt);
		Unametxt.setColumns(10);
		
		passtxt = new JPasswordField();
		passtxt.setColumns(10);
		passtxt.setBounds(254, 190, 180, 20);
		contentPane.add(passtxt);
		
	}

	public void clearFields()
	{
		IPtxt.setText("");
		Unametxt.setText("");
		passtxt.setText("");
	}

	public String getIPtxt() {
		return IPtxt.getText();
	}

	public void setIPtxt(JTextField iPtxt) {
		IPtxt.setText("");
	}

	public String getUnametxt() {
		return Unametxt.getText();
	}

	public void setUnametxt(JTextField unametxt) {
		Unametxt.setText("");
	}

	public String getPasstxt() {
		return String.valueOf(passtxt.getPassword());
	}

	public void setPasstxt(JPasswordField passtxt) {
		passtxt.setText("");
	}
	public void addLoginActionListener(ActionListener listener)
	{
		btnSignIn.addActionListener(listener);
	}

}
