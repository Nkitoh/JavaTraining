package ex1_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.Preferences;

public class GUI1_4 extends Frame implements ActionListener, Runnable {
	static Thread thread;

	String FontKind = "TimesRoman";
	int FontSize = 100;
	Font f = new Font(FontKind, Font.PLAIN, FontSize);
	Color stringC = Color.black;
	Color backC = Color.white;
	

	Image offscreen = null;

	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	public static void main(String[] args) {

		GUI1_4 frame = new GUI1_4();
		thread = new Thread(frame);

		thread.start();

	}

	public void run() {
		while (true) {
			repaint();
			setBackground(backC);
			setSize(FontSize * 6, FontSize * 3);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {

		offscreen = createImage(getSize().width, getSize().height);

		Graphics og = offscreen.getGraphics();
		og.setClip(0, 0, getSize().width, getSize().height);

		getTime time = new getTime();
		og.setFont(f);
		og.setColor(stringC);
		og.drawString(time.Now(), FontSize, FontSize * 2);// 文字の位置をフォントサイズに合わせて変更

		g.drawImage(offscreen, 0, 0, null);
		og.dispose();

	}

	GUI1_4() {
		super("DigitalClock");
		MenuBar mBar = new MenuBar();
		setMenuBar(mBar);

		Menu mMenu = new Menu("Menu");
		mMenu.addActionListener(this);
		mBar.add(mMenu);

		MenuItem mProperty = new MenuItem("Property");
		mMenu.add(mProperty);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				prefs.putInt("x", (int) getBounds().getX());
				prefs.putInt("y", (int) getBounds().getY());
				prefs.putInt("width", (int) getBounds().getWidth());
				prefs.putInt("height", (int) getBounds().getHeight());

				prefs.put("font", f.toString());
				prefs.putInt("fontSize", FontSize);
				prefs.put("stringC", stringC.toString());
				prefs.put("backC", backC.toString());
				System.exit(0);
			}
		});

		setBounds(prefs.getInt("x", 100), prefs.getInt("y", 200),
				prefs.getInt("width", FontSize * 6),
				prefs.getInt("height", FontSize * 3));

		FontSize = prefs.getInt("fontSize", 100);

		setStringC();
		setBackC();
		setFont();
		this.setSize(FontSize * 6, FontSize * 3);

