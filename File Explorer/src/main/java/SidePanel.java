
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SidePanel implements ActionListener {
	static JPanel sidePanel;

	JPanel getSidePanel() {
		(sidePanel = new JPanel()).setLayout(null);
		sidePanel.setBounds(0, 80, 200, Toolkit.getDefaultToolkit().getScreenSize().height);
		sidePanel.setBackground(new Color(255, 255, 255));

		JButton quick = new JButton("Quick Access");
		quick.setBounds(-18, 10, 150, 30);
        quick.setIcon(new javax.swing.ImageIcon(getClass().getResource("star.png")));

		JButton down = new JButton("Downloads");
		down.setBounds(-10, 40, 150, 30);
        down.setIcon(new javax.swing.ImageIcon(getClass().getResource("download.png")));

		JButton doc = new JButton("Documents");
		doc.setBounds(-10, 70, 150, 30);
        doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("document.png")));

		JButton pics = new JButton("Pictures");
		pics.setBounds(-18, 100, 150, 30);
        pics.setIcon(new javax.swing.ImageIcon(getClass().getResource("picture.png")));

		JButton pc = new JButton("This Pc");
		pc.setBounds(-38, 150, 150, 30);
		pc.setIcon(new javax.swing.ImageIcon(getClass().getResource("computer.png")));
//		pc.setBounds(-20, 10, 150, 30);

		toJLabel(pc);
		toJLabel(pics);
		toJLabel(doc);
		toJLabel(down);
		toJLabel(quick);

		sidePanel.add(quick);
		sidePanel.add(down);
		sidePanel.add(doc);
		sidePanel.add(pics);
		sidePanel.add(pc);
		return sidePanel;
	}

	private void toJLabel(JButton b) {
		// TODO Auto-generated method stub
		b.setFocusPainted(false);
		b.setMargin(new Insets(0, 0, 0, 0));
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setOpaque(false);
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Downloads"))
			OuterFrame.path = System.getProperty("user.home") + "/Downloads/";

		else if (e.getActionCommand().equals("Documents"))
			OuterFrame.path = System.getProperty("user.home") + "/Documents/";
		else if (e.getActionCommand().equals("Pictures"))
			OuterFrame.path = System.getProperty("user.home") + "/Pictures/";
		else if (e.getActionCommand().equals("This Pc"))
			OuterFrame.path = "ThisPc";

		OuterFrame.rePaintFrame();
	}

}
