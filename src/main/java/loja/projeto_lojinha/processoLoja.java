package loja.projeto_lojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class processoLoja {

    private int codigo;
    
    private String fone;
    private String email;
    
    private int ID;
    private String nome;
    private int CPF;
    private String Setor;
    
    private int ID_Produto;
    private String nome_produto;
    private double valor;
    private String descricao;
    
    
    public processoLoja(String email, String fone, String nome, int codigo,
     int ID, int CPF, String Setor, int ID_Produto, String nome_produto,
     double valor, String descricao
    ){
        this.codigo = codigo;
        this.email = email;
        this.fone = fone;
        
        this.nome = nome;
        this.CPF = CPF;
        this.ID = ID;
        this.ID_Produto = ID_Produto;
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.Setor = Setor;
        this.valor = valor;
        
        
    }

    public processoLoja() {}
    
    /**
     * 
     * Parte de usuarios
     */
    
    public void inserirUser() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO usuarios(nome, CPF, Setor) VALUES (?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setInt(2, CPF);
            ps.setString(3, Setor);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarUser() {
        //1: Definir o comando SQL
        String sql = "UPDATE usuarios SET nome = ?, CPF = ?, Setor = ? WHERE ID = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, CPF);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagarUser() {
        //1: Definir o comando SQL
        String sql = "DELETE FROM usuarios WHERE codigo = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, codigo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarUser() {
        //1: Definir o comando SQL
        String sql = "SELECT * FROM usuarios";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
                String aux = String.format(
                        "Código: %d, Nome: %s, Fone: %s, Email: %s",
                        codigo,
                        nome,
                        fone,
                        email
                );
                JOptionPane.showMessageDialog(null, aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 
         * Parte de produtos
         */
        
        public void inserirProduto() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Produtos(nome, fone, email) VALUES (?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarProduto() {
        //1: Definir o comando SQL
        String sql = "UPDATE Produtos SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagarProduto() {
        //1: Definir o comando SQL
        String sql = "DELETE FROM Produtos WHERE codigo = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, codigo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarProduto() {
        //1: Definir o comando SQL
        String sql = "SELECT * FROM Produtos";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
                String aux = String.format(
                        "Código: %d, Nome: %s, Fone: %s, Email: %s",
                        codigo,
                        nome,
                        fone,
                        email
                );
                JOptionPane.showMessageDialog(null, aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /**
         * 
         * Parte de compra 
         */
        public void comprar(){
            
        }
        
        public void estornar(){
            
        }
    }
    
    /**
     *
     * getters/setters
     */
    void setNome(String nome) {
        this.nome = nome;
    }

    void setFone(String fone) {
        this.fone = fone;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    String getNome(){
        return nome;
    }
    String getFone(){
        return fone;
    }
    String getEmail(){
        return email;
    }
    int getCodigo(){
        return codigo;
    }
}
