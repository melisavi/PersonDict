package org.rog.persondict.dao;

import org.rog.persondict.entity.Person;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDaoImpl implements PersonDao {
    //public static Map<Integer, Person> personMap = new HashMap<>();
    private static final String FIND_ALL = "select * from persons limit ? offset ?";
    private static final String FIND_BY_ID = "select * from persons where id = ?";
    private static final String SAVE = "insert into persons (name, birth_date, age) values (?, ?, ?)";
    private static final String UPDATE = "update persons set name = ?, birth_date = ?, age = ? where id = ?";
    private static final String DELETE = "delete from persons where id = ?";
    private final DataSource dataSource;

    public PersonDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Person> findAll(int limit, int offset) {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)){
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int personId = resultSet.getInt("id");
                String personName = resultSet.getString("name");
                LocalDate personBirthDate = resultSet.getDate("birth_date").toLocalDate();
                int personAge = Period.between(personBirthDate, LocalDate.now()).getYears();
                Person person = new Person(personId, personName, personBirthDate, personAge);
                persons.add(person);
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return personMap.values().stream().toList();
    }

    @Override
    public Optional<Person> findById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int personId = resultSet.getInt("id");
                String personName = resultSet.getString("name");
                LocalDate personBirthDate = resultSet.getDate("birth_date").toLocalDate();
                int personAge = Period.between(personBirthDate, LocalDate.now()).getYears();
                Person person = new Person(personId, personName, personBirthDate, personAge);
                return Optional.of(person);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return Optional.of(personMap.get(id));
    }

    @Override
    public Optional<Integer> save(Person person) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, new java.sql.Date(Date.valueOf(person.getBirthDate()).getTime()));
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.executeUpdate();
            return Optional.of(person.getId());
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
        //Integer newId = personMap.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        //person.setId(newId);
        //personMap.put(newId, person);
    }

    @Override
    public Optional<Person> update(Person person) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, new java.sql.Date(Date.valueOf(person.getBirthDate()).getTime()));
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getId());
            preparedStatement.executeUpdate();
            return Optional.of(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //personMap.put(id, person);
        //System.out.println("We've apdated the person");
    }

    @Override
    public void delete(int id) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //personMap.remove(id);
        //System.out.println("We've deleted the person");
    }
}
