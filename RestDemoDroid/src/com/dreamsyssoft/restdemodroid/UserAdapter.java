package com.dreamsyssoft.restdemodroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dreamsyssoft.demo.rest.model.User;

public class UserAdapter extends ArrayAdapter<User> {

	public UserAdapter(Context context, int resourceId) {
		super(context, resourceId);
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
        	LayoutInflater vi =
                    (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.user_list, null);
        }
        
        TextView txtName = (TextView)v.findViewById(R.id.txtName);
        txtName.setText(getItem(position).getName());
        
        TextView txtCity = (TextView)v.findViewById(R.id.txtCity);
        txtCity.setText(getItem(position).getCity() + ", ");
        
        TextView txtState = (TextView)v.findViewById(R.id.txtState);
        txtState.setText(getItem(position).getState());
 
        return v;
    }
}
