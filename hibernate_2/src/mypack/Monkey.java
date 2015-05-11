package mypack;

import java.util.*;

public class Monkey{

  private Long id;
  private String firstname;
  private String lastname;
  private char gender;
  private int age;
  private int avgAge;
  private String description;

  public Monkey() {}

  public Monkey(String firstname,String lastname,char gender,int age,String description){
    this.firstname=firstname;
    this.lastname=lastname;
    this.gender=gender;
    this.age=age;
    this.description=description;
  }

  public Long getId() {
    return this.id;
  }

  private void setId(Long id) {
    this.id = id;
  }

  public String getFirstname(){
    return firstname;
  }

  public void setFirstname(String firstname){
    this.firstname=firstname;
  }

  public String getLastname(){
    return lastname;
  }

  public void setLastname(String lastname){
    this.lastname = lastname;
  }

  public String getName(){
    return firstname+ " "+lastname;
  }

  public void setName(String name){
    StringTokenizer t=new StringTokenizer(name);
    firstname=t.nextToken();
    lastname=t.nextToken();
  }

  public int getAge(){
    return this.age;
  }

  public void setAge( int age ){
    this.age = age;
  }

  public int getAvgAge(){
    return this.avgAge;
  }

  private void setAvgAge( int avgAge){
    this.avgAge = avgAge;
  }

  public char getGender(){
    return this.gender;
  }
  
  public void setGender(char gender){
    if(gender!='F' && gender!='M'){
      throw new IllegalArgumentException("Invalid Gender");
    }
    this.gender =gender ;
  }

  public String getDescription(){
    return this.description;
  }

  public void setDescription(String description){
    this.description=description;
  }
}


