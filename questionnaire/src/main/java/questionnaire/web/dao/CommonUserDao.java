package questionnaire.web.dao;

import questionnaire.database.CommonUser;

import java.util.List;

public interface CommonUserDao {
    CommonUser verifyCommonUser(String username, String password);
    CommonUser readOneUser(String userName);
    void updateOneUser(CommonUser commonUser);
    CommonUser registerCommonUser(CommonUser cUser);
    CommonUser verifyUser(String username , String password);
    List<CommonUser> getAllCommonUsers();
}
