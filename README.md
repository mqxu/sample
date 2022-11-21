## 内容分享应用后端微服务

### 1. user-service

**用户微服务**，主要提供：

- 用户登录
- 查询/修改用户信息
- 用户投稿、用户积分

### 2. content-service

**内容微服务**，主要提供：

- （分页）查询所有分享内容
- 查询指定的分享内容
- 新增分享

### 3. notice-service

**公共微服务**，主要提供：

- 管理员查询所有公告，显示/隐藏某个公告
- 新增、删除公告
- 查询最新公告

### 4. file-service

**文件微服务**，主要提供：

- 单文件上传
- 文件批量上传

### 4. gateway-service

**网关微服务**，主要提供：

- 路由转发
- 动态路由
- 统一认证鉴权
- 统一跨域处理

