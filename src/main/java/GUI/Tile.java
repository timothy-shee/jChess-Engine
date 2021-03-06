package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import BoardMovement.ChessBoard;
import BoardMovement.Move;
import BoardMovement.Piece;
import BoardMovement.Position;

public class Tile extends JButton implements MouseListener
{
	private final static int TILE_HEIGHT_AND_WIDTH = 64;
    static final Color DARK = new Color(0xD1, 0x8B, 0x47);

    static final Color LIGHT = new Color(0xFF, 0xCE, 0x9E);
    
    ChessFrame board;
    Position coords;
	Image img;
	boolean isLegalMove;
	public Tile(ChessFrame aBoard, Position pos, Image anImg)
	{
		super(createIcon(anImg));
		img = anImg;
		board = aBoard;
		coords = pos;
		isLegalMove = false;
        resetBackground();
        MouseListener mouseListener = new MouseAdapter()
		{
			@Override
        	public void mouseClicked(MouseEvent arg0) {
        		if (isLegalMove)
        		{
        			board.move(coords);
        		}
        		else
        		{
        			board.showMoves(coords);
        		}
            		//parent.set the tile as legal move(true); --and green dot? 
        	}
	    	public void mousePresssed(MouseEvent mouseEvent)
	    	{
	    		System.out.println("Something");
	    	}
		};
        addMouseListener(mouseListener);
	}
	
	public static ImageIcon createIcon(Image im)
	{
		Image newimg = im.getScaledInstance(TILE_HEIGHT_AND_WIDTH, TILE_HEIGHT_AND_WIDTH,  java.awt.Image.SCALE_SMOOTH ) ; 
        ImageIcon icon = new ImageIcon(newimg);
        return icon;
	}
	void removeIcon()
	{
		setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
	}
	ImageIcon makeImgIcon() {
		return createIcon(img);
	}
	Image getImg()
	{
		return img;
	}
	public void resetBackground()
	{
		if (((coords.getY()+ coords.getX()) % 2 == 0)) 
        {
            setBackground(Color.WHITE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.BLACK);
            setForeground(Color.BLACK);
        }
	}
	public void move(Position newPos)
    {
		coords = newPos;
    }
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/*public boolean hasPiece() {
		return hasPiece;
	}
	public void setHasPiece(boolean hasPiece) {
		this.hasPiece = hasPiece;
	}*/
	public boolean isLegalMove() {
		return isLegalMove;
	}
	public void setLegalMove(boolean isLegalMove) {
		this.isLegalMove = isLegalMove;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Position getCoords() {
		return coords;
	}
	
}