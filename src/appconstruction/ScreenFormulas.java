package appconstruction;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ScreenFormulas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenFormulas frame = new ScreenFormulas();
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
	public ScreenFormulas() {
		setTitle("Queuing Theory");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitle = new JLabel("Formulas");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 464, 40);
		contentPane.add(lblTitle);
		setLocationRelativeTo(null);
		
		JButton btnF1 = new JButton("Average Time Between Arrivals");
		btnF1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(1,btnF1.getText(),"Lambda","");
				ScreenFormulas.this.dispose();
				
			}
		});
		
		btnF1.setBounds(10, 90, 202, 40);
		contentPane.add(btnF1);
		
		JButton btnF2 = new JButton("Average Service Time");
		btnF2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(2,btnF2.getText(),"Mi","");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF2.setBounds(10, 141, 202, 40);
		contentPane.add(btnF2);
		
		JButton btnF3 = new JButton("Probable Number in the System");
		btnF3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(3,btnF3.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF3.setBounds(10, 195, 202, 40);
		contentPane.add(btnF3);
		
		JButton btnF4 = new JButton("Probable Number in Queue");
		btnF4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(4,btnF4.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF4.setBounds(10, 246, 202, 40);
		contentPane.add(btnF4);
		
		JButton btnF5 = new JButton("System Occupancy");
		btnF5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(5,btnF5.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF5.setBounds(272, 90, 202, 40);
		contentPane.add(btnF5);
		
		JButton btnF6 = new JButton("Empty System Probability");
		btnF6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(6,btnF6.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF6.setBounds(272, 141, 202, 40);
		contentPane.add(btnF6);
		
		JButton btnF7 = new JButton("Empty Queue Probability");
		btnF7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(7,btnF7.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF7.setBounds(272, 195, 202, 40);
		contentPane.add(btnF7);
		
		JButton btnF8 = new JButton("Probable Time in the System");
		btnF8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(8,btnF8.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
			
			}
		});
		btnF8.setBounds(272, 246, 202, 40);
		contentPane.add(btnF8);
		
		JButton btnF9 = new JButton("Probable Time in Queue");
		btnF9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DynamicScreen.main(9,btnF9.getText(),"Lambda","Mi");
				ScreenFormulas.this.dispose();
				
			}
		});
		btnF9.setBounds(140, 297, 202, 40);
		contentPane.add(btnF9);
	}
}
