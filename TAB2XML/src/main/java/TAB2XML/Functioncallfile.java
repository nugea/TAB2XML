package TAB2XML;

import java.awt.FileDialog;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Functioncallfile {

	window win;
	String filename;
	String fileaddress;
	Font arial, comicSansMS, timesNewRoman;
	String fontname="Arial";
	public Functioncallfile(window win) {
		this.win = win;
		
	}
	public void newfile() {
		win.textArea.setText("");
		win.frame.setTitle("New");
		filename = null;
		fileaddress = null;
	}
	public void open() {
		FileDialog fileopen = new FileDialog(win.frame, "Open a txt file", FileDialog.LOAD);
		fileopen.setVisible(true);
		
		if(fileopen.getFile()!=null) {
			filename = fileopen.getFile();
			fileaddress = fileopen.getDirectory();
			win.frame.setTitle(filename);
		}
		try {
			BufferedReader firstbf = new BufferedReader(new FileReader(fileaddress + filename));
			win.textArea.setText("");
			String newtext = null;
			while ((newtext = firstbf.readLine())!=null) {
				win.textArea.append(newtext+"\n");
			}
			firstbf.close();
		}catch(Exception e) {
			System.out.println("File isn't open correctly");
		}
	}
	public void save() {
		if (filename==null) {
			saveas();
		}
		else {
			try {
				FileWriter newfile0  = new FileWriter(fileaddress+filename);
				newfile0.write(win.textArea.getText());
				newfile0.close();
			}catch(Exception e) {
				System.out.println("Save file isn't success");
			}
		}
	}
	public void saveas() {
		FileDialog savefd = new FileDialog(win.frame,"Save As", FileDialog.SAVE);
		savefd.setVisible(true);
		if(savefd.getFile()!=null) {
			filename = savefd.getName();
			fileaddress = savefd.getDirectory();
			win.frame.setTitle(filename);
		}
		try {
			FileWriter newfile1  = new FileWriter(fileaddress+filename);
			newfile1.write(win.textArea.getText());
			newfile1.close();
		}catch(Exception e) {
			System.out.println("Save file isn't success");
		}
	}
	public void exit() {
		System.exit(0);
	}
//====================================================================================format below
	public void wrap() {
		if (win.wrap_on == false) {
			win.wrap_on=true;
			win.textArea.setLineWrap(true);
			win.textArea.setWrapStyleWord(true);
			win.mntmNewMenuItemwarp.setText("Word Wrap: On");
		}
		else if (win.wrap_on == true) {
			win.wrap_on=false;
			win.textArea.setLineWrap(false);
			win.textArea.setWrapStyleWord(false);
			win.mntmNewMenuItemwarp.setText("Word Wrap: Off");
		}
	}
	
	public void font(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans Ms", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Time New Roman", Font.PLAIN, fontSize);
		setfont(fontname);
	}
	public void setfont(String font) {
		fontname = font;
		switch(fontname) {
		case "Arial":
			win.textArea.setFont(arial);
			break;
		case "Comic Sans Ms":
			win.textArea.setFont(comicSansMS);
			break;
		case "Time New Roman":
			win.textArea.setFont(timesNewRoman);
			break;
		}
	}
}