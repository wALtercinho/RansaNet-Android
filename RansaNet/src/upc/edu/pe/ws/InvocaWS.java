package upc.edu.pe.ws;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class InvocaWS {
	
	public boolean login(String usuario,String clave){
		boolean res=false;
		try {
			String NAMESPACE="http://joventube.com/";//http://www.webserviceX.NET
			String NAMEFUNCTION="logeo";//GetCitiesByCountry
			String METHOD_NAME="logeo";
			
			SoapObject rpc= new SoapObject(NAMESPACE, NAMEFUNCTION);
			rpc.addProperty("usuario",usuario);
			rpc.addProperty("clave",clave);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			envelope.bodyOut=rpc;
			envelope.dotNet=true;
			envelope.encodingStyle=SoapSerializationEnvelope.XSD;
			
			String URL="http://joventube.com/ServicioWebWs/index.php/soapserverws/";//http://www.webservicex.net/globalweather.asmx
			HttpTransportSE http=new HttpTransportSE(URL);
			http.debug=true;
			String SOAPACTION="urn:logeowsdl";
			http.call(SOAPACTION, envelope);
			res=(Boolean) envelope.getResponse();
			
			
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
}
