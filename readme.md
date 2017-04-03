# FunctionPainter2
从新开始的FunctionPainter

## 简介
顾名思义，这是一个用来画函数的画板（其实还想可以画点别的好看的几何图形）。

这个项目可以说是花了我最多时间的了，但到现在我似乎也没写了啥，主要就是有一些想法一直在改变吧。然后就把之前的代码给咔擦了，然后就躲在git的历史里了吧。

这里也可以说是一个备忘录，记录下一些想法，慢慢打成代码。

[来个GitHub的链接吧](https://github.com/RainbowYang/FunctionPainter2/)

## 各个部分的主要功能和想法(其实主要还是幻想中的)

### 坐标系
目前想法是二维和三维的。二维的有轴坐标系和极坐标系。三维的再说。

关于二维的两种坐标系在变形之后的互相转换也是一个问题，或许会分开吧。
+ 移动 (这都不行，还玩个啥)
+ 旋转 
+ 坐标轴之间角度可调
+ 坐标轴单位长度可调 (或许还可以按指数增长)


### 函数
这个其实不单是数学函数，还有其他的一些图形。但也就叫这个好了。
+ 拉伸和压缩
+ 叠加
+ 旋转 
+ 翻转
+ 强行求导 (就是不通过理论计算,直接模拟很小的(dealt)x) <del>(或许会吧啊)<del>
+ 求定积分 (同上)
+ 分形
+ 迭代
+ 其他东西
    + 一些有趣的函数和图形
    + 正多边形
    + [芒星][] [(Wiki搜索结果)][] (比如[五角星][],[六角星][](这货不是魔法阵么)啥的)
    + [贝塞尔曲线][]
    + 旋转的太极八卦图


### 点
关于点,在JavaFx是有Point2D和Point3D这两个类的。并且其中也实现了许多的点所需要的功能,比如加减，求距离等(当然不止，不一一列出)。同时也可以当做向量来用，也提供了一些向量运算的方法。

但是正如在坐标系里所提到的，坐标系不单单只是轴坐标系的，还有极坐标系。而无论作为一个点还是作为一个向量，那两个类都只能在轴坐标系中使用，并且作为官方给出的类，无法进行接口统一，所以打算自己实现。
    
<del>目前的实现是通过在接口(不特指interface)中定义一个数组，然后在抽象子类中定义数组长度(或者叫维度吧)，最后在分为轴坐标系和极坐标系的。<del>(已放弃用数组)

+ 相加减
+ 单向叠加 (这个在函数的叠加中要用到，比如说x不变，y相加)
+ 旋转 
+ 翻折
+ 放大和缩小

## 历史版本

### V2.0
    - 20170402 初始化


本文博客地址 http://rainbow-yang.moe/201703/18/introduction-of-FunctionPainter.html
（未完）

[贝塞尔曲线]: https://zh.wikipedia.org/wiki/%E8%B2%9D%E8%8C%B2%E6%9B%B2%E7%B7%9A "Wiki链接"
[芒星]: http://baike.baidu.com/item/%E8%8A%92%E6%98%9F "这是百度百科的,Wiki居然没有专门的页面0.0."
[(Wiki搜索结果)]: https://zh.wikipedia.org/w/index.php?search=%E8%8A%92%E6%98%9F&title=Special:%E6%90%9C%E7%B4%A2&go=%E5%89%8D%E5%BE%80&searchToken=5jdycsxqxvlwdpupxwttj9jyb
[五角星]: https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A7%92%E6%98%9F "Wiki链接"
[六角星]: https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A7%92%E6%98%9F "Wiki链接"