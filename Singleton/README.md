# DesignPatterns

设计模式：
  1、单例模式
  2、
  3、
  4、


#Suggestion:

## 测试不应该出现不通过的情况：

如果你是想表达，某个测试应该抛出错误，能不能考虑使用 assertThrows或者其他方法去写测试？
参见 EnumSingleTest 28行，47行？

## 测试和实现分开

常见的项目结构 main是实现，test下是测试。