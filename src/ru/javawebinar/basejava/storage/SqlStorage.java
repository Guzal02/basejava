package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.util.SqlHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {
    private final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        this.sqlHelper = new SqlHelper(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("DELETE FROM resume");
            ps.execute();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }


    @Override
    public void update(Resume resume) {
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("UPDATE resume SET full_name = ? WHERE uuid = ?");
            ps.setString(1, resume.getFullName());
            ps.setString(2, resume.getUuid());
            ps.execute();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void save(Resume resume) {
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("INSERT INTO resume (uuid, full_name) VALUES (?,?)");
            ps.setString(1, resume.getUuid());
            ps.setString(2, resume.getFullName());
            ps.execute();
        } catch (SQLException e) {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("SELECT * FROM resume r WHERE r.uuid =?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void delete(String uuid) {
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("DELETE FROM resume WHERE uuid = ? RETURNING uuid");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = new ArrayList<>();
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("SELECT * FROM resume");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Resume resume = new Resume(rs.getString("uuid").trim(), rs.getString("full_name").trim());
                resumeList.add(resume);
            }
        } catch (
                SQLException e) {
            throw new StorageException(e);
        }
        return resumeList;
    }

    @Override
    public int size() {
        try {
            PreparedStatement ps = sqlHelper.sqlGetConnection("SELECT count(*) AS rowcount FROM resume");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("rowcount");
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
