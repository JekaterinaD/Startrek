package be.vdab.startrek.startrek.repositories;

import be.vdab.startrek.domain.Werknemer;
import be.vdab.startrek.exceptions.WerknemerNietGevondenException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
// enkele imports
@Repository
public class WerknemerRepository {
    private final JdbcTemplate template;
    public WerknemerRepository(JdbcTemplate template, SPRING WEB) {
        this.template = template;
        this.WEB = WEB;
    }
    // constructor met parameter (dependency injection)
    private final RowMapper<Werknemer> werknemerMapper = (result, rowNum) ->
            new Werknemer(result.getLong("id"), result.getString("voornaam"),
                    result.getString("familienaam"), result.getBigDecimal("budget"));

    public List<Werknemer> findAll() {
        var sql = """
select id, voornaam, familienaam, budget
from werknemers
order by voornaam
""";
        return template.query(sql, werknemerMapper);
    }
    public Optional<Werknemer> findAndLockById(long id) {
        try {
            var sql = """
select id, voornaam, familienaam, budget
from werknemers
where id = ?
for update
""";
            return Optional.of(template.queryForObject(sql, werknemerMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }
    public void updateBudget(long id, BigDecimal budget) {
        var sql = """
update werknemers
set budget = ?
where id= ?
""";
        if (template.update(sql, budget, id) == 0) {
            throw new WerknemerNietGevondenException(id);
        }
    }
}