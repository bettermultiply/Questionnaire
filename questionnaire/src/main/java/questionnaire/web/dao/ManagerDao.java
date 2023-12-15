package questionnaire.web.dao;

import questionnaire.database.Manager;

import java.util.List;

public interface ManagerDao {
    Manager verifyManager(String username, String password);
    Manager findManagerByUserName(String username);
    Manager addManager(Manager manager);
    void deleteManager(String managerId);
    List<Manager> getAllManagers();
    void updateOneManager(Manager manager);
}
