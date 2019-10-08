package br.edu.ifg.cliente;

import br.edu.ifg.interf.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Chat {

	private String nick;
	
	InterfaceDNS remote;
	InterfaceDNS remoteChat;

	public Chat(String nick) {
		this.nick = nick;
	}

	/**
	 * Metodo para realizacao de lookup no servidor DNS
	 */
	public void lookupDNS() {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
			remote = (InterfaceDNS) registry.lookup(Constant.RMI_ID);
			String ip = obtemMeuIP();
			remote.autentica(nick, ip);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para realizar lookup no chat
	 */
	public void lookupChat() {		
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", ConstantMensagens.RMI_PORT);
			remoteChat = (InterfaceDNS) registry.lookup(ConstantMensagens.RMI_ID);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}		
	}

	/**
	 * Metodo para obtencao do meu endereco IP 
	 * 	 */
	public String obtemMeuIP() throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		String hostname = ip.getHostAddress();
		return hostname;
	}

	public String obterIpAmigo(String nickAmigo) throws RemoteException {
		String ipAmigo = remote.obterIP(nickAmigo);
		return ipAmigo;
	}
}