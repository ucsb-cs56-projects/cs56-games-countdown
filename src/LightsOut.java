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
	private final int grid_size_ = 5;
	private MyButton[][] button_grid_;
	private int light_count_;
	private final Color on_color_ = Color.GREEN;
	private final Color off_color_ = Color.WHITE;

	//ctors
	public LightsOut(long timer)
	{
		super(timer);
		light_count_ = 0;
		player_won_ = false;
		this.setTitle("Lights Out!");
		panel_ = new JPanel();
		panel_.setLayout(new GridLayout(this.grid_size_, 0));
		button_grid_ = new MyButton[grid_size_][grid_size_];	
		Random rng = new Random(this.start_time_);
		
		for (int row = 0; row < this.grid_size_; ++row)
		{
			for (int col = 0; col < this.grid_size_; ++col)
			{
				LightBox lightbox = new LightBox(row,col);
				MyButton button = new MyButton();
				button.setOpaque(true);
				button.addMouseListener(lightbox);
				button.setBackground(this.off_color_);
				this.panel_.add(button);
				this.button_grid_[row][col] = button;
			}
		}
		for (int i = 0; i < grid_size_; ++i)
		{
			for (int j = 0; j < grid_size_; ++j)
			{
				ArrayList<MyButton> neighbors = new ArrayList<MyButton>();
				if (i > 0)
					neighbors.add(this.button_grid_[i-1][j]);
				if (i < this.grid_size_-1)
					neighbors.add(this.button_grid_[i+1][j]);
				if (j > 0)
					neighbors.add(this.button_grid_[i][j-1]);
				if (j < this.grid_size_-1)
					neighbors.add(this.button_grid_[i][j+1]);
				this.button_grid_[i][j].neighbors = neighbors;
				
				if (rng.nextBoolean())
					this.button_grid_[i][j].toggle();
			}
		}
		this.add(panel_);
		this.setSize(new Dimension(500, 500));
		//this.start_timer();
	}

	class MyButton extends JButton
	{
		private ArrayList<MyButton> neighbors;

		private void toggleThis()
		{
			if (this.getBackground() == LightsOut.this.on_color_)
			{
				this.setBackground(LightsOut.this.off_color_); //turn on the light
				--LightsOut.this.light_count_;
			}
			else
			{
				this.setBackground(LightsOut.this.on_color_); //turn off the light
				++LightsOut.this.light_count_;
			}
		}

		private void toggleNeighbors()
		{
			for (MyButton neighbor : neighbors)
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