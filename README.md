# EntityTackle
living entity to egg by EntityTackle
> 目前想不到什么好的方式或者原版用来抓捕

> 此插件不应该有经济或者概率之类功能。请使用其他插件和外部实现

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
