package bq_resume.snake_game;

import static bq_resume.snake_game.Constants.*;

/**
 * Created by FLK on 4/19/18.
 */
public class Board {

    //Base fields
    private final int width;
    private final int height;

    //The maze should be a matrix, using character matrix here
    private final Character[][] maze;
    private final String id;

    //The board has to have at least one snake
    private Snake snake;

    //Constructor
    public Board(final String id,final int width, final int height){
        this.id = id;
        this.width = width;
        this.height = height;
        maze = new Character[height][width];
        init();
    }

   //initialized the wall for the maze
    private void init(){
        for(int i = 0; i < height; i++){
            maze[i][0] = wallChar;
            maze[i][width - 1] = wallChar;
        }

        for (int i = 0; i < width; i++){
            maze[0][i] = wallChar;
            maze[width -1][i] = wallChar;
        }
    }

    //Getters
    public String getId(){
        return id;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Character[][] getMaze(){
        return maze;
    }

    //Add the oringinal snake to the board, which is a single point
    public boolean addSnake(final Snake snake,final int i, final int j){
        if(this.snake != null || snake == null || snake.size() > 1) return false;
        if(!checkBoundary(i,j) || maze[i][j] != null) return false;
        maze[i][j] = snakeChar;
        this.snake = snake;
        snake.setBoard(this);
        return true;
    }

    //Check boundary
    public boolean checkBoundary(final int i, final int j){
        return !(i < 0 || i >= height || j < 0 || j >= width);
    }

    //Set char for wall in the maze
    public boolean setWall(final int i, final int j){
        if(!checkBoundary(i,j)) return false;

        if(maze[i][j] == null){
            maze[i][j] = wallChar;
            return true;
        }
        return false;
    }

    //Set char for food in the maze
    public boolean setFood(final int i, final int j){
        if(!checkBoundary(i,j)) return false;

        if(maze[i][j] == null){
            maze[i][j] = foodChar;
            return true;
        }
        return false;
    }

    //Set the char for snake in the maze
    public boolean setSnakeBody(final int i, final int j){
        if(!checkBoundary(i,j)) return false;

        if(maze[i][j] == null || maze[i][j] == foodChar){
            maze[i][j] = snakeChar;
            return true;
        }
        return false;
    }

    //Clear the entry for the maze
    public boolean setEmpty(final int i, final int j){
        if(!checkBoundary(i,j)) return false;

        maze[i][j] = null;
        return false;
    }
}
