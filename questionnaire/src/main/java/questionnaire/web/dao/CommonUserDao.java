package questionnaire.web.dao;

import questionnaire.database.CommonUser;

import java.util.List;

/**
 * 用户Dao接口
 */
public interface CommonUserDao {
    /**
     * 验证用户信息
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 若验证成功,则返回对应的用户对象,否则返回null
     */
    CommonUser verifyCommonUser(String username, String password);

    /**
     * 根据用户名查找对应的用户对象
     *
     * @param userName 用户名
     * @return 对应的用户对象
     */
    CommonUser readOneUser(String userName);

    /**
     * 更新用户信息
     *
     * @param commonUser 新的用户信息
     */
    void updateOneUser(CommonUser commonUser);

    /**
     * 用户注册
     *
     * @param cUser 用户的注册信息
     * @return 若注册成功,则返回对应的用户对象,否则返回null
     */
    CommonUser registerCommonUser(CommonUser cUser);

    /**
     * 验证用户信息
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 若验证成功,则返回对应的用户对象,否则返回null
     */
    CommonUser verifyUser(String username , String password);

    /**
     * 获取所有的用户列表
     *
     * @return 所有用户的列表
     */
    List<CommonUser> getAllCommonUsers();
}
