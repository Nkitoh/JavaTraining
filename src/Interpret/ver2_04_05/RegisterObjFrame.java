package Interpret;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RegisterObjFrame extends Frame {
	private Choice registerObjList = new Choice();
	private Button createNewObjButton = new Button("Create New Obj");
	
	
	public ArrayList<ShowFrame> ArrayObj = new ArrayList<ShowFrame>();

	public static void main(String[] args) {
		new RegisterObjFrame();
	}

	RegisterObjFrame() {
		super("Register Obj");
		setRegisterObj();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		createNewObjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayObj.add(new ShowFrame(ArrayObj.size() + 1));
				showRegisterObj();
			}
		});

	}

	private void showRegisterObj() {

		registerObjList.removeAll();

		for (Integer i = 1; i < ArrayObj.size() + 1; i++) {
			String regiterTitle = ArrayObj.get(i - 1).frameTitle;
			registerObjList.add(regiterTitle);
		}

	}

	private void setRegisterObj() {
		Label title;
		setLayout(null);
		setSize(600, 300);
		setVisible(true);

		title = new Label("Register Obj", Label.CENTER);
		title.setBounds(20, 60, 560, 20);
		add(title);

		registerObjList.setBounds(20, 90, 560, 40);
		add(registerObjList);

		title = new Label("Create New Obj", Label.CENTER);
		title.setBounds(20, 140, 560, 20);
		add(title);

		createNewObjButton.setBounds(20, 170, 560, 40);
		add(createNewObjButton);
		
	}

	// ShowFrame
	private class ShowFrame {
		private Interpret cntObj;
		public String frameTitle;
		private final String registerNum ;

		ShowFrame(Integer registerNum) {
			this.registerNum = registerNum.toString();
			new ConsFrame();
		}
	

		private class ConsFrame extends Frame {
			private TextField classText = new TextField(30);
			private MenuBar mBar = new MenuBar();
			private Menu mMenu = new Menu("Menu");
			private MenuItem mArray = new MenuItem("Create Array");
			private TextField errLog = new TextField(30);

			ConsFrame() {
				super("Input Class");
				frameTitle = "No" + registerNum + ":" + "Input Class";

				setCons();
				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				// Cons
				classText.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							cntObj = new Interpret(e.getActionCommand());
						} catch (ClassNotFoundException err) {
							errLog.setText(err.toString());
						}
						new CreateObjFrame();
						setVisible(false);
					}
				});

				mArray.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new CreateArrFrame();
						setVisible(false);
					}
				});

			}

			private void setCons() {
				Label title;
				setLayout(null);
				setSize(600, 300);

				setMenuBar(mBar);
				mBar.add(mMenu);
				mMenu.add(mArray);

				title = new Label("class name", Label.CENTER);
				title.setBounds(20, 70, 560, 40);
				add(title);

				classText.setBounds(20, 110, 560, 40);
				add(classText);
				
				title = new Label("Err Log", Label.CENTER);
				title.setBounds(20, 160, 560, 40);
				add(title);
				
				errLog.setBounds(20, 210,560, 40);
				add(errLog);
			}
		}

		
		private class CreateObjFrame extends Frame {
			private final int maxArgs = 10;

			private Choice consList = new Choice();
			private TextField[] consArgs = new TextField[maxArgs];
			private Button createObjButton = new Button("Create Obj");
			private Constructor<?>[] cons;
			private TextField errLog = new TextField(30);

			int numArgs;

			CreateObjFrame() {
				super("Cons List");
				frameTitle = "No" + registerNum + ":" + "Cons List";
				showRegisterObj();

				// コンストラクタの一覧
				cons = cntObj.getConstructor();
				for (Member m : cons)
					consList.add(m.toString());

				// メソッド引数を10個分用意
				for (int i = 0; i < consArgs.length; i++)
					consArgs[i] = new TextField(30);

				// UI設定
				numArgs = countNumArgs(consList.getSelectedItem());
				setCreateObj(numArgs);
				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});

				consList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {
						numArgs = countNumArgs(consList.getSelectedItem());
						setCreateObj(numArgs);
					}
				});

				// オブジェクト生成
				createObjButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// メソッドの実行
						int cIndex = searchIndexMethod(
								consList.getSelectedItem(), cons);
						ArrayList<Object> argClass = new ArrayList<Object>();

						Class<?>[] clsForCons = cons[cIndex]
								.getParameterTypes();
						for (int i = 0; i < numArgs; i++)
							argClass.add(getTypeValue(clsForCons[i],
									consArgs[i].getText()));
						try {
							cntObj.createCons(cons[cIndex], argClass.toArray());
						} catch (IllegalArgumentException err) {
							errLog.setText(err.toString());
						} catch (InstantiationException err) {
							errLog.setText(err.toString());
						} catch (IllegalAccessException err) {
							errLog.setText(err.toString());
						} catch (InvocationTargetException err) {
							Throwable cause = err.getCause();
							errLog.setText(cause.toString());
						}
						
						String title = "No" + registerNum + ":"
								+ cntObj.cls.toString();
						new FieldsAndMethodsFrame(title);
						setVisible(false);
					}
				});

			}

			private void setCreateObj(int num) {
				removeAll();
				Label title;
				setLayout(null);
				setSize(600, 320 + num * 20);

				title = new Label("Cons List", Label.CENTER);
				title.setBounds(20, 40, 560, 20);
				add(title);

				consList.setBounds(20, 70, 560, 40);
				add(consList);

				title = new Label("Cons Args", Label.CENTER);
				title.setBounds(20, 130, 560, 20);
				add(title);

				for (int i = 0; i < num; i++) {
					consArgs[i].setBounds(20, 160 + 20 * i, 560, 20);
					add(consArgs[i]);
				}

				createObjButton.setBounds(20, 160 + num * 20, 560, 40);
				add(createObjButton);
				
				title = new Label("Err Log", Label.CENTER);
				title.setBounds(20, 210 + num * 20, 560, 20);
				
				errLog.setBounds(20, 240 + num * 20, 560, 40);
				add(errLog);
			}
		}

		private class FieldsAndMethodsFrame extends Frame {
			private final int maxArgs = 10;

			private TextField fieldSet = new TextField(30);
			private Button fieldSetButton = new Button("field Set");
			private Choice fieldsList = new Choice();
			private TextField fieldValue = new TextField(30);

			private TextField[] methodsArgs = new TextField[maxArgs];
			private Button[] ObjLoadButton = new Button[maxArgs];
			private Button runButton = new Button("Run Method");
			private Choice methodsList = new Choice();

			private int[] isLoad = new int [maxArgs];
			private int numArgs;

			private Interpret.FieldSet[] fields = new Interpret.FieldSet[0];
			private Interpret.MethodSet[] methods = new Interpret.MethodSet[0];
			
			private TextField errLog = new TextField(30);
			private TextField retValOfMethod = new TextField(30);
			
			//引数にオブジェクトを指定するときのフラグ
			private void initIsLoad() {
				for (int i = 0; i < maxArgs; i++)
					isLoad[i] = -1;
			}
			FieldsAndMethodsFrame(String title) {
				super(title);
				frameTitle = title;
				showRegisterObj();

				// メソッド引数を10個分用意
				for (int i = 0; i < methodsArgs.length; i++) {
					methodsArgs[i] = new TextField(30);
					ObjLoadButton[i] = new Button("Load");
				}
				
				initIsLoad();

				// UI設定
				showFieldsAndMethods();
				numArgs = countNumArgs(methodsList.getSelectedItem());

				setFieldsAndMethods(numArgs);

				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});

				fieldsList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {
						int fIndex = searchIndexField(
								fieldsList.getSelectedItem(), fields);
						fieldValue
								.setText(fields[fIndex].getValue().toString());
					}
				});

				methodsList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {
						initIsLoad();
						for (int i = 0; i < maxArgs; i++) {
							methodsArgs[i].setText("");
						}
					}
				});

				methodsList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {
						numArgs = countNumArgs(methodsList.getSelectedItem());
						setFieldsAndMethods(numArgs);
					}
				});

				// メソッドの実行
				runButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						int mIndex = searchIndexMethod(
								methodsList.getSelectedItem(),
								cntObj.cls.getMethods());
						ArrayList<Object> argClass = new ArrayList<Object>();
						for (int i = 0; i < numArgs; i++) {
							if (isLoad[i] >= 0)
								argClass.add(ArrayObj.get(isLoad[i]).cntObj.obj);
							else
								argClass.add(getTypeValue(methods[mIndex].args[i], methodsArgs[i].getText()));
								
						}
						Object returnValue = null;
						try {
							
							returnValue = cntObj.runMethod((Method) methods[mIndex].member, argClass.toArray());
							//cntObj.runMethod((Method) methods[mIndex].member, argClass.toArray());
						} catch (SecurityException err) {
							errLog.setText(err.toString());
						} catch (IllegalArgumentException err) {
							errLog.setText(err.toString());
						} catch (IllegalAccessException err) {
							errLog.setText(err.toString());
						} catch (InvocationTargetException err) {
							Throwable cause = err.getCause();
							errLog.setText(cause.toString());
						} catch (Exception err) {
							errLog.setText(err.toString());
						}
						
						retValOfMethod.setText(returnValue.toString());
					}
				});

				// メソッドの実行
					ObjLoadButton[0].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							isLoad[0] = registerObjList.getSelectedIndex();
							String argsSetText = "No" + (isLoad[0]+1)  + ":" + ArrayObj.get(isLoad[0]).cntObj.cls.toString();
							methodsArgs[0].setText(argsSetText);
						}
					});

				// フィールドのセット
				fieldSetButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int fIndex = searchIndexField(
								fieldsList.getSelectedItem(), fields);
						System.out.println(fIndex);
						System.out.println(transformType(fields[fIndex].type,
								fieldSet.getText()));
						System.out.println(fields[fIndex]);
						
						try {
						cntObj.setField(
								fields[fIndex],
								transformType(fields[fIndex].type,
										fieldSet.getText()));
						} catch (SecurityException err) {
							errLog.setText(err.toString());
						}  catch (IllegalArgumentException err) {
							errLog.setText(err.toString());
						} catch (IllegalAccessException err) {
							errLog.setText(err.toString());
						}
						
						try {
							fields = cntObj.getFieldSet();
						}  catch (IllegalArgumentException err) {
							errLog.setText(err.toString());
						} catch (IllegalAccessException err) {
							errLog.setText(err.toString());
						}
							fieldValue
								.setText(fields[fIndex].getValue().toString());
					}
				});

			}

			private void setFieldsAndMethods(int num) {
				removeAll();
				Label title;
				setLayout(null);
				setSize(600, 550 + num * 20);

				title = new Label("Fields List", Label.CENTER);
				title.setBounds(20, 40, 560, 20);
				add(title);

				fieldsList.setBounds(20, 70, 560, 40);
				add(fieldsList);

				title = new Label("Field Value", Label.CENTER);
				title.setBounds(20, 110, 560, 20);
				add(title);

				fieldValue.setBounds(20, 130, 560, 40);
				add(fieldValue);

				title = new Label("Field Set", Label.CENTER);
				title.setBounds(20, 180, 560, 20);
				add(title);

				fieldSet.setBounds(20, 200, 100, 20);
				add(fieldSet);

				fieldSetButton.setBounds(120, 200, 60, 20);
				add(fieldSetButton);

				title = new Label("Methods List ", Label.CENTER);
				title.setBounds(20, 230, 160, 20);
				add(title);

				methodsList.setBounds(20, 260, 560, 40);
				add(methodsList);

				title = new Label("Method Args", Label.CENTER);
				title.setBounds(20, 310, 560, 20);
				add(title);

				for (int i = 0; i < num; i++) {
					methodsArgs[i].setBounds(20, 340 + 20 * i, 460, 20);
					add(methodsArgs[i]);
					ObjLoadButton[i].setBounds(480, 340 + 20 * i, 100, 20);
					add(ObjLoadButton[i]);
				}

				runButton.setBounds(20, 340 + num * 20, 560, 40);
				add(runButton);
				
				title = new Label("Ret Val", Label.CENTER);
				title.setBounds(20, 390 + num * 20, 560, 20);
				add(title);
				
				retValOfMethod.setBounds(20, 420 + num * 20, 560, 40);
				add(retValOfMethod);
				
				title = new Label("Err Log", Label.CENTER);
				title.setBounds(20, 470 + num * 20, 560, 20);
				add(title);
				
				errLog.setBounds(20, 500 + num * 20, 560, 40);
				add(errLog);
			}

			private void showFieldsAndMethods() {
				try {
					fields = cntObj.getFieldSet();
				} catch (IllegalArgumentException err) {
					errLog.setText(err.toString());
				} catch (IllegalAccessException err) {
					errLog.setText(err.toString());
				}
				
					methods = cntObj.getMethods();

				fieldsList.removeAll();
				methodsList.removeAll();
				// フィールド
				String[] fieldsSort = new String[fields.length];
				for (int i = 0; i < fields.length; i++)
					fieldsSort[i] = fields[i].toString();

				Arrays.sort(fieldsSort, new Comparator<String>() {
					@Override
					public int compare(String obj0, String obj1) {
						return obj0.compareTo(obj1);
					}
				});

				for (int i = 0; i < fields.length; i++)
					fieldsList.add(fieldsSort[i]);

				// メソッド
				String[] methodsSort = new String[methods.length];
				for (int i = 0; i < methods.length; i++)
					methodsSort[i] = methods[i].toString();

				Arrays.sort(methodsSort, new Comparator<String>() {
					@Override
					public int compare(String obj0, String obj1) {
						return obj0.compareTo(obj1);
					}
				});

				for (int i = 0; i < methods.length; i++)
					methodsList.add(methodsSort[i]);

			}

		}
		
		//配列生成
		private class CreateArrFrame extends Frame {
			private TextField classText = new TextField(30);
			private TextField numArray = new TextField(30);
			private Button createArrButton = new Button("Create Arr");
			private MenuBar mBar = new MenuBar();
			private Menu mMenu = new Menu("Menu");
			private MenuItem mCreateCons = new MenuItem("Create one obj");
			private TextField errLog = new TextField(30);

			CreateArrFrame() {
				super("createArr");
				frameTitle = "No" + registerNum + ":" + "createArr";
				showRegisterObj();
				setCreateArr();
				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});

				mCreateCons.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ConsFrame();
						setVisible(false);
					}
				});

				createArrButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							cntObj = new Interpret(classText.getText());
						} catch (ClassNotFoundException err) {
							errLog.setText(err.toString());
						}
						
						try {
							cntObj.createArr(Integer.parseInt(numArray.getText()));
						} catch(NumberFormatException err) {
							errLog.setText(err.toString());
						}
						
						String ArrName =  "No" + (ArrayObj.size())  + ":" + classText.getText() + "[" +Integer.parseInt(numArray.getText()) + "]";
						new ElemsAndMethodsFrame(ArrName);
						setVisible(false);
					}
				});
			}
			
			private void setCreateArr() {
				Label title;
				setLayout(null);
				setSize(600, 300);

				setMenuBar(mBar);
				mBar.add(mMenu);
				mMenu.add(mCreateCons);

				title = new Label("class name", Label.CENTER);
				title.setBounds(20, 70, 560, 40);
				add(title);

				classText.setBounds(20, 110, 560, 40);
				add(classText);

				title = new Label("num array", Label.CENTER);
				title.setBounds(20, 90, 560, 40);
				add(title);

				numArray.setBounds(20, 170, 40, 20);
				add(numArray);

				createArrButton.setBounds(80, 170, 80, 20);
				add(createArrButton);
				
				title = new Label("Err Log", Label.CENTER);
				title.setBounds(20, 200, 560, 40);
				add(title);
				
				errLog.setBounds(20, 250, 560, 40);
				add(errLog);
			}
		}
		
		//配列：要素とメソッド
		private class ElemsAndMethodsFrame extends Frame {
			private final int maxArgs = 10;

			private Button createElemButton = new Button("create obj");
			private Choice elemsList = new Choice();

			private TextField[] methodsArgs = new TextField[maxArgs];
			private Button[] ObjLoadButton = new Button[maxArgs];
			private Button runButton = new Button("Run Method");
			private Choice methodsList = new Choice();

			private int[] isLoad = new int [maxArgs];
			private int numArgs;			
			private Interpret.MethodSet[] methods = new Interpret.MethodSet[0];
			
			private TextField errLog = new TextField(30);
			private TextField retValOfMethod = new TextField(30);
			
			private boolean[] isCons = new boolean[cntObj.objArr.length];
			//引数にオブジェクトを指定するときのフラグ
			private void initIsLoad() {
				for (int i = 0; i < maxArgs; i++)
					isLoad[i] = -1;
			}
			ElemsAndMethodsFrame(String title) {
				super(title);
				frameTitle = title;
				showRegisterObj();

				// メソッド引数を10個分用意
				for (int i = 0; i < methodsArgs.length; i++) {
					methodsArgs[i] = new TextField(30);
					ObjLoadButton[i] = new Button("Load");
				}
				
				initIsLoad();

				// UI設定
				showElemsAndMethods();
				numArgs = countNumArgs(methodsList.getSelectedItem());

				setElemsAndMethods(numArgs);

				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});

				elemsList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {

					}
				});

				methodsList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {
						initIsLoad();
						for (int i = 0; i < maxArgs; i++) {
							methodsArgs[i].setText("");
						}
					}
				});

				methodsList.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent ev) {
						numArgs = countNumArgs(methodsList.getSelectedItem());
						setElemsAndMethods(numArgs);
					}
				});

				// メソッドの実行
				runButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						int mIndex = searchIndexMethod(
								methodsList.getSelectedItem(),
								cntObj.clsArr.getMethods());
						ArrayList<Object> argClass = new ArrayList<Object>();
						for (int i = 0; i < numArgs; i++) {
							if (isLoad[i] >= 0)
								argClass.add(ArrayObj.get(isLoad[i]).cntObj.obj);
							else
								argClass.add(getTypeValue(methods[mIndex].args[i], methodsArgs[i].getText()));
								
						}
						Object returnValue = null;
						try {
							
							returnValue = cntObj.runMethodArr((Method) methods[mIndex].member, argClass.toArray());
						} catch (SecurityException err) {
							errLog.setText(err.toString());
						} catch (IllegalArgumentException err) {
							errLog.setText(err.toString());
						} catch (IllegalAccessException err) {
							errLog.setText(err.toString());
						} catch (InvocationTargetException err) {
							Throwable cause = err.getCause();
							errLog.setText(cause.toString());
						} catch (Exception err) {
							errLog.setText(err.toString());
						}
						
						retValOfMethod.setText(returnValue.toString());
					}
				});

				// メソッドの実行
					ObjLoadButton[0].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							isLoad[0] = registerObjList.getSelectedIndex();
							String argsSetText = "No" + (isLoad[0]+1)  + ":" + ArrayObj.get(isLoad[0]).cntObj.cls.toString();
							methodsArgs[0].setText(argsSetText);
						}
					});

				createElemButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (isCons[elemsList.getSelectedIndex()] == false) {
							isCons[elemsList.getSelectedIndex()] = true;
							System.out.println(elemsList.getSelectedIndex());
							new ShowFrameArr(cntObj.cls, elemsList.getSelectedIndex());
							
						}
						showElemsAndMethods();
					}
				});

			}

			private void setElemsAndMethods(int num) {
				removeAll();
				Label title;
				setLayout(null);
				setSize(600, 550 + num * 20);

				title = new Label("Elemss List", Label.CENTER);
				title.setBounds(20, 40, 560, 20);
				add(title);

				elemsList.setBounds(20, 70, 560, 40);
				add(elemsList);

				

				title = new Label("Create Obj", Label.CENTER);
				title.setBounds(20, 180, 560, 20);
				add(title);


				createElemButton.setBounds(120, 200, 60, 20);
				add(createElemButton);

				title = new Label("Methods List ", Label.CENTER);
				title.setBounds(20, 230, 160, 20);
				add(title);

				methodsList.setBounds(20, 260, 560, 40);
				add(methodsList);

				title = new Label("Method Args", Label.CENTER);
				title.setBounds(20, 310, 560, 20);
				add(title);

				for (int i = 0; i < num; i++) {
					methodsArgs[i].setBounds(20, 340 + 20 * i, 460, 20);
					add(methodsArgs[i]);
					ObjLoadButton[i].setBounds(480, 340 + 20 * i, 100, 20);
					add(ObjLoadButton[i]);
				}

				runButton.setBounds(20, 340 + num * 20, 560, 40);
				add(runButton);
				
				title = new Label("Ret Val", Label.CENTER);
				title.setBounds(20, 390 + num * 20, 560, 20);
				add(title);
				
				retValOfMethod.setBounds(20, 420 + num * 20, 560, 40);
				add(retValOfMethod);
				
				title = new Label("Err Log", Label.CENTER);
				title.setBounds(20, 470 + num * 20, 560, 20);
				add(title);
				
				errLog.setBounds(20, 500 + num * 20, 560, 40);
				add(errLog);
			}

			private void showElemsAndMethods() {
				
				methods = cntObj.getMethodsArr();

				elemsList.removeAll();
				methodsList.removeAll();

				//要素
				for (int i = 0; i < cntObj.objArr.length; i++) {
					Object Elem = cntObj.objArr[i];
					String ElemForList;
					ElemForList = "No" + i + ": ";
					if (isCons[i] == false)
						ElemForList += "null";
					else {
						if (Elem == null)
							ElemForList += "Cons List";
						else
							ElemForList += Elem;
					}
					elemsList.add(ElemForList);
				}
					
				// メソッド
				String[] methodsSort = new String[methods.length];
				for (int i = 0; i < methods.length; i++)
					methodsSort[i] = methods[i].toString();

				Arrays.sort(methodsSort, new Comparator<String>() {
					@Override
					public int compare(String obj0, String obj1) {
						return obj0.compareTo(obj1);
					}
				});

				for (int i = 0; i < methods.length; i++)
					methodsList.add(methodsSort[i]);

			}

			private class ShowFrameArr {
				private Interpret cntObjArr;
				public String frameTitleArr;
				private final String elemNumArr;
				private final Integer elemNumIndex;

				ShowFrameArr(Class<?> cls, Integer elemNumArr) {
					this.elemNumArr = elemNumArr.toString();
					this.elemNumIndex = elemNumArr;
					cntObjArr = new Interpret(cls);
					new CreateObjFrameArr();
				}
				
				private class CreateObjFrameArr extends Frame {
					private final int maxArgs = 10;

					private Choice consListArr = new Choice();
					private TextField[] consArgsArr = new TextField[maxArgs];
					private Button createObjButtonArr = new Button("Create Obj");
					private Constructor<?>[] consArr;
					private TextField errLogArr = new TextField(30);

					int numArgsArr;

					CreateObjFrameArr() {
						super("Cons List");
						frameTitleArr = "ArryNo:" + elemNumArr + ":" + "Cons List";
						
						showElemsAndMethods();

						// コンストラクタの一覧
						consArr = cntObjArr.getConstructor();
						for (Member m : consArr)
							consListArr.add(m.toString());

						// メソッド引数を10個分用意
						for (int i = 0; i < consArgsArr.length; i++)
							consArgsArr[i] = new TextField(30);

						// UI設定
						numArgsArr = countNumArgs(consListArr.getSelectedItem());
						setCreateObjArr(numArgsArr);
						setVisible(true);
						addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								System.exit(0);
							}
						});

						consListArr.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent ev) {
								numArgsArr = countNumArgs(consListArr.getSelectedItem());
								setCreateObjArr(numArgsArr);
							}
						});

						// オブジェクト生成
						createObjButtonArr.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								// メソッドの実行
								int cIndexArr = searchIndexMethod(
										consListArr.getSelectedItem(), consArr);
								ArrayList<Object> argClassArr = new ArrayList<Object>();

								Class<?>[] clsForConsArr = consArr[cIndexArr]
										.getParameterTypes();
								for (int i = 0; i < numArgsArr; i++)
									argClassArr.add(getTypeValue(clsForConsArr[i],
											consArgsArr[i].getText()));
								try {
									cntObjArr.createCons(consArr[cIndexArr], argClassArr.toArray());
									cntObj.objArr[elemNumIndex] = cntObjArr.obj;
									showElemsAndMethods();
								} catch (IllegalArgumentException err) {
									errLogArr.setText(err.toString());
								} catch (InstantiationException err) {
									errLogArr.setText(err.toString());
								} catch (IllegalAccessException err) {
									errLogArr.setText(err.toString());
								} catch (InvocationTargetException err) {
									Throwable cause = err.getCause();
									errLogArr.setText(cause.toString());
								}
								
								String title = "No"  + ":"
										+ cntObjArr.cls.toString();
								new FieldsAndMethodsFrameArr(title);
								setVisible(false);
							}
						});

					}

					private void setCreateObjArr(int num) {
						removeAll();
						Label title;
						setLayout(null);
						setSize(600, 320 + num * 20);

						title = new Label("Cons List", Label.CENTER);
						title.setBounds(20, 40, 560, 20);
						add(title);

						consListArr.setBounds(20, 70, 560, 40);
						add(consListArr);

						title = new Label("Cons Args", Label.CENTER);
						title.setBounds(20, 130, 560, 20);
						add(title);

						for (int i = 0; i < num; i++) {
							consArgsArr[i].setBounds(20, 160 + 20 * i, 560, 20);
							add(consArgsArr[i]);
						}

						createObjButtonArr.setBounds(20, 160 + num * 20, 560, 40);
						add(createObjButtonArr);
						
						title = new Label("Err Log", Label.CENTER);
						title.setBounds(20, 210 + num * 20, 560, 20);
						
						errLogArr.setBounds(20, 240 + num * 20, 560, 40);
						add(errLogArr);
					}
				}
				
				private class FieldsAndMethodsFrameArr extends Frame {
					private final int maxArgsArr = 10;

					private TextField fieldSetArr = new TextField(30);
					private Button fieldSetButtonArr = new Button("field Set");
					private Choice fieldsListArr = new Choice();
					private TextField fieldValueArr = new TextField(30);

					private TextField[] methodsArgsArr = new TextField[maxArgsArr];
					private Button[] ObjLoadButtonArr = new Button[maxArgsArr];
					private Button runButtonArr = new Button("Run Method");
					private Choice methodsListArr = new Choice();

					private int[] isLoadArr = new int [maxArgsArr];
					private int numArgsArr;

					private Interpret.FieldSet[] fieldsArr = new Interpret.FieldSet[0];
					private Interpret.MethodSet[] methodsArr = new Interpret.MethodSet[0];
					
					private TextField errLogArr = new TextField(30);
					private TextField retValOfMethodArr = new TextField(30);
					
					//引数にオブジェクトを指定するときのフラグ
					private void initIsLoadArr() {
						for (int i = 0; i < maxArgsArr; i++)
							isLoadArr[i] = -1;
					}
					FieldsAndMethodsFrameArr(String title) {
						super(title);
						frameTitleArr = title;
					//	showRegisterObj();

						// メソッド引数を10個分用意
						for (int i = 0; i < methodsArgsArr.length; i++) {
							methodsArgsArr[i] = new TextField(30);
							ObjLoadButtonArr[i] = new Button("Load");
						}
						
						initIsLoadArr();

						// UI設定
						showFieldsAndMethodsArr();
						numArgsArr = countNumArgs(methodsListArr.getSelectedItem());

						setFieldsAndMethods(numArgsArr);

						setVisible(true);
						addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								System.exit(0);
							}
						});

						fieldsListArr.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent ev) {
								int fIndex = searchIndexField(
										fieldsListArr.getSelectedItem(), fieldsArr);
								fieldValueArr
										.setText(fieldsArr[fIndex].getValue().toString());
							}
						});

						methodsListArr.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent ev) {
								initIsLoadArr();
								for (int i = 0; i < maxArgsArr; i++) {
									methodsArgsArr[i].setText("");
								}
							}
						});

						methodsListArr.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent ev) {
								numArgsArr = countNumArgs(methodsListArr.getSelectedItem());
								setFieldsAndMethods(numArgsArr);
							}
						});

						// メソッドの実行
						runButtonArr.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								int mIndex = searchIndexMethod(
										methodsListArr.getSelectedItem(),
										cntObjArr.cls.getMethods());
								ArrayList<Object> argClassArr = new ArrayList<Object>();
								for (int i = 0; i < numArgsArr; i++) {
									if (isLoadArr[i] >= 0)
										argClassArr.add(ArrayObj.get(isLoadArr[i]).cntObj.obj);
									else
										argClassArr.add(getTypeValue(methodsArr[mIndex].args[i], methodsArgsArr[i].getText()));
										
								}
								Object returnValue = null;
								try {
									
									returnValue = cntObjArr.runMethod((Method) methodsArr[mIndex].member, argClassArr.toArray());
									//cntObj.runMethod((Method) methods[mIndex].member, argClass.toArray());
								} catch (SecurityException err) {
									errLogArr.setText(err.toString());
								} catch (IllegalArgumentException err) {
									errLogArr.setText(err.toString());
								} catch (IllegalAccessException err) {
									errLogArr.setText(err.toString());
								} catch (InvocationTargetException err) {
									Throwable cause = err.getCause();
									errLogArr.setText(cause.toString());
								} catch (Exception err) {
									errLogArr.setText(err.toString());
								}
								
								retValOfMethodArr.setText(returnValue.toString());
							}
						});

						// メソッドの実行
							ObjLoadButtonArr[0].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									isLoadArr[0] = registerObjList.getSelectedIndex();
									System.out.println(isLoadArr[0]);
									String argsSetText = "No" + (isLoadArr[0]+1)  + ":" + ArrayObj.get(isLoadArr[0]).cntObj.cls.toString();
									methodsArgsArr[0].setText(argsSetText);
								}
							});

						// フィールドのセット
						fieldSetButtonArr.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int fIndex = searchIndexField(
										fieldsListArr.getSelectedItem(), fieldsArr);
								System.out.println(fIndex);
								System.out.println(transformType(fieldsArr[fIndex].type,
										fieldSetArr.getText()));
								System.out.println(fieldsArr[fIndex]);
								cntObj.objArr[elemNumIndex] = cntObjArr.obj;
								showElemsAndMethods();
								
								try {
								cntObjArr.setField(
										fieldsArr[fIndex],
										transformType(fieldsArr[fIndex].type,
												fieldSetArr.getText()));
								} catch (SecurityException err) {
									errLog.setText(err.toString());
								}  catch (IllegalArgumentException err) {
									errLog.setText(err.toString());
								} catch (IllegalAccessException err) {
									errLog.setText(err.toString());
								}
								
								try {
									fieldsArr = cntObjArr.getFieldSet();
								}  catch (IllegalArgumentException err) {
									errLog.setText(err.toString());
								} catch (IllegalAccessException err) {
									errLog.setText(err.toString());
								}
									fieldValueArr
										.setText(fieldsArr[fIndex].getValue().toString());
							}
						});

					}

					private void setFieldsAndMethods(int num) {
						removeAll();
						Label title;
						setLayout(null);
						setSize(600, 550 + num * 20);

						title = new Label("Fields List", Label.CENTER);
						title.setBounds(20, 40, 560, 20);
						add(title);

						fieldsListArr.setBounds(20, 70, 560, 40);
						add(fieldsListArr);

						title = new Label("Field Value", Label.CENTER);
						title.setBounds(20, 110, 560, 20);
						add(title);

						fieldValueArr.setBounds(20, 130, 560, 40);
						add(fieldValueArr);

						title = new Label("Field Set", Label.CENTER);
						title.setBounds(20, 180, 560, 20);
						add(title);

						fieldSetArr.setBounds(20, 200, 100, 20);
						add(fieldSetArr);

						fieldSetButtonArr.setBounds(120, 200, 60, 20);
						add(fieldSetButtonArr);

						title = new Label("Methods List ", Label.CENTER);
						title.setBounds(20, 230, 160, 20);
						add(title);

						methodsListArr.setBounds(20, 260, 560, 40);
						add(methodsListArr);

						title = new Label("Method Args", Label.CENTER);
						title.setBounds(20, 310, 560, 20);
						add(title);

						for (int i = 0; i < num; i++) {
							methodsArgsArr[i].setBounds(20, 340 + 20 * i, 460, 20);
							add(methodsArgsArr[i]);
							ObjLoadButtonArr[i].setBounds(480, 340 + 20 * i, 100, 20);
							add(ObjLoadButtonArr[i]);
						}

						runButtonArr.setBounds(20, 340 + num * 20, 560, 40);
						add(runButtonArr);
						
						title = new Label("Ret Val", Label.CENTER);
						title.setBounds(20, 390 + num * 20, 560, 20);
						add(title);
						
						retValOfMethodArr.setBounds(20, 420 + num * 20, 560, 40);
						add(retValOfMethodArr);
						
						title = new Label("Err Log", Label.CENTER);
						title.setBounds(20, 470 + num * 20, 560, 20);
						add(title);
						
						errLogArr.setBounds(20, 500 + num * 20, 560, 40);
						add(errLogArr);
					}

					private void showFieldsAndMethodsArr() {
						try {
							fieldsArr = cntObjArr.getFieldSet();
						} catch (IllegalArgumentException err) {
							errLog.setText(err.toString());
						} catch (IllegalAccessException err) {
							errLog.setText(err.toString());
						}
						
							methodsArr = cntObj.getMethods();

						fieldsListArr.removeAll();
						methodsListArr.removeAll();
						// フィールド
						String[] fieldsSort = new String[fieldsArr.length];
						for (int i = 0; i < fieldsArr.length; i++)
							fieldsSort[i] = fieldsArr[i].toString();

						Arrays.sort(fieldsSort, new Comparator<String>() {
							@Override
							public int compare(String obj0, String obj1) {
								return obj0.compareTo(obj1);
							}
						});

						for (int i = 0; i < fieldsArr.length; i++)
							fieldsListArr.add(fieldsSort[i]);

						// メソッド
						String[] methodsSort = new String[methodsArr.length];
						for (int i = 0; i < methodsArr.length; i++)
							methodsSort[i] = methodsArr[i].toString();

						Arrays.sort(methodsSort, new Comparator<String>() {
							@Override
							public int compare(String obj0, String obj1) {
								return obj0.compareTo(obj1);
							}
						});

						for (int i = 0; i < methodsArr.length; i++)
							methodsListArr.add(methodsSort[i]);

					}

				}
			}
			
			
			
		}

		// 選択されたメソッドのインデックスを返す
		// リストの中になかった場合は-1を返す
		private int searchIndexMethod(String searchMethod, Member[] methods) {
			for (int i = 0; i < methods.length; i++)
				if (searchMethod.equals(methods[i].toString()))
					return i;
			return -1;
		}

		// 選択されたフィールドのインデックスを返す
		// リストの中になかった場合は-1を返す
		private int searchIndexField(String searchField,
				Interpret.FieldSet[] fields) {
			for (int i = 0; i < fields.length; i++)
				if (searchField.equals(fields[i].toString()))
					return i;
			return -1;
		}

		private int countNumArgs(String name) {
			int numArgs;
			if (name == null)
				return 0;
			numArgs = name.split(",").length;

			if (name.indexOf("()") != -1)
				numArgs = 0;

			return numArgs;
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

		private Object transformType(Type type, String value) {
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
	}

}
