package it.univpm.CovidForecast.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.univpm.CovidForecast.tools.Credenziali;

public class CFRegistrazione {

	private JFrame frame = new JFrame();
	
	private ImageIcon backgroundImg = new ImageIcon("images/Background - 2.png");
	private ImageIcon logo = new ImageIcon("images/Logo icona.png");
	private ImageIcon logoInterno = new ImageIcon("images/Logo interno.png");
	private ImageIcon minimize_white = new ImageIcon("images/Minimize_White_48x48.png");
	private ImageIcon minimize_lilac = new ImageIcon("images/Minimize_Lilac_48x48.png");
	private ImageIcon close_white = new ImageIcon("images/Close_White_36x36.png");
	private ImageIcon close_lilac = new ImageIcon("images/Close_Lilac_36x36.png");
	private ImageIcon profile = new ImageIcon("images/Login_logo_small.png");
	private ImageIcon login = new ImageIcon("images/Button_login_small.png");
	private ImageIcon login_switch = new ImageIcon("images/Button_login_switch_small.png");
	private ImageIcon registrati = new ImageIcon("images/Button_registrati_small.png");
	private ImageIcon registrati_switch = new ImageIcon("images/Button_registrati_switch_small.png");
	
	private JLabel background = new JLabel("", backgroundImg, JLabel.CENTER);
	private JLabel userLabel = new JLabel("username");
	private JLabel pwLabel = new JLabel("password");
	private JLabel pwLabel2 = new JLabel("conferma password");
	private JLabel logLabel = new JLabel("Se sei già registrato allora:");	
	
	private JTextField userField = new JTextField();
	private JPasswordField pwField = new JPasswordField();	
	private JPasswordField pwField2 = new JPasswordField();
	
	private JButton minimize = new JButton(minimize_white);
	private JButton close = new JButton(close_white);
	private JLabel logoInternoLabel = new JLabel(logoInterno);
	private JLabel profileLogo = new JLabel(profile);
	private JLabel titoloLabel = new JLabel("CovidForecast");
	private JButton loginButton = new JButton(login);
	private JButton registratiButton = new JButton(registrati);
	
	private Credenziali c = new Credenziali();
	
	public CFRegistrazione() {
		
		frame.setTitle("CovidForecast");
		frame.setSize(900, 507);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(logo.getImage());
		frame.setUndecorated(true);
		
		frame.add(background);
		
		logoInternoLabel.setBounds(10, 10, 80, 70);
		background.add(logoInternoLabel);
		
		titoloLabel.setBounds(100, 38, 200, 20);
		titoloLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		titoloLabel.setForeground(Color.WHITE);
		background.add(titoloLabel);
		
		profileLogo.setBounds(415,80, 70, 61);
		background.add(profileLogo);
		
		minimize.setBounds(770, 3, 48, 48);
		minimize.setContentAreaFilled(false);
		minimize.setBorderPainted(false);
		minimize.setFocusPainted(false);
		minimize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mEEn) {
				minimize.setIcon(minimize_lilac);
		    }
		    public void mouseExited(MouseEvent mEEx) {
		    	minimize.setIcon(minimize_white);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	minimize.setBounds(770, 8, 48, 48);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	minimize.setBounds(770, 3, 48, 48);
		    }
		    public void mouseClicked(MouseEvent mEC) {
		    	  frame.setExtendedState(JFrame.ICONIFIED);
		      }
		    });
		background.add(minimize);
		
		close.setBounds(840, 0, 48, 48);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setFocusPainted(false);
		close.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				close.setIcon(close_lilac);
		    }
		    public void mouseExited(MouseEvent evt) {
		    	close.setIcon(close_white);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	close.setBounds(840, 5, 48, 48);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	close.setBounds(840, 0, 48, 48);
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  System.exit(0);
		      }
		    });
		background.add(close);
		
		userLabel.setBounds(200, 180, 80, 20);
		userLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		userLabel.setForeground(Color.WHITE);
		background.add(userLabel);

		userField.setBounds(200, 210, 500, 20);
		userField.setFont(new Font("Arial", Font.PLAIN, 18));
		userField.setForeground(Color.WHITE);
		userField.setCaretColor(Color.WHITE);
		userField.setOpaque(false);
		userField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		background.add(userField);

		pwLabel.setBounds(200, 260, 80, 20);
		pwLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		pwLabel.setForeground(Color.WHITE);
		background.add(pwLabel);

		pwField.setBounds(200, 290, 500, 20);
		pwField.setFont(new Font("Arial", Font.PLAIN, 24));
		pwField.setForeground(Color.WHITE);
		pwField.setCaretColor(Color.WHITE);
		pwField.setOpaque(false);
		pwField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		background.add(pwField);
		
		pwLabel2.setBounds(200, 340, 150, 20);
		pwLabel2.setFont(new Font("Arial", Font.PLAIN, 17));
		pwLabel2.setForeground(Color.WHITE);
		pwField2.setCaretColor(Color.WHITE);
		background.add(pwLabel2);

		pwField2.setBounds(200, 370, 500, 20);
		pwField2.setFont(new Font("Arial", Font.PLAIN, 24));
		pwField2.setForeground(Color.WHITE);
		pwField2.setOpaque(false);
		pwField2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		background.add(pwField2);
		
		registratiButton.setBounds(240, 435, 158, 44);
		registratiButton.setContentAreaFilled(false);
		registratiButton.setBorderPainted(false);
		registratiButton.setFocusPainted(false);
		registratiButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				registratiButton.setIcon(registrati_switch);
		    }
		    public void mouseExited(MouseEvent evt) {
		    	registratiButton.setIcon(registrati);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	registratiButton.setBounds(240, 440, 158, 44);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	registratiButton.setBounds(240, 435, 158, 44);
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  if(c.salva(userField.getText(), new String(pwField.getPassword()), new String(pwField2.getPassword()))) {
		    		  new CFLogin();
		    		  frame.setVisible(false);
		    	  }
		      }
		    });
		registratiButton.setFocusPainted(false);
		background.add(registratiButton);
		
		logLabel.setBounds(490, 400, 250, 30);
		logLabel.setFont(new Font("Arial", Font.ITALIC, 16));
		logLabel.setForeground(Color.WHITE);
		background.add(logLabel);
		
		loginButton.setBounds(525, 435, 120, 44);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				loginButton.setIcon(login_switch);
		    }
		    public void mouseExited(MouseEvent evt) {
		    	loginButton.setIcon(login);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	loginButton.setBounds(525, 440, 120, 44);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	loginButton.setBounds(525, 435, 120, 44);
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  new CFLogin();
		    	  frame.setVisible(false);
		      }
		    });
		loginButton.setFocusPainted(false);
		background.add(loginButton);
				
		frame.setVisible(true);
		
	}
	
}