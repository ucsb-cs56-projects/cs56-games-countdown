import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.util.Random;


public class LightsOut extends MiniGame
{
	//fields
	private final int GRID_SIZE_ = 5;
	private MyButton[][] button_grid_;
	private int light_count_;
	private final Color ON_COLOR_ = Color.GREEN;
	private final Color OFF_COLOR_ = Color.WHITE;
	public static final String LIGHTSOUT = "Lights Out!";

	//ctors
	public LightsOut(long timer)
	{
		super(timer);
		light_count_ = 0;
		player_won_ = false;
		this.setLayout(new GridLayout(this.GRID_SIZE_, 0));
		button_grid_ = new MyButton[GRID_SIZE_][GRID_SIZE_];	
		Random rng = new Random(this.start_time_);
		
		for (int row = 0; row < this.GRID_SIZE_; ++row)
		{
			for (int col = 0; col < this.GRID_SIZE_; ++col)
			{
				LightBox lightbox = new LightBox(row,col);
				MyButton button = new MyButton();
				button.setOpaque(true);
				button.addMouseListener(lightbox);
				button.setBackground(this.OFF_COLOR_);
				this.add(button);
				this.button_grid_[row][col] = button;
			}
		}
		for (int i = 0; i < GRID_SIZE_; ++i)
		{
			for (int j = 0; j < GRID_SIZE_; ++j)
			{
				ArrayList<MyButton> neighbors = new ArrayList<MyButton>();
				if (i > 0)
					neighbors.add(this.button_grid_[i-1][j]);
				if (i < this.GRID_SIZE_-1)
					neighbors.add(this.button_grid_[i+1][j]);
				if (j > 0)
					neighbors.add(this.button_grid_[i][j-1]);
				if (j < this.GRID_SIZE_-1)
					neighbors.add(this.button_grid_[i][j+1]);
				this.button_grid_[i][j].neighbors_ = neighbors;
				
				if (rng.nextBoolean())
					this.button_grid_[i][j].toggle();
			}
		}
		//this.start_timer();
	}

	class MyButton extends JButton
	{
		private ArrayList<MyButton> neighbors_;

		private void toggleThis()
		{
			if (this.getBackground() == LightsOut.this.ON_COLOR_)
			{
				this.setBackground(LightsOut.this.OFF_COLOR_); //turn on the light
				--LightsOut.this.light_count_;
			}
			else
			{
				this.setBackground(LightsOut.this.ON_COLOR_); //turn off the light
				++LightsOut.this.light_count_;
			}
		}

		private void toggleNeighbors()
		{
			for (MyButton neighbor : this.neighbors_)
			{
				neighbor.toggleThis();
			}
		}

		public void toggle()
		{
			this.toggleThis();
			this.toggleNeighbors();
		}
	}

	//inner class LightBox
	class LightBox extends MouseAdapter
	{
		private int row_;
		private int col_;

		public LightBox(int row, int col)
		{
			super();
			this.row_ = row;
			this.col_ = col;		
		}

		public void mouseReleased(MouseEvent e)
		{
			LightsOut.this.button_grid_[row_][col_].toggle();
			if (LightsOut.this.light_count_ == 0)
			{
				LightsOut.this.player_won_ = true;
				System.out.println("player won!");
			}
		}
	}
}