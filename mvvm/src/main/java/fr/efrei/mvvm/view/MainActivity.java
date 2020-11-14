package fr.efrei.mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import fr.efrei.mvvm.R;
import fr.efrei.mvvm.adapter.ContactsRecyclerViewAdapter;
import fr.efrei.mvvm.viewmodel.MainActivityViewModel;
import fr.efrei.mvvm.viewmodel.MainActivityViewModel.LoadingState;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class MainActivity
    extends AppCompatActivity
{

  private MainActivityViewModel viewModel;

  private RecyclerView recyclerView;

  private RelativeLayout loaderContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

    recyclerView = findViewById(R.id.list_contacts);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    loaderContainer = findViewById(R.id.loader_container);

    observeLoadingState();
    observeContacts();
  }

  private void observeContacts()
  {
    viewModel.contacts.observe(this, contacts -> recyclerView.setAdapter(new ContactsRecyclerViewAdapter(contacts)));
  }

  private void observeLoadingState()
  {
    viewModel.loadingState.observe(this, loadingState ->
    {
      if (loadingState == LoadingState.Loading)
      {
        loaderContainer.setVisibility(View.VISIBLE);
      }
      else
      {
        loaderContainer.setVisibility(View.INVISIBLE);
      }
    });
  }

  @Override
  protected void onResume()
  {
    super.onResume();

    initList();
  }

  private void initList()
  {
    viewModel.initList();
  }

}