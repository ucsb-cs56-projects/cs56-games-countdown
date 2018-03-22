import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze extends MiniGame implements KeyListener
{
    //fields
    private Cell[][] grid_;
    private final int GRID_SIZE_ = 25;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private final int scale = 15;
    private final int offset = scale;
    private final Cell START_;
    private final Cell END_;
    private Cell player_;
    private boolean hard_mode_; //TODO -- if the user has selected 'hard mode' for this session, make the maze zoomed in. i.e. they can only see the current Cell they are in, and the 8 Cells around them, rather than the entire maze.

    //constructor
    public Maze(long timer)
    {
        super(timer);
        this.grid_ = new Cell[this.GRID_SIZE_][this.GRID_SIZE_];
        
        for (int row = 0; row < GRID_SIZE_; ++row)
            for (int col = 0; col < GRID_SIZE_; ++col)
                this.grid_[row][col] = new Cell(row,col);

        for (Cell[] row : grid_)
            for (Cell cell : row)
                cell.findNeighbors();
        this.generateMaze();
        this.START_ = grid_[0][0];
        this.END_ = grid_[GRID_SIZE_ -1][GRID_SIZE_ -1];
        this.player_ = this.START_;
        this.player_.visited_ = true;
        this.addKeyListener(this);
    }

    public void paintComponent(java.awt.Graphics g)
    {
        super.paintComponent(g);

        //TODO -- make the player a sprite (maybe a rat or something) instead of a circle.
        g.setColor(Color.GREEN);
        g.fillRect((START_.col_+offset)*scale, (START_.row_+offset)*scale, scale, scale);

        g.setColor(Color.RED);
        g.fillRect((END_.col_+offset)*scale, (END_.row_+offset)*scale, scale, scale);

        for (Cell[] row : this.grid_)
            for (Cell cell : row)
            {
                g.setColor(Color.cyan);
                if (cell.visited_ && cell != START_ && cell != END_)
                    g.fillRect((cell.col_+offset)*scale, (cell.row_+offset)*scale, scale, scale);
                g.setColor(Color.BLACK);
                if (cell.north_wall_)
                {
                    g.drawLine((cell.col_+offset) *scale, (cell.row_+offset)*scale, (cell.col_+offset)*scale + scale, (cell.row_+offset)*scale);
                }
                if (cell.west_wall_)
                {
                    g.drawLine((cell.col_+offset) *scale, (cell.row_+offset)*scale, (cell.col_+offset)*scale, (cell.row_+offset)*scale + scale);
                }
            }
        g.setColor(Color.BLACK);
        g.fillOval((player_.col_+offset)*scale, (player_.row_+offset)*scale, scale, scale);
        g.drawRect(offset*scale, offset*scale, GRID_SIZE_*scale, GRID_SIZE_*scale); //draw boundary box

    }

    private void generateMaze()
    {
        Stack<Cell> stack = new Stack<Cell>();
        Random rng = new Random(this.start_time_);
        int start_row = rng.nextInt(this.GRID_SIZE_);
        int start_col = rng.nextInt(this.GRID_SIZE_);
        Cell random_starting_cell = this.grid_[start_row][start_col];
        stack.push(random_starting_cell);

        while (!stack.empty()) //stack is active
        {
            Cell location = stack.peek();
            location.visited_ = true;
            ArrayList<Cell> possible_paths = new ArrayList<Cell>();
            for (Cell neighbor : location.neighbors_)
                if (neighbor != null && !neighbor.visited_)
                    possible_paths.add(neighbor);
            if (possible_paths.size() == 0)
                stack.pop();
            else
            {
                int direction = rng.nextInt(possible_paths.size());
                Cell destination = possible_paths.get(direction);
                if (destination == location.neighbors_[NORTH])
                    location.north_wall_ = false;
                else if (destination == location.neighbors_[EAST])
                    destination.west_wall_ = false;
                else if (destination == location.neighbors_[SOUTH])
                    destination.north_wall_ = false;
                else //destination is to the west
                    location.west_wall_ = false;
                stack.push(destination);
            }
        }

        //reset the visited property on all cells after generating the maze
        for (Cell[] row : this.grid_)
            for (Cell cell : row)
                    cell.visited_ = false;
    }

    class Cell
    {
        private int row_;
        private int col_;
        private Cell[] neighbors_;
        private boolean visited_;
        private boolean north_wall_;
        private boolean west_wall_; //only needed one up/down and left/right wall, each. Choice of north/west was arbitrary.


        private Cell(int row, int col)
        {
            super();
            this.row_ = row;
            this.col_ = col;
            this.visited_ = false;
            this.north_wall_ = true;
            this.west_wall_ = true;
        }

        private void findNeighbors()
        {
            this.neighbors_ = new Cell[4];
            if (this.row_ > 0)
                neighbors_[NORTH] = Maze.this.grid_[row_ -1][col_];
            if (this.row_ < Maze.this.GRID_SIZE_-1)
                neighbors_[SOUTH] = Maze.this.grid_[row_ +1][col_];
            if (this.col_ > 0)
                neighbors_[WEST] = Maze.this.grid_[row_][col_ -1];
            if (this.col_ < Maze.this.GRID_SIZE_-1)
                neighbors_[EAST] = Maze.this.grid_[row_][col_ +1];
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keycode = e.getKeyCode();
        switch(keycode)
        {
            case LEFTARROW_KEY_:    if (player_.neighbors_[WEST] != null && !player_.west_wall_)
                                        player_ = player_.neighbors_[WEST];
                                    break;
            case UPARROW_KEY_:      if (player_.neighbors_[NORTH] != null && !player_.north_wall_)
                                        player_ = player_.neighbors_[NORTH];
                                    break;
            case RIGHTARROW_KEY_:   if (player_.neighbors_[EAST] != null && !player_.neighbors_[EAST].west_wall_)
                                        player_ = player_.neighbors_[EAST];
                                    break;
            case DOWNARROW_KEY_:    if (player_.neighbors_[SOUTH] != null && !player_.neighbors_[SOUTH].north_wall_)
                                        player_ = player_.neighbors_[SOUTH];
                                    break;
            default: System.out.println(player_.col_ + "," + player_.row_); break;
        }
        player_.visited_ = true;
        if (player_ == this.END_)
            System.out.println("Player has solved a maze!"); //TODO -- add a victory panel to the project instead of printing to console.
        this.repaint();
    }
}