import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Output_renderer {
	
	static BufferedImage image = new BufferedImage(1920, 1080,
	        BufferedImage.TYPE_INT_RGB);
	static Graphics graphics = image.getGraphics();
	public static void render_basic_layout(double min_frequency, double max_frequency, double min_vol, double max_vol, double[] values)
	{
		 
		    graphics.setColor(Color.WHITE);
		    graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		    graphics.setColor(Color.BLACK);
		    //graphics.drawString("I be flossin'", 0, 0);
		    graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
		    //graphics.drawString("HOT SAUCE", 10, 25);
		    
		    
		    
		    
		    graphics.drawLine(99, 0, 99, image.getHeight());
		    
	}
	public static double[] stretch_relative_to_image(double[] input)
	{
	 return null;
		
	}
	public static void output_raw_data_to_image(double[] input)
	{
		double[] in = input;
		double smallest_number = 0;
		for(int i = 0;i<in.length;i++)
		{
			if(in[i]<smallest_number)
			{
				smallest_number = in[i];
			}
		}
		for(int i = 0;i<in.length;i++)
		{
			in[i] = in[i] - smallest_number;
		}
		for(int i = 0;i<in.length;i++)
		{
			in[i] = in[i]*100;
		}
		double largest_number = 0;
		for(int i = 0;i<in.length;i++)
		{
			if(in[i]>largest_number)
			{
				largest_number = in[i];
			}
		}
		BufferedImage image = new BufferedImage(in.length, (int) Math.ceil(largest_number),BufferedImage.TYPE_INT_RGB);
		for(int i = 0;i<in.length;i++)
		{
		image.setRGB(i, (int)in[i], Color.green.getRGB());
		}
		JFileChooser fileChooser = new JFileChooser();
	    int returnVal = fileChooser.showOpenDialog(null);
	    if ( returnVal == JFileChooser.APPROVE_OPTION ){
	    	File file = fileChooser.getSelectedFile();
	        try {
				ImageIO.write(image, "png", file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
}
