package it.univpm.CovidForecast.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import it.univpm.CovidForecast.exceptions.CFException;
import it.univpm.CovidForecast.tools.ConvertitoreData;	

public class CFPaginaPrincipale {

	private JFrame frame = new JFrame();

	private ImageIcon backgroundImg = new ImageIcon("images/Background - 2.png");
	private ImageIcon logo = new ImageIcon("images/Logo icona.png");
	private ImageIcon logoInterno = new ImageIcon("images/Logo interno.png");
	private ImageIcon minimize_white = new ImageIcon("images/Minimize_White_48x48.png");
	private ImageIcon minimize_lilac = new ImageIcon("images/Minimize_Lilac_48x48.png");
	private ImageIcon close_white = new ImageIcon("images/Close_White_36x36.png");
	private ImageIcon close_lilac = new ImageIcon("images/Close_Lilac_36x36.png");
	private ImageIcon ricerca_white = new ImageIcon("images/Button_ricerca_White_small.png");
	private ImageIcon ricerca_lilac = new ImageIcon("images/Button_ricerca_Lilac_small.png");
	private ImageIcon iconaMeteo;
	
	private JLabel background = new JLabel("", backgroundImg, JLabel.CENTER);
	private JLabel logoInternoLabel = new JLabel(logoInterno);
	private JLabel titoloLabel = new JLabel("CovidForecast");
	private JLabel posizioneLabel = new JLabel();
	private JLabel iconaMeteoLabel;
	private JLabel descrizioneLabel = new JLabel();
	private JLabel tempLabel;
	private JLabel tempMinLabel = new JLabel();
	private JLabel tempMaxLabel = new JLabel();
	private JLabel tempPercepitaLabel;
	private JLabel lineaLabel = new JLabel();
	private JLabel titoloDataLabel = new JLabel("Campionamento effettuato: ");
	private JLabel dataLabel = new JLabel();
	private JLabel dataPrevisionaleLabel;
	private JLabel bordi;
	
	private JTextField ricercaField = new JTextField("Cerca meteo città...");
	
	private JButton ricercaButton = new JButton(ricerca_white);
	private JButton minimize = new JButton(minimize_white);
	private JButton close = new JButton(close_white);
	
	private ConvertitoreData cD = new ConvertitoreData();
	private String[] arrayGiorni = new String[] {"Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"};
	private Vector<String> giorni = new Vector<String>(Arrays.asList(arrayGiorni));
	private String[] arrayBox;
	private String data;
	private String giorno;
	private String descrizione;
	private String temp;
	private String tempMin;
	private String tempMax;
	private String tempPercepita;
	private int nIcona = 0;
	
	private JComboBox<String> cBox;
	
	public CFPaginaPrincipale(String username, Vector<String> geo, Vector<Vector<String>> weather) {
		
		UIManager.put("ComboBox.selectionBackground", new Color(148,96,161)); //lilla
		
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
		
		ricercaField.setBounds(300, 38, 200, 20);
		ricercaField.setFont(new Font("Arial", Font.PLAIN, 18));
		ricercaField.setForeground(Color.WHITE);
		ricercaField.setCaretColor(Color.WHITE);
		ricercaField.setOpaque(false);
		ricercaField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		ricercaField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				ricercaField.setText("");
			}
			
