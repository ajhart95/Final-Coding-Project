package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void Credit_Rate_test() throws RateException {
		int score = 600;
		System.out.println("the rate is" + RateBLL.getRate(score));

		assertEquals(RateBLL.getRate(score), 5, 0.01);
	}

	@Test
	public void Exception_test() throws RateException {
		int no_match = 625;
		boolean thrown = false;

		try {
			RateBLL.getRate(no_match);
		} catch (RateException e) {
			thrown = true;

			assertTrue(thrown);
		}

	}

	@Test
	public void PMT_test() {
		double PMT = RateBLL.getPayment((.04/12), 360, -300000, 0, true);
		System.out.println(PMT+ "the payment");
		assertEquals(PMT, 1432.25, 5);
	}

}
