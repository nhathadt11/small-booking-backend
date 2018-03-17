package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Service.class)
public abstract class Service_ {
  public static volatile SingularAttribute<Service, Integer> id;
  public static volatile SingularAttribute<Service, String> name;
  public static volatile SingularAttribute<Service, String> description;
  public static volatile SingularAttribute<Service, Float> price;
  public static volatile SingularAttribute<Service, Integer> adminId;
}
