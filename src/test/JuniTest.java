package test;
 
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.bycle.fdv.ShowAndCalculedRentails;
import com.bycle.fdv.ValidationException;


public class JuniTest{
	
	private ShowAndCalculedRentails showAndCalculedRentails;

	
	//
	//  test Ok cuando se calcula tarifa por Hr, Dia, Week (Sin Promosion Family)
	//
	@Before
	public void onSetUp() {
		showAndCalculedRentails = new ShowAndCalculedRentails();
	}
	
	@Test
	public void testTarifaCeroOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 0, "H");

			assertTrue(result == 0);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testTarifaNegativaFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", -1, "H");

			assertTrue(result <  0);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testTarifaHrsOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 10, "H");

			assertTrue(result == 50.0);

		} catch (Exception e) {
			fail();
		}
	}

 
	@Test
	public void testTarifaDayOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 10, "D");

			assertTrue(result == 200.0);
 
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testTarifaWeekOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 10, "W");

			assertTrue(result == 600.0);

		} catch (Exception e) {
			fail();
		}
	}

	//
	//  test Ok cuando se calcula tarifa por Hr, Dia, Week (Con Promosion Family)
	//
	@Test
	public void testTarifaHrsFamililyOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("Y", 2, "H");

			assertTrue(result == 10.0);

		} catch (Exception e) {
			fail();
		}
	}


	@Test
	public void testTariDayFamililyOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("Y", 10, "D");

			assertTrue(result == (182.0));

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testTarifaWeekFamililyOk() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("Y", 4, "W");

			assertTrue(result == 204.0);

		} catch (Exception e) {
			fail();
		}
	}
	
	//
	//  test Fail cuando se calcula tarifa por Hr, Dia, Week
	//
	@Test
	public void testTarifaHrsFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 10, "H");

			assertTrue(result == 49.0);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testTarifaDayFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 10, "D");

			assertTrue(result == 199.9);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testTarifaWeekFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("N", 10, "W");

			assertTrue(result == 599.9);

		} catch (Exception e) {
			fail();
		}
	}

	
	//
	//  test Fail cuando se calcula tarifa por Hr, Dia, Week (Con Promosion Family)
	//
	@Test
	public void testTarifaHrsFamililyFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("Y", 2, "H");

			assertTrue(result == 10.1);

		} catch (Exception e) {
			fail();
		}
	}


	@Test
	public void testTariDayFamililyFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("Y", 10, "D");

			assertTrue(result == (182.1));

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testTarifaWeekFamililyFail() throws Exception {

		try {
			double result = showAndCalculedRentails.showCalculedRentails("Y", 4, "W");

			assertTrue(result == 203.0);

		} catch (Exception e) {
			fail();
		}
	}
	
		
 
	@Test
	public void testInputParameterFail() throws IOException {

		try {
			int result = showAndCalculedRentails.inputParameter("N", "10", "W");

			assertTrue(result == Integer.parseInt("10"));

		} catch (IllegalArgumentException | ValidationException | NullPointerException e) {
			fail();
		}
	}
	
	
 

	
	
}