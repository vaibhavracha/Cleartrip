package ClearTrip.FlightBooking;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import Utility.SeleniumRepo;



public class TC_Flight {
	
	SeleniumRepo Selenium = SeleniumRepo.getInstance();
	 
	
	@Test(priority=1)
	public void BookingFlight() throws Throwable 
	{
		try {
			BanToHyd  booking =PageFactory.initElements(Selenium.getDriver(), BanToHyd.class);

			String From = "Bangalore";
			String To = "Hyderabad";
			int bookingdates = 13;
			booking.NavigatetoUrl();
			booking.Destination(From,To);
			booking.Selectdates(bookingdates);
			booking.search_button();
			booking.Select_noof_passangers();
			booking.Book();
			 
			 

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
	
	@Test(priority=2)
	public void BookingreturnFlight() throws Throwable 
	{
		try {
			BanToHyd  booking =PageFactory.initElements(Selenium.getDriver(), BanToHyd.class);

			String From = "Hyderabad";
			String To = "Bangalore";
			int bookingdates = 14;
			booking.NavigatetoUrl();
			booking.Destination(From,To);
			booking.Selectdates(bookingdates);
			booking.search_button();
			booking.Select_noof_passangers();
			booking.Book();
			 
			 

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

}
