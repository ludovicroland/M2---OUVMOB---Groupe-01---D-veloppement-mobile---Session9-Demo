package fr.efrei.mvvm.viewmodel;

import java.util.List;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import fr.efrei.mvvm.model.Contact;
import fr.efrei.mvvm.service.ContactApiService;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class MainActivityViewModel
    extends ViewModel
{

  public enum LoadingState
  {
    Loading, Loaded

  }

  public MutableLiveData<List<Contact>> contacts = new MutableLiveData<>();

  public MutableLiveData<LoadingState> loadingState = new MutableLiveData<>(LoadingState.Loading);

  public void initList()
  {
    loadingState.postValue(LoadingState.Loading);

    new Handler().postDelayed(() -> {
      contacts.postValue(new ContactApiService().getContacts());
      loadingState.postValue(LoadingState.Loaded);
    }, 2_000);
  }

}
