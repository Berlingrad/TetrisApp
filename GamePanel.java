import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;

/**
 * Write a description of class GamePanel here.
 *
 * @author Greg Johnson, University of Connecticut
 * @version 0.3
 */
public class GamePanel extends JPanel implements ActionListener
{
    
    // instance variables - replace the example below with your own
    private PieceProxy _piece;
    private Timer _timer;
    private Random _generator;
    
    private KeyUpListener _upKey;
    private KeyDownListener _downKey;
    private KeyLeftListener _leftKey;
    private KeyRightListener _rightKey;
    private KeyPListener _pauseKey;
    
    
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        // initialise instance variables
        this.setBackground(Color.BLACK);
        this.setSize(new Dimension(TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_WIDTH), TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_HEIGHT)+15));
        this.setPreferredSize(new Dimension(TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_WIDTH), TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_HEIGHT)+15));

        _upKey = new KeyUpListener(this);
        _downKey = new KeyDownListener(this);
        _leftKey = new KeyLeftListener(this);
        _rightKey = new KeyRightListener(this);
        _pauseKey = new KeyPListener(this);

        _generator = new Random();
        
        _piece = new PieceProxy();
        _piece.setPiece(tetriminoFactory());

        _timer = new Timer(500, this);
        _timer.start();

    }
    
    public Tetrimino tetriminoFactory()
    /** 
     * This method implements the factory method design pattern to build new tetriminos during Tetris game play.
     */
    {
        Tetrimino newPiece;
        int randomNumber;
        
        int x = (TetrisConstants.BOARD_WIDTH/2) * TetrisConstants.BLOCK_SIZE;
        int y = 0;
        randomNumber = (int) (Math.floor(Math.random()*7)+1);
        switch(randomNumber) {
            case 1: newPiece = new Z(x,y);     break;
            case 2: newPiece = new S(x,y);     break;
            case 3: newPiece = new L(x,y);     break;
            case 4: newPiece = new J(x,y);     break;
            case 5: newPiece = new O(x,y);     break;
            case 6: newPiece = new I(x,y);     break;
            default: newPiece = new T(x,y);     break;
        }
        return newPiece;
    }
    
    public void paintComponent (java.awt.Graphics aBrush) 
    {
        super.paintComponent(aBrush);
        java.awt.Graphics2D betterBrush = (java.awt.Graphics2D)aBrush;
        
        _piece.fill(betterBrush);
        _piece.draw(betterBrush);
    }
    /**
     * This method takes two integers representing the column and row of a cell on the game board a component rectangle into which a
     * tetrimino wishes to move. This can be prevented by either the cell being off of the game board (not a valid cell) or by the
     * cell being occupied by another SmartRectangle.
     * 
     * @param c The column of the cell in question on the game board.
     * @param r The row of the cell in question on the game board.
     * @return boolean This function returns whether the component rectangle can be moved into this cell.
     */
    public boolean canMove(int c, int r)
    {
        return true;
    }
    
    /**
     * This method takes two integers representing the column and row of a cell on the game board a component rectangle into which a
     * tetrimino wishes to move. This method returns a boolean indicating whether the cell on the game board is empty.
     * 
     * @param c The column of the cell in question on the game board.
     * @param r The row of the cell in question on the game board.
     * @return boolean This function returns whether the cell on the game board is free.
     */    
    private boolean isFree(int c, int r)
    {
        return true;
    }
    /**
     * This method takes two integers representing the column and row of a cell on the game board a component rectangle into which a
     * tetrimino wishes to move. This function checks to see if the cell at (c, r) is a valid location on the game board.
     * 
     * @param c The column of the cell in question on the game board.
     * @param r The row of the cell in question on the game board.
     * @return boolean This function returns whether the location (c, r) is within the bounds of the game board.
     */
    private boolean isValid(int i, int j)
    {
        return true;
    }
     /**
     * This method takes two integers representing the column and row of a cell on the game board a component rectangle into which a
     * tetrimino wishes to move. This can be prevented by either the cell being off of the game board (not a valid cell) or by the
     * cell being occupied by another SmartRectangle.
     * 
     * @param r The SmartRectangle to add to the game board.
     * @return Nothing
     */   
    public void addToBoard(SmartRectangle r)
    {
    }
    /**
     * This method takes one integer representing the row of cells on the game board to move down on the screen after a full 
     * row of squares has been removed.
     * 
     * @param row The row in question on the game board.
     * @return Nothing
     */
    private void moveBlocksDown(int row)
    {
    }
    /**
     * This method checks each row of the game board to see if it is full of rectangles and should be removed. It calls
     * moveBlocksDown to adjust the game board after the removal of a row.
     * 
     * @return Nothing
     */
    private void checkRows(){
    }
    /**
     * This method checks to see if the game has ended.
     * 
     * @return boolean This function returns whether the game is over or not.
     */
    private boolean checkEndGame()
    {
        return false;
    }
    public void actionPerformed(ActionEvent e)
    {
        _piece.moveDown();
        repaint();
    }
    private class KeyUpListener extends KeyInteractor 
    {
        public KeyUpListener(JPanel p)
        {
            super(p,KeyEvent.VK_UP);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.turnRight();
            repaint();
        }
    }
    private class KeyDownListener extends KeyInteractor 
    {
        public KeyDownListener(JPanel p)
        {
            super(p,KeyEvent.VK_DOWN);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.moveDown();
            repaint();
        }
    } 
    private class KeyLeftListener extends KeyInteractor 
    {
        public KeyLeftListener(JPanel p)
        {
            super(p,KeyEvent.VK_LEFT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.moveLeft();
            repaint();
        }
    } 
    private class KeyRightListener extends KeyInteractor 
    {
        public KeyRightListener(JPanel p)
        {
            super(p,KeyEvent.VK_RIGHT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.moveRight();
            repaint();
        }
    }
    private class KeyPListener extends KeyInteractor 
    {
        public KeyPListener(JPanel p)
        {
            super(p,KeyEvent.VK_P);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if(_timer.isRunning()){
                _timer.stop();
            }
            else
                _timer.start();
        }
    }
}
