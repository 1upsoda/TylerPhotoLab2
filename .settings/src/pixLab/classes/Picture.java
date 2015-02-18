package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	// /////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
			}
		}
	}
	public void pixelBlack()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}
	

	public void keepOnlyRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setRed(0);
			}
		}
	}

	public void keepOnlyGreen1()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(255);
				pixelObj.setRed(255);
			}
		}
	}

	public void negate()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());
			}
		}
	}

	public void oneOff()
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();
				pixels[row][col].setGreen(oldBlue);
				pixels[row][col].setRed(oldGreen);
				pixels[row][col].setBlue(oldRed);
			}

		}
	}

	public void redGreenBlueAverage()
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < (pixels.length-1)/2; row++)
		{
			for (int col = 0; col < ((width-1)/2); col++)
			{
				
				pixels[row][col].setGreen(0);
				pixels[row][col].setBlue(0);
			}

		}
		for (int row = (pixels.length-1)/2; row < pixels.length; row++)
		{
			for (int col = 0; col < ((width-1)/2); col++)
			{
				
				pixels[row][col].setRed(0);
				pixels[row][col].setBlue(0);
			}

		}
		for (int row = 0; row < (pixels.length-1)/2; row++)
		{
			for (int col = ((width-1)/2); col < width; col++)
			{
				
				pixels[row][col].setRed(0);
				pixels[row][col].setGreen(0);
			}

		}
		for (int row = (pixels.length-1)/2; row < pixels.length; row++)
		{
			for (int col = ((width-1)/2); col < width; col++)
			{

				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();	
				pixels[row][col].setRed((oldRed+oldGreen+oldBlue)/3);
				pixels[row][col].setGreen((oldRed+oldGreen+oldBlue)/3);
				pixels[row][col].setBlue((oldRed+oldGreen+oldBlue)/3);
			}

		}
	}
	public void oneOff2()
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();
				pixels[row][col].setGreen(oldRed);
				pixels[row][col].setRed(oldBlue);
				pixels[row][col].setBlue(oldGreen);
			}

		}
	}

	public void grayscale()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
				pixelObj.setBlue((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
				pixelObj.setGreen((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
			}
		}
	}

	public void fixUnderwater()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				if (pixelObj.getRed() < 24 && pixelObj.getBlue() > 155)
				{
					// pixelObj.setRed(pixelObj.getRed());
					// pixelObj.setBlue(pixelObj.getBlue());
					// pixelObj.setGreen(pixelObj.getGreen());
				}
				else
				{
					pixelObj.setRed(255);
					pixelObj.setBlue(255);
					pixelObj.setGreen(255);
				}
			}
		}
	}
	public void checkerBoard()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					pixels[row][col].setBlue(0);
					pixels[row][col].setGreen(0);
					pixels[row][col].setRed(0);
				}
			}
		}
	}
	public void checkerRandom()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					int oldRed,oldBlue,oldGreen;
					oldRed = pixels[row][col].getRed();
					oldGreen = pixels[row][col].getGreen();
					oldBlue = pixels[row][col].getBlue();
					int randomAdd = (int) Math.random() * 40;
					int addOrSubtract = (int) Math.random();
					if(addOrSubtract == 0)
					{
						pixels[row][col].setBlue(oldBlue + randomAdd);
					}
					else
					{
						pixels[row][col].setBlue(oldBlue - randomAdd);
					}
					randomAdd = (int) Math.random() * 40;
					addOrSubtract = (int) Math.random();
					if(addOrSubtract == 0)
					{
						pixels[row][col].setBlue(oldGreen + randomAdd);
					}
					else
					{
						pixels[row][col].setBlue(oldGreen - randomAdd);
					}
					randomAdd = (int) Math.random() * 40;
					addOrSubtract = (int) Math.random();
					if(addOrSubtract == 0)
					{
						pixels[row][col].setBlue(oldRed + randomAdd);
					}
					else
					{
						pixels[row][col].setBlue(oldRed - randomAdd);
					}
					
				}
			}
		}
	}
	public void checkerBoard2Pictures()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					pixels[row][col].setBlue(0);
					pixels[row][col].setGreen(0);
					pixels[row][col].setRed(0);
					
				}
			}
		}
	}
	public void checkerBoardBig()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%4 == 0 && col%4 == 0) || (row%4 == 1 && col%4 == 1) || (row%4 == 1 && col%4 == 0) || (row%4 == 0 && col%4 == 1) || (row%4 == 2 && col%4 == 3) || (row%4 == 3 && col%4 == 2) || (row%4 == 2 && col%4 == 2) || (row%4 == 3 && col%4 == 3))
				{
					pixels[row][col].setBlue(0);
					pixels[row][col].setGreen(0);
					pixels[row][col].setRed(0);
				}
			}
		}
	}
	public void checkerBoardInverse()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					pixels[row][col].setBlue(255-pixels[row][col].getBlue());
					pixels[row][col].setGreen(255-pixels[row][col].getGreen());
					pixels[row][col].setRed(255-pixels[row][col].getRed());
				}
			}
		}
	}
	public void checkerBoardWat()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					int oldRed,oldBlue,oldGreen;
					oldRed = pixels[row][col].getRed();
					oldGreen = pixels[row][col].getGreen();
					oldBlue = pixels[row][col].getBlue();
					pixels[row][col].setBlue(255-oldRed);
					pixels[row][col].setGreen(255-oldBlue);
					pixels[row][col].setRed(255-oldGreen);
				}
			}
		}
	}
	public void colour()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					int oldRed,oldBlue,oldGreen;
					oldRed = pixels[row][col].getRed();
					oldGreen = pixels[row][col].getGreen();
					oldBlue = pixels[row][col].getBlue();
					pixels[row][col].setBlue(255-oldRed);
					pixels[row][col].setGreen(255-oldBlue);
					pixels[row][col].setRed(255-oldGreen);
				}
			}
		}
	}
	public void checkerBoardBigWat()
	{
	Pixel[][] pixels = this.getPixels2D();
	int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if((row%4 == 0 && col%4 == 0) || (row%4 == 1 && col%4 == 1) || (row%4 == 1 && col%4 == 0) || (row%4 == 0 && col%4 == 1) || (row%4 == 2 && col%4 == 3) || (row%4 == 3 && col%4 == 2) || (row%4 == 2 && col%4 == 2) || (row%4 == 3 && col%4 == 3))
				{
					pixels[row][col].setBlue(255-pixels[row][col].getGreen());
					pixels[row][col].setGreen(255-pixels[row][col].getRed());
					pixels[row][col].setRed(255-pixels[row][col].getBlue());
				}
			}
		}
	}
	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	
	public void redGrey()
	{
		
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();
				pixels[row][col].setGreen(oldRed);
				pixels[row][col].setRed(oldRed);
				pixels[row][col].setBlue(oldRed);
			}

		}
	}
	public void blueGrey()
	{
		
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				pixels[row][col].setGreen(pixels[row][col].getRed());
				
				pixels[row][col].setBlue(pixels[row][col].getRed());
			}

		}
	}
	public void greenGrey()
	{
		
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();
				pixels[row][col].setGreen(oldGreen);
				pixels[row][col].setRed(oldGreen);
				pixels[row][col].setBlue(oldGreen);
			}

		}
	}

	public void mostlyWhite()
	{
		
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();
				pixels[row][col].setGreen(oldGreen+oldBlue+oldRed);
				pixels[row][col].setRed(oldGreen+oldBlue+oldRed);
				pixels[row][col].setBlue(oldGreen+oldBlue+oldRed);
			}

		}
	}
	public void weakenedWhite()
	{
		
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int oldRed,oldBlue,oldGreen;
				oldRed = pixels[row][col].getRed();
				oldGreen = pixels[row][col].getGreen();
				oldBlue = pixels[row][col].getBlue();
				pixels[row][col].setGreen((oldGreen+oldBlue+oldRed)/2);
				pixels[row][col].setRed((oldGreen+oldBlue+oldRed)/2);
				pixels[row][col].setBlue((oldGreen+oldBlue+oldRed)/2);
			}

		}
	}
	
	public void mirrorVerticalRightToLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = width / 2; col < width - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length / 2 - 1; row++)
		{
			for (int col = 0; col < width - 1; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[pixels.length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());

			}
		}
	}

	public void mirrorHorizontalBottomToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int width = pixels[0].length;
		for (int row = pixels.length / 2 - 1; row < pixels.length; row++)
		{
			for (int col = 0; col < width - 1; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[pixels.length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());

			}
		}
	}

	public void mirrorDiagnol()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel firstPixel = null;
		Pixel secondPixel = null;
		int width = pixels[0].length;
		int height = pixels.length;
		if (width > height)
		{
			width = (height - 1);
		}
		else if (width < pixels.length)
		{
			height = (width - 1);
		}
		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				firstPixel = pixels[col][row];
				secondPixel = pixels[row][col];
				secondPixel.setColor(firstPixel.getColor());

			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple()
	{
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
	}

	public void mirrorArms()
	{
		int mirrorPoint = 195;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 163; row < mirrorPoint; row++)
		{

			for (int col = 100; col < 300; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
	}

	public void mirrorGull()
	{
		int mirrorPoint = 345;
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 230; row < 320; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 235; col < mirrorPoint; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());

			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	
	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}
