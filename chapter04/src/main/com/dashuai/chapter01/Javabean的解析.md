# 1、JavaBean和属性的概念

## JavaBean的特点：
- 必须有默认的构造方法（实际开发中都是通过反射实例化的 Class.forName(“”).newInstance()）

- 字段都是私有的（private String name）

- 提供针对字段的getter或setter方法（属性）

- 有一定的编码规范：
    ```
    private String name;
    getName====属性，该属性名为name
    setName====属性，该属性名为name
    
    private boolean married;
    isMarried==getMarried====属性，该属性名为married
    setMarried====属性，该属性名为married
    ```
# 2、获取Javabean中的数据

## 通过getter或setter方法操作JavaBean中的数据
这是传统的方法，不太推荐

## 通过反射
其实也是很多框架封装Javabean的本质技术

## 轻量级框架BeanUtils框架