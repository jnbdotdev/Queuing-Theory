package appconstruction;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logics.Formulas;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class DynamicScreen extends JFrame {
	

	private JPanel contentPane;
	public String lblTitleText;
	private JTextField txtResult;
	
	public static void main(int qtdOptions, String lblTitleText, String subtitleOne, String subtitleTwo) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					if(qtdOptions <= 2) {
						DynamicScreen frame = new DynamicScreen(qtdOptions, lblTitleText, subtitleOne);
						frame.setVisible(true);
					}else if(qtdOptions > 2) {
						DynamicScreen frame = new DynamicScreen(qtdOptions,lblTitleText, subtitleOne, subtitleTwo);
						frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

	public DynamicScreen(int option, String lblTitleText, String subtitleOne) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTitle = new JLabel(lblTitleText);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 414, 45);
		contentPane.add(lblTitle);
		
		JFormattedTextField txtVariableOne = new JFormattedTextField();
		txtVariableOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVariableOne.setBounds(10, 99, 182, 45);
		contentPane.add(txtVariableOne);
		
		JLabel lblSubtitle = new JLabel(subtitleOne);
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitle.setForeground(Color.BLACK);
		lblSubtitle.setBounds(10, 83, 182, 14);
		contentPane.add(lblSubtitle);
		
		JButton btnAction = new JButton("=");
		btnAction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Formulas formula = new Formulas();
				
				switch(option) {
				
				case 1:
					txtResult.setText(""+formula.tempoMedioChegadas(Double.parseDouble(txtVariableOne.getText())));
					break;
				case 2:
					txtResult.setText(""+formula.tempoMedioAtendimento(Double.parseDouble(txtVariableOne.getText())));
					break;
				
				}
			
			}
		});
		btnAction.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnAction.setBackground(Color.WHITE);
		btnAction.setBounds(68, 155, 71, 71);
		contentPane.add(btnAction);
		

		MaskFormatter mFormat = null;
		try {
			mFormat = new MaskFormatter("******");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtResult = new JFormattedTextField(mFormat);
		txtResult.setText("");
		txtResult.setBackground(SystemColor.menu);
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtResult.setEditable(false);
		txtResult.setBounds(10, 237, 182, 45);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtResult.selectAll();
				txtResult.copy();
			
			}
		});
		btnCopy.setBounds(46, 293, 115, 36);
		btnCopy.setBackground(Color.WHITE);
		btnCopy.setContentAreaFilled(true);
		contentPane.add(btnCopy);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ScreenFormulas sF = new ScreenFormulas();
				sF.setVisible(true);
				DynamicScreen.this.dispose();
			
			}
		});
		btnBack.setIcon(new ImageIcon(DynamicScreen.class.getResource("/img/left.png")));
		btnBack.setRolloverIcon(new ImageIcon(DynamicScreen.class.getResource("/img/left (1).png")));
		btnBack.setPressedIcon(new ImageIcon(DynamicScreen.class.getResource("/img/left.png")));
		btnBack.setBackground(null);
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(10, 11, 45, 45);
		contentPane.add(btnBack);
		
		MaskFormatter mFormatMin = null;
		try {
			mFormat = new MaskFormatter("***");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField txtMinutos = new JFormattedTextField(mFormatMin);
		txtMinutos.setBackground(SystemColor.menu);
		txtMinutos.setEditable(false);
		txtMinutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMinutos.setBounds(242, 99, 182, 45);
		contentPane.add(txtMinutos);
		
		MaskFormatter mFormatSeg = null;
		try {
			mFormat = new MaskFormatter("***");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField txtSegundos = new JFormattedTextField(mFormatSeg);
		txtSegundos.setBackground(SystemColor.menu);
		txtSegundos.setEditable(false);
		txtSegundos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSegundos.setBounds(242, 237, 182, 45);
		contentPane.add(txtSegundos);
		
		JButton btnConvertMin = new JButton("Convert");
		btnConvertMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtMinutos.setText(""+(Double.parseDouble(txtResult.getText())*60)+" minutes");
			
			}
		});
		btnConvertMin.setContentAreaFilled(true);
		btnConvertMin.setBackground(Color.WHITE);
		btnConvertMin.setBounds(278, 155, 115, 36);
		contentPane.add(btnConvertMin);
		
		JButton btnConvertSeg = new JButton("Convert");
		btnConvertSeg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtSegundos.setText(""+((Double.parseDouble(txtResult.getText())*60)*60)+" seconds");
			
			}
		});
		btnConvertSeg.setContentAreaFilled(true);
		btnConvertSeg.setBackground(Color.WHITE);
		btnConvertSeg.setBounds(278, 293, 115, 36);
		contentPane.add(btnConvertSeg);
		
		JLabel lblSubtitleMin = new JLabel("Minutes");
		lblSubtitleMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitleMin.setForeground(Color.BLACK);
		lblSubtitleMin.setBounds(242, 83, 182, 14);
		contentPane.add(lblSubtitleMin);
		
		JLabel lblSubtitleSeg = new JLabel("Seconds");
		lblSubtitleSeg.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitleSeg.setForeground(Color.BLACK);
		lblSubtitleSeg.setBounds(242, 221, 182, 14);
		contentPane.add(lblSubtitleSeg);
		
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public DynamicScreen(int option, String lblTitleText, String subtitleOne, String subtitleTwo) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ScreenFormulas sF = new ScreenFormulas();
				sF.setVisible(true);
				DynamicScreen.this.dispose();
			
			}
		});
		btnBack.setIcon(new ImageIcon(DynamicScreen.class.getResource("/img/left.png")));
		btnBack.setRolloverIcon(new ImageIcon(DynamicScreen.class.getResource("/img/left (1).png")));
		btnBack.setPressedIcon(new ImageIcon(DynamicScreen.class.getResource("/img/left.png")));
		btnBack.setBackground(null);
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(10, 11, 45, 45);
		contentPane.add(btnBack);
				
		JLabel lblTitle = new JLabel(lblTitleText);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 414, 45);
		contentPane.add(lblTitle);
		
		JFormattedTextField txtVariableOne = new JFormattedTextField();
		txtVariableOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVariableOne.setBounds(10, 95, 196, 45);
		contentPane.add(txtVariableOne);
		
		JLabel lblSubtitle = new JLabel(subtitleOne);
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitle.setBackground(Color.BLACK);
		lblSubtitle.setForeground(Color.BLACK);
		lblSubtitle.setBounds(10, 79, 196, 14);
		contentPane.add(lblSubtitle);
		
		MaskFormatter mFormat = null;
		try {
			mFormat = new MaskFormatter("******");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtResult = new JFormattedTextField(mFormat);
		txtResult.setBackground(SystemColor.menu);
		txtResult.setEditable(false);
		txtResult.setBounds(101, 247, 105, 36);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		
		JFormattedTextField txtVariableTwo = new JFormattedTextField();
		txtVariableTwo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVariableTwo.setBounds(10, 191, 196, 45);
		contentPane.add(txtVariableTwo);
		
		JLabel lblSubtitle2 = new JLabel(subtitleTwo);
		lblSubtitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitle2.setBackground(Color.BLACK);
		lblSubtitle2.setForeground(Color.BLACK);
		lblSubtitle2.setBounds(10, 175, 196, 14);
		contentPane.add(lblSubtitle2);
		
		JButton btnAction = new JButton("=");
		btnAction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Formulas formula = new Formulas();
				
				switch(option) {
				
				case 3:
					txtResult.setText(""+formula.numeroProvavelSistema(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				case 4:
					txtResult.setText(""+formula.numeroProvavelFila(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				case 5:
					txtResult.setText(""+formula.pOcupacaoSistema(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				case 6:
					txtResult.setText(""+formula.probabilidadeSistemaVazio(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				case 7:
					txtResult.setText(""+formula.probabilidadeFilaVazia(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				case 8:
					txtResult.setText(""+formula.tempoProvavelSistema(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				case 9:
					txtResult.setText(""+formula.tempoProvavelFila(Double.parseDouble(txtVariableOne.getText()), Double.parseDouble(txtVariableTwo.getText())));
					break;
				
				}
			
			}
		});
		btnAction.setBackground(Color.WHITE);
		btnAction.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnAction.setBounds(10, 247, 81, 80);
		contentPane.add(btnAction);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtResult.selectAll();
				txtResult.copy();
			
			}
		});
		btnCopy.setBackground(Color.WHITE);
		btnCopy.setBounds(101, 294, 105, 36);
		btnCopy.setContentAreaFilled(true);
		contentPane.add(btnCopy);
		
		JFormattedTextField txtMinutos = new JFormattedTextField();
		txtMinutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMinutos.setBackground(SystemColor.menu);
		txtMinutos.setEditable(false);
		txtMinutos.setColumns(10);
		txtMinutos.setBounds(242, 95, 182, 45);
		contentPane.add(txtMinutos);
		
		MaskFormatter mFormatSeg = null;
		try {
			mFormat = new MaskFormatter("***");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField txtSegundos = new JFormattedTextField(mFormatSeg);
		txtSegundos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSegundos.setBackground(SystemColor.menu);
		txtSegundos.setEditable(false);
		txtSegundos.setColumns(10);
		txtSegundos.setBounds(242, 238, 182, 45);
		contentPane.add(txtSegundos);
		
		JLabel lblMinutos = new JLabel("Minutes");
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setForeground(Color.BLACK);
		lblMinutos.setBackground(Color.BLACK);
		lblMinutos.setBounds(242, 74, 182, 14);
		contentPane.add(lblMinutos);
		
		JLabel lblSegundos = new JLabel("Seconds");
		lblSegundos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundos.setForeground(Color.BLACK);
		lblSegundos.setBackground(Color.BLACK);
		lblSegundos.setBounds(243, 217, 182, 14);
		contentPane.add(lblSegundos);
		
		JButton btnConvertSeg = new JButton("Convert");
		btnConvertSeg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtSegundos.setText(""+((Double.parseDouble(txtResult.getText())*60)*60)+" seconds");
			
			}
		});
		btnConvertSeg.setContentAreaFilled(true);
		btnConvertSeg.setBackground(Color.WHITE);
		btnConvertSeg.setBounds(282, 294, 105, 36);
		contentPane.add(btnConvertSeg);
		
		JButton btnConvertMin = new JButton("Convert");
		btnConvertMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtMinutos.setText(""+(Double.parseDouble(txtResult.getText())*60)+" minutes");
			
			}
		});
		btnConvertMin.setContentAreaFilled(true);
		btnConvertMin.setBackground(Color.WHITE);
		btnConvertMin.setBounds(282, 151, 105, 36);
		contentPane.add(btnConvertMin);
		
	}

	
	//private String lblTitleText,lblSubtitle,lblSubtitle2;

	
	

}
