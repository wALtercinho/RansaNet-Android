package upc.edu.pe.ws;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import upc.edu.pe.ransanet.beans.CustomerTO;
import upc.edu.pe.ransanet.beans.PedidoMovimientoRansaTO;

public class InvocaWS {
	
	public CustomerTO loginDatos(String usuario,String clave){
		CustomerTO res=new CustomerTO();
		SoapObject result;
		try {
			//String NAMESPACE="http://visitasadm.inpe.gob.pe/";//http://www.webserviceX.NET
			String NAMESPACE="http://service.ransa.com";
			String NAMEFUNCTION="datosUsuario";//GetCitiesByCountry
			String METHOD_NAME="datosUsuario";
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("usuario",usuario);
			rpc.addProperty("clave",clave);
			rpc.addProperty("tipo","C");
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			//envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			envelope.setOutputSoapObject(rpc);
			String URL="http://visitasadm.inpe.gob.pe/ServicioRansaNetWs/services/UsuarioRansaServiceImpl/";//http://www.webservicex.net/globalweather.asmx
			
			envelope.addMapping(NAMESPACE, "UsuarioRansa",new CustomerTO().getClass());
			
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			//String SOAPACTION="urn:iniciarSesionwsdl";
			String SOAPACTION="http://service.ransa.com/datosUsuario";
			http.call(SOAPACTION, envelope);
			ArrayList<CustomerTO> salida=new ArrayList<CustomerTO>();

			 result = (SoapObject) envelope.getResponse();//tomamos la respuesta del servidor

             SoapObject yourResponseObject = (SoapObject) envelope.bodyIn;
    		 SoapObject array = (SoapObject) yourResponseObject.getProperty(0);// this is -->anyType //property 0           

    		 String estadoPedido= array.getProperty(0).toString();// this is--> //   property 0 [0]  ;
    		 res.setLastName(estadoPedido);
    		 
             			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
		
	public boolean login(String usuario,String clave){
		Boolean res=false;
		try {
			//String NAMESPACE="http://visitasadm.inpe.gob.pe/";//http://www.webserviceX.NET
			String NAMESPACE="http://service.ransa.com";
			String NAMEFUNCTION="iniciarSesion";//GetCitiesByCountry
			String METHOD_NAME="iniciarSesion";
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("usuario",usuario);
			rpc.addProperty("clave",clave);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			
			String URL="http://visitasadm.inpe.gob.pe/ServicioRansaNetWs/services/UsuarioRansaServiceImpl/";//http://www.webservicex.net/globalweather.asmx
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			//String SOAPACTION="urn:iniciarSesionwsdl";
			String SOAPACTION="iniciarSesion";
			http.call(SOAPACTION, envelope);
			if(envelope.getResponse().toString().equalsIgnoreCase("true")){
				res=true;
			}
			else{
				res=false;
			}
			//res=(Boolean) ;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public String ejemplo(String usuario,String clave){
		String res="";
		try {
			String NAMESPACE="http://joventube.com/";//http://www.webserviceX.NET
			String NAMEFUNCTION="hello";//GetCitiesByCountry
			String METHOD_NAME="hello";
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("name",usuario);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			
			String URL="http://joventube.com/WsRansaNet.php/";//http://www.webservicex.net/globalweather.asmx
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			String SOAPACTION="urn:hellowsdl";
			http.call(SOAPACTION, envelope);
			res=envelope.getResponse().toString();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			res = "Error"+e.getMessage();
		}
		return res;
	}

	public String DevolverSaludo(String dni,String nom,String ciud){
		String res="";
		try {
			String NAMESPACE="http://ws.cibertec.com";//http://www.webserviceX.NET
			String NAMEFUNCTION="Grabar";//GetCitiesByCountry
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("dni",dni);
			rpc.addProperty("nom",nom);
			rpc.addProperty("ciud",ciud);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			
			String URL="http://miweserver.ioricarlos22.cloudbees.net/services/ImplementacionWS";//http://www.webservicex.net/globalweather.asmx
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			String SOAPACTION="urn:Grabar";
			http.call(SOAPACTION, envelope);
			res=envelope.getResponse().toString();
			
			
		} catch (Exception e) {
			res = "Error"+e.getMessage();
		}
		return res;
	}
	public String BuscarSaludo(String dni){
		String res="";
		try {
			String NAMESPACE="http://ws.cibertec.com";//http://www.webserviceX.NET
			String NAMEFUNCTION="Buscar";//GetCitiesByCountry
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("dni",dni);
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			
			String URL="http://miweserver.ioricarlos22.cloudbees.net/services/ImplementacionWS";//http://www.webservicex.net/globalweather.asmx
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			String SOAPACTION="urn:Buscar";
			http.call(SOAPACTION, envelope);
			res=envelope.getResponse().toString();
			
			
		} catch (Exception e) {
			res = "Error"+e.getMessage();
		}
		return res;
	}
	
	public String BuscarVoucher(String nrovoucher, String fechavoucher){
		String res="";
		try {
			String NAMESPACE="http://dao.trastienda";//http://www.webserviceX.NET
			String NAMEFUNCTION="estadoVo";//GetCitiesByCountry
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("nro",nrovoucher);
			rpc.addProperty("fecha",fechavoucher);
			//numsec
			//fech
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			
			String URL="http://10.4.1.126:8080/WsAJTrab/services/PersonaDAO";//http://www.webservicex.net/globalweather.asmx
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			String SOAPACTION="urn:estadoVo";
			http.call(SOAPACTION, envelope);
			res=envelope.getResponse().toString();
			
			
		} catch (Exception e) {
			res = "Error"+e.getMessage();
		}
		return res;
	}

	public ArrayList<PedidoMovimientoRansaTO> buscarPedidoMovimiento(String codigoPedido){
		ArrayList<PedidoMovimientoRansaTO> salida=new ArrayList<PedidoMovimientoRansaTO>();
		try{
		String NAMESPACE="http://service.ransa.com";
		String NAMEFUNCTION="getPedidoMovimiento";//GetCitiesByCountry
		
		SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
		rpc.addProperty("idPedido",codigoPedido);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		//envelope.bodyOut=rpc;
		envelope.dotNet=true;
		envelope.encodingStyle=SoapSerializationEnvelope.XSD;
		envelope.setOutputSoapObject(rpc);
		String URL="http://visitasadm.inpe.gob.pe/ServicioRansaNetWs/services/UsuarioRansaServiceImpl/";//http://www.webservicex.net/globalweather.asmx
		
		envelope.addMapping(NAMESPACE, "PedidoMovimientoRansa",new PedidoMovimientoRansaTO().getClass());
		
		HttpTransportSE http=new HttpTransportSE(URL);
		http.debug=true;
		
		String SOAPACTION="http://service.ransa.com/getPedidoMovimiento";
		http.call(SOAPACTION, envelope);
	 
		 SoapObject responseObject = (SoapObject) envelope.bodyIn;
		 
		 
		 for(int i=0;i<responseObject.getPropertyCount();i++){
			 SoapObject array = (SoapObject) responseObject .getProperty(i);
			/*System.out.println("0 "+array.getProperty(0).toString());
			fin System.out.println("1 "+array.getProperty(1).toString());
			inicio System.out.println("2 "+array.getProperty(2).toString());
			System.out.println("3 "+array.getProperty(3).toString());
			System.out.println("4 "+array.getProperty(4).toString());*/
			 PedidoMovimientoRansaTO pedidoMovimientoRansaTO=new PedidoMovimientoRansaTO();
			 pedidoMovimientoRansaTO.setFecFin(array.getProperty(1)==null?"":array.getProperty(1).toString());
			 pedidoMovimientoRansaTO.setFecInicio(array.getProperty(2)==null?"":array.getProperty(2).toString());
			 pedidoMovimientoRansaTO.setEstadoPedido(array.getProperty(10).toString());
			 
			 salida.add(pedidoMovimientoRansaTO);
		 }
		         
         return salida;
 	  		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return salida;
	}	
	
}
