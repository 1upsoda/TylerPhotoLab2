package pix.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import pix.controller.FauxToeShopController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;


public class FauxToeShopPanel extends JPanel
{
//	public FauxToeShopPanel() {
//	}
	private FauxToeShopController baseController;
	
	private JComboBox<String> filterBox, pictureBox;
	private JScrollPane imagePane;
	private SpringLayout baseLayout;
	
	private Picture currentPicture;
	private Picture basePicture;
	
	public FauxToeShopPanel(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		
		pictureBox = new JComboBox<String>();
		filterBox = new JComboBox<String>();
		imagePane = new JScrollPane();
		basePicture = new Picture("beach.jpg");
		currentPicture = new Picture("beach.jpg");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.EAST, pictureBox, 0, SpringLayout.EAST, this);
		
		
		setupPicture();
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	

	private void setupPicture()
	{
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
		
	}
	private void setupPanel()
	{
		setBackground(Color.YELLOW);
		this.setLayout(baseLayout);
		this.add(filterBox);
		this.add(pictureBox);
		this.add(imagePane);
		
	}
	private void setupComboBox()
	{
		String [] pictures = {
				"Beach",
				"Fnaf",
				"Arch",
				"Seagull",
				"Snow Man",
				"Swan",
				"Blue Motorcycle",
				"Butterfly",
				"Cumberland Island",
				"Lion and Hall",
				"Gorge",
				"Kitten",
				"Koala",
				"Red Motorcycle",
				"Temple",
				"Thru Door",
				"Wall",
				"Water",
				"WhiteFlower"
				
		};
		pictureBox.setModel(new DefaultComboBoxModel<String>(pictures));
	    String [] filters2 = {
	    		"Reset",
	    		"RedGreenBlueAverage",
	    		"MostlyWhite",
	    		"WeakenedWhite",
	    	    "ZeroBlue",
	    	    "KeepOnlyBlue",
	    	    "KeepOnlyRed",
	    	    "KeepOnlyGreen",
	    	    "Negate",
	    	    "Grayscale",
	    	    "FixUnderwater",
	    	    "Decode it",
	    	    "OneOff",
	    	    "OneOff2",
	    	    "MirrorVertical",
	    	    "MirrorVerticalRightToLeft",
	    	    "MirrorHorizontal",
	    	    "MirrorHorizontalBottomToTop",
	    	    "MirrorDiagnol",
	    	    "CheckerBoard",
	    	    "CheckerBoardBig",
	    	    "CheckerBoardInverse",
	    	    "CheckerBoardWat",
	    	    "CheckerBoardBigWat",
	    	    "Multiple",
	    		"EndProduct",
	    	    "MirrorTemple",
	    	    "MirrorArms",
	    	    "MirrorGull",
	    	    "Collage",
	    	    "Copy",
	    	    "EdgeDetection",
	    	    "EdgeDetection2",
	    	    "Chromakey",
	    	    "EncodeAndDecode",
	    	    "GetCountRedOverValue",
	    	    "SetRedToHalfValueInTopHalf",
	    	    "ClearBlueOverValue",
	    	    "GetAverageForColumn",
	    };
	    filterBox.setModel(new DefaultComboBoxModel<String>(filters2));
	    
	}
	private void setupLayout()
	{

	}
	private void setupListeners()
	{
		filterBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				if(filterBox.getSelectedIndex() == 0)
				{
					basePicture = new Picture(currentPicture);
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 1)
				{
					basePicture.redGreenBlueAverage();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 2)
				{
					basePicture.mostlyWhite();
					setupPicture();
					
				}
				else if(filterBox.getSelectedIndex() == 3)
				{
					basePicture.weakenedWhite();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 4)
				{
					basePicture.zeroBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 5)
				{
					basePicture.keepOnlyBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 6)
				{
					basePicture.keepOnlyRed();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 7)
				{
					basePicture.keepOnlyGreen();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 8)
				{
					basePicture.negate();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 9)
				{
					basePicture.grayscale();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 10)
				{
					basePicture.fixUnderwater();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 11)
				{
					basePicture.decode(basePicture);
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 12)
				{
					basePicture.oneOff();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 13)
				{
					basePicture.oneOff2();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 14)
				{
					basePicture.mirrorVertical();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 0)
				{
					setupPicture();
				}
				
			}
			
		});
		pictureBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				if(pictureBox.getSelectedIndex() == 0)
				{
					basePicture = new Picture("beach.jpg");
					currentPicture = new Picture("beach.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 1)
				{
					basePicture = new Picture("640px-Fnaf3.jpg");
					currentPicture = new Picture("640px-Fnaf3.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 2)
				{
					basePicture = new Picture("arch.jpg");
					currentPicture = new Picture("arch.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 3)
				{
					basePicture = new Picture("seagull.jpg");
					currentPicture = new Picture("seagull.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 4)
				{
					basePicture = new Picture("snowman.jpg");
					currentPicture = new Picture("snowman.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 5)
				{
					basePicture = new Picture("swan.jpg");
					currentPicture = new Picture("swan.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 6)
				{
					basePicture = new Picture("blueMotorcycle.jpg");
					currentPicture = new Picture("blueMotorcycle.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 7)
				{
					basePicture = new Picture("butterfly1.jpg");
					currentPicture = new Picture("butterfly1.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 8)
				{
					basePicture = new Picture("CumberlandIsland.jpg");
					currentPicture = new Picture("CumberlandIsland.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 9)
				{
					basePicture = new Picture("femaleLionAndHall.jpg");
					currentPicture = new Picture("femaleLionAndHall.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 10)
				{
					basePicture = new Picture("gorge.jpg");
					currentPicture = new Picture("gorge.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 11)
				{
					basePicture = new Picture("kitten2.jpg");
					currentPicture = new Picture("kitten2.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 12)
				{
					basePicture = new Picture("koala.jpg");
					currentPicture = new Picture("koala.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 13)
				{
					basePicture = new Picture("redMotorcycle.jpg");
					currentPicture = new Picture("redMotorcycle.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 14)
				{
					basePicture = new Picture("temple.jpg");
					currentPicture = new Picture("temple.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 15)
				{
					basePicture = new Picture("thruDoor.jpg");
					currentPicture = new Picture("thruDoor.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 16)
				{
					basePicture = new Picture("wall.jpg");
					currentPicture = new Picture("wall.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 17)
				{
					basePicture = new Picture("water.jpg");
					currentPicture = new Picture("water.jpg");
					setupPicture();
				}
				else if(pictureBox.getSelectedIndex() == 18)
				{
					basePicture = new Picture("whiteFlower.jpg");
					currentPicture = new Picture("whiteFlower.jpg");
					setupPicture();
				}
			}
		});
	}
}
