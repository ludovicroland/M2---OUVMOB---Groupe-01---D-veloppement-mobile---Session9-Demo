package fr.efrei.mvp.view;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import fr.efrei.mvp.R;
import fr.efrei.mvp.adapter.ContactsRecyclerViewAdapter;
import fr.efrei.mvp.model.Contact;
import fr.efrei.mvp.presenter.MainActivityPresenter;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class MainActivity
    extends AppCompatActivity
    implements MainActivityPresenter.View
{

  private MainActivityPresenter presenter;

  private RecyclerView recyclerView;

  private RelativeLayout loaderContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    presenter = new MainActivityPresenter(this);

    recyclerView = findViewById(R.id.list_contacts);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    loaderContainer = findViewById(R.id.loader_container);
  }

  @Override
  protected void onResume()
  {
    super.onResume();

    initList();
  }

  @Override
  public void showProgressBar()
  {
    loaderContainer.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideProgressBar()
  {
    loaderContainer.setVisibility(View.INVISIBLE);
  }

  @Override
  public void updateRecyclerView(List<Contact> contacts)
  {
    recyclerView.setAdapter(new ContactsRecyclerViewAdapter(contacts));
  }

  private void initList()
  {
    presenter.initList();
  }

}