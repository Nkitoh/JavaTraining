package Interpret;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ShowFrame extends Frame {
	private GridBagLayout gbLayout = new GridBagLayout();
	private TextField classText = new TextField("java.awt.Frame", 30);
	private Choice classes = new Choice();
	private Choice fields = new Choice();
	private Choice methods = new Choice();
	// private TextField fieldName = new TextField(30);
	private TextField fieldValue = new TextField(30);
	// private TextField methodName = new TextField(30);
	private TextField methodArg = new TextField(30);
	private TextField outputArea = new TextField(30);
	private Button createObjButton;
	private Button runButton;
	private Button registerButton;
	private Button loadButton;
	private Interpret cntObj;
	private Interpret.FieldSet[] fieldList = new Interpret.FieldSet[0];
	private Interpret.MethodSet[] methodList = new Interpret.MethodSet[0];
	private ArrayList<Interpret> register = new ArrayList<Interpret>();
	private Object loadObj;
	private boolean isLoad = false;
	
	public static void main(String[] args) {
		new ShowFrame("interpret");
	}

	public ShowFrame(String title) {
		super(title);
		createFrame();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// コンストラクタ
		classText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputAll();
				fields.removeAll();
				methods.removeAll();
				cntObj = new Interpret(e.getActionCommand(), ShowFrame.this);

				methodList = cntObj.getConstructor();

				for (Interpret.MethodSet ms : methodList)
					methods.add(ms.toString());

			}
		});

		// オブジェクト生成
		createObjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// メソッドの実行
				int mIndex = serchIndexMethod(methods.getSelectedItem());
				ArrayList<Object> argClass = new ArrayList<Object>();
				String[] sArg;
				if (methodArg.getText().equals(""))
					sArg = new String[0];
				else
					sArg = methodArg.getText().split(",");

				for (int i = 0; i < sArg.length; i++)
					argClass.add(getTypeValue(methodList[mIndex].args[i],
							sArg[i]));

				Constructor<?> cons = (Constructor<?>) methodList[mIndex].member;

				cntObj.createCons(cons, argClass.toArray());

				showFieldsAndMethods();

			}
		});
		// メソッドの実行
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// メソッドの実行
				int mIndex = serchIndexMethod(methods.getSelectedItem());
				ArrayList<Object> argClass = new ArrayList<Object>();
				String[] sArg;
				if (isLoad == true) {
					argClass.add(loadObj);
					cntObj.runMethod((Method) methodList[mIndex].member, argClass.toArray() );
				}
				else {
				
				if (methodArg.getText().equals(""))
					sArg = new String[0];
				else
					sArg = methodArg.getText().split(",");

				for (int i = 0; i < sArg.length; i++)
					argClass.add(getTypeValue(methodList[mIndex].args[i],
							sArg[i]));

				Object returnValue = cntObj.runMethod(
						(Method) methodList[mIndex].member, argClass.toArray());

				showFieldsAndMethods();
				}
				isLoad = false;
			}
		});

		// オブジェクトの登録
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register.add(cntObj);
				classes.add(classText.getText());
			}
		});
		
		//オブジェクトの読み込み
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strObj = classes.getSelectedItem();
				methodArg.setText(strObj);
				loadObj = register.get(classes.getItemCount()-1);
				isLoad = true;
			}
		});
	}

	// 選択されたフィールドのインデックスを返す
	// リストの中になかった場合は-1を返す
	private int serchIndexField(String field) {
		for (int i = 0; i < fieldList.length; i++)
			if (field.equals(fieldList[i].toString()))
				return i;
		return -1;
	}

	// 選択されたメソッドのインデックスを返す
	// リストの中になかった場合は-1を返す
	private int serchIndexMethod(String method) {
		for (int i = 0; i < methodList.length; i++)
			if (method.equals(methodList[i].toString()))
				return i;
		return -1;
	}

	private Object getTypeValue(Class<?> type, String value) {
		if (type.equals(int.class))
			return Integer.parseInt(value);
		else if (type.equals(double.class))
			return Double.parseDouble(value);
		else if (type.equals(long.class))
			return Long.parseLong(value);
		else if (type.equals(float.class))
			return Float.parseFloat(value);
		else if (type.equals(short.class))
			return Short.parseShort(value);
		else if (type.equals(byte.class))
			return Byte.parseByte(value);
		else if (type.equals(boolean.class))
			return Boolean.parseBoolean(value);
		else
			return value;
	}

	private Class<?> getType(String name) {
		if (name.equals("int"))
			return int.class;
		else if (name.equals("double"))
			return double.class;
		else if (name.equals("long"))
			return long.class;
		else if (name.equals("float"))
			return float.class;
		else if (name.equals("short"))
			return short.class;
		else if (name.equals("byte"))
			return byte.class;
		else if (name.equals("boolean"))
			return boolean.class;
		else
			return null;
	}

	private void showFieldsAndMethods() {
		fieldList = cntObj.getFieldSet();
		methodList = cntObj.getMethods();
		fields.removeAll();
		methods.removeAll();
		for (Interpret.FieldSet fs : fieldList)
			fields.add(fs.toString());
		for (Interpret.MethodSet ms : methodList)
			methods.add(ms.toString());
	}

	private void createFrame() {
		Label title;
		setSize(450, 800);

		title = new Label("クラス");
		this.addLabel(title, 0, 0, 1, 1);
		this.addTextField(classText, 1, 0, 1, 1);

		title = new Label("クラスフィールド");
		this.addLabel(title, 0, 1, 1, 1);
		this.addChoice(fields, 1, 1, 1, 1);

		title = new Label("クラスメソッド");
		this.addLabel(title, 0, 2, 1, 1);
		this.addChoice(methods, 1, 2, 1, 1);

		title = new Label("オブジェクト");
		this.addLabel(title, 0, 3, 1, 1);
		this.addChoice(classes, 1, 3, 1, 1);
		/*
		 * title = new Label("選択フィールド"); this.addLabel(title, 0, 4, 1, 1);
		 * this.addTextField(fieldName, 1, 4, 1, 1);
		 */
		title = new Label("値");
		this.addLabel(title, 0, 4, 1, 1);
		this.addTextField(fieldValue, 1, 4, 1, 1);
		/*
		 * title = new Label("選択メソッド"); this.addLabel(title, 0, 6, 1, 1);
		 * this.addTextField(methodName, 1, 6, 1, 1);
		 */
		title = new Label("引数");
		this.addLabel(title, 0, 5, 1, 1);
		this.addTextField(methodArg, 1, 5, 1, 1);

		title = new Label("出力結果");
		this.addLabel(title, 0, 6, 1, 1);
		this.addTextField(outputArea, 1, 6, 1, 1);

		runButton = new Button("実行");
		this.addButton(runButton, 0, 7, 1, 1);

		registerButton = new Button("登録");
		this.addButton(registerButton, 1, 7, 1, 1);

		loadButton = new Button("読み込み");
		this.addButton(loadButton, 0, 8, 1, 1);

		createObjButton = new Button("オブジェクト生成");
		this.addButton(createObjButton, 1, 8, 1, 1);

		setLayout(this.gbLayout);
	}

	public void outputException(Throwable e) {
		outputArea.setText(e.toString());
	}

	void clearInputAll() {
		// .setText("");
		fieldValue.setText("");
		// methodName.setText("");
		methodArg.setText("");
	}

	private void addLabel(Label label, int x, int y, int width, int height) {
		GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
		gbConst.anchor = GridBagConstraints.EAST;
		gbLayout.setConstraints(label, gbConst);
		add(label);
	}

	private void addChoice(Choice choice, int x, int y, int width, int height) {
		GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
		gbConst.anchor = GridBagConstraints.WEST;
		gbLayout.setConstraints(choice, gbConst);
		add(choice);
	}

	private void addButton(Button button, int x, int y, int width, int height) {
		GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
		gbConst.anchor = GridBagConstraints.WEST;
		gbLayout.setConstraints(button, gbConst);
		add(button);
	}

	private void addTextField(TextField textField, int x, int y, int width,
			int height) {
		GridBagConstraints gbConst = this.prepareGBC(x, y, width, height);
		gbConst.anchor = GridBagConstraints.WEST;
		gbLayout.setConstraints(textField, gbConst);
		add(textField);
	}

	private GridBagConstraints prepareGBC(int x, int y, int width, int height) {
		GridBagConstraints gbConst = new GridBagConstraints();
		gbConst.gridx = x;
		gbConst.gridy = y;
		gbConst.gridwidth = width;
		gbConst.gridheight = height;
		gbConst.fill = GridBagConstraints.BOTH;
		gbConst.weightx = 100.0;
		gbConst.weighty = 100.0;
		gbConst.insets = new Insets(1, 1, 1, 1);
		return gbConst;
	}
}
