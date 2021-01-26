package dev.dao.mapper;

import dev.entite.Plat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatMapper implements RowMapper<Plat> {

    @Override
    public Plat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Plat plat = new Plat();
        plat.setId(rs.getInt("id"));
        plat.setNom(rs.getString("nom"));
        plat.setPrixEnCentimesEuros(rs.getInt("prix"));
        return plat;
    }
}
