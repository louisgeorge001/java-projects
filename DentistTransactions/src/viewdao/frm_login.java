package viewdao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllerdao.usercontroller;
import modeldao.user;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_login_uname;
	private JPasswordField txt_login_pass;
	public static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_login frame = new frm_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_login_uname = new JTextField();
		txt_login_uname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_login_uname.setBounds(159, 28, 167, 28);
		panel.add(txt_login_uname);
		txt_login_uname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(33, 32, 83, 20);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(33, 71, 83, 20);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(237, 106, 89, 23);
		panel.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new frm_register().setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(138, 106, 89, 23);
		panel.add(btnRegister);
		
		txt_login_pass = new JPasswordField();
		txt_login_pass.setBounds(158, 67, 168, 24);
		panel.add(txt_login_pass);
		setLocationRelativeTo(null);
	}
	public void login()
	{
		String uname = this.txt_login_uname.getText();
		String pass = new String(txt_login_pass.getText());
		user u = new user();
		u.setId(0);
		u.setUsername(uname);
		u.setPassword(pass);
		
		usercontroller ucontrol = new usercontroller();
		boolean res = ucontrol.checkLogin(u);
		if(res)
		{
			JOptionPane.showMessageDialog(null, "Login!!!");
			new frm_mainpage().setVisible(true);
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
		}
	}
}
