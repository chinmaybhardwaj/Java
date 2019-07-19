
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainPanel implements ActionListener {

    private final String[] imgKeys = {".png",".jpg",".jpeg"};
    private final String[] videoKeys = {".mp3",".mp4",".avi",".mkv"};

	JPanel getMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(205, 80, Toolkit.getDefaultToolkit().getScreenSize().width - 200, Toolkit.getDefaultToolkit().getScreenSize().height);
		mainPanel.setBackground(new Color(255, 255, 255));
		//
		/*JScrollPane scroll=new JScrollPane(mainPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); scroll.setBounds(870, 0, 30, 550);
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500, 400));
		contentPane.add(scroll);
		OuterFrame.outer.setContentPane(contentPane);*/
		//
		if (OuterFrame.path.equals("ThisPc")) {
			JButton b;
			int ct = 0;
			File[] fileList = File.listRoots();
			for (File f : fileList) {
				b = new JButton(f.getPath());
				b.setBounds(130 * (ct % 5) + 10, 30 * (ct / 5) + 10, 120, 20);
				b.addActionListener(this);
                b.setIcon(new javax.swing.ImageIcon(getClass().getResource("disk.png")));
                b.setContentAreaFilled(false);
                b.setBorderPainted(true);
                b.setOpaque(false);
                b.setBorder(new LineBorder(Color.BLACK));
				mainPanel.add(b);
				ct++;
			}
		} else {
			JButton b;
			int ct = 0;
			File[] fileList = (new File(OuterFrame.path)).listFiles();

            ArrayList<File> fileArrayList = new ArrayList<>();

            if(fileList != null) {
                for (File f : fileList) {
                    //
                    boolean containsImage = Arrays.stream(imgKeys).anyMatch(f.getName()::endsWith);
                    boolean containsVideo = Arrays.stream(videoKeys).anyMatch(f.getName()::endsWith);
                    //
                    if (containsImage || containsVideo || f.isDirectory() || !f.isHidden()) {
                        fileArrayList.add(f);
                    }
                }
            }

			for (File f : fileArrayList) {

                b = new JButton(f.getName());
                b.setBounds(130 * (ct % 5), 30 * (ct / 5), 120, 20);
                b.addActionListener(this);
                b.setContentAreaFilled(false);
                b.setBorderPainted(true);
                b.setOpaque(false);
                b.setBorder(new LineBorder(Color.BLACK));
                //
                boolean containsImage = Arrays.stream(imgKeys).anyMatch(f.getName()::endsWith);
                boolean containsVideo = Arrays.stream(videoKeys).anyMatch(f.getName()::endsWith);
                //
                if(containsImage){
                    b.setHorizontalAlignment(SwingConstants.LEFT);
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/picture.png")));
                }
                //
                if(containsVideo){
                    b.setHorizontalAlignment(SwingConstants.LEFT);
                    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/video.png")));
                }
                //
				b.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON3) {
							System.out.println("Right Button Pressed " + f.getName());
                            //
                            showPopUpMenu(e, f);
						}
					}
				});
                mainPanel.add(b);
                ct++;
			}
		}
		return mainPanel;
	}


    private void showPopUpMenu(MouseEvent e, File file){
        PopUpMenu menu = new PopUpMenu(file);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

	@Override
	public void actionPerformed(ActionEvent e) {

		File file = new File(OuterFrame.path + e.getActionCommand() + "/");
		if (file.isDirectory() || OuterFrame.path.equals("ThisPc")) {

			if (OuterFrame.path.equals("ThisPc"))
				OuterFrame.path = e.getActionCommand();
			else
				OuterFrame.path = OuterFrame.path + e.getActionCommand() + "/";
			OuterFrame.rePaintFrame();
		} else {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(file.getPath());
			}
		}
	}
}
