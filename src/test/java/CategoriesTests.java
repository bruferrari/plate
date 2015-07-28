import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.plate.dao.impl.CategoriesDAOImpl;
import com.plate.dao.model.CategoriesDAO;
import com.plate.model.Categories;

public class CategoriesTests {

	@Test
	@Ignore
	public void testListofAllCategories() {
		CategoriesDAO dao = new CategoriesDAOImpl();
		List<Categories> categories = dao.listAll();

		System.out.println(categories);
	}
	
	@Test
	@Ignore
	public void testDeleteCategory() {
		Categories category = new Categories();
		category.setId(6L);
		
		CategoriesDAO dao = new CategoriesDAOImpl();
		dao.delete(category);
	}
	
	@Test
	@Ignore
	public void testUpdateCategory() {
		Categories category = new Categories();
		category.setId(1L);
		category.setDescription("to danu update denovo!");
		
		CategoriesDAO dao = new CategoriesDAOImpl();
		dao.saveOrUpdateCategory(category);
	}
	
	@Test
	@Ignore
	public void testSaveCategory() {
		Categories category = new Categories();
		category.setDescription("esse aqui eh novo!!");
		
		CategoriesDAO dao = new CategoriesDAOImpl();
		dao.saveOrUpdateCategory(category);
	}
	
	@Test
	@Ignore
	public void testSearchCategory() {
		CategoriesDAO dao = new CategoriesDAOImpl();
		List<Categories> categories = dao.search("novo");
		
		System.out.println(categories);
	}

}
