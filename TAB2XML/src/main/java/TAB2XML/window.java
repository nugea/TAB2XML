package TAB2XML;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class window implements ActionListener{

	public JFrame frame;
	private JFileChooser openfile;
	private BufferedImage ori;
	private JScrollPane scrollPane;
	private JMenuItem iNew, iOpen,iSave, iSaveAs, iExit;
	public JTextArea textArea;
	boolean wrap_on = false;
	public JMenuItem mntmNewMenuItemwarp;
	Functioncallfile file = new Functioncallfile(this);
	Functioncallfile format = new Functioncallfile(this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
		format.fontname = "Arial";
		format.font(16);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Choose a file");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
				btnNewButton.addActionListener(this);
				btnNewButton.setActionCommand("Open");
//			}
//		});
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton.setAutoscrolls(true);
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBorder(BorderFactory.createEmptyBorder());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		textArea = new JTextArea();
		
		
		
		
		textArea.setBorder(null);
		textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane_1.setViewportView(textArea);
		
		format.fontname = "Arial";
		format.font(16);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
					.addGap(0))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
		);
		

		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("File");
		menu1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(menu1);
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		
//		iNew, iOpen,iSave, iSaveAs, iExit
		menu1.add(iNew);
		menu1.add(iOpen);
		menu1.add(iSave);
		menu1.add(iSaveAs);
		menu1.add(iExit);
		
		JMenu mnNewMenu = new JMenu("Edit");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_Format = new JMenu("Fromat");
		mnNewMenu_Format.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_Format);
//===========================================================================
		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mnNewMenu_Format.add(mntmNewMenuItemwarp);
//		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mntmNewMenuItemwarp.addActionListener(this);
		mntmNewMenuItemwarp.setActionCommand("Word Wrap");
//===========================================================================
		JMenu mnNewMenufont = new JMenu("Font");
		mnNewMenu_Format.add(mnNewMenufont);
		
		JMenuItem mntmNewMenuItem_Arial = new JMenuItem("Arial");
		mnNewMenufont.add(mntmNewMenuItem_Arial);
		mntmNewMenuItem_Arial.addActionListener(this);
		mntmNewMenuItem_Arial.setActionCommand("Arial");
		
		JMenuItem mntmNewMenuItem_Comic_Sans_Ms = new JMenuItem("Comic Sans Ms");
		mnNewMenufont.add(mntmNewMenuItem_Comic_Sans_Ms);
		mntmNewMenuItem_Comic_Sans_Ms.addActionListener(this);
		mntmNewMenuItem_Comic_Sans_Ms.setActionCommand("Comic Sans Ms");
		
		JMenuItem mntmNewMenuItem_Time_New_Roman = new JMenuItem("Time New Roman");
		mntmNewMenuItem_Time_New_Roman.setAutoscrolls(true);
		mnNewMenufont.add(mntmNewMenuItem_Time_New_Roman);
		mntmNewMenuItem_Time_New_Roman.addActionListener(this);
		mntmNewMenuItem_Time_New_Roman.setActionCommand("Time New Roman");
		
		JMenu mnNewMenufontsize = new JMenu("Font Size");
		mnNewMenu_Format.add(mnNewMenufontsize);
		
		JMenuItem mntmNewMenuItem_size4 = new JMenuItem("4");
		mnNewMenufontsize.add(mntmNewMenuItem_size4);
		mntmNewMenuItem_size4.addActionListener(this);
		mntmNewMenuItem_size4.setActionCommand("size4");
		
		JMenuItem mntmNewMenuItem_size8 = new JMenuItem("8");
		mnNewMenufontsize.add(mntmNewMenuItem_size8);
		mntmNewMenuItem_size8.addActionListener(this);
		mntmNewMenuItem_size8.setActionCommand("size8");
		
		JMenuItem mntmNewMenuItem_size12 = new JMenuItem("12");
		mnNewMenufontsize.add(mntmNewMenuItem_size12);
		mntmNewMenuItem_size12.addActionListener(this);
		mntmNewMenuItem_size12.setActionCommand("size12");
		
		JMenuItem mntmNewMenuItem_size16 = new JMenuItem("16");
		mnNewMenufontsize.add(mntmNewMenuItem_size16);
		mntmNewMenuItem_size16.addActionListener(this);
		mntmNewMenuItem_size16.setActionCommand("size16");
		
		JMenuItem mntmNewMenuItem_size20 = new JMenuItem("20");
		mnNewMenufontsize.add(mntmNewMenuItem_size20);
		mntmNewMenuItem_size20.addActionListener(this);
		mntmNewMenuItem_size20.setActionCommand("size20");
		
		JMenuItem mntmNewMenuItem_size24 = new JMenuItem("24");
		mnNewMenufontsize.add(mntmNewMenuItem_size24);
		mntmNewMenuItem_size24.addActionListener(this);
		mntmNewMenuItem_size24.setActionCommand("size24");
		
		JMenuItem mntmNewMenuItem_size28 = new JMenuItem("28");
		mnNewMenufontsize.add(mntmNewMenuItem_size28);
		mntmNewMenuItem_size28.addActionListener(this);
		mntmNewMenuItem_size28.setActionCommand("size28");
		
		JMenu mnNewMenu_2 = new JMenu("Color");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
//		scrollPane = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		frame.getContentPane().add(scrollPane);
//		textAreanum1 = new JTextArea();
//		textAreanum1.setBounds(1, 1, 110, 24);
//		frame.getContentPane().add(textAreanum1);
//		scrollPane = new JScrollPane(textAreanum1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		frame.getContentPane().add(scrollPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command){
			case "New": file.newfile(); break;
			case "Open": file.open(); break;
			case "SaveAs":file.saveas();break;
			case "Save": file.save();break;
			case "Exit": file.exit();break;
			case "size4": file.font(4);break;
			case "size8": file.font(8);break;
			case "size12": file.font(12);break;
			case "size16": file.font(16);break;
			case "size20": file.font(20);break;
			case "size24": file.font(24);break;
			case "size28": file.font(28);break;
			case "Arial": file.setfont(command);break;
			case "Comic Sans Ms": file.setfont(command);break;
			case "Time New Roman": file.setfont(command);break;
			case "Word Wrap": file.wrap();break;
		}
	}
}