//	public void checker2Pictures()
//	{
//		Picture flower1 = new Picture("flower1.jpg");
//		Picture flower2 = new Picture("flower2.jpg");
//		this.copy(flower1, 0, 0);
//		flower1.checkerBoard();
//		this.copy(flower1, 0, 0);
//		flower1.checkerBoard();
//		this.copy(flower2, 100, 0);
//		this.copy(flower1, 200, 0);
//		Picture flowerNoBlue = new Picture(flower2);
//		flowerNoBlue.zeroBlue();
//		this.copy(flowerNoBlue, 300, 0);
//		this.copy(flower1, 400, 0);
//		this.copy(flower2, 500, 0);
//		this.mirrorVertical();
//		this.write("collage.jpg");
//	}
	public void encode()
	{
		Picture beach = new Picture("beach.jpg");
		Picture message = new Picture("message.jpg");
		beach.evenRed();
		beach.encoding(message, beach);
		this.copy(beach, 0, 0);
//		beach.decode(beach);
//		this.copy(beach, 0, 0);
//		
		
	}
	public void decode()
	{
		Picture beach = new Picture("beach.jpg");
		Picture message = new Picture("message.jpg");
		beach.decode(beach);
		this.copy(beach, 0, 0);
	}
	public void encodeAndDecode()
	{
		Picture beach = new Picture("beach.jpg");
		Picture message = new Picture("message.jpg");
		beach.evenRed();
		this.copy(beach, 0, 0);
		beach.encoding(message, beach);
		this.copy(beach, 0, 0);
		beach.decode(beach);
		this.copy(beach, 0, 0);
	}
	public void encoding(Picture message, Picture beach)
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < (pixels.length-1); row++)
		{
			for (int col = 0; col < (pixels[0].length-1); col++)
			{				
				if((message.getPixel(col, row).getRed()) < 10)
				{
					beach.getPixel(col, row).setRed(beach.getPixel(col, row).getRed()+1);
				}
				
			}

		}
	}
	public void decode(Picture beach)
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 1; row < (pixels.length); row++)
		{
			for (int col = 1; col < (width); col++)
			{				
				if(((beach.getPixel(col, row).getRed()) % 2) == 0)
				{					
					beach.getPixel(col, row).setRed(255);
					beach.getPixel(col, row).setBlue(255);
					beach.getPixel(col, row).setGreen(255);
				}
//				else
//				{
//					beach.getPixel(col, row).setRed(0);
//					beach.getPixel(col, row).setBlue(0);
//					beach.getPixel(col, row).setGreen(0);
//				}
				
			}

		}
	}
	public void evenRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col++)
			{
				
				if(pixels[row][col].getRed() % 2 == 1)
				{
				pixels[row][col].setRed(pixels[row][col].getRed()-1);
				}
				
			}

		}
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void picture2CheckerBoard(Picture firstPicture, Picture secondPicture, int smallestRowSize, int smallestColSize)
	{
		Picture beach = new Picture(firstPicture);
		Picture message = new Picture(secondPicture);
		this.copy(beach, 0, 0);
		beach.checkering(beach, message, smallestRowSize, smallestColSize);
		this.copy(beach, 0, 0);
	}
	public void checkering(Picture message, Picture beach, int smallestRowSize, int smallestColSize)
	{
		Pixel[][] pixels = this.getPixels2D();
		int width = pixels[0].length;
		for (int row = 0; row < (smallestRowSize-2); row++)
		{
			for (int col = 0; col < (smallestColSize-2); col++)
			{				
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1))
				{
					message.getPixel(col, row).setRed(beach.getPixel(col, row).getRed());
					message.getPixel(col, row).setBlue(beach.getPixel(col, row).getBlue());
					message.getPixel(col, row).setGreen(beach.getPixel(col, row).getGreen());
				}
				
			}

		}
	}
	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args)
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		// beach.zeroBlue();
		// beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
