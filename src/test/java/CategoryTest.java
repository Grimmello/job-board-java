import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class CategoryTest {
  @After
  public void clearEverything(){
    Category.clearList();
  }

  @Test
  public void category_instantiatesCorrectly_true() {
    Category testCategory = new Category("title");
    assertEquals(true, testCategory instanceof Category);
  }

  @Test
  public void getName_categoryInstantiatesWithName_title() {
    Category testCategory = new Category("title");
    assertEquals("title", testCategory.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCategory_true() {
    Category firstCategory = new Category("title1");
    Category secondCategory = new Category("title2");
    assertEquals(true, Category.all().contains(firstCategory));
    assertEquals(true, Category.all().contains(secondCategory));
  }

  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Category testCategory = new Category("title");
    Category.clearList();
    assertEquals(Category.all().size(), 0);
  }

  @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Category testCategory = new Category("title");
    assertEquals(1, testCategory.getId());
  }

  @Test
  public void find_returnsCategoryWithSameId_secondCategory() {
    Category firstCategory = new Category("title1");
    Category secondCategory = new Category("title2");
    assertEquals(Category.find(secondCategory.getId()), secondCategory);
  }

  @Test
  public void getJobs_initiallyReturnsEmptyList_ArrayList() {
    Category testCategory = new Category("title");
    assertEquals(0, testCategory.getJobs().size());
  }

  @Test
  public void addJob_addsJobToList_true() {
    Category testCategory = new Category("title");
    List<String> contactList = new ArrayList<String>();
    Job job = new Job("title", 1, "description", contactList);
    testCategory.addJob(job);
    assertTrue(testCategory.getJobs().contains(job));
  }

  @Test
  public void find_returnsNullWhenNoJobFound_null() {
    assertTrue(Category.find(999) == null);
  }
}
