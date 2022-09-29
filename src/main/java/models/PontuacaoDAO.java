package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class PontuacaoDAO {

    static public ArrayList<Pontuacao> findAll() {

        ArrayList<Pontuacao> pontuacoes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM pontuacoes";

            PreparedStatement pmt = conn.prepareStatement(sql);

            ResultSet reultado = pmt.executeQuery();

            while (reultado.next()) {
                int id = reultado.getInt("id");
                String nome = reultado.getString("nome");
                int jogadas = reultado.getInt("jogadas");
                String dataString = reultado.getString("data");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate data = LocalDate.parse(dataString,formatter);
                pontuacoes.add(new Pontuacao(id, nome, jogadas, data));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return pontuacoes;
    }

    static public void inserir(Pontuacao pontuaco){

        try(Connection conn = ConnectionFactory.getConnection()){

            String sql = "INSERT INTO pontuacoes(nome, jogadas, data) VALUES(?, ?, ?)";

            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,pontuaco.getNome());
            stm.setInt(2,pontuaco.getJogadas());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String data = formatter.format(pontuaco.getData());
            stm.setString(3,data);

            int rowsAffected = stm.executeUpdate();

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
