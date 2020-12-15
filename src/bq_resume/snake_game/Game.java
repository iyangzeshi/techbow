package bq_resume.snake_game;

import static bq_resume.snake_game.Constants.spaceChar;

/**
 * Created by FLK on 4/19/18.
 */
//The class game is watching the snake
public class Game implements SnakeEventListener {
    
    // Two basic elements: Snake and Game
    private final Board board;

    private final Snake snake;

    /** The boolean to tell whether the game is over or not */
    private boolean isOver;

    //Constructor
    public Game(final Board board, final Snake snake){
        this.board = board;
        this.snake = snake;

        init();
    }

    /** Initialize the game */
    private void init(){
        //When snake event happens, the game needs to know the event
        snake.registerListener(this);

        //Put the snake on board
        board.addSnake(snake,1,1);
        //Set the head for that snake
        snake.setHead(1,1);
    }

    public boolean isOver(){
        return isOver;
    }

    @Override
    public void onStateChange() {
        //Print the "Game Over" message
        isOver = true;
        System.out.println("Game Over");
    }

    //Visualize the current board
    public void printBoard(){
        for(int i = 0; i < board.getHeight();i++){
            for (int j = 0; j < board.getWidth(); j++){
                Character c = board.getMaze()[i][j];
                if(c == null) System.out.print(spaceChar+" ");
                else System.out.print(c+" ");
            }
            System.out.println(" ");
        }
    }
}
