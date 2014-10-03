package upc.edu.pe.ransanet;

import java.util.ArrayList;
import java.util.Date;

import upc.edu.pe.ransanet.beans.PedidoMovimientoRansaTO;
import upc.edu.pe.ws.InvocaWS;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultaEstadoActivity extends Activity {

	Resources rs; 
	TableLayout tabla;   
    TableRow.LayoutParams layoutFila;  
    TableRow.LayoutParams layoutFechaInicio;
    TableRow.LayoutParams layoutFechaFin;
    TableRow.LayoutParams layoutEstadoPedido;
    ArrayList<PedidoMovimientoRansaTO> pedidoMovimientoRansaList;
    EditText txtCodigoPedido;
    
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
		txtCodigoPedido = (EditText) findViewById(R.id.txtCodigoPedido);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consulta_estado, menu);
		return true;
	}
	
	
	
	public void buscarPedido(View v){
		
		pedidoMovimientoRansaList=new ArrayList<PedidoMovimientoRansaTO>();
		
		InvocaWS a=new InvocaWS();
		pedidoMovimientoRansaList=a.buscarPedidoMovimiento(txtCodigoPedido.getText().toString());
		
		/* Manejo de tabla dinamica */		
		
		
		rs = this.getResources();  
        tabla = (TableLayout)findViewById(R.id.tabla);
        tabla.removeAllViews();
        
        tabla = (TableLayout)findViewById(R.id.tabla);
 layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,  
                                               TableRow.LayoutParams.WRAP_CONTENT);  
 layoutEstadoPedido = new TableRow.LayoutParams(400,TableRow.LayoutParams.WRAP_CONTENT);
 layoutFechaInicio = new TableRow.LayoutParams(250,TableRow.LayoutParams.WRAP_CONTENT);
 layoutFechaFin = new TableRow.LayoutParams(250,TableRow.LayoutParams.WRAP_CONTENT);
 
 
 if(this.pedidoMovimientoRansaList!=null){
	if(this.pedidoMovimientoRansaList.size()>0){
		crearTrackingTable();	
	}	 
	 else{
		 Toast.makeText(ConsultaEstadoActivity.this, "No se encontraron movimientos para este código de pedido",
					Toast.LENGTH_LONG).show();
	 }
 }
	}
	
	public void crearTrackingTable(){
			 agregarCabecera();
			 agregarFilasTabla();  	

	}
	
	 public void agregarFilasTabla(){  
		  
	     TableRow fila;  
	     
	     TextView txtFilaEstado;  
	     TextView txtFilaFechaInicio;
	     TextView txtFilaFechaFin;
	     
	      for(int i = 0;i<this.pedidoMovimientoRansaList.size();i++){ 
	    	 
	    	 PedidoMovimientoRansaTO pedidoMovimientoRansaTOTemp=this.pedidoMovimientoRansaList.get(i);
	    	 
	         fila = new TableRow(this);  
	         fila.setLayoutParams(layoutFila);  
	  
	         txtFilaEstado = new TextView(this);  
	         txtFilaFechaInicio = new TextView(this);
	    	 txtFilaFechaFin = new TextView(this);
	    	 
	         txtFilaEstado.setText(pedidoMovimientoRansaTOTemp.getEstadoPedido());  
	         txtFilaEstado.setGravity(Gravity.CENTER_HORIZONTAL);  
	         txtFilaEstado.setTextAppearance(this,R.style.etiqueta);  
	         txtFilaEstado.setBackgroundResource(R.drawable.tabla_celda);  
	         txtFilaEstado.setLayoutParams(layoutEstadoPedido);  	         
	         
	         java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
	         
	         txtFilaFechaInicio.setText(pedidoMovimientoRansaTOTemp.getFecInicio());
	    	 txtFilaFechaInicio.setGravity(Gravity.CENTER_HORIZONTAL);  
	    	 txtFilaFechaInicio.setTextAppearance(this,R.style.etiqueta);  
	    	 txtFilaFechaInicio.setBackgroundResource(R.drawable.tabla_celda);  
	    	 txtFilaFechaInicio.setLayoutParams(layoutFechaInicio);  

	    	 txtFilaFechaFin.setText(pedidoMovimientoRansaTOTemp.getFecFin());
	    	 txtFilaFechaFin.setGravity(Gravity.CENTER_HORIZONTAL);  
	    	 txtFilaFechaFin.setTextAppearance(this,R.style.etiqueta);  
	    	 txtFilaFechaFin.setBackgroundResource(R.drawable.tabla_celda);  
	    	 txtFilaFechaFin.setLayoutParams(layoutFechaFin); 
	
	         fila.addView(txtFilaEstado);  
	         fila.addView(txtFilaFechaInicio); 
	    	 fila.addView(txtFilaFechaFin);
	         tabla.addView(fila);  
	     }  
	    }  
			
	
    public void agregarCabecera(){  
	     TableRow fila;  
	     TextView txtTableEstado;  
	     TextView txtTableFechaInicio;
	     TextView txtTableFechaFin;
	     
	     fila = new TableRow(this);  
	 fila.setLayoutParams(layoutFila);  
	  
	 txtTableEstado = new TextView(this);
	 txtTableFechaInicio = new TextView(this);
	 txtTableFechaFin = new TextView(this);
	   
	 txtTableEstado.setText(rs.getString(R.string.estadoPedido));  
	 txtTableEstado.setGravity(Gravity.CENTER_HORIZONTAL);  
	 txtTableEstado.setTextAppearance(this,R.style.etiqueta);  
	 txtTableEstado.setBackgroundResource(R.drawable.tabla_celda_cabecera);  
	 txtTableEstado.setLayoutParams(layoutEstadoPedido);  
	 
	 
	 txtTableFechaInicio.setText(rs.getString(R.string.fecini));  
	 txtTableFechaInicio.setGravity(Gravity.CENTER_HORIZONTAL);  
	 txtTableFechaInicio.setTextAppearance(this,R.style.etiqueta);  
	 txtTableFechaInicio.setBackgroundResource(R.drawable.tabla_celda_cabecera);  
	 txtTableFechaInicio.setLayoutParams(layoutFechaInicio);  

	 txtTableFechaFin.setText(rs.getString(R.string.fecfin));  
	 txtTableFechaFin.setGravity(Gravity.CENTER_HORIZONTAL);  
	 txtTableFechaFin.setTextAppearance(this,R.style.etiqueta);  
	 txtTableFechaFin.setBackgroundResource(R.drawable.tabla_celda_cabecera);  
	 txtTableFechaFin.setLayoutParams(layoutFechaFin); 
	 
	 fila.addView(txtTableEstado);
	 fila.addView(txtTableFechaInicio); 
	 fila.addView(txtTableFechaFin);
	 tabla.addView(fila);  
	    }  
}
