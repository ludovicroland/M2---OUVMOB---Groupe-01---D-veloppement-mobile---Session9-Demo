package fr.efrei.mvp.model;

import java.io.Serializable;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class Contact
    implements Serializable
{

  public final long id;

  public final String name;

  public final String phoneNumber;

  public Contact(long id, String name, String phoneNumber)
  {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }


  @Override
  public String toString()
  {
    return "Contact{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }

}