		setVisible(true);
	}

	public void setFont() {
		if (prefs.get("font", "TimesRoman").equals("TimesRoman"))
			FontKind = "TimesRoman";
		else if (prefs.get("font", "TimesRoman").equals("ＭＳ ゴシック"))
			FontKind = "ＭＳ ゴシック";
		else if (prefs.get("font", "TimesRoman").equals("メイリオ"))
			FontKind = "メイリオ";

		f = new Font(FontKind, Font.PLAIN, FontSize);
	}

	public void setStringC() {
		if (prefs.get("stringC", Color.black.toString()).equals(
				Color.black.toString()))
			stringC = Color.black;
		else if (prefs.get("stringC", Color.black.toString()).equals(
				Color.red.toString()))
			stringC = Color.red;
		else if (prefs.get("stringC", Color.black.toString()).equals(
				Color.blue.toString()))
			stringC = Color.blue;
	}

	public void setBackC() {
		if (prefs.get("backC", Color.white.toString()).equals(
				Color.white.toString()))
			backC = Color.white;
		else if (prefs.get("backC", Color.white.toString()).equals(
				Color.green.toString()))
			backC = Color.green;
		else if (prefs.get("backC", Color.white.toString()).equals(
				Color.yellow.toString()))
			backC = Color.yellow;
		setBackground(backC);
	}

	public void actionPerformed(ActionEvent e) {
		MyDialog dlg = new MyDialog(this);
		dlg.setVisible(true);
	}

	class MyDialog extends Dialog implements ActionListener {
		private Label lFont = new Label("Font");
		private Choice cFont = new Choice();

		private Label lFSize = new Label("Font Size");
		private Choice cSize = new Choice();

		private Label lFColor = new Label("Font Color");
		private Choice cFColor = new Choice();

		private Label lBColor = new Label("Background Color");
		private Choice cBColor = new Choice();

		private GridBagLayout gbLayout = new GridBagLayout();

		MyDialog(Frame owner) {
			super(owner);

			this.addLabel(lFont, 0, 0, 1, 1);
			cFont.add("TimesRoman");
			cFont.add("ＭＳ ゴシック");
			cFont.add("メイリオ");
			this.addChoice(cFont, 1, 0, 2, 1);
			
			  this.addLabel(lFSize, 0, 1, 1, 1); cSize.add("50");
			  cSize.add("100"); cSize.add("200"); this.addChoice(cSize, 1, 1,
			  1, 1);
			  
			  this.addLabel(lFColor, 0, 2, 1, 1); cFColor.add("黒");
			  cFColor.add("赤"); cFColor.add("青"); this.addChoice(cFColor, 1, 2,
			  1, 1);
			  
			  this.addLabel(lBColor, 0, 3, 1, 1); cBColor.add("白");
			  cBColor.add("緑"); cBColor.add("黄"); this.addChoice(cBColor, 1, 3,
			  1, 1);
			  
			  Button bOK = new Button("OK"); bOK.addActionListener(this);
			  this.addButton(bOK, 3, 4, 1, 1); Button bCancel = new
			  Button("Cancel"); bCancel.addActionListener(this);
			  this.addButton(bCancel, 4, 4, 1, 1);
			  
			  Dimension d = getSize(); d.setSize(450, 200);
			  setTitle("Property"); setMinimumSize(d); setResizable(true);
			  setLayout(this.gbLayout);
		}
		 public void actionPerformed(ActionEvent e) {
			 if (e.getActionCommand() == "OK") {
				// フォント変更
					if (this.cFont.getSelectedItem().equals("TimesRoman")) {
						FontKind = "TimesRoman";
						f = new Font(FontKind, Font.PLAIN, FontSize);

					} else if (this.cFont.getSelectedItem().equals("ＭＳ ゴシック")) {
						FontKind = "ＭＳ ゴシック";
						f = new Font(FontKind, Font.PLAIN, FontSize);
					} else if (this.cFont.getSelectedItem().equals("メイリオ")) {
						FontKind = "メイリオ";
						f = new Font(FontKind, Font.PLAIN, FontSize);
					}

					// サイズ変更
					if (this.cSize.getSelectedItem().equals("50")) {
						int size = 50;
						FontSize = size;
						f = new Font(FontKind, Font.PLAIN, FontSize);

					} else if (this.cSize.getSelectedItem().equals("100")) {
						int size = 100;
						FontSize = size;
						f = new Font(FontKind, Font.PLAIN, FontSize);
					} else if (this.cSize.getSelectedItem().equals("200")) {
						int size = 200;
						FontSize = size;
						f = new Font(FontKind, Font.PLAIN, FontSize);

					}

					// 文字色変更
					if (this.cFColor.getSelectedItem().equals("黒")) {
						stringC = Color.black;
					} else if (this.cFColor.getSelectedItem().equals("赤")) {
						stringC = Color.red;
					} else if (this.cFColor.getSelectedItem().equals("青")) {
						stringC = Color.blue;
					}

					// 背景色変更
					if (this.cBColor.getSelectedItem().equals("白")) {
						backC = Color.white;
			
					} else if (this.cBColor.getSelectedItem().equals("緑")) {
						backC = Color.green;
					
					} else if (this.cBColor.getSelectedItem().equals("黄")) {
						backC = Color.yellow;
			
					}
			 }
			 else if (e.getActionCommand() == "Cancel") {
				 setVisible(false);
				 
			 }
		 }

		private void addLabel(Label label, int x, int y, int width, int height) {
			GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
			gbConst.anchor = GridBagConstraints.EAST;
			gbLayout.setConstraints(label, gbConst);
			add(label);
		}

		private void addChoice(Choice choice, int x, int y, int width,
				int height) {
			GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
			gbConst.anchor = GridBagConstraints.WEST;
			gbLayout.setConstraints(choice, gbConst);
			add(choice);
		}

		private void addButton(Button button, int x, int y, int width,
				int height) {
			GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
			gbConst.anchor = GridBagConstraints.WEST;
			gbLayout.setConstraints(button, gbConst);
			add(button);
		}

		private GridBagConstraints prepareGBC(int x, int y, int width,
				int height) {
			GridBagConstraints gbConst = new GridBagConstraints();
			gbConst.gridx = x;
			gbConst.gridy = y;
			gbConst.gridwidth = width;
			gbConst.gridheight = height;
			gbConst.fill = GridBagConstraints.BOTH;
			gbConst.weightx = 100.0;
			gbConst.weighty = 100.0;
			gbConst.insets = new Insets(3, 3, 3, 3);
			return gbConst;
		}
	}
}

class getTime {
	Calendar cal1 = Calendar.getInstance();
	int hour = cal1.get(Calendar.HOUR_OF_DAY);
	int minute = cal1.get(Calendar.MINUTE);
	int second = cal1.get(Calendar.SECOND);

	String Now() {
		return String.valueOf(hour) + ":" + String.valueOf(minute) + ":"
				+ String.valueOf(second);
	}
}