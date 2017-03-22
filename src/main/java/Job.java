import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Job {
  private String mTitle;
  private String mDescription;
  private String mTimeStamp;
  private static List<Job> instances = new ArrayList<Job>();
  private String mID;

  public Job() {

  }

  public Job(String title, String description) {
    mTitle = title;
    mDescription = description;
    mTimeStamp = formatDate();
    instances.add(this);
    mID = randomString();
  }

  private String randomString() {
    String uuid = UUID.randomUUID().toString();
    String id = uuid.substring(0,8);
    return id;
  }

  private String formatDate() {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    String text = date.format(formatter);
    return text;
  }

  public String getID() {
    return mID;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getDescription() {
    return mDescription;
  }

  public static List<Job> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }

  public String getTime() {
    return mTimeStamp;
  }

  public static Job find(String id) {
    Job job = new Job();
    for (Job instance : instances) {
      if (instance.getID().equals(id)) {
        job = instance;
      }
    }
    return job;
  }
}
