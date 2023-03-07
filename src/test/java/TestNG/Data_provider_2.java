package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_provider_2 {
	
	@Test(dataProvider="dataProviderTest")
public void bookTicket(String src, String dsc)
{
	System.out.println("Books tickets from "+src+ " to " +dsc+"");
}


@DataProvider
public Object[][] dataProviderTest()
{
	Object[][] objArr=new Object[5][2];//5 set of data  2 rows
	objArr[0][0]="Bangalore";
	objArr[0][1]="Mysore";
	
	objArr[1][0]="Mangalore";
	objArr[1][1]="Goa";
	
	objArr[2][0]="Mumbai";
	objArr[2][1]="Madurai";
	
	objArr[3][0]="Hubli";
	objArr[3][1]="Hampi";
	
	objArr[4][0]="NY";
	objArr[4][1]="NJ";
	
	
	
	
	
	return objArr;
}

}