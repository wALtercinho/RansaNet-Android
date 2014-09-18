package upc.edu.pe.ransanet;

import upc.edu.pe.ransanet.beans.CustomerTO;
import upc.edu.pe.ws.InvocaWS;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	EditText login;
	EditText password;

	CustomerTO customerTO = new CustomerTO();
	   
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		login = (EditText) findViewById(R.id.txtLogin);
		password = (EditText) findViewById(R.id.txtPassword);

		login.setText("");
		password.setText("");
		
		
    }


	public void login(View v) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		
		InvocaWS a=new InvocaWS();
		boolean loginres=a.login(login.getText().toString(), password.getText().toString());
			
		if(loginres){
			finish();
		Intent intent = new Intent(LoginActivity.this,
				MainActivity.class);
		startActivity(intent);
		}
		else{
		Toast.makeText(LoginActivity.this, "Usuario y/o Password incorrecto",
				Toast.LENGTH_LONG).show();
		}
			
			
		}

	}

