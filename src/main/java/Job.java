import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Job {
  private String mTitle;
  private String mDescription;
  private String mTimeStamp;
  private static List<Job> instances = new ArrayList<Job>();
  private String mID;
  private int mCategoryID;
  private List<String> mContactList = new ArrayList<String>();

  public Job() {

  }

  public Job(String title, int categoryID, String description, List<String> contactList) {
    mTitle = title;
    mCategoryID = categoryID;
    mDescription = description;
    mTimeStamp = formatDate();
    instances.add(0, this);
    mID = randomString();
    mContactList = contactList;
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

  // public void addJob(Job job) {
  //   instances.add(0, job);
  // }

  public String getID() {
    return mID;
  }

  public int getCategoryID() {
    return mCategoryID;
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

  public String getContactName() {
    String contactName = mContactList.get(0);
    return contactName;
  }
  public String getContactNumber() {
    String contactNumber = mContactList.get(1);
    return contactNumber;
  }
  public String getContactEmail() {
    String contactEmail = mContactList.get(2);
    return contactEmail;
  }
}
