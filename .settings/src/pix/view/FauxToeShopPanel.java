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
	public FauxToeShopPanel() {
	}
	private FauxToeShopController baseController;
	
	private JComboBox filterBox;
	private JScrollPane imagePane;
	private SpringLayout baseLayout;
	
	private Picture basePicture;
	
	public FauxToeShopPanel(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		
		filterBox = new JComboBox();
		imagePane = new JScrollPane();
		basePicture = new Picture("beach.jpg");
		baseLayout = new SpringLayout();
		
		
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
		this.add(imagePane);
		
	}
	private void setupComboBox()
	{
	    String [] filters2 = {
	    		"Reset",
	    		"RedGreenBlueAverage",
	    		"MostlyWhite",
	    		"RGBGrey",
	    		"WeakenedWhite",
	    	    "ZeroBlue",
	    	    "KeepOnlyBlue",
	    	    "KeepOnlyRed",
	    	    "KeepOnlyGreen",
	    	    "Negate",
	    	    "Grayscale",
	    	    "FixUnderwater",
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
	    filterBox.setModel(new DefaultComboBoxModel(filters2));
	    
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
					basePicture = new Picture("beach.jpg");
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
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 4)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 5)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 6)
				{
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 7)
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
	}
}
