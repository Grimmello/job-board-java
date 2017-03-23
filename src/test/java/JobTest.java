import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class JobTest {
  @After
  public void tearDown() {
    Job.clearList();
  }

  // test random string id
  @Test
  public void randomString_getRandom8charString_true(){
    List<String> contactList = new ArrayList<String>();
    Job job = new Job("title", 1, "description", contactList);
    String id = job.getID();
    assertEquals(8, id.length());
  }
  // test title getter
  @Test
  public void getTitle_returnsTitle_title() {
    List<String> contactList = new ArrayList<String>();
    Job job = new Job("title", 1, "description", contactList);
    assertEquals("title", job.getTitle());
  }
  // test description getter
  @Test
  public void getDescription_returnsDescription_description() {
    List<String> contactList = new ArrayList<String>();
    Job job = new Job("title", 1, "description", contactList);
    assertEquals("description", job.getDescription());
  }
  // test the date is being set correctly
  @Test
  public void getTime_returnsTime_time() {
    List<String> contactList = new ArrayList<String>();
    Job job = new Job("title", 1, "description", contactList);
    assertEquals("03-23-2017", job.getTime());
  }
  // test to return all jobs created
  @Test
  public void all_returnsAllInstancesOfJob_true() {
    List<String> contactList = new ArrayList<String>();
    Job job1 = new Job("title", 1, "description", contactList);
    Job job2 = new Job("title", 1, "description", contactList);
    assertEquals(true, Job.all().contains(job1));
    assertEquals(true, Job.all().contains(job2));
  }
  // clear arraylist
  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    List<String> contactList = new ArrayList<String>();
    Job job = new Job("title", 1, "description", contactList);
    Job.clearList();
    assertEquals(Job.all().size(), 0);
  }
  // test for searching for id in jobs list
  @Test
  public void find_returnsJobWithSameID_job1() {
    List<String> contactList = new ArrayList<String>();
    Job job1 = new Job("title", 1, "description", contactList);
    Job job2 = new Job("title", 1, "description", contactList);
    Job job3 = new Job("title", 1, "description", contactList);
    assertEquals(Job.find(job2.getID()), job2);
  }
}
