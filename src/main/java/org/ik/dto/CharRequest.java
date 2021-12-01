package org.ik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
public class CharRequest {
     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }

     public String getSchool() {
          return school;
     }

     public void setSchool(String school) {
          this.school = school;
     }

     public String getHouse() {
          return house;
     }

     public void setHouse(String house) {
          this.house = house;
     }

     public String getPatronus() {
          return patronus;
     }

     public void setPatronus(String patronus) {
          this.patronus = patronus;
     }

     private String name;
     private String role;
     private String school;
     private String house;
     private String patronus;



}
