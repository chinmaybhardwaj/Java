import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TopPanel implements KeyListener {

	static JTextField add;
	static JLabel lblDetail;

	JPanel getTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 20, Toolkit.getDefaultToolkit().getScreenSize().width, 55);
		topPanel.setBackground(new Color(255, 255, 255));

		JButton back = new JButton();
		back.setIcon(new javax.swing.ImageIcon(getClass().getResource("backButton.png")));
		back.setFocusPainted(false);
		back.setMargin(new Insets(10, 10, 10, 10));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setOpaque(false);
		back.setBounds(30, 10, 30, 30);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OuterFrame.path = (new File(OuterFrame.path).getParent());
				OuterFrame.rePaintFrame();
			}
		});

		add = new JTextField(OuterFrame.path);
		add.setBounds(210, 10, 450, 30);
		add.addKeyListener(this);

		lblDetail = new JLabel("Right Click File for Action");
		lblDetail.setBounds(700, 10,  Toolkit.getDefaultToolkit().getScreenSize().width - 130, 30);


		JButton scan = new JButton("Scan");
//		scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("backButton.png")));
		scan.setFocusPainted(false);
		scan.setMargin(new Insets(10, 10, 10, 10));
		scan.setContentAreaFilled(false);
		scan.setBorderPainted(true);
		scan.setOpaque(true);
		scan.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 120, 10, 100, 30);
		scan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                OuterFrame.mTopPanel.setDetailText("Starting Scan....");
                try {
//                    Process p = Runtime.getRuntime().exec(new String[]{"csh","-c","cat /home/narek/pk.txt"});

                    Process process =
                            new ProcessBuilder(new String[] {"bash", "-c", "cat /home/narek/pk.txt"})
                                    .redirectErrorStream(true)
                                    .directory(new File(OuterFrame.path))
                                    .start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
		});

		topPanel.add(add);
		topPanel.add(back);
		topPanel.add(lblDetail);
		topPanel.add(scan);

		return topPanel;
	}

	public void setDetailText(String detail){
		if(lblDetail != null)
			lblDetail.setText(detail);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			OuterFrame.path = add.getText();
			OuterFrame.rePaintFrame();
		}
	}

}
