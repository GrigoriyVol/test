package techtest.techtest.entity;


import java.util.ArrayList;

 public class Job
{
  private boolean driverLicenseRequired;

  public boolean getDriverLicenseRequired() { return this.driverLicenseRequired; }

  public void setDriverLicenseRequired(boolean driverLicenseRequired) { this.driverLicenseRequired = driverLicenseRequired; }

  private ArrayList<String> requiredCertificates;

  public ArrayList<String> getRequiredCertificates() { return this.requiredCertificates; }

  public void setRequiredCertificates(ArrayList<String> requiredCertificates) { this.requiredCertificates = requiredCertificates; }

  private Location location;

  public Location getLocation() { return this.location; }

  public void setLocation(Location location) { this.location = location; }

  private String billRate;

  public String getBillRate() { return this.billRate; }

  public void setBillRate(String billRate) { this.billRate = billRate; }

  private int workersRequired;

  public int getWorkersRequired() { return this.workersRequired; }

  public void setWorkersRequired(int workersRequired) { this.workersRequired = workersRequired; }

  private String startDate;

  public String getStartDate() { return this.startDate; }

  public void setStartDate(String startDate) { this.startDate = startDate; }

  private String about;

  public String getAbout() { return this.about; }

  public void setAbout(String about) { this.about = about; }

  private String jobTitle;

  public String getJobTitle() { return this.jobTitle; }

  public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

  private String company;

  public String getCompany() { return this.company; }

  public void setCompany(String company) { this.company = company; }

  private String guid;

  public String getGuid() { return this.guid; }

  public void setGuid(String guid) { this.guid = guid; }

  private int jobId;

  public int getJobId() { return this.jobId; }

  public void setJobId(int jobId) { this.jobId = jobId; }
  
}


