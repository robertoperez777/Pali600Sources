package JavaShellSort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BarExample {

	private int[] theArray;

	private int arraySize;

	ChartPanel chartPanel;

	JLabel intervalLabel;

	DefaultCategoryDataset dataset;

	public BarExample(int arraySize) {

		this.arraySize = arraySize;

		this.theArray = new int[arraySize];

		JFrame theFrame = new JFrame();

		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JInternalFrame theInnerFrame = new JInternalFrame("Chart", true, true, true, true);

		this.dataset = new DefaultCategoryDataset();

		this.generateRandomArray(this.dataset);

		JFreeChart chart = ChartFactory.createBarChart("Shell Sort", "Random Values", "Values", this.dataset, PlotOrientation.VERTICAL,
				false, true, false);

		chart.setBackgroundPaint(Color.white);
		chart.getTitle().setPaint(Color.black);

		CategoryPlot p = chart.getCategoryPlot();

		CategoryItemRenderer renderer = new DifferenceBarRenderer();

		p.setRenderer(renderer);

		p.setRangeGridlinePaint(Color.blue);

		this.chartPanel = new ChartPanel(chart);

		theInnerFrame.add(this.chartPanel);

		this.intervalLabel = new JLabel("Hello");

		this.intervalLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));

		this.intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);

		theInnerFrame.pack();

		theInnerFrame.setVisible(true);

		this.chartPanel.setSize(1500, 800);

		theFrame.add(theInnerFrame, BorderLayout.CENTER);

		theFrame.add(this.intervalLabel, BorderLayout.NORTH);

		theFrame.setSize(1920, 1080);

		theFrame.setLocationRelativeTo(null);

		theFrame.setVisible(true);

		this.sort();
	}

	public void generateRandomArray(DefaultCategoryDataset dataset) {

		for (int i = 0; i < this.arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			this.theArray[i] = (int) (Math.random() * 50) + 10;

			dataset.setValue((int) (Math.random() * 50) + 10, "Value", Integer.toString(i));

		}

	}

	public void updateTheBarChart(DefaultCategoryDataset dataset) {

		for (int i = 0; i < this.arraySize; i++) {

			dataset.setValue(this.theArray[i], "Value", Integer.toString(i));

		}

		this.chartPanel.repaint();

	}

	public void sort() {

		int inner, outer, temp;

		int interval = 1;

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (interval <= (this.arraySize / 3)) {
			interval = (interval * 3) + 1;
		}

		// Keep looping until the interval is 1
		// Then this becomes an insertion sort

		while (interval > 0) {

			// Continue incrementing outer until the end of the array is reached

			for (outer = interval; outer < this.arraySize; outer++) {

				// Store the value of the array in temp unless it has to be
				// copied to a space occupied by a bigger number closer to the
				// beginning of the array

				temp = this.theArray[outer];

				// inner is assigned the value of the highest index to check
				// against all values the proceed it. Along the way if a
				// number is greater than temp it will be moved up in the array

				inner = outer;

				// While there is a number bigger than temp move it further
				// up in the array

				while ((inner > (interval - 1)) && (this.theArray[inner - interval] >= temp)) {

					// Make room for the smaller temp by moving values in the
					// array
					// up one space if they are greater than temp

					this.theArray[inner] = this.theArray[inner - interval];

					inner -= interval;

				}

				// Now that everything has been moved into place put the value
				// stored in temp into the index above the first value smaller
				// than it is

				this.theArray[inner] = temp;

				this.updateTheBarChart(this.dataset);

				try {

					this.intervalLabel.setText("INTERVAL : " + interval);

					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			interval = (interval - 1) / 3;
		}

	}

	public static void main(String[] args) {

		new BarExample(50);

	}

}

class DifferenceBarRenderer extends BarRenderer {
	public DifferenceBarRenderer() {
		super();
	}

	public Paint getItemPaint(int x_row, int x_col) {
		return Color.blue;
	}
}