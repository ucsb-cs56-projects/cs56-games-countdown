import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LightsOut extends MiniGame
{
	//test========
	public static void main(String[] args)
	{
		LightsOut g = new LightsOut(60000); //timer in milliseconds (1 minute right now)
		boolean result = g.playerWon();
		if (result)
			System.out.println("Player won the game!");
		else
			System.out.println("Player lost!");
	}
	//=========test

	//fields
	private final int grid_size_ = 5;
	private JButton[][] button_grid_;
	private boolean[][] logical_grid_;
	private int light_count_;

	//ctors
	public LightsOut(long timer)
	{
		super(timer);
		light_count_ = 0;
		player_won_ = false;
		frame_ = new JFrame("LightsOut!");
		panel_ = new JPanel();
		panel_.setLayout(new GridLayout(this.grid_size_, 0));
		button_grid_ = new JButton[grid_size_][grid_size_];
		logical_grid_ = new boolean[grid_size_][grid_size_];
		for (int i = 0; i < grid_size_; ++i)
		{
			for (int j = 0; j < grid_size_; ++j)
			{
				JButton button = new JButton();
				button.setOpaque(true);
				button.addMouseListener(new LightBox(i,j));
				boolean rand = true; //TODO -- make this an actually random boolean
				logical_grid_[i][j] = rand;
				if (rand) //light should be on
				{
					++light_count_;
					button.setBackground(Color.GREEN);
				}
				else //light should be on
				{
					button.setBackground(Color.WHITE);
				}
				this.panel_.add(button);				
				button_grid_[i][j] = button;
			}
		}
		frame_.add(panel_);
		frame_.setVisible(true);
		frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.start_timer();
	}

	//inner class LightBox
	class LightBox extends MouseAdapter
	{
		private int row;
		private int col;

		public LightBox(int i, int j)
		{
			super();
			row = i;
			col = j;
			
		}

		public void mouseReleased(MouseEvent e)
		{
			if (LightsOut.this.logical_grid_[row][col]) //light is on, but will be turned off
			{
				--LightsOut.this.light_count_;
				button_grid_[row][col].setBackground(Color.WHITE); //turn light off
			}
			else
			{
				++LightsOut.this.light_count_;	
				button_grid_[row][col].setBackground(Color.GREEN); //turn light on
			}		
			LightsOut.this.logical_grid_[row][col] ^= true; //xor with true -> if the lightbox is on it goes off, else it goes on.
			
			if (row > 0)
			{
				if (LightsOut.this.logical_grid_[row-1][col]) //light is on, but will be turned off
				{
					--LightsOut.this.light_count_;
					button_grid_[row-1][col].setBackground(Color.WHITE); //turn light off
				}
				else
				{
					++LightsOut.this.light_count_;	
					button_grid_[row-1][col].setBackground(Color.GREEN); //turn light on
				}		
				LightsOut.this.logical_grid_[row-1][col] ^= true;
			}
			if (row < LightsOut.this.grid_size_ - 1)
			{
				if (LightsOut.this.logical_grid_[row+1][col]) //light is on, but will be turned off
				{
					--LightsOut.this.light_count_;
					button_grid_[row+1][col].setBackground(Color.WHITE); //turn light off
				}
				else
				{
					++LightsOut.this.light_count_;	
					button_grid_[row+1][col].setBackground(Color.GREEN); //turn light on
				}			
				LightsOut.this.logical_grid_[row+1][col] ^= true;
			}
			if (col > 0)
			{
				if (LightsOut.this.logical_grid_[row][col-1]) //light is on, but will be turned off
				{
					--LightsOut.this.light_count_;
					button_grid_[row][col-1].setBackground(Color.WHITE); //turn light off
				}
				else
				{
					++LightsOut.this.light_count_;	
					button_grid_[row][col-1].setBackground(Color.GREEN); //turn light on
				}				
				LightsOut.this.logical_grid_[row][col-1] ^= true;
			}
			if (col < LightsOut.this.grid_size_ - 1)
			{
				if (LightsOut.this.logical_grid_[row][col+1]) //light is on, but will be turned off
				{
					--LightsOut.this.light_count_;
					button_grid_[row][col+1].setBackground(Color.WHITE); //turn light off
				}
				else
				{
					++LightsOut.this.light_count_;	
					button_grid_[row][col+1].setBackground(Color.GREEN); //turn light on
				}				
				LightsOut.this.logical_grid_[row][col+1] ^= true;
			}
			if (LightsOut.this.light_count_ == 0)
			{
				System.out.println("Game over!");
				LightsOut.this.player_won_ = true;
			}
		}
	}
}