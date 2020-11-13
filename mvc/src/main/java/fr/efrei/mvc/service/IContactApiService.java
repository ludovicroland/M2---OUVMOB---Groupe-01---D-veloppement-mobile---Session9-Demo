package fr.efrei.mvc.service;

import java.util.List;

import fr.efrei.mvc.model.Contact;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public interface IContactApiService
{

  List<Contact> getContacts();

}
