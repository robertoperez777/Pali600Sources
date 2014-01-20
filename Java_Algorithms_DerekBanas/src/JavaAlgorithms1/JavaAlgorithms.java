package JavaAlgorithms1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JavaAlgorithms extends JFrame {

	private JPanel contentPane;

	private JTextField arrayValueTextField;
	private JTable table;
	private JTextField arrayIndexTextField;
	private JButton insertButton, deleteButton, findButton, sortButton;
	JRadioButton linearSearchRadioButton, binarySearchRadioButton;
	JRadioButton descendingRadioButton, ascendingRadioButton;

	int cellToMark = -1;

	// Holds the array that goes in JTable

	Object[][] data = { { new Integer(0), new Integer(0), "" }, { new Integer(1), new Integer(0), "" },
			{ new Integer(2), new Integer(0), "" }, { new Integer(3), new Integer(0), "" }, { new Integer(4), new Integer(0), "" },
			{ new Integer(5), new Integer(0), "" }, { new Integer(6), new Integer(0), "" }, { new Integer(7), new Integer(0), "" },
			{ new Integer(8), new Integer(0), "" }, { new Integer(9), new Integer(0), "" }, };

	String[] columnNames = { "Index", "Value", "Selected" };

	DefaultTableModel dTableModel = new DefaultTableModel(this.data, this.columnNames);

	/**
	 * Create the frame.
	 */
	public JavaAlgorithms() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 970, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);

		JLabel valueLabel = new JLabel("Value");
		valueLabel.setFont(new Font("Dialog", Font.BOLD, 30));

		this.arrayValueTextField = new JTextField();
		this.arrayValueTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
		this.arrayValueTextField.setColumns(10);

		JLabel indexLabel = new JLabel("Index");
		indexLabel.setFont(new Font("Dialog", Font.BOLD, 30));

		this.arrayIndexTextField = new JTextField();
		this.arrayIndexTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
		this.arrayIndexTextField.setColumns(10);

		this.insertButton = new JButton("Insert");
		this.insertButton.setFont(new Font("Dialog", Font.BOLD, 30));

		this.deleteButton = new JButton("Delete");
		this.deleteButton.setFont(new Font("Dialog", Font.BOLD, 30));

		this.findButton = new JButton("Find");
		this.findButton.setFont(new Font("Dialog", Font.BOLD, 30));

		JScrollPane scrollPane = new JScrollPane();

		this.ascendingRadioButton = new JRadioButton("Ascending");
		this.ascendingRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));

		this.descendingRadioButton = new JRadioButton("Descending");
		this.descendingRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));

		// Stores the radio buttons so when one is selected the other is deselected

		ButtonGroup sortDirection = new ButtonGroup();

		sortDirection.add(this.ascendingRadioButton);

		sortDirection.add(this.descendingRadioButton);

		this.sortButton = new JButton("Sort");
		this.sortButton.setFont(new Font("Dialog", Font.BOLD, 30));

		// Sets up the radio buttons for the search type

		this.linearSearchRadioButton = new JRadioButton("Linear");
		this.linearSearchRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));

		this.binarySearchRadioButton = new JRadioButton("Binary");
		this.binarySearchRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));

		ButtonGroup searchType = new ButtonGroup();

		searchType.add(this.linearSearchRadioButton);
		searchType.add(this.binarySearchRadioButton);

		JTextArea textArea = new JTextArea("Output");
		textArea.setFont(new Font("Dialog", Font.PLAIN, 30));

		// ------------------------

		GroupLayout groupLayout = new GroupLayout(this.contentPane);

		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(30)
										.addGroup(
												groupLayout
														.createParallelGroup(Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 339,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(Alignment.LEADING, false)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												this.ascendingRadioButton)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												this.descendingRadioButton))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(valueLabel)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												this.arrayValueTextField,
																												GroupLayout.PREFERRED_SIZE,
																												71,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(34)
																										.addComponent(indexLabel,
																												GroupLayout.PREFERRED_SIZE,
																												87,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												this.arrayIndexTextField,
																												GroupLayout.PREFERRED_SIZE,
																												71,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(Alignment.LEADING, false)
																						.addGroup(
																								groupLayout.createSequentialGroup()
																										.addComponent(this.insertButton)
																										.addGap(26)
																										.addComponent(this.deleteButton)
																										.addGap(26)
																										.addComponent(this.findButton))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(this.sortButton)
																										.addGap(18)
																										.addComponent(
																												this.linearSearchRadioButton)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												this.binarySearchRadioButton)))))
										.addContainerGap(75, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(
												groupLayout
														.createParallelGroup(Alignment.BASELINE)
														.addComponent(valueLabel)
														.addComponent(this.insertButton)
														.addComponent(this.deleteButton)
														.addComponent(this.findButton)
														.addComponent(this.arrayValueTextField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addGroup(
																groupLayout
																		.createParallelGroup(Alignment.BASELINE)
																		.addComponent(indexLabel, GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(this.arrayIndexTextField, GroupLayout.PREFERRED_SIZE,
																				40, GroupLayout.PREFERRED_SIZE)).addGap(2)))
						.addGap(35)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(this.ascendingRadioButton)
										.addComponent(this.descendingRadioButton).addComponent(this.sortButton)
										.addComponent(this.linearSearchRadioButton).addComponent(this.binarySearchRadioButton))
						.addGap(42)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING, false).addComponent(textArea)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
						.addContainerGap(94, Short.MAX_VALUE)));

		this.table = new JTable(this.dTableModel);

		// Set the font for the table column titles

		this.table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 30));

		// Set the font for the data in the columns

		this.table.setFont(new Font("Dialog", Font.BOLD, 30));

		// Increase the row height so that the larger font fits

		this.table.setRowHeight(this.table.getRowHeight() + 30);

		scrollPane.setViewportView(this.table);

		this.contentPane.setLayout(groupLayout);
	}

	// Set up all the listeners

	void addInsertButtonListener(ActionListener listenerForInsertButton) {

		this.insertButton.addActionListener(listenerForInsertButton);

	}

	void addDeleteButtonListener(ActionListener listenerForDeleteButton) {

		this.deleteButton.addActionListener(listenerForDeleteButton);

	}

	void addFindButtonListener(ActionListener listenerForFindButton) {

		this.findButton.addActionListener(listenerForFindButton);

	}

	void addSortButtonListener(ActionListener listenerForSortButton) {

		this.sortButton.addActionListener(listenerForSortButton);

	}

	// Other Random Methods Needed

	void sendMessageToUser(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);

	}

	public int getTheValue() {

		return Integer.parseInt(this.arrayValueTextField.getText());

	}

	public int getTheIndex() {

		return Integer.parseInt(this.arrayIndexTextField.getText());

	}

	public void updateTheTable(int[] newArray, int rows) {

		Object[] tempRow;

		this.dTableModel.setRowCount(0); // Clear JTable

		for (int i = 0; i < rows; i++) {

			if (i == this.cellToMark) {
				tempRow = new Object[] { i, newArray[i], "XXXXX" };
			} else {
				tempRow = new Object[] { i, newArray[i], "" };
			}

			this.dTableModel.addRow(tempRow);

		}

	}

}

