# 实体处理 EntityTackle
### 你还在使用矿车和船运输实体？来康康这个！
### 实体处理为您的生存类服务器提供吸引人的新功能，实体储存与运输
### 玩家可以通过来多种模式来捕获实体
### 对 MySQLPlayerDataBridge HuskSync 等跨服背包插件完全兼容
### 对 Residence 等区域控制插件完全兼容
### 对 MythicMobs 等实体控制插件完全兼容
### 高度自定义的物品与文本，兼容材质
### 允许你控制刷怪笼是否能被更改（权限）
### 每个实体一个权限节点，每个实体可以彻底关闭和开启（在配置文件）
### 面向玩家，只可以捕获基础实体，不包含 箭 区域云 之类

## 特征
- 多种捕获模式
  - 通过鸡蛋、雪球、末影珍珠远程命中实体捕获，并在实体位置生成物品（消耗物品）
  - 左键或右键实体将实体储存进物品，并放入背包（消耗物品）
- 通过物品储存实体
  - 完全记录实体 NBT 数据
  - 蛋模式，每个实体对应一种刷怪蛋，如果没有对应则是白蛋
  - 物品模式，使用通常类物品储存实体，并更改Name和Lore
  - 右键或者Shift+右键，物品将实体释放到空地上
  - 允许或者拒绝蛋模式更改刷怪笼
- 物品
  - 自定义 type material name lore
  - 自定义 custom-model-data flag 以及对应变量
  - Type 为 egg 模式则是蛋模式 item 则是物品模式
  - 自定义模型数据支持允许你使用材质包更改每个物品
  - Flag 允许你控制物品所有数据（不可破坏，隐藏属性，还有更多！）
  - 全局物品设置，和细分每个实体的物品设置，会继承
  - 可以通过原版合成方式获得，并注册合并表
- 文本与语言
  - 翻译 Translations 文件夹，允许您新建自己的文本并在 config 指定文件
  - 支持 "&" 颜色
  - 支持 MiniMessage （原生）（复杂颜色请使用此）（自由控制chat与bar）
  - 不考虑i18n，手动进行选择语言文件。如果要支持全球语言，则应该使用材质包搭配语言字符
- 粒子与声音
  - 进行捕获时
  - 实体未能抓住
  - 实体被抓住
- 权限与安全
  - 被命名的实体是否能抓（权限）
  - 每个权限节点对应一个实体
  - 兼容 Residence WorldGuard Bentobox PlotSquared 等区域管理
    - 初始兼容模式，区域内的实体无法抓。除非自己是主人（Owner）和加入者（Member）
    - 高级兼容模式，挂钩 API 变成 flag 允许对应插件控制实体捕获
  - 兼容 MythicMobs itemAdder 等实体控制
    - 初始兼容模式，无法被抓

## 命令
- 主命令 /entitytackle 别名 /entityitem
- 缩写 /et 和 /ei
- 帮助 /entitytackle help 和 /entityitem 一样
- 给予 /entitytackle give 玩家 数量
- 重载 /entitytackle reload

## 文件
- config.yml
- Translations/chinese.yml
- Settings/item.yml
- Settings/mobs-item.yml














# 以下是旧的 markdown
#### 目前想不到什么好的方式或者原版用来抓捕
#### 此插件不应该有经济或者概率之类功能。请使用其他插件和外部实现

## 特征
- 右键或者左键将实体存入物品内，一个物品只能储存一个实体。哪个方式更适合兼容区域控制优先采用
- 也可以通过伤害实体0.1血来触发区域控制的保护实现兼容？
- 通过过程或者玩法将实体储存为物品
  - 可以储存实体所有nbt数据
  - 每个实体对应一种蛋，如果没有蛋类型则是白蛋（可选）
  - 并且可以控制抓来的蛋是否能更改刷怪笼
  - 也可以储存为 Stone这种 但是不好分辨。优点是不必监听刷怪笼
  - 自定义蛋或者物品的 Material Name lore
  - 鉴于本插件面向的是玩家，那么可以抓的实体应该不包含特殊的 Arrow 矿车之类
  - 如有必要，未来可能会能抓 MythicMobs itemAdder 实体。但是兼容是一个问题
  - 可以使用合成方式来获取物品，但我不认为用得上
  - 是否能抓被命名的
  - 声音和特效（未来）
- 开启和关闭每个实体的配置文件
- 语言文本，支持"&"，以及支持 MiniMessage （原生）
- 兼容 Residence WorldGuard Bentobox PlotSquared 等区域管理进行兼容，优先兼容 Residence WorldGuard 
  - 初始兼容模式，区域内的实体无法抓。除非自己是主人（和加入者Member？未来再说）
  - 进阶模式，挂钩API变成 flag 允许控制。未来再说
- 兼容 MythicMobs itemAdder 等实体控制型的插件，暂定 MythicMobs （未来）
- 不考虑i18n，手动进行选择全局语言

## 命令
- 主命令 /entityitem 缩写 /ei
- 帮助 /entityitem help 和 /entityitem 一样
- 给予 /entityitem give 玩家 数量
- 重载 /entityitem reload

## 文件
- config.yml
- Translations/chinese.yml
- Settings/item.yml
- Settings/mobs.yml
