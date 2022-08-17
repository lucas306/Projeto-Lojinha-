package loja.projeto_lojinha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class processoLoja {

    private int ID;
    private String nome;
    private int CPF;
    private String Setor;
    private int ID_Produto;
    private String nome_produto;
    private double valor;
    private String descricao;
    private String cargo;
    
    
    public processoLoja(
        String nome, 
        int codigo,
        int ID, int CPF, 
        String Setor, 
        int ID_Produto, 
        String nome_produto,
        double valor, 
        String descricao,
        String cargo
    ){
  
        this.nome = nome;
        this.CPF = CPF;
        this.ID = ID;
        this.ID_Produto = ID_Produto;
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.Setor = Setor;
        this.valor = valor;
        this.cargo = cargo;
    }

    public processoLoja() {}
    
    /**
     * 
     * Parte de usuarios
     */
    
    public void inserirUser() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO usuarios(nome, CPF, Setor, cargo) VALUES (?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setInt(2, CPF);
            ps.setString(3, Setor);
            ps.setString(4, cargo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarUser() {
        //1: Definir o comando SQL
        String sql = "UPDATE usuarios SET nome = ?, CPF = ?, Setor = ?, cargo = ? WHERE ID = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setInt(2, CPF);
            ps.setString(3, Setor);
            ps.setString(4, cargo);
            ps.setInt(5, ID);
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
            ps.setInt(1, ID);
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
                int ID = rs.getInt("ID");
                String nome = rs.getString("nome");
                String CPF = rs.getString("CPF");
                String Setor = rs.getString("Setor");
                String aux = String.format(
                        "ID: %d, NOME: %s, CPF: %s, SETOR: %s",
                        ID,
                        nome,
                        CPF,
                        Setor
                );
                JOptionPane.showMessageDialog(null, aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * Parte de produtos
     */
                
    public void inserirProduto() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Produtos(nome_produto, valor, descricao) VALUES (?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome_produto);
            ps.setDouble(2, valor);
            ps.setString(3, descricao);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarProduto() {
        //1: Definir o comando SQL
        String sql = "UPDATE Produtos SET nome_produto = ?, valor = ?, descricao = ? WHERE ID_Produto = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome_produto);
            ps.setDouble(2, valor);
            ps.setString(3, descricao);
            ps.setInt(4, ID_Produto);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagarProduto() {
        //1: Definir o comando SQL
        String sql = "DELETE FROM Produtos WHERE ID_Produto = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, ID_Produto);
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
                int ID_Produto = rs.getInt("ID_Produto");
                String nome_produto = rs.getString("nome_produto");
                String valor = rs.getString("fone");
                String descricao = rs.getString("email");
                String aux = String.format(
                        "Código: %d, Nome do Produto: %s, valor: %s, descricao: %s",
                        ID_Produto,
                        nome_produto,
                        valor,
                        descricao
                );
                JOptionPane.showMessageDialog(null, aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    /**
     *
     * Parte da compra
     */
    
    public void compra() {

    }

    public void estorno() {

    }
    
    /**
     *
     * getters/setters
     */
        
    void setNome(String nome) {this.nome = nome;}
    void setNome_produto(String nome_produto) {this.nome_produto = nome_produto;}
    void setDescricao(String descricao) {this.descricao = descricao;}
    void setSetor(String Setor) {this.Setor = Setor;}
    void setValor(double valor) {this.valor = valor;}
    void setCPF(int CPF) {this.CPF = CPF;}
    void setID(int ID) {this.ID = ID;}
    void setID_Produto(int ID_Produto) {this.ID_Produto = ID_Produto;}
    
    String getNome_produto() {return nome_produto;}
    String getNome() {return nome;}
    String getSetor() {return Setor;}
    String getDescricao() {return descricao;}
    int getID() {return ID;}
    int getID_Produto() {return ID_Produto;}
    int getCPF() {return CPF;}
    double getValor() {return valor;}
}
