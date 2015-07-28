import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.plate.dao.impl.ClientsDAOImpl;
import com.plate.dao.model.ClientsDAO;
import com.plate.model.Clients;


public class ClientsTests {
	
	@Test
	@Ignore
	public void testListAllClients() {
		ClientsDAO dao = new ClientsDAOImpl();
		List<Clients> clients = dao.listAll();
		
		System.out.println(clients);
	}
	
	@Test
	@Ignore
	public void testDeleteClient() {
		Clients client = new Clients();
		ClientsDAO dao = new ClientsDAOImpl();
		
		client.setId(1L);
		
		dao.delete(client);
	}
	
	@Test
	@Ignore
	public void testSaveClient() {
		Clients client = new Clients();
		ClientsDAO dao = new ClientsDAOImpl();
		
		client.setName("Bruno Ferrari");
		client.setEmail("b_ferrari@live.com");
		client.setPhone("+551433241893");
		client.setDoc("47.625.465-6");
		client.setType("FISICA");
		
		dao.saveOrUpdate(client);
	}
	
	@Test
	@Ignore
	public void testSearch() {
		ClientsDAO dao = new ClientsDAOImpl();
		List<Clients> clients = dao.search("ta");
		if(clients.size() > 0)
			System.out.println(clients);
		else
			System.out.println("no results.");
		
	}

}
