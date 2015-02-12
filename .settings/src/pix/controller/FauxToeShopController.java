package pix.controller;

import javax.swing.JOptionPane;

import pix.view.FauxToeShopFrame;

public class FauxToeShopController
{

	private FauxToeShopFrame appFrame;
	
	
	public FauxToeShopController()
	{
		appFrame = new FauxToeShopFrame(this);
	}
	
	public void start()
	{
		
		JOptionPane.showMessageDialog(appFrame, "hello");
	}
	
}
