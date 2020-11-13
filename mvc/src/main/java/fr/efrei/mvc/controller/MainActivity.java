package fr.efrei.mvc.controller;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import fr.efrei.mvc.R;
import fr.efrei.mvc.adapter.ContactsRecyclerViewAdapter;
import fr.efrei.mvc.model.Contact;
import fr.efrei.mvc.service.ContactApiService;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public class MainActivity
    extends AppCompatActivity
{

  private List<Contact> contacts;

  private RecyclerView recyclerView;

  private RelativeLayout loaderContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

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

  private void initList()
  {
    loaderContainer.setVisibility(View.VISIBLE);

    new Handler().postDelayed(() -> {
      contacts = new ContactApiService().getContacts();
      recyclerView.setAdapter(new ContactsRecyclerViewAdapter(contacts));

      loaderContainer.setVisibility(View.INVISIBLE);
    }, 2_000);
  }

}