			public void focusLost(FocusEvent e) {

			}
		});
		background.add(ricercaField);
		
		ricercaButton.setBounds(510, 30, 36, 35);
		ricercaButton.setContentAreaFilled(false);
		ricercaButton.setBorderPainted(false);
		ricercaButton.setFocusPainted(false);
		ricercaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mEEn) {
				ricercaButton.setIcon(ricerca_lilac);
		    }
		    public void mouseExited(MouseEvent mEEx) {
		    	ricercaButton.setIcon(ricerca_white);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	ricercaButton.setBounds(510, 35, 36, 35);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	ricercaButton.setBounds(510, 30, 36, 35);
		    }
		    public void mouseClicked(MouseEvent mEC) {
		    	String testo = ricercaField.getText();
		    	  if(!testo.equals("")) {
		    		  try {
						new ChiamataPaginaPrincipale(username, testo);
						frame.setVisible(false);
					} catch (CFException e) {
						ricercaField.setText("Cerca meteo città...");
					}
		    	  }
		      }
		    });
		background.add(ricercaButton);
		
		bordi = new JLabel();
		bordi.setBounds(570, 15, 180, 30);/*20, 34, 90*/
		bordi.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 3, new Color(148,96,161)));
		background.add(bordi);
		
		bordi = new JLabel();
		bordi.setBounds(570, 15, 161, 30);
		bordi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(20, 34, 90)));
		background.add(bordi);
		
		arrayBox = new String[] {username, "Statistiche", "Logout"};
		cBox = new JComboBox<String>(arrayBox);
		cBox.setBounds(570, 15, 180, 30);
		cBox.setFont(new Font("Arial", Font.PLAIN, 18));
		cBox.setForeground(Color.WHITE);
		cBox.setFocusable(false);
		cBox.setBackground(new Color(148,96,161));
		cBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(cBox.getSelectedItem().equals("Logout")) {
					new CFLogin();
					frame.setVisible(false);
				} else if(cBox.getSelectedItem().equals("Statistiche")) {
					new CFStats(username, geo, weather);
					frame.setVisible(false);
				}
				
			}
			
		});
		background.add(cBox);
		
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
		
		posizioneLabel.setBounds(320, 110, 300, 25);
		posizioneLabel.setText(geo.elementAt(1) + ", " + geo.elementAt(0));
		posizioneLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		posizioneLabel.setForeground(Color.WHITE);
		background.add(posizioneLabel);
		
		titoloDataLabel.setBounds(30, 170, 250, 20);
		titoloDataLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		titoloDataLabel.setForeground(Color.WHITE);
		background.add(titoloDataLabel);
		
		dataLabel.setBounds(30, 200, 250, 20);
		data = cD.convertiDaUnix("dd-MM-yyyy HH:mm:ss", System.currentTimeMillis());
		giorno = data.substring(0, 3);
		dataLabel.setText(data);
		dataLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		dataLabel.setForeground(Color.WHITE);
		background.add(dataLabel);
		
		iconaMeteo = new ImageIcon("images/icone meteo/" + weather.elementAt(nIcona).elementAt(1) + ".png");
//		iconaMeteo = new ImageIcon("images/icone meteo/50n.png");
		iconaMeteoLabel = new JLabel(iconaMeteo);
		iconaMeteoLabel.setBounds(305, 140, 100, 100);
		background.add(iconaMeteoLabel);
		
		tempLabel = new JLabel();
		tempLabel.setBounds(405, 140, 100, 100);
		temp = weather.elementAt(nIcona).elementAt(2);
		tempLabel.setText(temp + "°");
		tempLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		tempLabel.setForeground(Color.WHITE);
		background.add(tempLabel);
		
		tempMin = weather.elementAt(0).elementAt(3);
		tempMinLabel = new JLabel(tempMin + "°");
		if(tempMin.length()>3)
			tempMinLabel.setBounds(524, 135, 80, 60);
		else
			tempMinLabel.setBounds(540, 135, 80, 60);	
		tempMinLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		tempMinLabel.setForeground(Color.CYAN);
		background.add(tempMinLabel);
		
		lineaLabel.setBounds(520, 190, 90, 2);
		lineaLabel.setOpaque(true);
		lineaLabel.setBackground(Color.WHITE);
		background.add(lineaLabel);
		
		tempMax = weather.elementAt(0).elementAt(4);
		tempMaxLabel = new JLabel(tempMax + "°");
		if(tempMax.length()>3)
			tempMaxLabel.setBounds(524, 190, 80, 60);
		else
			tempMaxLabel.setBounds(540, 190, 80, 60);
		tempMaxLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		tempMaxLabel.setForeground(Color.RED);
		background.add(tempMaxLabel);
		
		descrizioneLabel.setBounds(320, 250, 150, 25);
		descrizione = weather.elementAt(nIcona).elementAt(0);
		descrizioneLabel.setText(descrizione.substring(0, 1).toUpperCase() + descrizione.substring(1));
		descrizioneLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		descrizioneLabel.setForeground(Color.WHITE);
		background.add(descrizioneLabel);
		
		
		//Primo elemento previsionale
		
		giorno = this.dataPrevisionale(giorno);
		dataPrevisionaleLabel = new JLabel(giorno);
		dataPrevisionaleLabel.setBounds(82, 330, 100, 20);
		dataPrevisionaleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		dataPrevisionaleLabel.setForeground(Color.WHITE);
		background.add(dataPrevisionaleLabel);
		
		iconaMeteo = new ImageIcon("images/icone meteo/" + weather.elementAt(++nIcona).elementAt(1) + ".png");
		iconaMeteoLabel = new JLabel(iconaMeteo);
		iconaMeteoLabel.setBounds(50, 350, 100, 100);
		background.add(iconaMeteoLabel);
		
		temp = weather.elementAt(nIcona).elementAt(2);
		tempLabel = new JLabel(temp + "°");
