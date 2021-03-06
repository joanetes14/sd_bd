package bd_java_code;

import java.sql.*;

public class LigacaoBD {
	
	private Connection conn;
	private String baseDadosURL;
	private String baseDadosUser;
	private String baseDadosPassword;
	
	public LigacaoBD() {
		// TODO Auto-generated constructor stub
		baseDadosURL = "jdbc:oracle:thin:@localhost:1521:xe";
		baseDadosPassword = "proj";
		baseDadosUser = "proj";
		
		System.out.println(conectaBD());//Serve para conectar a base de dados
	}
	
	public boolean conectaBD (){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			return (conn = DriverManager.getConnection(baseDadosURL, baseDadosUser, baseDadosPassword)) != null;
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			  System.out.println(e.getMessage());
			  return false;
		}
	}
	
	public ResultSet executaSQL(String comando){return executaSQL(comando,0);}
	public ResultSet executaSQL(String comando, int num){
		try{
			Statement stm;
			if((stm = conn.createStatement())==null){
				if(num<5){
					this.conectaBD();
					return (executaSQL(comando,num+1));
				}
				System.out.println("Comando Invalido, ou conflito!");
				return null;
			}
			return stm.executeQuery(comando);			
		}
		catch(SQLException e){
			if(num<5){
				this.conectaBD();
				return (executaSQL(comando,num+1));
			}
			System.out.println("Sem liagacao com a base de dados, ou conflito de comando!");
			return null;
		}
	}
	
	public void imprimeResultSet (ResultSet res){
		if(res==null){System.out.println("Sem resultados");return;}
		try{
			ResultSetMetaData rsmd = res.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();
	
	        for(int i = 1 ; i <= columnsNumber ; i++){
	            System.out.print(textEditor.limitaString(rsmd.getColumnName(i),30));
	        }
	        System.out.println("");
	        while (res.next()) {
	            for (int i = 1; i <= columnsNumber; i++) {
	                String columnValue = res.getString(i);
	                System.out.print(textEditor.limitaString(columnValue,30));
	            }
	            System.out.println("");
	        }
		}catch (SQLException e){
			System.out.println("Sem resultados");
			return;
		}
	}
}
