import org.junit.*;
import static org.junit.Assert.*;

public class JobTest {
  @After
  public void tearDown() {
    Job.clearList();
  }

  // test random string id
  @Test
  public void randomString_getRandom8charString_true(){
    Job newJob = new Job("title", "description");
    String id = newJob.getID();
    assertEquals(8, id.length());
  }
  // test title getter
  @Test
  public void getTitle_returnsTitle_title() {
    Job job = new Job("title", "description");
    assertEquals("title", job.getTitle());
  }
  // test description getter
  @Test
  public void getDescription_returnsDescription_description() {
    Job job = new Job("title", "description");
    assertEquals("description", job.getDescription());
  }
  // test the date is being set correctly
  @Test
  public void getTime_returnsTime_time() {
    Job job = new Job("title", "description");
    assertEquals("03-22-2017", job.getTime());
  }
  // test to return all jobs created
  @Test
  public void all_returnsAllInstancesOfJob_true() {
    Job job1 = new Job("title1", "description1");
    Job job2 = new Job("title2", "description2");
    assertEquals(true, Job.all().contains(job1));
    assertEquals(true, Job.all().contains(job2));
  }
  // clear arraylist
  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Job job = new Job("title", "description");
    Job.clearList();
    assertEquals(Job.all().size(), 0);
  }
  // test for searching for id in jobs list
  @Test
  public void find_returnsJobWithSameID_job1() {
    Job job1 = new Job("title1", "description1");
    Job job2 = new Job("title2", "description2");
    Job job3 = new Job("title3", "description2");
    assertEquals(Job.find(job2.getID()), job2);
  }
}
