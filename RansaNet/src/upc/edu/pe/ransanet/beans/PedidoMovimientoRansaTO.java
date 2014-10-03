package upc.edu.pe.ransanet.beans;

import java.io.Serializable;
import java.util.Date;

public class PedidoMovimientoRansaTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8003837321862089297L;
	
	
	private String codPedido;
	private String estadoPedido;
	private String fecInicio;
	private String fecFin;
	private Date fecMovimeinto;
	private int idCliente;
	private int idEstadoPedido;
	private int idPedidoMovimiento;
	private int idPedido;
	private int idTipoPedido;
	private int idUsuarioCreador;
	private byte stsRegistro;
	public String getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}
	
	public String getFecInicio() {
		return fecInicio;
	}
	public void setFecInicio(String fecInicio) {
		this.fecInicio = fecInicio;
	}
	public String getFecFin() {
		return fecFin;
	}
	public void setFecFin(String fecFin) {
		this.fecFin = fecFin;
	}
	public Date getFecMovimeinto() {
		return fecMovimeinto;
	}
	public void setFecMovimeinto(Date fecMovimeinto) {
		this.fecMovimeinto = fecMovimeinto;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEstadoPedido() {
		return idEstadoPedido;
	}
	public void setIdEstadoPedido(int idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}
	public int getIdPedidoMovimiento() {
		return idPedidoMovimiento;
	}
	public void setIdPedidoMovimiento(int idPedidoMovimiento) {
		this.idPedidoMovimiento = idPedidoMovimiento;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdTipoPedido() {
		return idTipoPedido;
	}
	public void setIdTipoPedido(int idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}
	public int getIdUsuarioCreador() {
		return idUsuarioCreador;
	}
	public void setIdUsuarioCreador(int idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}
	public byte getStsRegistro() {
		return stsRegistro;
	}
	public void setStsRegistro(byte stsRegistro) {
		this.stsRegistro = stsRegistro;
	}
	public String getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	
}
