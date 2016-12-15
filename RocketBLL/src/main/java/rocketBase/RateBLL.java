package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();

	static double getRate(int GivenCreditScore) throws RateException {
		// TODO - RocketBLL RateBLL.getRate - make sure you throw any exception

		// Call RateDAL.getAllRates... this returns an array of rates
		// write the code that will search the rates to determine the
		// interest rate for the given credit score
		// hints: you have to sort the rates... you can do this by using
		// a comparator... or by using an OrderBy statement in the HQL

		// TODO - RocketBLL RateBLL.getRate
		// obviously this should be changed to return the determined rate

		ArrayList<RateDomainModel> rates = RateDAL().getAllRates();

		double MatchRate = 0;
		for (RateDomainModel R : rates) {
			if (GivenCreditScore == R.getiMinCreditScore()) {
				MatchRate = R.getdInterestRate();
			
			} else {
				return MatchRate;
			}

			if (MatchRate == 0) {
				throw new RateException(R);
			} else {
				return MatchRate;
			}
		}

		return MatchRate;

	}

	private static RateDAL RateDAL() {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO - RocketBLL RateBLL.getPayment
	// how to use:
	// https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html

	public static double getPayment(double r, double n, double p, double f, boolean t) {
		return FinanceLib.pmt(r, n, p, f, t);
	}


public boolean LoanCheck(){
	LoanRequest lq = new LoanRequest();
	
	double income = Math.abs(lq.getiIncome());
	double payment = Math.abs(lq.getdPayment());
	
	if ((income * 1.28) < payment){
		return true;
	}
	else {
		return false;
	}
}
}