package fr.efrei.mvp.service;

import java.util.List;

import fr.efrei.mvp.model.Contact;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class ContactApiService
    implements IContactApiService
{

  private List<Contact> contacts = ContactGenerator.generateContacts();

  @Override
  public List<Contact> getContacts()
  {
    return contacts;
  }

}
