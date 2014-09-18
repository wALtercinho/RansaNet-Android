package upc.edu.pe.ransanet;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ConsultaEstadoActivity extends Activity {

	
	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consulta_estado);
		setTitle("Consulta de Servicio");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consulta_estado, menu);
		return true;
	}

}
