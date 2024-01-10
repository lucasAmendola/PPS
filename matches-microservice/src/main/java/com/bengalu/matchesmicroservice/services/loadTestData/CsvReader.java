package com.bengalu.matchesmicroservice.services.loadTestData;

import com.bengalu.matchesmicroservice.entities.Match;
import com.bengalu.matchesmicroservice.entities.SelectedPlayer;
import com.bengalu.matchesmicroservice.entities.Team;
import com.bengalu.matchesmicroservice.repositories.MatchRepository;
import com.bengalu.matchesmicroservice.repositories.SelectedPlayerRepository;
import com.bengalu.matchesmicroservice.repositories.TeamRepository;
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
import java.util.ArrayList;
import java.util.Optional;

@Component
public class CsvReader {
    private MatchRepository matchRepository;
    private SelectedPlayerRepository selectedPlayerRepository;
    private TeamRepository teamRepository;
    private static final String userDir =
            System.getProperty("user.dir") + "/src/main/java/com/bengalu/matchesmicroservice/services/loadTestData/";

    @Autowired
    public CsvReader(MatchRepository mr, SelectedPlayerRepository sr, TeamRepository tr) throws IOException, SQLException {
        this.matchRepository = mr;
        this.selectedPlayerRepository = sr;
        this.teamRepository = tr;
    }

    public void load() throws SQLException, IOException {
        this.loadTeams();
        //this.loadMatches();
        //this.loadSelectedPlayers();
    }

    private void loadTeams() throws IOException, SQLException {
        ArrayList<Team> teams = new ArrayList<>();
        CSVParser parser = CSVFormat.DEFAULT.withHeader().
                parse(new FileReader(userDir + "team.csv"));
        for (CSVRecord row : parser) {
            String name = String.valueOf(row.get("name"));
            String address = String.valueOf(row.get("address"));
            String logo = String.valueOf(row.get("logo"));

            Team team = new Team(name,address,logo);
            teams.add(team);
            teamRepository.save(team);
        }
    }


    private void loadMatches() throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().
                parse(new FileReader(userDir + "match.csv"));
        int indexTeams = 0;
        for (CSVRecord row : parser) {
            Date date = Date.valueOf(row.get("date"));
            Time time = Time.valueOf(row.get("time"));
            Team localTeam = this.teamRepository.findById(Long.valueOf(row.get("localTeam"))).get();
            Team visitingTeam = this.teamRepository.findById(Long.valueOf(row.get("visitingTeam"))).get();
            Long matchDay = Long.valueOf(row.get("matchDay"));
            String category = String.valueOf(row.get("category"));
            String status = String.valueOf(row.get("status"));

            Match match = new Match(date, time, matchDay, category, localTeam, visitingTeam,status);
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
            String category = String.valueOf(row.get("category"));

            SelectedPlayer selectedPlayer = new SelectedPlayer(dni, surname, name, category);
            selectedPlayerRepository.save(selectedPlayer);
            Optional<Match> match = matchRepository.findById(21L);
            match.get().addPlayer(selectedPlayer);
            matchRepository.save(match.get());
        }
    }

}
