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
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import it.univpm.CovidForecast.api.ChiamataDati;
import it.univpm.CovidForecast.api.ChiamataStats;
import it.univpm.CovidForecast.exceptions.CFException;

public class CFStats {

	private JFrame frame = new JFrame();

	private ImageIcon backgroundImg = new ImageIcon("images/Background - 2.png");
	private ImageIcon logo = new ImageIcon("images/Logo icona.png");
	private ImageIcon logoInterno = new ImageIcon("images/Logo interno.png");
	private ImageIcon minimize_white = new ImageIcon("images/Minimize_White_48x48.png");
	private ImageIcon minimize_lilac = new ImageIcon("images/Minimize_Lilac_48x48.png");
	private ImageIcon close_white = new ImageIcon("images/Close_White_36x36.png");
	private ImageIcon close_lilac = new ImageIcon("images/Close_Lilac_36x36.png");
	private ImageIcon freccia_white = new ImageIcon("images/Freccia_White_small.png");
	private ImageIcon freccia_lilac = new ImageIcon("images/Freccia_lilac_small.png");
	private ImageIcon iIStats = new ImageIcon("images/Button_crea_statistica_small.png");
	private ImageIcon iIStats_switch = new ImageIcon("images/Button_crea_statistica_switch_small.png");
	
	private JLabel background = new JLabel("", backgroundImg, JLabel.CENTER);
	private JLabel logoInternoLabel = new JLabel(logoInterno);
	private JLabel titoloLogoLabel = new JLabel("CovidForecast");
	private JLabel titoloLabel = new JLabel("Statistiche");
	
	private JButton minimize = new JButton(minimize_white);
	private JButton close = new JButton(close_white);
	private JButton buttonStats = new JButton(iIStats);
	private JButton frecciaButton = new JButton(freccia_white);
	
	private JComboBox<String> cBoxCitta1;
	private JComboBox<String> cBoxCitta2;
	private JComboBox<String> cBoxVariabile;
	private JComboBox<String> cBoxStats;
	
	
	
	private JTextField tField1 = new JTextField(" Inserire la data iniziale");
	private JTextField tField2 = new JTextField(" Inserire la data finale");
	
	private JTextArea textArea = new JTextArea();
	
	private JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	private String[] citta = new String[] {"Ancona", "Cagliari", "Firenze", "Foggia", "Milano", "Napoli", "Palermo", "Perugia", "Torino", "Venezia"};
	private String[] variabile = new String[] {"Scegliere una variabile", "Pressione", "Temperatura", "Temperatura Massima", "Temperatura Minima", "Temperatura Percepita", "Umidità"};
	private HashMap<String, String> variabileMap = new HashMap<String, String>();
	private HashMap<String, String> statsMap = new HashMap<String, String>();
	private String[] stats = new String[] {"Scegliere il tipo di statistica", "Minimo", "Massimo", "Media", "Varianza"};
	private Vector<String> cittaCovid;
	private Vector<String> vettCitta1 = new Vector<String>();
	private Vector<String> vettCitta2 = new Vector<String>();
	
	
	
	private String citta1, citta2, dataInit, dataFin, var, tipoStat;
	
	private ChiamataStats chiamata = new ChiamataStats();
	
	private ChiamataDati cD = new ChiamataDati();
	