//		if(tempMin.length()>4)
//			tempMinLabel.setBounds(524, 135, 80, 60);
//		else
//			tempMinLabel.setBounds(540, 135, 80, 60);	
		tempLabel.setBounds(35, 440, 50, 30);
		tempLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempLabel.setForeground(Color.WHITE);
		background.add(tempLabel);
		
		tempPercepita = weather.elementAt(nIcona).elementAt(3);
		tempPercepitaLabel = new JLabel(tempPercepita + "°");
//		if(tempMax.length()>3)
//			tempMaxLabel.setBounds(100, 440, 50, 30);
//		else
//			tempMaxLabel.setBounds(540, 190, 80, 60);
		tempPercepitaLabel.setBounds(110, 440, 50, 30);
		tempPercepitaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempPercepitaLabel.setForeground(Color.ORANGE);
		background.add(tempPercepitaLabel);
		
		
		//Secondo elemento previsionale
		
		giorno = this.dataPrevisionale(giorno);
		dataPrevisionaleLabel = new JLabel(giorno);
		dataPrevisionaleLabel.setBounds(252, 330, 100, 20);
		dataPrevisionaleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		dataPrevisionaleLabel.setForeground(Color.WHITE);
		background.add(dataPrevisionaleLabel);
		
		iconaMeteo = new ImageIcon("images/icone meteo/" + weather.elementAt(++nIcona).elementAt(1) + ".png");
		iconaMeteoLabel = new JLabel(iconaMeteo);
		iconaMeteoLabel.setBounds(220, 350, 100, 100);
		background.add(iconaMeteoLabel);
		
		temp = weather.elementAt(nIcona).elementAt(2);
		tempLabel = new JLabel(temp + "°");
//		if(tempMin.length()>4)
//			tempMinLabel.setBounds(524, 135, 80, 60);
//		else
//			tempMinLabel.setBounds(540, 135, 80, 60);	
		tempLabel.setBounds(205, 440, 50, 30);
		tempLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempLabel.setForeground(Color.WHITE);
		background.add(tempLabel);
		
		
		tempPercepita = weather.elementAt(nIcona).elementAt(3);
		tempPercepitaLabel = new JLabel(tempPercepita + "°");
//		if(tempMax.length()>3)
//			tempMaxLabel.setBounds(100, 440, 50, 30);
//		else
//			tempMaxLabel.setBounds(540, 190, 80, 60);
		tempPercepitaLabel.setBounds(280, 440, 50, 30);
		tempPercepitaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempPercepitaLabel.setForeground(Color.ORANGE);
		background.add(tempPercepitaLabel);		
		
		//Terzo elemento previsionale
		
		giorno = this.dataPrevisionale(giorno);
		dataPrevisionaleLabel = new JLabel(giorno);
		dataPrevisionaleLabel.setBounds(422, 330, 100, 20);
		dataPrevisionaleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		dataPrevisionaleLabel.setForeground(Color.WHITE);
		background.add(dataPrevisionaleLabel);
		
		iconaMeteo = new ImageIcon("images/icone meteo/" + weather.elementAt(++nIcona).elementAt(1) + ".png");
		iconaMeteoLabel = new JLabel(iconaMeteo);
		iconaMeteoLabel.setBounds(390, 350, 100, 100);
		background.add(iconaMeteoLabel);
		
		temp = weather.elementAt(nIcona).elementAt(2);
		tempLabel = new JLabel(temp + "°");
//		if(tempMin.length()>4)
//			tempMinLabel.setBounds(524, 135, 80, 60);
//		else
//			tempMinLabel.setBounds(540, 135, 80, 60);	
		tempLabel.setBounds(375, 440, 50, 30);
		tempLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempLabel.setForeground(Color.WHITE);
		background.add(tempLabel);
		
		
		tempPercepita = weather.elementAt(nIcona).elementAt(3);
		tempPercepitaLabel = new JLabel(tempPercepita + "°");
