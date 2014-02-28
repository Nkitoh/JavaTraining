package Interpret;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShowFrame extends Frame implements ActionListener{
	private GridBagLayout gbLayout = new GridBagLayout();
	private TextField textfield = new TextField("test", 30);
	
	public static void main(String[] args) {
		ShowFrame frame = new ShowFrame();
		frame.setSize(300, 300);
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}

	ShowFrame() {
		super("Interpret");
		
		this.addTextField(textfield, 3, 1, 10, 1, GridBagConstraints.WEST);
		setLayout(this.gbLayout);

	
			addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void addTextField(TextField textField, int x, int y, int width, int height, int anchor) {
		GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
		gbConst.anchor = anchor;
		gbLayout.setConstraints(textField, gbConst);
		add(textField);
	}
	
	private GridBagConstraints prepareGBC(int x, int y, int width, int height) {
		GridBagConstraints gbConst = new GridBagConstraints();
		gbConst.gridx = x;
		gbConst.gridy = y;
		gbConst.gridwidth = width;
		gbConst.gridheight = height;
		gbConst.fill = GridBagConstraints.HORIZONTAL;
		gbConst.weightx = 100.0;
		gbConst.weighty = 100.0;
		gbConst.insets = new Insets(3, 3, 3, 3);
		return gbConst;
	}

	
	public void actionPerformed(ActionEvent e) {
		

		
	}

}
