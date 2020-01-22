package techtest.techtest.entity;

import java.util.ArrayList;


class Availability
{
  private String title;

  public String getTitle() { return this.title; }

  public void setTitle(String title) { this.title = title; }

  private int dayIndex;

  public int getDayIndex() { return this.dayIndex; }

  public void setDayIndex(int dayIndex) { this.dayIndex = dayIndex; }
}

class Name
{
  private String last;

  public String getLast() { return this.last; }

  public void setLast(String last) { this.last = last; }

  private String first;

  public String getFirst() { return this.first; }

  public void setFirst(String first) { this.first = first; }
}

public class Worker
{
  private int rating;

  public int getRating() { return this.rating; }

  public void setRating(int rating) { this.rating = rating; }

  private boolean isActive;

  public boolean getIsActive() { return this.isActive; }

  public void setIsActive(boolean isActive) { this.isActive = isActive; }

  private ArrayList<String> certificates;

  public ArrayList<String> getCertificates() { return this.certificates; }

  public void setCertificates(ArrayList<String> certificates) { this.certificates = certificates; }

  private ArrayList<String> skills;

  public ArrayList<String> getSkills() { return this.skills; }

  public void setSkills(ArrayList<String> skills) { this.skills = skills; }

  private JobSearchAddress jobSearchAddress;

  public JobSearchAddress getJobSearchAddress() { return this.jobSearchAddress; }

  public void setJobSearchAddress(JobSearchAddress jobSearchAddress) { this.jobSearchAddress = jobSearchAddress; }

  private String transportation;

  public String getTransportation() { return this.transportation; }

  public void setTransportation(String transportation) { this.transportation = transportation; }

  private boolean hasDriversLicense;

  public boolean getHasDriversLicense() { return this.hasDriversLicense; }

  public void setHasDriversLicense(boolean hasDriversLicense) { this.hasDriversLicense = hasDriversLicense; }

  private ArrayList<Availability> availability;

  public ArrayList<Availability> getAvailability() { return this.availability; }

  public void setAvailability(ArrayList<Availability> availability) { this.availability = availability; }

  private String phone;

  public String getPhone() { return this.phone; }

  public void setPhone(String phone) { this.phone = phone; }

  private String email;

  public String getEmail() { return this.email; }

  public void setEmail(String email) { this.email = email; }

  private Name name;

  public Name getName() { return this.name; }

  public void setName(Name name) { this.name = name; }

  private int age;

  public int getAge() { return this.age; }

  public void setAge(int age) { this.age = age; }

  private String guid;

  public String getGuid() { return this.guid; }

  public void setGuid(String guid) { this.guid = guid; }

  private int userId;

  public int getUserId() { return this.userId; }

  public void setUserId(int userId) { this.userId = userId;} 
  
  }