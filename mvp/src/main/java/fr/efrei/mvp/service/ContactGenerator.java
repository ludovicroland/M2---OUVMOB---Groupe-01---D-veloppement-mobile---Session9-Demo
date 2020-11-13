package fr.efrei.mvp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.efrei.mvp.model.Contact;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public abstract class ContactGenerator
{

  public static List<Contact> DUMMY_NEIGHBOURS = Arrays.asList(
      new Contact(1, "Caroline", "+33 6 86 57 90 14"),
      new Contact(2, "Jack", "+33 6 86 57 90 14"),
      new Contact(3, "Chloé", "+33 6 86 57 90 14"),
      new Contact(4, "Vincent", "+33 6 86 57 90 14"),
      new Contact(5, "Elodie", "+33 6 86 57 90 14"),
      new Contact(6, "Sylvain", "+33 6 86 57 90 14"),
      new Contact(7, "Laetitia", "+33 6 86 57 90 14"),
      new Contact(8, "Dan", "+33 6 86 57 90 14"),
      new Contact(9, "Joseph", "+33 6 86 57 90 14"),
      new Contact(10, "Emma", "+33 6 86 57 90 14"),
      new Contact(11, "Patrick", "+33 6 86 57 90 14"),
      new Contact(12, "Ludovic", "+33 6 86 57 90 14")
  );

  static List<Contact> generateContacts()
  {
    return new ArrayList<>(DUMMY_NEIGHBOURS);
  }

  private ContactGenerator()
  {

  }

}
