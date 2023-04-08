package ru.timofeev.translator.dao.mapper;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.jdbc.core.RowMapper;
import ru.timofeev.translator.data.TranslationResult;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TranslationResultRowMapper implements RowMapper<TranslationResult> {
    @Override
    public TranslationResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        Timestamp timestamp = rs.getTimestamp("request_data");
        LocalDateTime date = timestamp.toLocalDateTime();

        TranslationResult result
                = TranslationResult.builder()
                .id(rs.getInt("id"))
                .inputText(rs.getString("input_text"))
                .result(rs.getString("result"))
                .params(rs.getString("params"))
                .ipAddress(rs.getString("ip_address"))
                .date(date)
                .build();

        return result;
    }
}
