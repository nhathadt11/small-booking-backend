package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Admin.class)
public abstract class Admin_ {
  public static volatile SingularAttribute<Admin, Integer> id;
  public static volatile SingularAttribute<Admin, String> firstName;
  public static volatile SingularAttribute<Admin, String> lastName;
  public static volatile SingularAttribute<Admin, String> phone;
  public static volatile SingularAttribute<Admin, String> email;
  public static volatile SingularAttribute<Admin, String> address;
  public static volatile SingularAttribute<Admin, Boolean> isActive;
}
