package fr.efrei.mvp.adapter;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import fr.efrei.mvp.R;
import fr.efrei.mvp.model.Contact;

/**
 * @author Ludovic Roland
 * @since 2020.11.13
 */
public final class ContactsRecyclerViewAdapter
    extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder>
{

  public static final class ViewHolder
      extends RecyclerView.ViewHolder
  {

    private final TextView name;

    private final TextView number;

    public ViewHolder(View view)
    {
      super(view);

      name = view.findViewById(R.id.name);
      number = view.findViewById(R.id.number);
    }

    public void update(Contact contact)
    {
      name.setText(contact.name);
      number.setText(contact.phoneNumber);

      itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), contact.toString(), Toast.LENGTH_SHORT).show());
    }

  }

  private final List<Contact> contacts;

  public ContactsRecyclerViewAdapter(List<Contact> items)
  {
    contacts = items;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
  {
    final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position)
  {
    final Contact contact = contacts.get(position);
    holder.update(contact);
  }

  @Override
  public int getItemCount()
  {
    return contacts.size();
  }
}
