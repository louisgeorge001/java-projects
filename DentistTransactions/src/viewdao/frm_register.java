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
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_reg_username;
	private JPasswordField txt_reg_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_register frame = new frm_register();
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
	public frm_register() {
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
		
		txt_reg_username = new JTextField();
		txt_reg_username.setBounds(168, 26, 86, 20);
		panel.add(txt_reg_username);
		txt_reg_username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(79, 29, 46, 14);
		panel.add(lblUsername);
		
		JLabel lblPasswrod = new JLabel("passwrod");
		lblPasswrod.setBounds(79, 60, 46, 14);
		panel.add(lblPasswrod);
		
		JButton btnregaccount = new JButton("Register");
		btnregaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reg();
			}
		});
		btnregaccount.setBounds(168, 88, 89, 23);
		panel.add(btnregaccount);
		
		txt_reg_pass = new JPasswordField();
		txt_reg_pass.setBounds(167, 57, 87, 20);
		panel.add(txt_reg_pass);
		setLocationRelativeTo(null);
	}
	public void reg()
	{
		String uname = this.txt_reg_username.getText();
		String pass = new String(txt_reg_username.getText());
		user u = new user();
		u.setId(0);
		u.setUsername(uname);
		u.setPassword(pass);
		
		usercontroller usercontrol = new usercontroller();
		int res = usercontrol.createUserAccount(u);
		if(res>0)
		{
			JOptionPane.showMessageDialog(null, "Saved");
			new frm_login().setVisible(true);
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Error Saving!");
			txt_reg_username.setText("");
			
			//dispose();
		}
		
	}
}
