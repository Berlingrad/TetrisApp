import javax.swing.*;

/**
 * Write a description of class TetrisApp here.
 *
 * @author Greg Johnson, University of Connecticut
 * @version 0.3
 */
public class TetrisApp extends JFrame{
    private GamePanel _gamePanel;
    
    public TetrisApp(){
     super("Tetris");
     this.setResizable(false);
     _gamePanel = new GamePanel(); 
     _gamePanel.setPreferredSize(new java.awt.Dimension(TetrisConstants.BLOCK_SIZE*TetrisConstants.BOARD_WIDTH, TetrisConstants.BLOCK_SIZE*TetrisConstants.BOARD_HEIGHT + 22));
     this.setSize(TetrisConstants.BLOCK_SIZE*TetrisConstants.BOARD_WIDTH, TetrisConstants.BLOCK_SIZE*TetrisConstants.BOARD_HEIGHT+22);
     this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     this.add(_gamePanel);  
     this.setVisible(true);
    }
    
    public static void main(String[] args){
        TetrisApp app = new TetrisApp();
    }
}