//		if(tempMax.length()>3)
//			tempMaxLabel.setBounds(100, 440, 50, 30);
//		else
//			tempMaxLabel.setBounds(540, 190, 80, 60);
		tempPercepitaLabel.setBounds(450, 440, 50, 30);
		tempPercepitaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempPercepitaLabel.setForeground(Color.ORANGE);
		background.add(tempPercepitaLabel);	
		
		
		//Quarto elemento
		
		giorno = this.dataPrevisionale(giorno);
		dataPrevisionaleLabel = new JLabel(giorno);
		dataPrevisionaleLabel.setBounds(592, 330, 100, 20);
		dataPrevisionaleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		dataPrevisionaleLabel.setForeground(Color.WHITE);
		background.add(dataPrevisionaleLabel);
		
		iconaMeteo = new ImageIcon("images/icone meteo/" + weather.elementAt(++nIcona).elementAt(1) + ".png");
		iconaMeteoLabel = new JLabel(iconaMeteo);
		iconaMeteoLabel.setBounds(560, 350, 100, 100);
		background.add(iconaMeteoLabel);
		
		temp = weather.elementAt(nIcona).elementAt(2);
		tempLabel = new JLabel(temp + "°");
//		if(tempMin.length()>4)
//			tempMinLabel.setBounds(524, 135, 80, 60);
//		else
//			tempMinLabel.setBounds(540, 135, 80, 60);	
		tempLabel.setBounds(545, 440, 50, 30);
		tempLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempLabel.setForeground(Color.WHITE);
		background.add(tempLabel);
		
		
		tempPercepita = weather.elementAt(nIcona).elementAt(3);
		tempPercepitaLabel = new JLabel(tempPercepita + "°");
//		if(tempMax.length()>3)
//			tempMaxLabel.setBounds(100, 440, 50, 30);
//		else
//			tempMaxLabel.setBounds(540, 190, 80, 60);
		tempPercepitaLabel.setBounds(620, 440, 50, 30);
		tempPercepitaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempPercepitaLabel.setForeground(Color.ORANGE);
		background.add(tempPercepitaLabel);	
		
		
		//Quinto elemento
		
		giorno = this.dataPrevisionale(giorno);
		dataPrevisionaleLabel = new JLabel(giorno);
		dataPrevisionaleLabel.setBounds(762, 330, 100, 20);
		dataPrevisionaleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		dataPrevisionaleLabel.setForeground(Color.WHITE);
		background.add(dataPrevisionaleLabel);
		
		iconaMeteo = new ImageIcon("images/icone meteo/" + weather.elementAt(++nIcona).elementAt(1) + ".png");
		iconaMeteoLabel = new JLabel(iconaMeteo);
		iconaMeteoLabel.setBounds(730, 350, 100, 100);
		background.add(iconaMeteoLabel);
		
		temp = weather.elementAt(nIcona).elementAt(2);
		tempLabel = new JLabel(temp + "°");
//		if(tempMin.length()>4)
//			tempMinLabel.setBounds(524, 135, 80, 60);
//		else
//			tempMinLabel.setBounds(540, 135, 80, 60);	
		tempLabel.setBounds(735, 440, 50, 30);
		tempLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempLabel.setForeground(Color.WHITE);
		background.add(tempLabel);
		
		
		tempPercepita = weather.elementAt(nIcona).elementAt(3);
		tempPercepitaLabel = new JLabel(tempPercepita + "°");
//		if(tempMax.length()>3)
//			tempMaxLabel.setBounds(100, 440, 50, 30);
//		else
//			tempMaxLabel.setBounds(540, 190, 80, 60);
		tempPercepitaLabel.setBounds(790, 440, 50, 30);
		tempPercepitaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		tempPercepitaLabel.setForeground(Color.ORANGE);
		background.add(tempPercepitaLabel);	

		
		frame.setVisible(true);
	
	}

	private String dataPrevisionale(String g) {
		
		int i = this.giorni.indexOf(g);
		if(i<this.giorni.size()-1)
			return this.giorni.elementAt(i+1);
		else
			return this.giorni.elementAt(0);
	}
	
}
