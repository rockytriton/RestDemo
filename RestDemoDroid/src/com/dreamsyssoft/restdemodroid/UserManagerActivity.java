package com.dreamsyssoft.restdemodroid;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dreamsyssoft.demo.rest.model.User;
import com.dreamsyssoft.demo.rest.model.UserRequest;
import com.dreamsyssoft.demo.rest.model.UserResponse;
import com.dreamsyssoft.demo.rest.services.UserManager;

@EActivity(R.layout.activity_user_manager)
@OptionsMenu(R.menu.user_manager)
public class UserManagerActivity extends Activity {
	@RestService
	UserManager userManager;
	
	@ViewById
	ListView userList;
	
	@AfterViews
	public void init() {
		userList.setAdapter(new UserAdapter(this, R.id.userList));
		
		userList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				ArrayAdapter<User> adapter = (ArrayAdapter<User>)userList.getAdapter();
				
				User user = adapter.getItem(position);
				
				Intent intent = new Intent(UserManagerActivity.this, EditUserActivity_.class);
				intent.putExtra("user", user);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		refresh();
	}
	
	@OptionsItem(R.id.action_add_user)
	public void onAddUser()
	{
		Intent intent = new Intent(this, EditUserActivity_.class);
		startActivity(intent);
	}
	
	@Background
	public void refresh()
	{
		UserResponse response = userManager.fetchAllUsers(new UserRequest());
		
		handleResponse(response);
	}
	
	@UiThread
	public void handleResponse(UserResponse response)
	{
		ArrayAdapter<User> adapter = (ArrayAdapter<User>)userList.getAdapter();
		
		adapter.clear();
		
		for (User user : response.getUsers())
		{
			adapter.add(user);
		}
	}
}
