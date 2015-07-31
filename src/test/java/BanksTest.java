import org.junit.Ignore;
import org.junit.Test;

import com.plate.dao.impl.BanksDAOImpl;
import com.plate.model.Banks;


public class BanksTest {
			
				@Test
				@Ignore
				public void bancoPorId(){
					BanksDAOImpl bDao = new BanksDAOImpl();
					Banks bank = bDao.findId(1L);
					System.out.println(bank);
				}
}
