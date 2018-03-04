import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

class Maze extends MiniGame
{
    //fields
    private Cell[][] grid_;
    private final int GRID_SIZE_ = 25;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private final int SCREEN_SIZE_ = 520;
    private final int scale = 10;
    private final int offset = scale;
    private ArrayList<Cell> active_cells_;

    //constructor
    public Maze(long timer)
    {
        super(timer);
        this.setSize(SCREEN_SIZE_,SCREEN_SIZE_);
        this.grid_ = new Cell[this.GRID_SIZE_][this.GRID_SIZE_];
        this.active_cells_ = new ArrayList<Cell>();
        for (int row = 0; row < GRID_SIZE_; ++row)
            for (int col = 0; col < GRID_SIZE_; ++col)
                this.grid_[row][col] = new Cell(row,col);

        for (Cell[] row : grid_)
            for (Cell cell : row)
                cell.findNeighbors();
        this.generateMaze();
    }
    public void paint(java.awt.Graphics g)
    {       
        for (Cell cell : this.active_cells_)
        {
            if (cell.north_wall_)
            {
                g.drawLine((cell.col_+offset) *scale, (cell.row_+offset)*scale, (cell.col_+offset)*scale + scale, (cell.row_+offset)*scale);
            }
            if (cell.west_wall_)
            {
                g.drawLine((cell.col_+offset) *scale, (cell.row_+offset)*scale, (cell.col_+offset)*scale, (cell.row_+offset)*scale + scale);
            }
        }
        g.drawRect(offset*scale, offset*scale, GRID_SIZE_*scale, GRID_SIZE_*scale); //draw boundary box
        this.active_cells_.clear();
    }

    private void generateMaze()
    {
        Stack<Cell> stack = new Stack<Cell>();
        Random rng = new Random(this.start_time_);
        int start_row = rng.nextInt(this.GRID_SIZE_);
        int start_col = rng.nextInt(this.GRID_SIZE_);
        Cell starting_cell = this.grid_[start_row][start_col];
        stack.push(starting_cell);

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
                
                //uncomment to watch the maze generate itself step-by-step
                this.active_cells_.add(location);
                this.active_cells_.add(destination);
            }
        }

        //reset the visited property on all cells after generating the maze
        for (Cell[] row : this.grid_)
            for (Cell cell : row)
                {
                    cell.visited_ = false;
                    this.active_cells_.add(cell);
                }
        this.repaint();
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
}