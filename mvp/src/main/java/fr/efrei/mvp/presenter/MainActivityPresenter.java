package fr.efrei.mvp.presenter;

import java.util.List;

import android.os.Handler;

import fr.efrei.mvp.model.Contact;
import fr.efrei.mvp.service.ContactApiService;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class MainActivityPresenter
{

  public interface View
  {

    void showProgressBar();

    void hideProgressBar();

    void updateRecyclerView(List<Contact> contacts);

  }

  private final View view;

  private List<Contact> contacts;

  public MainActivityPresenter(View view)
  {
    this.view = view;
  }

  public void initList()
  {
    view.showProgressBar();

    new Handler().postDelayed(() -> {
      contacts = new ContactApiService().getContacts();

      view.updateRecyclerView(contacts);

      view.hideProgressBar();
    }, 2_000);
  }

}
