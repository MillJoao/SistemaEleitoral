package Objetos;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListaPartidos extends LinkedList<Partido> {
	
	private static final long serialVersionUID = 1L;

	public void getDados(File path) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			
			String linha = br.readLine();
			linha = br.readLine();
			while (linha != null) {
				
				String[] vect = linha.split(",");
				Integer num = Integer.parseInt(vect[0]);
				Integer votos = Integer.parseInt(vect[1]);
				String nome = vect[2];
				String sigla = vect[3];
				
				Partido partido = new Partido(num, nome, sigla, votos);
				this.add(partido);
				
				linha = br.readLine();
			}	
			
		}
		catch (IOException erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
}
