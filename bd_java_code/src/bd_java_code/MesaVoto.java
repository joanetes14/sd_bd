package bd_java_code;

public class MesaVoto {
	private String username;
	private String password;
	private Departamento dep;
	private Eleicao eleicao;
	
	public MesaVoto() {
		// TODO Auto-generated constructor stub
	}
	public Departamento getDep() {
		return dep;
	}public Eleicao getEleicao() {
		return eleicao;
	}public String getPassword() {
		return password;
	}public String getUsername() {
		return username;
	}public void setDep(Departamento dep) {
		this.dep = dep;
	}public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}public void setPassword(String password) {
		this.password = password;
	}public void setUsername(String username) {
		this.username = username;
	}
}