class AlgorithmsMVC {

	public static void main(String[] args) {

		JavaAlgorithms theView = new JavaAlgorithms();
		ArrayStructure theModel = new ArrayStructure();

		AlgorithmsController theController = new AlgorithmsController(theView, theModel);

		theView.setVisible(true);

	}

}

class AlgorithmsController {

	private JavaAlgorithms theView;
	private ArrayStructure theModel;

	public AlgorithmsController(JavaAlgorithms theView, ArrayStructure theModel) {

		this.theView = theView;
		this.theModel = theModel;

		theModel.generateRandomArray();

		// Add button listeners

		this.theView.addInsertButtonListener(new InsertButtonListener());
		this.theView.addDeleteButtonListener(new DeleteButtonListener());
		this.theView.addFindButtonListener(new FindButtonListener());
		this.theView.addSortButtonListener(new SortButtonListener());

		// Put random array data in the table model

		theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());

	}

	// ActionListener for the Insert Button

	class InsertButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {

				AlgorithmsController.this.theModel.insertValue(AlgorithmsController.this.theView.getTheValue());

				// Take the array data from the model & move it to the JTable

				AlgorithmsController.this.theView.updateTheTable(AlgorithmsController.this.theModel.getTheArray(),
						AlgorithmsController.this.theModel.getArraySize());

			}

			catch (NumberFormatException ex) {

				AlgorithmsController.this.theView.sendMessageToUser("You Need a Value in the Value Box");

			}

		}

	}

	// ActionListener for the Insert Button

	class DeleteButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {

				AlgorithmsController.this.theModel.deleteIndex(AlgorithmsController.this.theView.getTheIndex());

				AlgorithmsController.this.theView.updateTheTable(AlgorithmsController.this.theModel.getTheArray(),
						AlgorithmsController.this.theModel.getArraySize());

			}

			catch (NumberFormatException ex) {

				AlgorithmsController.this.theView.sendMessageToUser("You Need a Index in the Index Box");

			}

		}

	}

	// ActionListener for the Find Button

	class FindButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String indexWithValue = "";

			try {

				if (AlgorithmsController.this.theView.linearSearchRadioButton.isSelected()) {

					indexWithValue = AlgorithmsController.this.theModel.linearSearchForValue(AlgorithmsController.this.theView
							.getTheValue());

				}

				AlgorithmsController.this.theView.sendMessageToUser("Found in Index: " + indexWithValue);

			}

			catch (NumberFormatException ex) {

				AlgorithmsController.this.theView.sendMessageToUser("You Need a Value in the Value Box");

			}

		}

	}

	// ActionListener for the Sort Button

	class SortButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {

				if (AlgorithmsController.this.theView.ascendingRadioButton.isSelected()) {

					AlgorithmsController.this.theModel.bubbleSort();

				} else {

					AlgorithmsController.this.theModel.bubbleSortDescending();

				}

				AlgorithmsController.this.theView.updateTheTable(AlgorithmsController.this.theModel.getTheArray(),
						AlgorithmsController.this.theModel.getArraySize());

			}

			catch (NumberFormatException ex) {

				AlgorithmsController.this.theView.sendMessageToUser("Something Went Wrong");

			}

		}

	}

}