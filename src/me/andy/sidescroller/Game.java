package me.andy.sidescroller;

public class Game
{
    private Grid grid;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;

    public Game()
    {
        grid = new Grid(5, 10);
        userRow = 0;
        userCol = 0;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        grid.setImage(new Location(userRow, 0), "/graphics/user.gif");
    }

    public void play()
    {
        while (!isGameOver())
        {
            grid.pause(100);
            handleKeyPress();
            if (msElapsed % 300 == 0)
            {
                scrollLeft();
                populateRightEdge();
            }
            updateTitle();
            msElapsed += 100;
        }
    }

    public void handleKeyPress(){
        int key = grid.checkLastKeyPressed();
        if (key == 37) {
            if (userCol > 0) {
                userCol--;
                grid.setImage(new Location(userRow, userCol +1), null);
                grid.setImage(new Location(userRow, userCol), "/graphics/user.gif");
            }
        }
        if (key == 38) {
            if (userRow > 0) {
                userRow--;
                grid.setImage(new Location(userRow + 1, userCol), null);
                grid.setImage(new Location(userRow, userCol), "/graphics/user.gif");
            }
        }
        if (key == 39) {
            if (userCol < 9) {
                userCol++;
                grid.setImage(new Location(userRow, userCol - 1), null);
                grid.setImage(new Location(userRow, userCol), "/graphics/user.gif");
            }
        }
        if (key == 40) {
            if (userRow < 4) {
                userRow++;
                grid.setImage(new Location(userRow - 1, userCol), null);
                grid.setImage(new Location(userRow, userCol), "/graphics/user.gif");
            }
        }
    }

    public void populateRightEdge()
    {
    }

    public void scrollLeft()
    {
    }

    public void handleCollision(Location loc)
    {
    }

    public int getScore()
    {
        return 0;
    }

    public void updateTitle()
    {
        grid.setTitle("Game:  " + getScore());
    }

    public boolean isGameOver()
    {
        return false;
    }

    public static void test()
    {
        Game game = new Game();
        game.play();
    }

    public static void main(String[] args)
    {
        test();
    }
}