package dev.dao;

import dev.entite.Plat;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {
    NamedParameterJdbcTemplate jdbcTemplate;

    public PlatDaoJdbc(DataSource ds) {
        jdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    public Plat mapRow(ResultSet rs, Integer rowNum) throws SQLException {
        Plat plat = new Plat();
        plat.setId(rs.getInt("id"));
        plat.setNom(rs.getString("nom"));
        plat.setPrixEnCentimesEuros(rs.getInt("prix"));
        return plat;
    }

    @Override
    public List<Plat> listerPlats() {
        return jdbcTemplate.query("select * from plat", this::mapRow);
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {
        Plat plat = new Plat(nomPlat, prixPlat);
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(plat);
        jdbcTemplate.update("insert into plat(nom, prix) values(:nom,:prix)", params);
    }
}