	public CFStats(String username, Vector<String> geo, Vector<Vector<String>> weather) {
		
		UIManager.put("ComboBox.selectionBackground", new Color(148,96,161)); //lilac
		
		frame.setTitle("CovidForecast");
		frame.setSize(900, 507);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(logo.getImage());
		frame.setUndecorated(true);

		frame.add(background);		
		
		logoInternoLabel.setBounds(10, 10, 80, 70);
		background.add(logoInternoLabel);

		titoloLogoLabel.setBounds(100, 38, 200, 20);
		titoloLogoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		titoloLogoLabel.setForeground(Color.WHITE);
		background.add(titoloLogoLabel);
		
		titoloLabel.setBounds(375, 25, 150, 20);
		titoloLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		titoloLabel.setForeground(Color.WHITE);
		background.add(titoloLabel);
		
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
		
		frecciaButton.setBounds(40, 290, 48, 48);
		frecciaButton.setContentAreaFilled(false);
		frecciaButton.setBorderPainted(false);
		frecciaButton.setFocusPainted(false);
		frecciaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mEEn) {
				frecciaButton.setIcon(freccia_lilac);
		    }
		    public void mouseExited(MouseEvent mEEx) {
		    	frecciaButton.setIcon(freccia_white);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	frecciaButton.setBounds(40, 295, 48, 48);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	frecciaButton.setBounds(40, 290, 48, 48);
		    }
		    public void mouseClicked(MouseEvent mEC) {
		    	new CFPaginaPrincipale(username, geo, weather);
		    	frame.setVisible(false);
		      }
		    });
		background.add(frecciaButton);
		
		//Prima combobox: prima citta
		
		cittaCovid = cD.chiamata();
		vettCitta1.addAll(cittaCovid);
		vettCitta1.add(0, "Prima città");
		cBoxCitta1 = new JComboBox<String>(vettCitta1);
		cBoxCitta1.setBounds(60, 90, 160, 30);
		cBoxCitta1.setFont(new Font("Arial", Font.PLAIN, 18));
		cBoxCitta1.setForeground(Color.WHITE);
		cBoxCitta1.setFocusable(false);
		cBoxCitta1.setBackground(new Color(148,96,161));
		cBoxCitta1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(cBoxCitta1.getSelectedItem().equals(vettCitta1.firstElement()))
					citta1 = null;
				else {
					int i = cBoxCitta1.getSelectedIndex();
					citta1 = citta[i-1];
				}
				
			}
		});
		background.add(cBoxCitta1);
		
		//Seconda combobox: seconda citta
		
		vettCitta2.addAll(cittaCovid);
		vettCitta2.add(0, "Seconda città");
		cBoxCitta2 = new JComboBox<String>(vettCitta2);
		cBoxCitta2.setBounds(245, 90, 160, 30);
		cBoxCitta2.setFont(new Font("Arial", Font.PLAIN, 18));
		cBoxCitta2.setForeground(Color.WHITE);
		cBoxCitta2.setFocusable(false);
		cBoxCitta2.setBackground(new Color(148,96,161));
		cBoxCitta2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
						
				if(cBoxCitta2.getSelectedItem().equals(vettCitta2.firstElement()))
					citta2 = null;
				else {
					int i = cBoxCitta2.getSelectedIndex();
					citta2 = citta[i-1];
				}
					}
					
			});
		background.add(cBoxCitta2);
		
		//Prima textfield: dataInit
		
		tField1.setBounds(435, 90, 190, 30);
		tField1.setFont(new Font("Arial", Font.PLAIN, 18));
		tField1.setBackground(new Color(148,96,161));
		tField1.setForeground(Color.WHITE);
		tField1.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if(tField1.getText().equals(" Inserire la data iniziale") && !tField1.getText().equals(""))
					tField1.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				if(tField1.getText().equals(""))
					tField1.setText(" Inserire la data iniziale");
			}
		});
		background.add(tField1);
		
		//Seconda textfield: dataFin
		
		tField2.setBounds(650, 90, 190, 30);
		tField2.setFont(new Font("Arial", Font.PLAIN, 18));
		tField2.setBackground(new Color(148,96,161));
		tField2.setForeground(Color.WHITE);
		tField2.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if(tField2.getText().equals(" Inserire la data finale") && !tField2.getText().equals(""))
					tField2.setText("");
			}
			
			public void focusLost(FocusEvent e) {
				if(tField2.getText().equals(""))
					tField2.setText(" Inserire la data finale");
			}
		});
		background.add(tField2);
		
		//Terza combobox: variabile
		
		variabileMap.put("Scegliere una variabile", null);
		variabileMap.put("Pressione", "pressione");
		variabileMap.put("Temperatura", "temp");
		variabileMap.put("Temperatura Massima", "tempMax");
		variabileMap.put("Temperatura Minima", "tempMin");
		variabileMap.put("Temperatura Percepita", "tempPercepita");
		variabileMap.put("Umidità", "umidita");
		
		cBoxVariabile = new JComboBox<String>(variabile);
		cBoxVariabile.setBounds(200, 160, 210, 30);
		cBoxVariabile.setFont(new Font("Arial", Font.PLAIN, 18));
		cBoxVariabile.setForeground(Color.WHITE);
		cBoxVariabile.setFocusable(false);
		cBoxVariabile.setBackground(new Color(148,96,161));
		cBoxVariabile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(variabileMap.containsKey(cBoxVariabile.getSelectedItem()))
					var = variabileMap.get(cBoxVariabile.getSelectedItem());
				else
					var = variabileMap.get(cBoxVariabile.getSelectedItem());
					}
					
			});
		background.add(cBoxVariabile);
		
		//Quarta combobox: tipo statistica
		
		statsMap.put("Scegliere il tipo di statistica", null);
		statsMap.put("Minimo", "min");
		statsMap.put("Massimo", "max");
		statsMap.put("Media", "media");
		statsMap.put("Varianza", "varianza");
		
		cBoxStats = new JComboBox<String>(stats);
		cBoxStats.setBounds(450, 160, 250, 30);
		cBoxStats.setFont(new Font("Arial", Font.PLAIN, 18));
		cBoxStats.setForeground(Color.WHITE);
		cBoxStats.setFocusable(false);
		cBoxStats.setBackground(new Color(148,96,161));
		cBoxStats.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(statsMap.containsKey(cBoxStats.getSelectedItem()))
					tipoStat = statsMap.get(cBoxStats.getSelectedItem());
				else
					tipoStat = statsMap.get(cBoxStats.getSelectedItem());
				
					}
			});
		background.add(cBoxStats);
		
		textArea.setFont(new Font("Arial", Font.PLAIN, 24));
		textArea.setBackground(new Color(148,96,161));
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		scroll.setBounds(250, 220, 400, 200);
		background.add(scroll);
		
		buttonStats.setBounds(340, 440, 200, 48);
		buttonStats.setContentAreaFilled(false);
		buttonStats.setBorderPainted(false);
		buttonStats.setFocusPainted(false);
		buttonStats.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				buttonStats.setIcon(iIStats_switch);
		    }
		    public void mouseExited(MouseEvent evt) {
		    	buttonStats.setIcon(iIStats);
		    }
		    public void mousePressed(MouseEvent mEP) {
		    	buttonStats.setBounds(340, 445, 200, 48);
		    }
		    public void mouseReleased(MouseEvent mEP) {
		    	buttonStats.setBounds(340, 440, 200, 48);
		    }
		      public void mouseClicked(MouseEvent me) {
		    	  try {
		    	  if(cBoxCitta1.getSelectedItem().equals(vettCitta1.firstElement())
		    			  || cBoxCitta2.getSelectedItem().equals(vettCitta2.firstElement())
		    			  || tField1.getText().equals(" Inserire la data iniziale")
		    			  || tField2.getText().equals(" Inserire la data finale")
		    			  || var == null
		    			  || tipoStat == null)
		    		  throw new CFException("Inserire tutti i parametri", "CovidForecast", JOptionPane.ERROR_MESSAGE);
		    	  else {
		    		  dataInit = tField1.getText();
		    		  dataFin = tField2.getText();
		    		  textArea.setText(chiamata.getStats(citta1, citta2, dataInit, dataFin, var, tipoStat));
		    	  	}
		    	  } catch(CFException g) {

		    	  }
		      }
		    });
		buttonStats.setFocusPainted(false);
		background.add(buttonStats);
		
		frame.setVisible(true);
		
	}
	
}
