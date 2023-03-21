package testRun;

import org.testng.annotations.Test;

import functions.Base;
import functions.LeagueTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ScoreTest extends Base {

	@Test
	public void verifyLeauge() {
		LeagueTest leagueTest = new LeagueTest();
		leagueTest.VerifyLeagueinScoreApp("NHL","NHL Hockey");
	}
	@BeforeClass
	public void beforeClass() {
		startApplication();
	}

	@AfterClass
	public void afterClass() {
	}

}
