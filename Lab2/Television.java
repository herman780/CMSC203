/**
 * The purpose of this class is to model a television
 * @author Herman Mann Date: 09/25/2020
 */

public class Television {
	
	private final String MANUFACTURER; /*The manufacturer attribute will hold the brand name. 
	This cannot change once the television is created, so will be a named constant. */
	
	private final int SCREEN_SIZE; /*The screenSize attribute will hold the size of the television screen.
	Cannot change once the television is created as well, so this will be treated as a named constant. */
	
	private boolean powerOn; /*The powerOn attribute will hold the value true 
	if the power is on, and false if the power is off. */
	
	private int channel; /*The channel attribute will hold the value of the 
	station that the television is showing. */
	
	private int volume; /*The volume attribute will hold a number value
	 representing the loudness (0 being no sound). */
	
	
	/*Constructor definition taking in two parameters, the first one the brand of
	 * Manufacturer and the second one the screen size. Bringing in the information which is necessary.
	 */
	
	public Television(String brand, int size)
	{
		this.MANUFACTURER = brand;
		this.SCREEN_SIZE = size;
		this.powerOn= false;
		this.volume = 20;
		this.channel = 2;
	}
	
	/**
	 * @param station
	 * The setChannel method will store the desired station in the channel field.
	 */
	
	public void setChannel(int station)
	{
		this.channel = station;
	}
	
	/** 
	 * The power method will toggle the power between on and off, changing
	   the value stored in the powerOn field from true to false or from false to true.
	 */
	
	public void power()
	{
		this.powerOn = !powerOn;
	}
	
	/**
	 * The increaseVolume method will increase the value stored in
	   the volume field by 1 and set that to the volume field correspondingly.
	 */
	
	public void increaseVolume()
	{
		volume = volume + 1;
	}
	
	/**
	 * The decreaseVolume method will decrease the value stored in
	   the volume field by 1 and set that to the volume field correspondingly. 
	 */
	
	public void decreaseVolume()
	{
		volume = volume - 1;
	}
	
	/**
	 * The getChannel method will return the value stored in the channel
	   field.
	 * @return an integer of the channel number.
	 */
	
	public int getChannel()
	{
		return channel;
	}
	
	/**
	 * The getVolume method will return the value stored in the volume
	   field.
	 * @return an integer for volume number level.
	 */
	
	public int getVolume()
	{
		return volume;
	}
	
	/**
	 * The getManufacturer method will return the constant value
	   stored in the MANUFACTURER field.
	 * @return a String of brand name.
	 */
	
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
	
	/**
	 * The getScreenSize method will return the constant value 
	   stored in the SCREEN_SIZE field.
	 * @return an integer for the Screen size of the television. 
	 */
	
	public int getScreenSize()
	{
		return SCREEN_SIZE;
  }
	
}
