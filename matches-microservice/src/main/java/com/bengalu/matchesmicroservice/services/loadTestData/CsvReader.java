package com.bengalu.matchesmicroservice.services.loadTestData;

import com.bengalu.matchesmicroservice.entities.Match;
import com.bengalu.matchesmicroservice.entities.SelectedPlayer;
import com.bengalu.matchesmicroservice.repositories.MatchRepository;
import com.bengalu.matchesmicroservice.repositories.SelectedPlayerRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CsvReader {
    private MatchRepository matchRepository;
    private SelectedPlayerRepository selectedPlayerRepository;
    private static final String userDir =
            System.getProperty("user.dir") + "/src/main/java/com/bengalu/matchesmicroservice/services/loadTestData/";

    @Autowired
    public CsvReader(MatchRepository mr, SelectedPlayerRepository sr ) throws IOException, SQLException {
        this.matchRepository = mr;
        this.selectedPlayerRepository = sr;
    }

    public void load() throws SQLException, IOException {
        this.loadMatches();
        this.loadSelectedPlayers();
    }

    private void loadMatches() throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().
                parse(new FileReader(userDir + "match.csv"));

        for (CSVRecord row : parser) {
            Date date = Date.valueOf(row.get("date"));
            String stadium = String.valueOf(row.get("stadium"));
            String rival = String.valueOf(row.get("rivalTeam"));
            String status = String.valueOf(row.get("status"));

            Match match = new Match(date, stadium, rival,status);
            matchRepository.save(match);
        }
    }

    public void loadSelectedPlayers() throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().
                parse(new FileReader(userDir + "selectedplayers.csv"));

        for (CSVRecord row : parser) {
            Long dni = Long.valueOf(row.get("dni"));
            String surname = String.valueOf(row.get("surname"));
            String name = String.valueOf(row.get("name"));

            SelectedPlayer selectedPlayer = new SelectedPlayer(dni, surname, name);
            selectedPlayerRepository.save(selectedPlayer);
            Optional<Match> match = matchRepository.findById(21L);
            System.out.println(match);
            match.get().addPlayer(selectedPlayer);
            matchRepository.save(match.get());
        }
    }

}
