package M;

public class Contatos {
	private static String nome;
    private static String fone;
    
    public Contatos(String fone, String nome) {
        Contatos.fone = fone;
        Contatos.nome = nome;
    }
    
    public static void setNome(String nome) {
		Contatos.nome = nome;
	}
    
    public static String getNome() {
		return nome;
	}
    
    public static void setFone(String fone) {
		Contatos.fone = fone;
	}
    
    public static String getFone() {
		return fone;
	}
}