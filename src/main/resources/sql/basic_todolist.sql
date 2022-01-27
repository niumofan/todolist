use todolist_test2;


DROP TABLE IF EXISTS `s_user`;
CREATE TABLE IF NOT EXISTS `s_user` (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    username VARCHAR(30) NOT NULL COMMENT '用户名',
    password VARCHAR(64) NOT NULL COMMENT '密码',
    nickname VARCHAR(30) NOT NULL DEFAULT '未设置昵称' COMMENT '昵称',
    sex CHAR(1) NOT NULL DEFAULT '无' COMMENT '性别',
    mobile VARCHAR(20) NOT NULL DEFAULT '' COMMENT '手机号',
    qq VARCHAR(15) NOT NULL DEFAULT '' COMMENT 'QQ号',
    wexin VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信号',
    email VARCHAR(64) NOT NULL DEFAULT '' COMMENT '电子邮箱',
    head_icon VARCHAR(255) NOT NULL DEFAULT 'images/default/default_head_icon' COMMENT '头像路径',
    bg_image VARCHAR(255) NOT NULL DEFAULT 'images/default/default_background_image' COMMENT '背景图片路径',
    create_time DATETIME NOT NULL COMMENT '用户创建时期',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    last_login_time DATETIME NOT NULL DEFAULT '1970-05-05 05:05:05' COMMENT '上一次登陆时间',
    enabled TINYINT NOT NULL DEFAULT 0 COMMENT '用户状态',
    account_non_expired TINYINT NOT NULL DEFAULT 0 COMMENT '账户是否没过期。1表示没过期',
    account_non_locked TINYINT NOT NULL DEFAULT 0 COMMENT '帐户是否没被锁。1表示没被锁',
    credentials_non_expired TINYINT NOT NULL DEFAULT 0 COMMENT '密码是否没过期。1表示没过期',
    token VARCHAR(255) NOT NULL DEFAULT '' COMMENT '用户的token'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户基础信息表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '角色ID',
    code VARCHAR(30) NOT NULL COMMENT '角色名(英文)',
    name VARCHAR(30) NOT NULL COMMENT '角色名(中文)'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `s_permission`;
CREATE TABLE `s_permission` (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '权限ID',
    code VARCHAR(30) NOT NULL COMMENT '权限名(英文)',
    name VARCHAR(30) NOT NULL COMMENT '权限名(中文)'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限信息表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `s_api`;
CREATE TABLE `s_api` (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '请求路径ID',
    url VARCHAR(255) NOT NULL COMMENT '请求路径',
    `content` VARCHAR(255) NOT NULL COMMENT '功能描述'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请求路径信息表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL COMMENT '用户ID',
    role_id INT NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `r_role_permission`;
CREATE TABLE `r_role_permission` (
   id INT PRIMARY KEY AUTO_INCREMENT,
   role_id INT NOT NULL COMMENT '角色ID',
   permission_id INT NOT NULL COMMENT '权限ID'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-权限关系表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `r_api_permission`;
CREATE TABLE `r_api_permission` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    api_id INT NOT NULL COMMENT '请求路径ID',
    permission_id INT NOT NULL COMMENT '权限ID'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请求路径-权限关系表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `b_category`;
CREATE TABLE `b_category` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL COMMENT '用户ID',
    name VARCHAR(10) NOT NULL COMMENT '分类名',
    INDEX(user_id),
    UNIQUE(user_id, name)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `b_todo`;
CREATE TABLE `b_todo` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL COMMENT '用户ID',
    category_id INT NOT NULL DEFAULT 0 COMMENT '分类ID',
    category_name VARCHAR(16) NOT NULL DEFAULT '无分类' COMMENT '分类名',
    `content` VARCHAR(32) NOT NULL COMMENT '内容',
    priority TINYINT NOT NULL COMMENT '优先级。1->不紧急；2->一般紧急；3->非常紧急',
    start_time DATETIME NOT NULL COMMENT '待办生效日期',
    alarm_time DATETIME COMMENT '提醒时间',
    state TINYINT NOT NULL COMMENT '状态。1->待办: 到期前还没做; 2->完成: 到期前完成了; 3->失败: 到期时没有完成',
    subtodos VARCHAR(1024) COMMENT '子待办事项，以json形式存储([{state:1, content:"todo1"},{...}])',
    repetition Long NOT NULL DEFAULT 0 COMMENT '重复标识',
    INDEX(user_id),
    INDEX(category_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '待办事项表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `b_focus`;
CREATE TABLE `b_focus` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL COMMENT '用户ID',
    todo_id INT NOT NULL COMMENT '待办ID',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    duration SMALLINT NOT NULL COMMENT '专注持续时间',
    INDEX(user_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专注表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `b_subtask`;
# CREATE TABLE `b_subtask` (
#     id INT PRIMARY KEY AUTO_INCREMENT,
#     task_id INT NOT NULL COMMENT '父任务ID',
#     `content` VARCHAR(32) NOT NULL COMMENT '内容',
#     priority TINYINT NOT NULL DEFAULT 1 COMMENT '优先级。1->不紧急；2->一般紧急；3->非常紧急',
#     state TINYINT NOT NULL DEFAULT 1 COMMENT '状态。1->待办: 到期前还没做; 2->完成: 到期前完成了; 3->失败: 到期时没有完成'
# ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '子待办事项表' ROW_FORMAT = Dynamic;


INSERT INTO s_user(id, username, password, nickname, sex, mobile, qq, wexin, email, head_icon, bg_image, create_time, update_time, last_login_time, enabled, account_non_expired, account_non_locked, credentials_non_expired, token)
VALUES
    (1, 'admin', '$2a$10$qcSDlKsm8od9VsTVu5igduwH5sHUkI5s063TKp/42HGY/pB/g/4Wm', '未设置昵称', 0, '', '', '', '', 'images/default/default_head_icon', 'images/default/default_background_image', '2021-11-02 22:41:47', '2021-11-02 22:41:47', '2021-11-02 22:41:47', 1, 1, 1, 1, ''),
    (2, 'user1', '$2a$10$dboqOjhA.n0XCSyeH7JY4OIqM4Vyq2mbUKnPIjmsDtnDrF2VRqfvm', '未设置昵称', 0, '', '', '', '', 'images/default/default_head_icon', 'images/default/default_background_image', '2021-11-02 23:00:35', '2021-11-02 23:00:35', '2021-11-02 23:00:35', 1, 1, 1, 1, '') ;

INSERT INTO s_role(id, code, name)
VALUES
       (1, 'ROLE_ANYONE', '任何人'),
       (2, 'ROLE_ADMIN', '管理员'),
       (3, 'ROLE_COMMON_USER', '普通用户');

INSERT INTO s_permission(id, code, name)
VALUES
       (1, 'user:login', '登录'),
       (2, 'user:register', '注册'),
       (3, 'task:get', '获取待办'),
       (4, 'user:get', '查看用户');

INSERT INTO s_api(id, url, content)
VALUES
       (1, '/login', '登录'),
       (2, '/user/register', '注册'),
       (3, '/user/getUser', '查看用户信息');

INSERT INTO r_user_role(id, user_id, role_id)
VALUES
       (1, 1, 2),
       (2, 2, 3);

INSERT INTO r_role_permission(id, role_id, permission_id)
VALUES
       (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1),
       (4, 1, 2),
       (5, 3, 3),
       (6, 3, 4);

INSERT INTO r_api_permission(id, api_id, permission_id)
VALUES
       (1, 1, 1),
       (2, 2, 2),
       (3, 3, 4);