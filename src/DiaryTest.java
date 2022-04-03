import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaryTest {
	Diary test_init;
	Diary test1_add;
	Diary test2_add;
	Diary test1_search;
	Diary test2_search;
	Diary test1_save;
	Diary test2_save;
	
	@BeforeEach
	void setUp() throws Exception {
		test_init = new Diary();
		test1_add = new Diary();
		test2_add = new Diary();
		test1_search = new Diary();
		test2_search = new Diary();
		test1_save = new Diary();
		test2_save = new Diary();
	}

	@AfterEach
	void tearDown() throws Exception {
		test_init = null;
		test1_add = null;
		test2_add = null;
		test1_search = null;
		test2_search = null;
		test1_save = null;
		test2_save = null;
	}
	/**
	 * test method: Diary.init()();
	 * test input: no input
	 */
	@Test
	void test_init() {
		assertEquals(true, test_init.init());
	}
	
	/**
	 * test method: Diary.addContent();
	 * test input:
	 * 		(Date(2020,1,1), "content1")
	 * 		(Date(2020,2,2), "content2")
	 * 		(Date(2020,3,3), "content3")
	 */
	@Test
	void test_addContent_1() {
		Date d1 = new Date(2020,1,1);
		Date d2 = new Date(2020,2,2);
		Date d3 = new Date(2020,3,3);
		String s1 = "content1";
		String s2 = "content2";
		String s3 = "content3";
		assertEquals(true, test1_add.addContent(d1, s1));
		assertEquals(true, test1_add.addContent(d2, s2));
		assertEquals(true, test1_add.addContent(d3, s3));
	}
	
	/**
	 * test method: Diary.addContent();
	 * test input:
	 * 		(Date(3,3,3), "content3")
	 * 		(Date(2,2,2), "content2")
	 * 		(Date(1,1,1), "content1")
	 * 		(Date(2,2,2), "content2_new")
	 */
	@Test
	void test_addContent_2() {
		Date d1 = new Date(1,1,1);
		Date d2 = new Date(2,2,2);
		Date d3 = new Date(3,3,3);
		String s1 = "content1";
		String s2 = "content2";
		String s2_new = "content2_new";
		String s3 = "content3";
		
		assertEquals(true, test2_add.addContent(d3, s3));
		assertEquals(true, test2_add.addContent(d2, s2));
		assertEquals(true, test2_add.addContent(d1, s1));
		assertEquals(true, test2_add.addContent(d2, s2_new));
	}
	
	/**
	 * test method: Diary.searchContent();
	 * test input:
	 * 		Date(2020,1,1)
	 * 		Date(2020,2,2)
	 * 		Date(2020,3,3)
	 */
	@Test
	void test_seachContent_1() {
		Date d1 = new Date(2020,1,1);
		Date d2 = new Date(2020,2,2);
		Date d3 = new Date(2020,3,3);
		String s1 = "content1";
		String s2 = "content2";
		String s3 = "content3";
		test1_search.addContent(d1, s1);
		test1_search.addContent(d2, s2);
		test1_search.addContent(d3, s3);
		
		assertEquals(s1, test1_search.searchContent(d1));
		assertEquals(s2, test1_search.searchContent(d2));
		assertEquals(s3, test1_search.searchContent(d3));
	}
	
	/**
	 * test method: Diary.searchContent();
	 * test input:
	 * 		Date(1,1,1)
	 * 		Date(2,2,2)
	 * 		Date(3,3,3)
	 */
	@Test
	void test_seachContent_2() {
		Date d1 = new Date(1,1,1);
		Date d2 = new Date(2,2,2);
		Date d3 = new Date(3,3,3);
		String s1 = "content1";
		String s2 = "content2";
		String s2_new = "content2_new";
		String s3 = "content3";
		
		test2_search.addContent(d3, s3);
		test2_search.addContent(d2, s2);
		test2_search.addContent(d1, s1);
		test2_search.addContent(d2, s2_new);
		
		assertEquals(s1, test2_search.searchContent(d1));
		assertEquals(s2_new, test2_search.searchContent(d2));
		assertEquals(s3, test2_search.searchContent(d3));
	}
	
	/**
	 * test method: Diary.saveDiary();
	 * test input: no input
	 */
	@Test
	void test1_save() {
		Date d1 = new Date(2020,1,1);
		Date d2 = new Date(2020,2,2);
		Date d3 = new Date(2020,3,3);
		String s1 = "content1";
		String s2 = "content2";
		String s3 = "content3";
		test1_save.addContent(d3, s3);
		test1_save.addContent(d1, s1);
		test1_save.addContent(d2, s2);
		assertEquals(true ,test1_save.saveDiary());
	}
	
	/**
	 * test method: Diary.saveDiary();
	 * test input: no input
	 */
	@Test
	void test2_save() {
		assertEquals(true ,test2_save.saveDiary());
	}
	

}
