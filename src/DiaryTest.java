import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaryTest {
	Diary test;
	@BeforeEach
	void setUp() throws Exception {
		test = new Diary();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void test() {
		Date d1 = new Date(2020,1,1);
		Date d2 = new Date(2020,2,2);
		Date d3 = new Date(2020,3,3);
		String s1 = "content1";
		String s2 = "content2";
		String s3 = "content3";
		test.addContent(d3, s3);
		test.addContent(d1, s1);
		test.addContent(d2, s2);
		
		try {
			test.saveDiary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
