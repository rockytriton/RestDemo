package com.dreamsyssoft.restdemodroid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;

import com.dreamsyssoft.demo.rest.model.User;
import com.dreamsyssoft.demo.rest.model.UserRequest;
import com.dreamsyssoft.demo.rest.services.UserManager;

@EActivity(R.layout.activity_edit_user)
public class EditUserActivity extends Activity
{
	@RestService
	UserManager userManager;
	
	@ViewById
	TextView txtName;
	
	@ViewById
	TextView txtEmail;
	
	@ViewById
	TextView txtBirthDate;
	
	@ViewById
	TextView txtCity;
	
	@ViewById
	TextView txtState;
	
	@ViewById
	Button btnSubmit;
	
	@Extra
	User user;
	
	@AfterViews
	public void init()
	{
		if (user == null) {
			//This would be a create user entry...
			btnSubmit.setText("Create");
			System.out.println("IS CREATE");
		}
		else {
			btnSubmit.setText("Update");
			System.out.println("IS UPDATE");
			
			txtName.setText(user.getName());
			txtCity.setText(user.getCity());
			txtState.setText(user.getState());
			txtEmail.setText(user.getEmail());
			
			try {
				txtBirthDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthDate()));
			}
			catch(Exception e) {
				
			}
		}
	}
	
	@Click(R.id.btnSubmit)
	public void onSubmit()
	{
		boolean insert = false;
		
		if (user == null) {
			insert = true;
			user = new User();
		}
		
		Date birthDate = null;
		
		try {
			birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(txtBirthDate.getText().toString());
		}
		catch(ParseException e) {
			AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);                      
		    dlgAlert.setMessage("Invalid Date");
		    dlgAlert.setTitle("Error");              
		    dlgAlert.setPositiveButton("OK", null);
		    dlgAlert.setCancelable(true);
		    dlgAlert.create().show();
		    
		    if (insert) {
		    	user = null;
		    }
		    
			return;
		}
		
		user.setName(txtName.getText().toString());
		user.setEmail(txtEmail.getText().toString());
		user.setCity(txtCity.getText().toString());
		user.setState(txtState.getText().toString());
		user.setBirthDate(birthDate);
		
		UserRequest request = new UserRequest();
		request.setUser(user);
		
		if (insert) {
			System.out.println("INSERTING");
			userManager.insertUser(request);
		} else {
			System.out.println("UPDATING");
			userManager.updateUser(request);
		}
		
		finish();
	}
	
}
