import java.util.List;

import com.plate.dao.impl.ProvidersDAOImpl;
import com.plate.dao.model.ProvidersDAO;
import com.plate.model.Cities;
import com.plate.model.ProviderFilter;
import com.plate.model.Providers;
import com.plate.model.Provinces;

import org.junit.Ignore;
import org.junit.Test;


/**
 * @author bruno
 *
 */
public class ProvidersTests {

	@Test
	@Ignore
	public void testListProviders() {
		List<Providers> providers = null;
		ProvidersDAO dao = new ProvidersDAOImpl();
		
		providers = dao.listAll();
		
		System.out.println(providers);
	}
	
	@Test
	@Ignore
	public void testDelete() {
		ProvidersDAO dao = new ProvidersDAOImpl();
		Providers provider = new Providers();
		provider.setId(1L);
		
		try{
			dao.delete(provider);
			System.out.println("Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSave() {
		Providers provider = new Providers();
		Cities city = new Cities();
		city.setId(3L);
		
		provider.setName("Beatriz Mayara Aguiar");
		provider.setAddress("Rua Conceição Costa");
		provider.setDistrict("Cohab");
		provider.setEmail("mah_bea@hotmail.com");
		provider.setCity(city);
		provider.setPhone("(14) 99999-9999");
		provider.setDoc("99.999.999/9999-99");
		provider.setObs("Fornece elementos para decoração de ambientes");
		
		ProvidersDAO dao = new ProvidersDAOImpl();
		
		try{
			dao.saveOrUpdate(provider);
			System.out.println("SAVED!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Providers provider = new Providers();
		provider.setId(1L);
		provider.setName("Beatriz Mayara Aguiar");
		provider.setAddress("Rua Conceição Costa");
		provider.setDistrict("Cohab");
		provider.setEmail("mah_bea@hotmail.com");
		provider.setPhone("(14) 99999-9999");
		provider.setDoc("230.908.908-79");
		provider.setObs("Fornece elementos para decoração de ambientes. Mudei documento");
		
		ProvidersDAO dao = new ProvidersDAOImpl();
		try{
			dao.saveOrUpdate(provider);
			System.out.println("UPDATED!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void search() {
		ProvidersDAO dao = new ProvidersDAOImpl();
		ProviderFilter filter = new ProviderFilter();
		filter.setName("bea");
		List<Providers> providers = dao.search(filter);
		
		System.out.println("RESULT ==> " + providers);
	}
	
	@Test
	public void searchByDoc() {
		ProvidersDAO dao = new ProvidersDAOImpl();
		ProviderFilter filter = new ProviderFilter();
		filter.setDoc("12.312.312/0000-01");;
		List<Providers> providers = dao.searchByDoc(filter);
		
		System.out.println("RESULT ==> " + providers);
	}
	
	@Test
	@Ignore
	public void testListProvinces() {
		ProvidersDAOImpl dao = new ProvidersDAOImpl();
//		List<Provinces> provinces = dao.listProvinces();
//		System.out.println(provinces);
	}
}
