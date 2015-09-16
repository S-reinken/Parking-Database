package main;

class ParkingSpace
{
	int spacenumber;
	String assignment1;
	String assignment2;
	Car car1;
	Car car2;
	
	public String getnum()
	{
		return ("" + spacenumber);
	}
	public void activate()
	{
		car1 = new Car();
		car2 = new Car();
	}
	public void setYear1(String a)
	{
		car1.setYear(a);
	}
	public String getYear1()
	{
		return car1.year;
	}
	public void setOwner1(String a)
	{
		car1.setOwner(a);
	}
	public String getOwner1()
	{
		return car1.owner;
	}
	public void setLicensePlate1(String a)
	{
		car1.setLicensePlate(a);
	}
	public String getLicensePlate1()
	{
		return car1.licenseplate;
	}
	public void setColor1(String a)
	{
		car1.setColor(a);
	}
	public String getColor1()
	{
		return car1.color;
	}
	public void setMake1(String a)
	{
		car1.setMake(a);
	}
	public String getMake1()
	{
		return car1.make;
	}
	public void setModel1(String a)
	{
		car1.setModel(a);
	}
	public String getModel1()
	{
		return car1.model;
	}
	public void setYear2(String a)
	{
		car2.setYear(a);
	}
	public String getYear2()
	{
		return car2.year;
	}
	public void setOwner2(String a)
	{
		car2.setOwner(a);
	}
	public String getOwner2()
	{
		return car2.owner;
	}
	public void setLicensePlate2(String a)
	{
		car2.setLicensePlate(a);
	}
	public String getLicensePlate2()
	{
		return car2.licenseplate;
	}
	public void setColor2(String a)
	{
		car2.setColor(a);
	}
	public String getColor2()
	{
		return car2.color;
	}
	public void setMake2(String a)
	{
		car2.setMake(a);
	}
	public String getMake2()
	{
		return car2.make;
	}
	public void setModel2(String a)
	{
		car2.setModel(a);
	}
	public String getModel2()
	{
		return car2.model;
	}
	public void setAssignment1(String a)
	{
		assignment1 = a;
	}
	
	public void setAssignment2(String a)
	{
		assignment2 = a;
	}
	
	public void setNumber(int a)
	{
		spacenumber = a;
	}

}
