import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.plate.dao.impl.AccountsDAOlmpl;
import com.plate.dao.model.AccountsDAO;
import com.plate.model.Accounts;
import com.plate.model.AccountsFilter;


public class AccountsTests {
			
			@Test
			@Ignore
			public void lista(){
				AccountsDAO dao = new AccountsDAOlmpl();
				List<Accounts> accouts = dao.listAll();
				System.out.println(accouts);
			}
			
			@Test
			public void buscar(){
				AccountsDAO dao = new AccountsDAOlmpl();
				AccountsFilter filter = new AccountsFilter();
				filter.setName("Conta");
				
				List<Accounts> accounts = dao.search(filter);
				System.out.println(accounts);
				
			}
}
