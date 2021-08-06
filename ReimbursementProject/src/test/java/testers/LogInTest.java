package testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project1dao.UserDaoImpl;

class LogInTest {	
		UserDaoImpl rdi = new UserDaoImpl();

		@Test
		void LogInTester() {
//			fail("Not yet implemented");
			
			//assertEquals( exceptedValue, actualValue, messageString);


			assertEquals(true, rdi.UserLoginCheck("zk", "zk"));
			assertEquals(false, rdi.UserLoginCheck("help", "me"));
			assertEquals(true, rdi.UserLoginCheck("love", "craft"));
			assertEquals(false, rdi.UserLoginCheck("tc", "zk"));
		}
		
}
