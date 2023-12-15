package questionnaire.web.dao;

import questionnaire.database.Manager;

import java.util.List;

/**
 * 管理员Dao接口
 */
public interface ManagerDao {
    /**
     * 验证管理员信息
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 若验证成功,则返回对应的管理员对象,否则返回null
     */
    Manager verifyManager(String username, String password);

    /**
     * 根据用户名查找管理员
     *
     * @param username 用户名
     * @return 对应的管理员对象
     */
    Manager findManagerByUserName(String username);

    /**
     * 添加管理员
     *
     * @param manager 管理员对象
     * @return 管理员对象
     */
    Manager addManager(Manager manager);

    /**
     * 删除管理员
     *
     * @param managerId 被删除的管理员ID
     */
    void deleteManager(String managerId);

    /**
     * 获取所有管理员
     *
     * @return 所有管理员列表
     */
    List<Manager> getAllManagers();

    /**
     * 更新管理员信息
     *
     * @param manager 新的管理员信息
     */
    void updateOneManager(Manager manager);
}
