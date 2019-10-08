package br.edu.ifg.cliente;

import br.edu.ifg.interf.*;
import br.edu.ifg.model.Mensagem;
import br.edu.ifg.servidor.DNS;

import java.io.ObjectInputStream.GetField;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AplicacaoChat {
// sudo gedit /etc/hosts
	private AplicacaoChat() {
		
	}

	public static void main(String[] args) {
		try {
			
//			Registry registry  = LocateRegistry.getRegistry("localhost",Constant.RMI_PORT);
//			final InterfaceDNS remote = (InterfaceDNS) registry.lookup(Constant.RMI_ID);
//			
//			InetAddress ip = InetAddress.getLocalHost();
//	        String hostname = ip.getHostAddress();
//			
//	        System.out.println("APLICAÇÃO RODANDO");
//	        String nick = JOptionPane.showInputDialog("Digite o nick para registrar o IP:"); 
//	        //System.out.println(nick);
//	    	//if (remote.autentica("Euripedes", hostname)) {
//
//	        if (remote.autentica(nick, hostname)) {
//				System.out.println("Usuario adicionado com sucesso!");
//			} else {
//				System.out.print("Erro ao adicionar!");
//			}
//	        
//			ArrayList<String> lista = new ArrayList<>();			
//			lista = remote.obterListaUsuariosOnline();
//			
//			System.out.println("Usuários on line:");
//			for (String nomeOnline : lista) {
//				System.out.println("- "+nomeOnline);
//			}
//			nick = JOptionPane.showInputDialog("Digite o nick do usário para obter o IP");
//			
//			if(remote.obterIP(nick).equals("")) {				
//				System.out.println("Não existe a chave dentro da lista");
//			}else {
//				System.out.println("O o IP do usuário "+ nick+" é: " +remote.obterIP(nick));
//
//			}
			String nick = JOptionPane.showInputDialog("Digite seu nome:");
			
			Chat chat = new Chat(nick);
			
			chat.lookupDNS();
			
			String nickAmigo = JOptionPane.showInputDialog("Digite o nick do seu amigo:");
			
			String ipAmigo = chat.obterIpAmigo(nickAmigo);
			
			System.out.println("O ip do seu amigo é: " +ipAmigo);
		
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}				
	}

	
	
	
}