package br.edu.ifg.cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.management.remote.rmi.RMIServer;

import br.edu.ifg.interf.Constant;
import br.edu.ifg.interf.ConstantMensagens;
import br.edu.ifg.interf.InterfaceMensagens;
import br.edu.ifg.model.Mensagem;

public class ServidorMensagens implements InterfaceMensagens{
	
	
	
	public Mensagem enviarMensagens(Mensagem mensagem) throws RemoteException {		
		mensagem.setConteudo("AULA DE REDES");
		mensagem.setRemetente("SERVIDOR DE MENSAGEM");
		return mensagem;
	}
	
	public static void main(String[] args) throws RemoteException{
		
		try{
			
			ServidorMensagens servidorMensagens = new ServidorMensagens();
			InterfaceMensagens mensagem = (InterfaceMensagens) UnicastRemoteObject.exportObject(servidorMensagens, 0);
			Registry registry = LocateRegistry.createRegistry(ConstantMensagens.RMI_PORT); 
			
			registry.bind(ConstantMensagens.RMI_ID, mensagem);

			System.out.println("Servidor Mensagem ready!");
			
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
		
	}
	
}
