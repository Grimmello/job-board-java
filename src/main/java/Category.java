import java.util.*;

public class Category {
  private String mName;
  private static List<Category> instances = new ArrayList<Category>();
  private int mId;
  private List<Job> mJobs;

  public Category(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mJobs = new ArrayList<Job>();
  }

  public String getName() {
    return mName;
  }

  public static List<Category> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Category find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public List<Job> getJobs() {
    return mJobs;
  }

  public void addJob(Job job) {
    mJobs.add(job);
  }
}
